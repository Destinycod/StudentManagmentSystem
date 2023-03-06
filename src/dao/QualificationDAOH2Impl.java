package dao;

import entities.Course;
import entities.Qualification;
import entities.Student;
import entities.Teacher;
import exeptions.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class QualificationDAOH2Impl implements GenericDAO<Qualification> {

    private Connection connection = null;

    private void executePersistentChanges(String query) throws UnableCloseException, SQLException, UnableException {
        try {
            connection = ConnectionManager.connect();
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            connection.commit();
            connection.rollback();
        } catch (SQLException e) {
            if (e.getErrorCode()==30080){
                throw new UnableException("The connection is not possible");
            } else /*if(e.getErrorCode()==30090)*/{
                throw new SQLException();
            }
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                if(e.getErrorCode()==843) {
                    throw new UnableCloseException("The connection does not exist");
                }
            }
        }
    }

    @Override
    public void create(Qualification qualification) throws EmptyException, ExistException, UnableCloseException, SQLException, UnableException {
        Long id = qualification.getId();
        int score = qualification.getQualification();
        Long courseId = qualification.getCourse().getId();
        Long teacherId = qualification.getTeacher().getNid();
        Long studentId = qualification.getStudent().getNid();

        String query = "INSERT INTO QUALIFICATIONS (ID, SCORE, TEACHER_ID, COURSE_ID, STUDENT_ID) " +
                "VALUES (" + id + ", " + score + "," + teacherId + "," + courseId + "," +
                studentId + ")";
        this.executePersistentChanges(query);
    }

    @Override
    public void delete(Long id) throws EmptyException, NotExistException, UnableCloseException, SQLException, UnableException {
        String query = "DELETE FROM QUALIFICATIONS WHERE ID = " + id;
        this.executePersistentChanges(query);
    }

    @Override
    public void update(Qualification qualification) throws EmptyException, NotExistException, UnableCloseException, SQLException, UnableException {
        Long id = qualification.getId();
        int score = qualification.getQualification();
        Long courseId = qualification.getCourse().getId();
        Long teacherId = qualification.getTeacher().getNid();
        Long studentId = qualification.getStudent().getNid();
        String query = "UPDATE QUALIFICATIONS SET ID =" + id + ", SCORE = " + score +
                ", TEACHER_ID = " + teacherId + ", COURSE_ID = " + courseId +
                ", STUDENT_ID = " + studentId;
        this.executePersistentChanges(query);
    }
//TODO CHECK
    @Override
    public List<Qualification> list() throws UnableCloseException, SQLException, UnableException {
        List<Qualification> qualificationList = new ArrayList<>();
        try {
            String query = "SELECT Q.ID ID, Q.SCORE SCORE, " +
                    "T.NID T_NID, T.NAME TEACHER_NAME, T.LAST_NAME TEACHER_LAST_NAME, " +
                    "C.ID C_ID, C.NAME COURSE_NAME, C.PRICE PRICE, " +
                    "S.NID S_NID, S.NAME STUDENT_NAME, S.LAST_NAME STUDENT_LAST_NAME " +
                    "FROM QUALIFICATIONS Q JOIN TEACHERS T ON T.NID = Q.TEACHER_ID " +
                    "INNER JOIN COURSES C ON C.ID = Q.COURSE_ID " +
                    "JOIN STUDENTS S ON S.NID = Q.STUDENT_ID ORDER BY ID";

            connection = ConnectionManager.connect();
            Statement s = connection.createStatement();
            ResultSet results = s.executeQuery(query);

            while (results.next()) {
                Teacher teacher = new Teacher(
                        results.getLong("T_NID"),
                        results.getString("TEACHER_NAME"),
                        results.getString("TEACHER_LAST_NAME"));
                Course course = new Course(
                        results.getLong("C_ID"),
                        results.getString("COURSE_NAME"),
                        results.getDouble("PRICE"));
                Student student = new Student(
                        results.getLong("S_NID"),
                        results.getString("STUDENT_NAME"),
                        results.getString("STUDENT_LAST_NAME"));

                Qualification q = new Qualification(results.getLong("ID"),
                        results.getInt("SCORE"));
                q.setTeacher(teacher);
                q.setStudent(student);
                q.setCourse(course);
                qualificationList.add(q);
            }
            connection.commit();
            connection.rollback();
        } catch (SQLException e) {
            if (e.getErrorCode()==30080){
                throw new UnableException("The connection is not possible");
            } else if(e.getErrorCode()==30090){
                throw new SQLException();
            }
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                if(e.getErrorCode()==843) {
                    throw new UnableCloseException("The connection does not exist");
                }
            }
        }
        return qualificationList;
    }

    public List<Qualification> listForTeacher(Long id) throws UnableCloseException, SQLException, UnableException {
        List<Qualification> qualificationList = new ArrayList<>();
        try {
            String query = "SELECT Q.ID ID, Q.SCORE SCORE, " +
                    "T.NID T_NID, " +
                    "C.ID C_ID, C.NAME COURSE_NAME, " +
                    "S.NID S_NID, S.NAME STUDENT_NAME " +
                    "FROM QUALIFICATIONS Q JOIN TEACHERS T ON T.NID = Q.TEACHER_ID " +
                    "INNER JOIN COURSES C ON C.ID = Q.COURSE_ID " +
                    "JOIN STUDENTS S ON S.NID = Q.STUDENT_ID " +
                    "WHERE T.ID = " + id + " ORDER BY ID";

            connection = ConnectionManager.connect();
            Statement s = connection.createStatement();
            ResultSet results = s.executeQuery(query);

            while (results.next()) {
                Teacher teacher = new Teacher(
                        results.getLong("T_NID"));
                Course course = new Course(
                        results.getLong("C_ID"),
                        results.getString("COURSE_NAME"));
                Student student = new Student(
                        results.getLong("S_NID"),
                        results.getString("STUDENT_NAME"),
                        results.getString("STUDENT_LAST_NAME"));

                Qualification q = new Qualification(results.getLong("ID"),
                        results.getInt("SCORE"));
                q.setTeacher(teacher);
                q.setStudent(student);
                q.setCourse(course);
                qualificationList.add(q);
            }
            connection.commit();
            connection.rollback();
        } catch (SQLException e) {
            if (e.getErrorCode()==30080){
                throw new UnableException("The connection is not possible");
            } else if(e.getErrorCode()==30090){
                throw new SQLException();
            }
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                if(e.getErrorCode()==843) {
                    throw new UnableCloseException("The connection does not exist");
                }
            }
        }
        return qualificationList;
    }
/*
    public List<Qualification> listStudentView(Long id) throws UnableCloseException, SQLException, UnableException {
        List<Qualification> qualificationList = new ArrayList<>();
        try {
            String query = "SELECT Q.ID ID, Q.SCORE SCORE, " +
                    "T.NAME TEACHER_NAME, T.LAST_NAME TEACHER_LAST_NAME, " +
                    "C.ID C_ID, C.NAME COURSE_NAME, " +
                    "S.NID S_NID " +
                    "FROM QUALIFICATIONS Q JOIN TEACHERS T ON T.NID = Q.TEACHER_ID " +
                    "JOIN COURSES C ON C.ID = Q.COURSE_ID " +
                    "JOIN STUDENTS S ON S.NID = Q.STUDENT_ID" +
                    "WHERE S_NID = " + id + "ORDER BY C_ID";

            connection = ConnectionManager.connect();
            Statement s = connection.createStatement();
            ResultSet results = s.executeQuery(query);

            while (results.next()) {
                Teacher teacher = new Teacher(
                        results.getLong("T_NID"),
                        results.getString("TEACHER_NAME"),
                        results.getString("TEACHER_LAST_NAME"));
                Course course = new Course(
                        results.getLong("C_ID"),
                        results.getString("COURSE_NAME"),
                        results.getDouble("PRICE"));
                Student student = new Student(
                        results.getLong("S_NID"),
                        results.getString("STUDENT_NAME"),
                        results.getString("STUDENT_LAST_NAME"));

                Qualification q = new Qualification(results.getLong("ID"),
                        results.getInt("SCORE"));
                q.setTeacher(teacher);
                q.setStudent(student);
                q.setCourse(course);
                qualificationList.add(q);
            }
            connection.commit();
            connection.rollback();
        } catch (SQLException e) {
            if (e.getErrorCode()==30080){
                throw new UnableException("The connection is not possible");
            } else if(e.getErrorCode()==30090){
                throw new SQLException();
            }
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                if(e.getErrorCode()==843) {
                    throw new UnableCloseException("The connection does not exist");
                }
            }
        }
        return qualificationList;
    }
    */
//TODO CHECK
    @Override
    public Qualification search(Long id) throws EmptyException, NotExistException, UnableCloseException, SQLException, UnableException {
        String query = "SELECT * FROM QUALIFICATIONS WHERE ID = " + id;

        try {
            connection = ConnectionManager.connect();
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery(query);

            if(rs.next()) {
                int score = rs.getInt("score");
                Long teacher_id = rs.getLong("teacher_id");
                Long course_id = rs.getLong("course_id");
                Long student_id = rs.getLong("student_id");
                Qualification qualification = new Qualification(id, score, teacher_id, course_id, student_id);
                return qualification;
            }
            connection.commit();
            connection.rollback();
        } catch (SQLException e) {
            if (e.getErrorCode()==30080){
                throw new UnableException("The connection is not possible");
            } else if(e.getErrorCode()==30090){
                throw new SQLException();
            } else{
                throw new NotExistException("Not Exist Error");
            }
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                if(e.getErrorCode()==843) {
                    throw new UnableCloseException("The connection does not exist");
                }
            }
        }
        return null;
    }
}

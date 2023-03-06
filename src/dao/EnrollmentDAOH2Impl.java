package dao;

import entities.*;
import exeptions.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EnrollmentDAOH2Impl implements GenericDAO<Enrollment> {

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

    @Override //TODO CHECK
    public void create(Enrollment enrollment) throws EmptyException, ExistException, UnableCloseException, SQLException, UnableException {
        Long id = enrollment.getId();
        Long course_id = enrollment.getCourse().getId();
        Long student_id = enrollment.getStudent().getNid();
        int addTotalCourses = (enrollment.getStudent().getTotalCourses()) + 1;
        String query = "INSERT INTO ENROLLMENTS (ID, STUDENT_ID, COURSE_ID) VALUES (" + id + ", "
                + student_id + "," + course_id + ");" +
                "UPDATE STUDENTS SET TOTAL_COURSES = " + addTotalCourses + //TODO CHECK
                "WHERE NID = " + enrollment.getStudent().getNid();
        /*enrollment.getCourse().getEnrollments().add(enrollment);
        enrollment.getStudent().getEnrollments().add(enrollment);
        System.out.println("Enroll creado, lista en cursos: " + enrollment.getCourse().getEnrollments().size());
        */this.executePersistentChanges(query);
    }

    @Override
    public void delete(Long id) throws EmptyException, NotExistException, UnableCloseException, SQLException, UnableException {
        String query = "DELETE FROM ENROLLMENTS WHERE ID = " + id;
        this.executePersistentChanges(query);
    }

    @Override
    public void update(Enrollment enrollment) throws EmptyException, NotExistException, UnableCloseException, SQLException, UnableException {
        Long id = enrollment.getId();
        Long course_id = enrollment.getCourse().getId();
        Long student_id = enrollment.getStudent().getNid();
        String query = "UPDATE ENROLLMENTS (ID, STUDENT_ID, COURSE_ID) VALUES (" + id + ", " + student_id
                + "," + course_id + ")";
        this.executePersistentChanges(query);
    }

    @Override
    public List<Enrollment> list() throws UnableCloseException, SQLException, UnableException {
        List<Enrollment> enrollmentList = new ArrayList<>();
        try {
            String query = "SELECT E.ID ID, " +
                    "C.ID C_ID, C.NAME COURSE_NAME, C.PRICE PRICE, " +
                    "S.NID S_NID, S.NAME STUDENT_NAME, S.LAST_NAME STUDENT_LAST_NAME " +
                    "FROM ENROLLMENTS E " +
                    "INNER JOIN COURSES C ON C.ID = E.COURSE_ID " +
                    "JOIN STUDENTS S ON S.NID = E.STUDENT_ID ORDER BY ID";

            connection = ConnectionManager.connect();
            Statement s = connection.createStatement();
            ResultSet results = s.executeQuery(query);

            while (results.next()) {
                Course course = new Course(
                        results.getLong("C_ID"),
                        results.getString("COURSE_NAME"),
                        results.getDouble("PRICE"));
                Student student = new Student(
                        results.getLong("S_NID"),
                        results.getString("STUDENT_NAME"),
                        results.getString("STUDENT_LAST_NAME"));

                Enrollment enrollment = new Enrollment(results.getLong("ID"));
                enrollment.setStudent(student);
                enrollment.setCourse(course);
                enrollmentList.add(enrollment);
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

        return enrollmentList;
    }
//TODO NO ANDA
    @Override
    public Enrollment search(Long id) throws EmptyException, NotExistException, UnableCloseException, SQLException, UnableException {
        String query = "SELECT * FROM ENROLLMENTS WHERE ID = " + id;

        try {
            connection = ConnectionManager.connect();
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery(query);

            if(rs.next()) {
                Long student_id = rs.getLong("STUDENT_ID");
                Long course_id = rs.getLong("COURSE_ID");
                Enrollment enrollment = new Enrollment(id, student_id, course_id);
                return enrollment;
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
        } finally {
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

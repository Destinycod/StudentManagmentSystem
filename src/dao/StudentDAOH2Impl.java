package dao;

import entities.Student;
import exeptions.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOH2Impl implements GenericDAO<Student> {

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
    public void create(Student student) throws EmptyException, ExistException, UnableCloseException, SQLException, UnableException {
        String name = student.getName();
        String lastName = student.getLastName();
        Long nid = student.getNid();
        String password = student.getPassword();
        String query = "INSERT INTO STUDENTS (NAME, LAST_NAME, NID, PASSWORD) VALUES ('" + name
                + "', '" + lastName + "', " + nid + ", '" + password + "')";
        this.executePersistentChanges(query);
    }

    @Override
    public void delete(Long nid) throws EmptyException, NotExistException, UnableCloseException, SQLException, UnableException {
        String query = "DELETE FROM STUDENTS WHERE NID = " + nid;
        this.executePersistentChanges(query);
    }

    @Override
    public void update(Student student) throws EmptyException, NotExistException, UnableCloseException, SQLException, UnableException {
        String name = student.getName();
        String lastName = student.getLastName();
        Long nid = student.getNid();
        String password = student.getPassword();

        String query = "UPDATE STUDENTS set NAME = '" + name + "', LAST_NAME = '" + lastName
                + "', NID = " + nid + ", PASSWORD = '" + password + "' WHERE NID = " + nid;
        this.executePersistentChanges(query);
    }

    @Override
    public List<Student> list() throws UnableCloseException, SQLException, UnableException {
        List<Student> studentList = new ArrayList<>();

        String query = "SELECT * FROM STUDENTS ORDER BY LAST_NAME";
        //TODO CHECK
        //String query = "SELECT S.NAME NAME, S.LAST_NAME LAST_NAME, S.NID NID, S.PASSWORD PASSWORD, " +
        //        "E.ID ENROLLMENT_ID FROM STUDENTS S JOIN ENROLLMENTS E ON S.NID = E.STUDENT_ID" +
        //        "ORDER BY LAST_NAME";
        try {
            connection = ConnectionManager.connect();
            Statement s = connection.createStatement();
            ResultSet results = s.executeQuery(query);

            while (results.next()) {
                Student person = new Student(results.getString("NAME"),
                        results.getString("LAST_NAME"),
                        results.getLong("NID"),
                        results.getString("PASSWORD"),
                        results.getInt("TOTAL_COURSES"));
                studentList.add(person);
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
        return studentList;
    }

    @Override
    public Student search(Long id) throws EmptyException, NotExistException, UnableCloseException, SQLException, UnableException {
        String query = "SELECT * FROM STUDENTS WHERE NID = " + id;

        try {
            connection = ConnectionManager.connect();
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery(query);

            if(rs.next()) {
                //Long nid = rs.getLong("nid");
                String name = rs.getString("name");
                String last_name = rs.getString("last_name");
                String password = rs.getString("password");
                Student student = new Student(name, last_name, id, password);
                return student;
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




    /*
    public void create(Student student) throws EmptyException, ExistException, UnableException, UnableCloseException, SQLException {
        String name = student.getName();
        String lastName = student.getLastName();
        Integer nid = student.getNid();
        String password = student.getPassword();

        Connection connection = null;

        try {
            connection = ConnectionManager.connect();
            //Statement statement = connection.createStatement();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO STUDENT (NAME, LAST_NAME, NID, PASSWORD) VALUES (?,?,?,?)");
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,lastName);
            preparedStatement.setInt(3,nid);
            preparedStatement.setString(4,password);

            //String query = "INSERT INTO STUDENT (NAME, LAST_NAME, NID, PASSWORD) VALUES ('" + name + "', '" + lastName + "', " + nid + ", '" + password + "')";
            //statement.executeUpdate(query);
            connection.commit();
            connection.rollback();
        } catch (SQLException e) {
            if(e.getErrorCode()==87){
                throw new EmptyException("Empty Error"); //que hereda de exception, nada especifico, da indicio de lo que paso
            } else if (e.getErrorCode()==30080){
                throw new UnableException("The connection is not possible");
            } else if(e.getErrorCode()==30090){
                throw new SQLException();
            } else if (e.getErrorCode()==290){
                throw new ExistException("Exist Error");
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
    public void delete(int id) throws NotExistException, UnableException, UnableCloseException, SQLException {
        String query = "DELETE FROM STUDENT WHERE NID = '" + id + "'";
        Connection connection = null;
        try {
            connection = ConnectionManager.connect();
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            connection.commit();
            connection.rollback();
        } catch (SQLException e) {
            if(e.getErrorCode()==30080){
                throw new UnableException("The connection is not possible");
            } else if(e.getErrorCode()==30090){
                throw new SQLException();
            } else {
                throw new NotExistException("Not exist Error");
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
    public void update(Student student) throws NotExistException, UnableException, UnableCloseException, SQLException {
        String name = student.getName();
        String lastName = student.getLastName();
        Integer nid = student.getNid();
        String password = student.getPassword();

        String query = "UPDATE STUDENT set NAME = '" + name + "', LAST_NAME = '" + lastName + "', NID =" + nid + ", PASSWORD = '" + password + "' WHERE NID = " + nid;

        Connection connection = null;
        try {
            connection = ConnectionManager.connect();
            Statement s = connection.createStatement();
            s.executeUpdate(query);
            connection.commit();
            connection.rollback();
        } catch (SQLException e) {
            if (e.getErrorCode()==30080){
                throw new UnableException("The connection is not possible");
            } else if(e.getErrorCode()==30090){
                throw new SQLException();
            } else {
                throw new NotExistException("Not exist Error");
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
    public List<Student> list() throws EmptyException, UnableException, UnableCloseException, SQLException {

        List<Student> studentList = new ArrayList<>();
        String query = "SELECT * FROM STUDENT ORDER BY LAST_NAME";
        Connection connection = null;
        try {
            connection = ConnectionManager.connect();
            Statement s = connection.createStatement();
            ResultSet results = s.executeQuery(query);

            while (results.next()) {
                Student person = new Student(results.getString("NAME"),
                        results.getString("LAST_NAME"),
                        results.getInt("NID"),
                        results.getString("PASSWORD"));
                studentList.add(person);

            }
            connection.commit();
            connection.rollback();
        } catch (SQLException e) {
            if (e.getErrorCode()==30080){
                throw new UnableException("The connection is not possible");
            } else if(e.getErrorCode()==30090){
                throw new SQLException();
            } else {
                throw new EmptyException("Empty error");
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
        return studentList;
    }

    public Student search(int id) throws EmptyException, NotExistException, UnableException, UnableCloseException, SQLException {
        String query = "SELECT * FROM STUDENT WHERE NID = " + id;
        Connection connection = null;
        try {
            connection = ConnectionManager.connect();
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery(query);

            if(rs.next()) {
                int nid = rs.getInt("nid");
                String name = rs.getString("name");
                String last_name = rs.getString("last_name");
                String password = rs.getString("password");
                Student student = new Student(name, last_name, nid, password);
                return student;
            }
            connection.commit();
            connection.rollback();
        } catch (SQLException e) {
            if (e.getErrorCode()==30080){
                throw new UnableException("The connection is not possible");
            } else if(e.getErrorCode()==87){
                throw new EmptyException("Empty Error");
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
*/
}

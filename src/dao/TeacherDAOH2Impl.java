package dao;

import entities.Teacher;
import exeptions.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TeacherDAOH2Impl implements GenericDAO<Teacher>{

    private Connection connection = null;

    private void executePersistentChanges(String query) throws UnableCloseException, SQLException, UnableException {
        try {
            connection = ConnectionManager.connect();
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            connection.commit();
            connection.rollback();
        } catch (SQLException e) {
            if (e.getErrorCode() == 30080) {
                throw new UnableException("The connection is not possible");
            } else /*if(e.getErrorCode()==30090)*/ {
                throw new SQLException();
            }
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                if (e.getErrorCode() == 843) {
                    throw new UnableCloseException("The connection does not exist");
                }
            }
        }
    }

    public void create(Teacher teacher) throws EmptyException, ExistException, UnableException, UnableCloseException, SQLException {
        String name = teacher.getName();
        String lastName = teacher.getLastName();
        Long nid = teacher.getNid();
        String password = teacher.getPassword();
        String query = "INSERT INTO TEACHERS (NID, NAME, LAST_NAME, PASSWORD) VALUES (" + nid
                + ", '" + name + "', '" + lastName + "', '" + password + "')";
        this.executePersistentChanges(query);
    }


    public void delete(Long id) throws EmptyException, NotExistException, UnableException, UnableCloseException, SQLException {
        String query = "DELETE FROM TEACHERS WHERE NID = " + id;
        this.executePersistentChanges(query);
    }


    public void update(Teacher teacher) throws EmptyException, NotExistException, UnableException, UnableCloseException, SQLException {
        String name = teacher.getName();
        String lastName = teacher.getLastName();
        Long nid = teacher.getNid();
        String password = teacher.getPassword();
        //TODO CHECK
        String query = "UPDATE TEACHERS set NAME = '" + name + "', LAST_NAME = '" + lastName
                + "', NID =" + nid + ", PASSWORD = '" + password + "' WHERE NID = " + nid;
        this.executePersistentChanges(query);
    }


    public List<Teacher> list() throws UnableException, UnableCloseException, SQLException {
        List<Teacher> teacherList = new ArrayList<>();
        String query = "SELECT * FROM TEACHERS";
        try {
            connection = ConnectionManager.connect();
            Statement s = connection.createStatement();
            ResultSet results = s.executeQuery(query);

            while (results.next()) {
                Teacher persona = new Teacher(
                        results.getString("NAME"),
                        results.getString("LAST_NAME"),
                        results.getLong("NID"),
                        results.getString("PASSWORD"));
                teacherList.add(persona);

            }
        } catch (SQLException e) {
            if (e.getErrorCode()==30080){
                throw new UnableException("The connection is not possible");
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
        return teacherList;
    }

    public Teacher search(Long id) throws EmptyException, NotExistException, UnableException, UnableCloseException, SQLException{
        String query = "SELECT * FROM TEACHERS WHERE NID = " + id;
        try {
            connection = ConnectionManager.connect();
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery(query);

            if(rs.next()) {
                Long nid = rs.getLong("nid");
                String nombre = rs.getString("name");
                String apellido = rs.getString("last_name");
                String contrasenia = rs.getString("password");
                Teacher teacher = new Teacher(nombre, apellido, nid,contrasenia);
                return teacher;
            }
        } catch (SQLException e) {
            if (e.getErrorCode()==30080){
                throw new UnableException("The connection is not possible");
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
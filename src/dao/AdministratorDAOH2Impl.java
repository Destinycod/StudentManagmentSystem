package dao;

import entities.Administrator;
import exeptions.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdministratorDAOH2Impl implements GenericDAO<Administrator>{

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
            } else {
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
    public void create(Administrator administrator) throws EmptyException, ExistException, UnableException, UnableCloseException, SQLException {
        String name = administrator.getName();
        String lastName = administrator.getLastName();
        Long nid = administrator.getNid();
        String password = administrator.getPassword();

        String query = "INSERT INTO ADMINISTRATORS (NAME, LAST_NAME, NID, PASSWORD) VALUES ('" + name
                + "', '" + lastName + "', " + nid + ", '" + password + "')";
        this.executePersistentChanges(query);
    }

    @Override
    public void delete(Long nid) throws EmptyException, NotExistException, UnableException, UnableCloseException, SQLException {
        String query = "DELETE FROM ADMINISTRATORS WHERE NID = '" + nid + "'";
        this.executePersistentChanges(query);
    }

    @Override
    public void update(Administrator administrator) throws EmptyException, NotExistException, UnableException, UnableCloseException, SQLException {
        String name = administrator.getName();
        String lastName = administrator.getLastName();
        Long nid = administrator.getNid();
        String password = administrator.getPassword();

        String query = "UPDATE ADMINISTRATORS set NAME = '" + name + "', LAST_NAME = '" + lastName
                + "', NID =" + nid + ", PASSWORD = '" + password + "' WHERE NID = " + nid;
        this.executePersistentChanges(query);
    }

    @Override
    public List<Administrator> list() throws UnableException, UnableCloseException, SQLException {
        List<Administrator> adminList = new ArrayList<>();
        String query = "SELECT * FROM ADMINISTRATORS ORDER BY LAST_NAME";
        try {
            connection = ConnectionManager.connect();
            Statement s = connection.createStatement();
            ResultSet results = s.executeQuery(query);

            while (results.next()) {
                Administrator person = new Administrator(results.getString("NAME"),
                        results.getString("LAST_NAME"),
                        results.getLong("NID"),
                        results.getString("PASSWORD"));
                adminList.add(person);
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
        return adminList;
    }

    @Override
    public Administrator search(Long id) throws EmptyException, NotExistException, UnableException, UnableCloseException, SQLException {
        String query = "SELECT * FROM ADMINISTRATORS WHERE NID = " + id;
        Connection connection = null;
        try {
            connection = ConnectionManager.connect();
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery(query);

            if(rs.next()) {
                Long nid = rs.getLong("nid");
                String name = rs.getString("name");
                String last_name = rs.getString("last_name");
                String password = rs.getString("password");
                Administrator administrator = new Administrator(name, last_name, nid, password);
                return administrator;
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

package dao;

import entities.Course;
import exeptions.*;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CourseDAOH2Impl implements GenericDAO<Course> {

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
    public void create(Course course) throws EmptyException, ExistException, UnableException, UnableCloseException, SQLException {
        String name = course.getName();
        Long id = course.getId();
        double price = course.getPrice();
        int midterms = course.getMidtermsRequired();
        LocalDate startDate = course.getStartDate();
        Date endDate = (Date) course.getEndDate();
        int quota = course.getQuota();
        String query = "INSERT INTO COURSES (ID, NAME, PRICE, MIDTERMS, START_DATE, END_DATE, QUOTA) VALUES ("
                + id + ", '" + name + "', " + price + ", " + midterms + ", '" + startDate + "', '" + endDate + "', "
                + quota + ")";
        this.executePersistentChanges(query);
    }

    @Override
    public void delete(Long id) throws EmptyException, NotExistException, UnableException, UnableCloseException, SQLException {
        String query = "DELETE FROM COURSES WHERE ID = " + id;
        this.executePersistentChanges(query);
    }

    @Override
    public void update(Course course) throws EmptyException, NotExistException, UnableException, UnableCloseException, SQLException {
        String name = course.getName();
        Long id = course.getId();
        double price = course.getPrice();
        int midterms = course.getMidtermsRequired();
        LocalDate startDate = course.getStartDate();
        Date endDate = (Date) course.getEndDate();
        int quota = course.getQuota();
        String query = "UPDATE COURSES set ID = " + id + ", NAME = '" + name + "', PRICE = " + price
                + ", MIDTERMS = " + midterms + ", START_DATE = '" + startDate + "', END_DATE = '" + endDate
                + "', QUOTA = " + quota + " WHERE ID = " + id;

        this.executePersistentChanges(query);
    }

    @Override
    public List<Course> list() throws UnableException, UnableCloseException, SQLException {
        List<Course> courseList = new ArrayList<>();
        String query = "SELECT * FROM COURSES ORDER BY ID";
        //TODO
        //String query = "SELECT C.ID ID, C.NAME COURSE, T.ID TEACHER, " +
         //       "T.ID TEACHER_ID FROM COURSE C JOIN TEACHER T on C.ID = T.COURSE_ID join TASK T on P.ID = T.ID";
        try {
            connection = ConnectionManager.connect();
            Statement s = connection.createStatement();
            ResultSet results = s.executeQuery(query);

            while (results.next()) {
                Course course = new Course(results.getLong("ID"),
                        results.getString("NAME"),
                        results.getDouble("PRICE"),
                        results.getInt("MIDTERMS"),
                        LocalDate.parse(results.getString("START_DATE")),
                        results.getDate("END_DATE"),
                        results.getInt("QUOTA"));
                courseList.add(course);
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
        return courseList;
    }

    @Override
    public Course search(Long id) throws EmptyException, NotExistException, UnableException, UnableCloseException, SQLException {
        String query = "SELECT * FROM COURSES WHERE ID = " + id;
        try {
            connection = ConnectionManager.connect();
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery(query);
            if(rs.next()) {
                Course course = new Course(rs.getLong("ID"),
                        rs.getString("NAME"),
                        rs.getDouble("PRICE"),
                        rs.getInt("MIDTERMS"),
                        LocalDate.parse(rs.getString("START_DATE")), //TODO CHANGED FROM DATE
                        rs.getDate("END_DATE"),
                        rs.getInt("QUOTA"));
                return course;
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

package dao;

import exeptions.UnableCloseException;
import exeptions.UnableException;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TableManager {

    private void executePersistentChanges(String query) {
        Connection connection = null;
        try {
            connection = ConnectionManager.connect();
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            connection.commit();
            connection.rollback();
        } catch (SQLException e) {
            try {
                connection.rollback();
                e.printStackTrace();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void createStudentTable(){

        String sql = "CREATE TABLE STUDENTS (NID INT PRIMARY KEY, NAME VARCHAR(255), " +
                "LAST_NAME VARCHAR(255), PASSWORD VARCHAR(8), TOTAL_COURSES INT)";

        this.executePersistentChanges(sql);
    }

    public void dropStudentTable() {
        String sql = "DROP TABLE STUDENTS";
        this.executePersistentChanges(sql);
    }

    public void createCourseTable(){

        String sql = "CREATE TABLE COURSES (ID INT PRIMARY KEY, NAME VARCHAR(255), PRICE DOUBLE," +
                "MIDTERMS INT, START_DATE DATE, END_DATE DATE, QUOTA INT)";
        this.executePersistentChanges(sql);
    }

    public void dropCourseTable() {
        String sql = "DROP TABLE COURSES";
        this.executePersistentChanges(sql);
    }

    public void createTeacherTable(){
        String sql = "CREATE TABLE TEACHERS (NID INT PRIMARY KEY, NAME VARCHAR(255), " +
                "LAST_NAME VARCHAR(255), PASSWORD VARCHAR(8))";
        this.executePersistentChanges(sql);
    }

    public void dropTeachersTable() {
        String sql = "DROP TABLE TEACHERS";
        this.executePersistentChanges(sql);
    }

    public void createEnrollmentTable(){
        String sql = "CREATE TABLE ENROLLMENTS (ID INT PRIMARY KEY, " +
                "STUDENT_ID INT, FOREIGN KEY (STUDENT_ID) REFERENCES STUDENTS(NID), " +
                "COURSE_ID INT, FOREIGN KEY (COURSE_ID) REFERENCES COURSES(ID))";
        this.executePersistentChanges(sql);
    }

    public void dropEnrollmentTable() {
        String sql = "DROP TABLE ENROLLMENTS";
        this.executePersistentChanges(sql);
    }

    public void createQualificationTable(){
        String sql = "CREATE TABLE QUALIFICATIONS (ID INT PRIMARY KEY, SCORE INT," +
                "TEACHER_ID INT, FOREIGN KEY (TEACHER_ID) REFERENCES TEACHERS(NID)," +
                "COURSE_ID INT, FOREIGN KEY (COURSE_ID) REFERENCES COURSES(ID), " +
                "STUDENT_ID INT, FOREIGN KEY (STUDENT_ID) REFERENCES STUDENTS(NID))";
        this.executePersistentChanges(sql);
    }

    public void dropQualificationTable() {
        String sql = "DROP TABLE QUALIFICATIONS";
        this.executePersistentChanges(sql);
    }

    public void createAdministratorTable(){

        String sql = "CREATE TABLE ADMINISTRATORS (NID INT PRIMARY KEY, NAME VARCHAR(255), " +
                "LAST_NAME VARCHAR(255), PASSWORD VARCHAR(8))";

        this.executePersistentChanges(sql);
    }

    public void dropAdministratorTable() {
        String sql = "DROP TABLE ADMINISTRATORS";
        this.executePersistentChanges(sql);
    }
}

package ui;


import entities.Student;
import entities.Teacher;
import ui.admins.*;
import ui.reports.AllCoursesReportTablePanel;
import ui.students.StudentPanel;
import ui.teachers.TeacherPanel;

import javax.swing.*;

/*
2:20:00 Clase 27/05
frame.pack() ajusta la ventana para que los componentes se vean usando el menor espacio posible
frame.getContentPane() es como accedo al contenedor principal (pensado para contener componentes)
1:30:00 FLOW LAYOUT
1:43:00 GRID LAYOUT
1:50:00 BORDER LAYOUT
1:55:00 BOX LAYOUT
2:02:00 Explicacion de marco con varios paneles
2:16 EVENTOS
2:42:00 Como hacer para cambiar de paneles que estan dentro de un panel padre
2:54:00 JTable
3:23 CARGA DE TABLA
*/
public class WindowManager {

    private JFrame frame;
    private LogInPanel logInPanel;
    private StudentPanel studentPanel;
    private TeacherPanel teacherPanel;

    public WindowManager(JFrame frame){
        this.frame = frame;
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void closeFrame(){
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void redirectToLogIn(){
        logInPanel = new LogInPanel(this);
        frame.getContentPane().removeAll();
        frame.getContentPane().add(logInPanel);
        frame.getContentPane().validate();
        frame.getContentPane().repaint();
        frame.setVisible(true);
    }

    public void redirectToStudent(Student student){
        studentPanel = new StudentPanel(this, student);
        frame.getContentPane().removeAll();
        if (student!=null){
            frame.getContentPane().add(studentPanel);
            frame.getContentPane().validate();
            frame.getContentPane().repaint();
            frame.setVisible(true);
        }
    }

    public void redirectToTeacher(Teacher teacher){
        teacherPanel = new TeacherPanel(this, teacher);
        frame.getContentPane().removeAll();
        if (teacher!=null){
            frame.getContentPane().add(teacherPanel);
            frame.getContentPane().validate();
            frame.getContentPane().repaint();
            frame.setVisible(true);
        }
    }

    public void redirectToAdministrator(){
        AdministratorPanel administratorPanel = new AdministratorPanel(this);
        frame.getContentPane().removeAll();
        frame.getContentPane().add(administratorPanel);
        frame.getContentPane().validate();
        frame.getContentPane().repaint();
        frame.setVisible(true);
    }

    public void redirectToStudentView(){
        StudentViewPanel studentViewPanel = new StudentViewPanel(this);
        frame.getContentPane().removeAll();
        frame.getContentPane().add(studentViewPanel);
        frame.getContentPane().validate();
        frame.getContentPane().repaint();
        frame.setVisible(true);
    }

    public void redirectToTeacherView(){
        TeacherViewPanel teacherViewPanel = new TeacherViewPanel(this);
        frame.getContentPane().removeAll();
        frame.getContentPane().add(teacherViewPanel);
        frame.getContentPane().validate();
        frame.getContentPane().repaint();
        frame.setVisible(true);
    }

    public void redirectToCourseView(){
        CourseViewPanel courseViewPanel = new CourseViewPanel(this);
        frame.getContentPane().removeAll();
        frame.getContentPane().add(courseViewPanel);
        frame.getContentPane().validate();
        frame.getContentPane().repaint();
        frame.setVisible(true);
    }

    public void redirectToReportView(){ //TODO
        ReportViewPanel reportViewPanel = new ReportViewPanel(this);
        frame.getContentPane().removeAll();
        frame.getContentPane().add(reportViewPanel);
        frame.getContentPane().validate();
        frame.getContentPane().repaint();
        frame.setVisible(true);
    }

    public void redirectToAllCoursesReportTablePanel(){ //TODO
        AllCoursesReportTablePanel allCoursesReportTablePanel = new AllCoursesReportTablePanel(this);
        frame.getContentPane().removeAll();
        frame.getContentPane().add(allCoursesReportTablePanel);
        frame.getContentPane().validate();
        frame.getContentPane().repaint();
        frame.setVisible(true);
    }
    /*
    public void redirectToStudentRegistration(){
        StudentRegistrationPanel studentRegistration = new StudentRegistrationPanel (this);
        frame.getContentPane().removeAll();
        frame.getContentPane().add(studentRegistration);
        frame.getContentPane().validate();
        frame.getContentPane().repaint();
        frame.setVisible(true);
    }

    public void redirectToStudentDelete(){
        DeleteStudentPanel deleteStudentPanel = new DeleteStudentPanel (this);
        frame.getContentPane().removeAll();
        frame.getContentPane().add(deleteStudentPanel);
        frame.getContentPane().validate();
        frame.getContentPane().repaint();
        frame.setVisible(true);
    }

    public void redirectToStudentUpdate(){
        UpdateStudentPanel updateStudentPanel = new UpdateStudentPanel (this);
        frame.getContentPane().removeAll();
        frame.getContentPane().add(updateStudentPanel);
        frame.getContentPane().validate();
        frame.getContentPane().repaint();
        frame.setVisible(true);
    }

    public void redirectToStudentSearch(){
        UpdateStudentPanel updateStudentPanel = new UpdateStudentPanel (this);
        frame.getContentPane().removeAll();
        frame.getContentPane().add(updateStudentPanel);
        frame.getContentPane().validate();
        frame.getContentPane().repaint();
        frame.setVisible(true);
    }

    public void redirectToStudentList(){
        StudentsTablePanel studentsTablePanel = new StudentsTablePanel (this);
        frame.getContentPane().removeAll();
        frame.getContentPane().add(studentsTablePanel);
        frame.getContentPane().validate();
        frame.getContentPane().repaint();
        frame.setVisible(true);
    }

    public void redirectToCourseRegistration(){
        CourseRegistrationPanel courseRegistrationPanel = new CourseRegistrationPanel (this);
        frame.getContentPane().removeAll();
        frame.getContentPane().add(courseRegistrationPanel);
        frame.getContentPane().validate();
        frame.getContentPane().repaint();
        frame.setVisible(true);
    }*/

}

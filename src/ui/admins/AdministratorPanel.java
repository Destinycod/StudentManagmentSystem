package ui.admins;

import ui.WindowManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//todo
public class AdministratorPanel extends JPanel  {

    private WindowManager windowManager;
    private JButton studentButton;
    private JButton teacherButton;
    private JButton courseButton;
    private JButton reportButton;
    private JButton goBackButton;

    public AdministratorPanel(WindowManager windowManager){
        this.windowManager = windowManager;
        assemble();
    }

    private void assemble(){
        this.setLayout(new GridLayout(2,3));

        this.studentButton = new JButton("Students");
        this.add(this.studentButton);
        this.studentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                windowManager.redirectToStudentView(); //TODO
            }
        });

        this.teacherButton = new JButton("Teachers");
        this.add(this.teacherButton);
        this.teacherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                windowManager.redirectToTeacherView();
            }
        });

        this.courseButton = new JButton("Courses");
        this.add(this.courseButton);
        this.courseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                windowManager.redirectToCourseView();
            }
        });

        this.reportButton = new JButton("Reports");
        this.add(this.reportButton);
        this.reportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                windowManager.redirectToReportView();
            }
        });

        this.goBackButton = new JButton("Go Back");
        this.add(this.goBackButton);
        this.goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                windowManager.redirectToLogIn();
            }
        });
    }

}

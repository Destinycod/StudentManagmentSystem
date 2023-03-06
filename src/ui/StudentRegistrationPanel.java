package ui;

import entities.Student;
import exeptions.*;
import service.StudentService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentRegistrationPanel extends JPanel implements ActionListener {

    private GeneralButtonPanel buttons;
    private GeneralTitle title;
    private StudentFormPanel registerFormPanel;
    private WindowManager windowManager;

    public StudentRegistrationPanel(WindowManager windowManager){
        this.windowManager = windowManager;
        assemble();
    }

    private void assemble(){
        this.setLayout(new BorderLayout());

        this.title = new GeneralTitle("Student Registration");
        this.add(title, BorderLayout.NORTH);

        this.registerFormPanel = new StudentFormPanel();
        this.add(registerFormPanel, BorderLayout.CENTER);

        this.buttons = new GeneralButtonPanel();
        this.add(buttons, BorderLayout.SOUTH);

        this.buttons.getOkButton().addActionListener(this);
        this.buttons.getCancelButton().addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Long nidEntered = Long.parseLong(this.registerFormPanel.getNidTextField().getText());
        String nameEntered = this.registerFormPanel.getNameTextField().getText();
        String lastNameEntered = this.registerFormPanel.getLastNameTextField().getText();
        String passwordEntered = this.registerFormPanel.getPasswordTextField().getText();
        StudentService studentService = new StudentService();
        Student studentEntered = new Student(nameEntered,lastNameEntered,nidEntered,passwordEntered);
        System.out.println(studentEntered);
        if(e.getSource() == this.buttons.getOkButton()) {
            try {
                studentService.create(studentEntered);

            } catch (EmptyFieldException ex) {
                ex.printStackTrace();
            } catch (EntityAlreadyExistException ex) {
                ex.printStackTrace();
            } catch (UnableConnectionException ex) {
                ex.printStackTrace();
            } catch (UnableCloseConnectionException ex) {
                ex.printStackTrace();
            } catch (OperationException ex) {
                ex.printStackTrace();
            }
        }
        if(e.getSource() == this.buttons.getCancelButton()){
            windowManager.redirectToAdministrator();
        }

    }
}

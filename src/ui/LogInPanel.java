package ui;

import entities.Student;
import entities.Teacher;
import exeptions.*;
import service.StudentService;
import service.TeacherService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogInPanel extends JPanel implements ActionListener{

    private GeneralTitle generalTitle;
    private LogInFormPanel logInFormPanel;
    private GeneralButtonPanel generalButtonPanel;
    private WindowManager windowManager;

    public LogInPanel(WindowManager windowManager){
        this.windowManager = windowManager;
        assemble();
    }

    private void assemble(){
        this.setLayout(new BorderLayout());

        this.generalTitle = new GeneralTitle("Log In");
        this.add(this.generalTitle, BorderLayout.NORTH);

        this.logInFormPanel = new LogInFormPanel();
        this.add(this.logInFormPanel, BorderLayout.CENTER);

        this.generalButtonPanel = new GeneralButtonPanel();
        this.add(this.generalButtonPanel, BorderLayout.SOUTH);

        this.generalButtonPanel.getOkButton().addActionListener(this);
        this.generalButtonPanel.getCancelButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                windowManager.closeFrame();
            }
        });
    }

    public Long validaInt(String number){
        Long result = Long.valueOf(-1); //Valor default.
        try{
            if(number != null){
                result = Long.parseLong(number);
            }
        }catch(NumberFormatException nfe){
            //throw new EmptyFieldException();
        }
        return result;
    }

    public void actionPerformed(ActionEvent actionEvent) {
        String selectedItem = (String) logInFormPanel.getEntityJComboBox().getSelectedItem();
        Long nidEntered = validaInt(logInFormPanel.getNidTextField().getText());
        String passwordEntered = logInFormPanel.getPasswordTextField().getText();

        if (nidEntered == -1 || passwordEntered == null) {
            JOptionPane.showMessageDialog(null, "There cannot be EMPTY fields");
        } else {

            if (selectedItem.equals("Student")) {

                StudentService studentService = new StudentService();
                String studentPassword = null;
                Student student;

                try {
                    studentPassword = studentService.search(nidEntered).getPassword();
                    if (studentPassword.equals(passwordEntered)) {
                        if (actionEvent.getSource() == this.generalButtonPanel.getOkButton()) {
                            // 2:40:00 Clase 03/06
                            student = studentService.search(nidEntered);
                            windowManager.redirectToStudent(student);
                        }
                    }

                } catch (EmptyFieldException e) {
                    JOptionPane.showMessageDialog(null, "There cannot be EMPTY fields");
                } catch (EntityNotExistException e) {
                    JOptionPane.showMessageDialog(null, "The NID does not exist");
                } catch (UnableCloseConnectionException e) {
                    JOptionPane.showMessageDialog(null, "The connection could not be closed");
                } catch (UnableConnectionException e) {
                    JOptionPane.showMessageDialog(null, "The connection could not be established");
                } catch (OperationException e) {
                    JOptionPane.showMessageDialog(null, "Operation Error");
                }

            } else if (selectedItem.equals("Administrator")) {
                if (actionEvent.getSource() == this.generalButtonPanel.getOkButton()) {
                    windowManager.redirectToAdministrator();
                }

            } else {
                TeacherService teacherService = new TeacherService();
                String teacherPassword = null;
                Teacher teacher;

                try {
                    teacherPassword = teacherService.search(nidEntered).getPassword();
                    if (teacherPassword.equals(passwordEntered)) {
                        if (actionEvent.getSource() == this.generalButtonPanel.getOkButton()) {
                            teacher = teacherService.search(nidEntered);
                            windowManager.redirectToTeacher(teacher);
                        }
                    }
                } catch (EntityNotExistException e) {
                    e.printStackTrace();
                } catch (EmptyFieldException e) {
                    e.printStackTrace();
                } catch (UnableCloseConnectionException e) {
                    e.printStackTrace();
                } catch (OperationException e) {
                    e.printStackTrace();
                } catch (UnableConnectionException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}



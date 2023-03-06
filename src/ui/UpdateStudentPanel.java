package ui;

import entities.Student;
import exeptions.*;
import service.StudentService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateStudentPanel extends JPanel implements ActionListener {

    private JLabel studentName;
    private JTextField studentNameTF;
    private JLabel studentLastName;
    private JTextField studentLastNameTF;
    private JLabel studentNID;
    private JTextField studentNIDTF;
    private JLabel studentPassword;
    private JTextField studentPasswordTF;
    private JPanel updatePanel;

    private GeneralButtonPanel buttons;
    private GeneralTitle title;
    private WindowManager windowManager;

    public UpdateStudentPanel(WindowManager windowManager){
        this.windowManager = windowManager;
        assemble();
    }

    private void assemble(){
        this.setLayout(new BorderLayout());

        this.title = new GeneralTitle("STUDENT UPDATE");
        this.add(this.title, BorderLayout.NORTH);

        this.updatePanel = new JPanel();
        updatePanel.setLayout(new GridLayout(4,2));

        this.studentName = new JLabel("Name");
        updatePanel.add(this.studentName);

        this.studentNameTF = new JTextField(25);
        updatePanel.add(this.studentNameTF);

        this.studentLastName = new JLabel("Last Name");
        updatePanel.add(this.studentLastName);

        this.studentLastNameTF = new JTextField();
        updatePanel.add(this.studentLastNameTF);

        this.studentNID = new JLabel("NID");
        updatePanel.add(this.studentNID);

        this.studentNIDTF = new JTextField();
        updatePanel.add(this.studentNIDTF);

        this.studentPassword = new JLabel("Password");
        updatePanel.add(this.studentPassword);

        this.studentPasswordTF = new JTextField();
        updatePanel.add(this.studentPasswordTF);

        this.add(updatePanel, BorderLayout.CENTER);

        this.buttons = new GeneralButtonPanel();
        this.add(buttons, BorderLayout.SOUTH);

        this.buttons.getOkButton().addActionListener(this);
        this.buttons.getCancelButton().addActionListener(this);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Long nidEntered = Long.parseLong(this.getStudentNIDTF().getText());
        String nameEntered = this.getStudentNameTF().getText();
        String lastNameEntered = this.getStudentLastNameTF().getText();
        String passwordEntered = this.getStudentPasswordTF().getText();
        StudentService studentService = new StudentService();
        Student studentEntered = new Student(nameEntered,lastNameEntered,nidEntered,passwordEntered);

        if(e.getSource() == this.buttons.getOkButton()){
            try {
                studentService.update(studentEntered);
            } catch (EntityNotExistException ex) {
                ex.printStackTrace();
            } catch (UnableConnectionException ex) {
                ex.printStackTrace();
            } catch (UnableCloseConnectionException ex) {
                ex.printStackTrace();
            } catch (OperationException ex) {
                ex.printStackTrace();
            } catch (EmptyFieldException ex) {
                JOptionPane.showMessageDialog(null, "There cannot be EMPTY fields");
            }
        }
        if(e.getSource() == this.buttons.getCancelButton()){
            windowManager.redirectToAdministrator();
        }

    }

    public JTextField getStudentNameTF() {
        return studentNameTF;
    }

    public JTextField getStudentLastNameTF() {
        return studentLastNameTF;
    }

    public JTextField getStudentNIDTF() {
        return studentNIDTF;
    }

    public JTextField getStudentPasswordTF() {
        return studentPasswordTF;
    }
}

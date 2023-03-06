package ui.admins;

import entities.Student;
import exeptions.*;
import service.StudentService;
import ui.CRUDButtons;
import ui.WindowManager;
import ui.students.StudentDataPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentViewPanel extends JPanel implements ActionListener {

    protected WindowManager manager;
    private StudentDataPanel studentDataPanel;
    private CRUDButtons crudButtons;
    private StudentsTablePanel studentsTablePanel;

    public StudentViewPanel(WindowManager manager){
        this.manager = manager;
        assemble();
    }

    public void assemble(){
        this.setLayout(new GridLayout(2,2));

        this.studentDataPanel = new StudentDataPanel(manager);
        this.add(this.studentDataPanel);
        this.studentDataPanel.getSearchButton().addActionListener(this);

        this.studentsTablePanel = new StudentsTablePanel(manager);
        this.add(studentsTablePanel);

        this.crudButtons = new CRUDButtons();
        this.add(crudButtons);
        this.crudButtons.getAddButton().addActionListener(this);
        this.crudButtons.getGoBackButton().addActionListener(this);
        this.crudButtons.getEditButton().addActionListener(this);
        this.crudButtons.getDeleteButton().addActionListener(this);

    }

    public void actionPerformed(ActionEvent actionEvent) {
        StudentService studentService = new StudentService();

        if (actionEvent.getSource() == this.crudButtons.getGoBackButton()){
            manager.redirectToAdministrator();
        }
        if (actionEvent.getSource() == this.studentDataPanel.getSearchButton()){
            Long searchValue = Long.parseLong(this.studentDataPanel.getSearchLabel().getText());
            try {
                this.studentDataPanel.getEntityName().setText(studentService.search(searchValue).getName());
                this.studentDataPanel.getEntityLastName().setText(studentService.search(searchValue).getLastName());
                this.studentDataPanel.getEntityNID().setText(String.valueOf(studentService.search(searchValue).getNid()));
                this.studentDataPanel.getEntityPassword().setText(studentService.search(searchValue).getPassword());
                this.studentDataPanel.getSearchLabel().setText("");
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
        }

        if(actionEvent.getSource() == this.crudButtons.getAddButton()){
            Student student = new Student();
            student.setName(this.studentDataPanel.getEntityName().getText());
            student.setLastName(this.studentDataPanel.getEntityLastName().getText());
            student.setNid(Long.valueOf(this.studentDataPanel.getEntityNID().getText()));
            student.setPassword(this.studentDataPanel.getEntityPassword().getText());
            try {
                studentService.create(student);
            } catch (EmptyFieldException e) {
                JOptionPane.showMessageDialog(null, "There cannot be EMPTY fields");
            } catch (EntityAlreadyExistException e) {
                JOptionPane.showMessageDialog(null, "The student ALREADY exist");
            } catch (UnableCloseConnectionException e) {
                JOptionPane.showMessageDialog(null, "The connection could not be closed");
            } catch (UnableConnectionException e) {
                JOptionPane.showMessageDialog(null, "The connection could not be established");
            } catch (OperationException e) {
                JOptionPane.showMessageDialog(null, "Operation Error");
            }
        }

        if(actionEvent.getSource() == this.crudButtons.getEditButton()){
            Student student = new Student();
            student.setName(this.studentDataPanel.getEntityName().getText());
            student.setLastName(this.studentDataPanel.getEntityLastName().getText());
            student.setNid(Long.valueOf(this.studentDataPanel.getEntityNID().getText()));
            student.setPassword(this.studentDataPanel.getEntityPassword().getText());
            try {
                studentService.update(student);
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
        }

        if(actionEvent.getSource() == this.crudButtons.getDeleteButton()){
            try {
                studentService.delete(Long.valueOf(this.studentDataPanel.getEntityNID().getText()));
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
        }
    }
}

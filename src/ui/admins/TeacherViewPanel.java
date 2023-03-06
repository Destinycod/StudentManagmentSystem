package ui.admins;

import entities.Teacher;
import exeptions.*;
import service.TeacherService;
import ui.CRUDButtons;
import ui.WindowManager;
import ui.teachers.TeacherDataPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TeacherViewPanel extends JPanel implements ActionListener {

    protected WindowManager manager;
    private TeacherDataPanel teacherDataPanel;
    private CRUDButtons crudButtons;
    private TeachersTablePanel teachersTablePanel;

    public TeacherViewPanel(WindowManager manager){
        this.manager = manager;
        assemble();
    }

    public void assemble(){
        this.setLayout(new GridLayout(2,2));

        this.teacherDataPanel = new TeacherDataPanel(manager);
        this.add(this.teacherDataPanel);
        this.teacherDataPanel.getSearchButton().addActionListener(this);

        this.teachersTablePanel = new TeachersTablePanel(manager);
        this.add(teachersTablePanel);

        this.crudButtons = new CRUDButtons();
        this.add(crudButtons);
        this.crudButtons.getAddButton().addActionListener(this);
        this.crudButtons.getGoBackButton().addActionListener(this);
        this.crudButtons.getEditButton().addActionListener(this);
        this.crudButtons.getDeleteButton().addActionListener(this);

    }
    //TODO Agregar el campo de la pass al studentdatapanel, para hacer el add
    public void actionPerformed(ActionEvent actionEvent) {
        TeacherService teacherService = new TeacherService();

        if (actionEvent.getSource() == this.crudButtons.getGoBackButton()){
            manager.redirectToAdministrator();
        }
        if (actionEvent.getSource() == this.teacherDataPanel.getSearchButton()){
            Long searchValue = Long.parseLong(this.teacherDataPanel.getSearchLabel().getText());
            try {
                this.teacherDataPanel.getEntityName().setText(teacherService.search(searchValue).getName());
                this.teacherDataPanel.getEntityLastName().setText(teacherService.search(searchValue).getLastName());
                this.teacherDataPanel.getEntityNID().setText(String.valueOf(teacherService.search(searchValue).getNid()));
                this.teacherDataPanel.getEntityPassword().setText(teacherService.search(searchValue).getPassword());
                this.teacherDataPanel.getSearchLabel().setText("");
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
            Teacher teacher = new Teacher();
            teacher.setName(this.teacherDataPanel.getEntityName().getText());
            teacher.setLastName(this.teacherDataPanel.getEntityLastName().getText());
            teacher.setNid(Long.valueOf(this.teacherDataPanel.getEntityNID().getText()));
            teacher.setPassword(this.teacherDataPanel.getEntityPassword().getText());
            try {
                teacherService.create(teacher);
            } catch (EmptyFieldException e) {
                JOptionPane.showMessageDialog(null, "There cannot be EMPTY fields");
            } catch (EntityAlreadyExistException e) {
                JOptionPane.showMessageDialog(null, "The theacher ALREADY exist");
            } catch (UnableCloseConnectionException e) {
                JOptionPane.showMessageDialog(null, "The connection could not be closed");
            } catch (UnableConnectionException e) {
                JOptionPane.showMessageDialog(null, "The connection could not be established");
            } catch (OperationException e) {
                JOptionPane.showMessageDialog(null, "Operation Error");
            }
        }

        if(actionEvent.getSource() == this.crudButtons.getEditButton()){
            Teacher teacher = new Teacher();
            teacher.setName(this.teacherDataPanel.getEntityName().getText());
            teacher.setLastName(this.teacherDataPanel.getEntityLastName().getText());
            teacher.setNid(Long.valueOf(this.teacherDataPanel.getEntityNID().getText()));
            teacher.setPassword(this.teacherDataPanel.getEntityPassword().getText());
            try {
                teacherService.update(teacher);
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
                teacherService.delete(Long.valueOf(this.teacherDataPanel.getEntityNID().getText()));
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

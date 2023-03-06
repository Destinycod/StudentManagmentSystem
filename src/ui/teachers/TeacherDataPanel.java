package ui.teachers;

import ui.EntityDataPanel;
import ui.WindowManager;

import javax.swing.*;
import java.awt.*;

public class TeacherDataPanel extends EntityDataPanel {

    private JLabel name;
    private JTextField entityName;
    private JLabel lastName;
    private JTextField entityLastName;
    private JLabel nid;
    private JTextField entityNID;
    private JLabel password;
    private JTextField entityPassword;
    private JButton searchButton;
    private JTextField searchLabel;
    private JButton qualifications;
    private JButton goBack;
    //TODO AGREGAR EL BOTON DE NOTAS Y LA TABLA DE CURSOS Y NOTAS

    public TeacherDataPanel(WindowManager manager) {
        super(manager);
    }

    @Override
    public void assembleForm() {
        this.setLayout(new GridLayout(5,3));

        this.name = new JLabel("Name");
        this.add(name);

        this.entityName = new JTextField(25);
        this.add(entityName);

        this.lastName = new JLabel("Last Name");
        this.add(lastName);

        this.entityLastName = new JTextField(25);
        this.add(entityLastName);

        this.nid = new JLabel("NID");
        this.add(nid);

        this.entityNID = new JTextField(10);
        this.add(entityNID);

        this.password = new JLabel("Password");
        this.add(password);

        this.entityPassword = new JTextField(10);
        this.add(entityPassword);

        this.searchButton = new JButton("Search");
        this.add(searchButton);

        this.searchLabel = new JTextField(10);
        this.add(searchLabel);
    }

    public JTextField getEntityName() {
        return entityName;
    }

    public void setEntityName(JTextField entityName) {
        this.entityName = entityName;
    }

    public JTextField getEntityLastName() {
        return entityLastName;
    }

    public void setEntityLastName(JTextField entityLastName) {
        this.entityLastName = entityLastName;
    }

    public JTextField getEntityNID() {
        return entityNID;
    }

    public void setEntityNID(JTextField entityNID) {
        this.entityNID = entityNID;
    }

    public JTextField getEntityPassword() {
        return entityPassword;
    }

    public void setEntityPassword(JTextField entityPassword) {
        this.entityPassword = entityPassword;
    }

    public JButton getSearchButton() {
        return searchButton;
    }

    public void setSearchButton(JButton searchButton) {
        this.searchButton = searchButton;
    }

    public JTextField getSearchLabel() {
        return searchLabel;
    }

    public void setSearchLabel(JTextField searchLabel) {
        this.searchLabel = searchLabel;
    }

    public JButton getQualifications() {
        return qualifications;
    }

    public void setQualifications(JButton qualifications) {
        this.qualifications = qualifications;
    }

    public JButton getGoBack() {
        return goBack;
    }

    public void setGoBack(JButton goBack) {
        this.goBack = goBack;
    }
}

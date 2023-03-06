package ui;

import javax.swing.*;

public class CRUDButtons extends JPanel{

    private JButton addButton;
    private JButton editButton;
    private JButton deleteButton;
    private JButton goBackButton;

    public CRUDButtons(){
        assemble();
    }

    private void assemble(){
        this.addButton = new JButton("Add");
        this.add(addButton);

        this.editButton = new JButton("Edit");
        this.add(editButton);

        this.deleteButton = new JButton("Delete");
        this.add(deleteButton);

        this.goBackButton = new JButton("Go back");
        this.add(goBackButton);
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getEditButton() {
        return editButton;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public JButton getGoBackButton() {
        return goBackButton;
    }
}

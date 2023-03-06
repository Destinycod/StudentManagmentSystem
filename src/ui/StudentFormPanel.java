package ui;

import javax.swing.*;
import java.awt.*;

public class StudentFormPanel extends JPanel {

    private JLabel nameLabel;
    private JTextField nameTextField;
    private JLabel lastNameLabel;
    private JTextField lastNameTextField;
    private JLabel nidLabel;
    private JTextField nidTextField;
    private JLabel passwordLabel;
    private JTextField passwordTextField;

    public StudentFormPanel(){
        assemble();
    }

    private void assemble(){
        this.setLayout(new GridLayout(4,2));

        this.nameLabel = new JLabel("Name");
        JPanel namePanel = new JPanel();
        namePanel.add(nameLabel);
        this.add(namePanel);

        this.nameTextField = new JTextField(25);
        JPanel nameTextFieldPanel = new JPanel();
        nameTextFieldPanel.add(nameTextField);
        this.add(nameTextFieldPanel);

        this.lastNameLabel = new JLabel("Last Name");
        JPanel lastNamePanel = new JPanel();
        lastNamePanel.add(lastNameLabel);
        this.add(lastNamePanel);

        this.lastNameTextField = new JTextField(25);
        JPanel lastNameTextFieldPanel = new JPanel();
        lastNameTextFieldPanel.add(lastNameTextField);
        this.add(lastNameTextFieldPanel);

        this.nidLabel = new JLabel("NID");
        JPanel nidPanel = new JPanel();
        nidPanel.add(nidLabel);
        this.add(nidPanel);

        this.nidTextField = new JTextField(25);
        JPanel nidTextFieldPanel = new JPanel();
        nidTextFieldPanel.add(nidTextField);
        this.add(nidTextFieldPanel);

        this.passwordLabel = new JLabel("Password");
        JPanel passwordPanel = new JPanel();
        passwordPanel.add(passwordLabel);
        this.add(passwordPanel);

        this.passwordTextField = new JTextField(25);
        JPanel passwordTextFieldPanel = new JPanel();
        passwordTextFieldPanel.add(passwordTextField);
        this.add(passwordTextFieldPanel);
    }

    public JTextField getNameTextField() {
        return nameTextField;
    }

    public JTextField getLastNameTextField() {
        return lastNameTextField;
    }

    public JTextField getNidTextField() {
        return nidTextField;
    }

    public JTextField getPasswordTextField() {
        return passwordTextField;
    }
}

package ui;

import javax.swing.*;
import java.awt.*;

public class LogInFormPanel extends JPanel{

    private JLabel nidLabel;
    private JTextField nidTextField;
    private JLabel passwordLabel;
    private JTextField passwordTextField;
    private JComboBox entityJComboBox; //admin, stu, teac

    public LogInFormPanel(){
        assemble();
    }

    private void assemble(){
        this.setLayout(new GridLayout(3,2));

        this.nidLabel = new JLabel("NID");
        JPanel nidPanel = new JPanel();
        nidPanel.add(nidLabel);
        this.add(nidPanel);

        this.nidTextField = new JTextField(10);
        JPanel nidTextFieldPanel = new JPanel();
        nidTextFieldPanel.add(nidTextField);
        this.add(nidTextFieldPanel);

        this.passwordLabel = new JLabel("Password");
        JPanel passwordPanel = new JPanel();
        passwordPanel.add(passwordLabel);
        this.add(passwordPanel);

        this.passwordTextField = new JTextField(10);
        JPanel passwordTextFieldPanel = new JPanel();
        passwordTextFieldPanel.add(passwordTextField);
        this.add(passwordTextFieldPanel);

        this.entityJComboBox = new JComboBox();
        entityJComboBox.addItem("Student");
        entityJComboBox.addItem("Teacher");
        entityJComboBox.addItem("Administrator");
        JPanel entityJCB = new JPanel();
        entityJCB.add(entityJComboBox);
        this.add(entityJCB);

    }

    public JTextField getNidTextField(){
        return nidTextField;
    }

    public JTextField getPasswordTextField() {
        return passwordTextField;
    }

    public JComboBox getEntityJComboBox() {
        return entityJComboBox;
    }

    /*public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setLayout(new FlowLayout());
        frame.setMinimumSize(new Dimension(600,600));
        WindowManager windowManager = new WindowManager(frame);

    }*/
}

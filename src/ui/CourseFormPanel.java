package ui;

import javax.swing.*;
import java.awt.*;

public class CourseFormPanel extends JPanel {

    private JLabel name;
    private JTextField nameTextField;
    private JLabel id;
    private JTextField idTextField;
    private JLabel fee;
    private JTextField feeTextField;
    private JLabel midterms;
    private JTextField midtermsTextField;
    private JLabel weeksDuration;
    private JTextField weeksDurationTextField;
    private JLabel maximumCapacity;
    private JTextField maximumCapacityTextField;
    private JLabel teacher;
    private JTextField teacherTextField;

    public CourseFormPanel(){
        assemble();
    }

    private void assemble() {
        this.setLayout(new GridLayout(7,2));

        this.name = new JLabel("Name");
        JPanel namePanel = new JPanel();
        namePanel.add(name);
        this.add(namePanel);

        this.nameTextField = new JTextField(25);
        JPanel nameTextFieldPanel = new JPanel();
        nameTextFieldPanel.add(nameTextField);
        this.add(nameTextFieldPanel);

        this.id = new JLabel("ID");
        JPanel idPanel = new JPanel();
        idPanel.add(id);
        this.add(idPanel);

        this.idTextField = new JTextField(25);
        JPanel idTextFieldPanel = new JPanel();
        idTextFieldPanel.add(idTextField);
        this.add(idTextFieldPanel);

        this.fee = new JLabel("Fee");
        JPanel feePanel = new JPanel();
        feePanel.add(fee);
        this.add(feePanel);

        this.feeTextField = new JTextField(25);
        JPanel feeTextFieldPanel = new JPanel();
        feeTextFieldPanel.add(feeTextField);
        this.add(feeTextFieldPanel);

        this.midterms = new JLabel("Midterms necessary");
        JPanel midtermsPanel = new JPanel();
        midtermsPanel.add(midterms);
        this.add(midtermsPanel);

        this.midtermsTextField = new JTextField(25);
        JPanel midtermsTextFieldPanel = new JPanel();
        midtermsTextFieldPanel.add(midtermsTextField);
        this.add(midtermsTextFieldPanel);

        this.weeksDuration = new JLabel("Weeks duration");
        JPanel weeksDurationPanel = new JPanel();
        weeksDurationPanel.add(weeksDuration);
        this.add(weeksDurationPanel);

        this.weeksDurationTextField = new JTextField(25);
        JPanel weeksDurationTextFieldPanel = new JPanel();
        weeksDurationTextFieldPanel.add(weeksDurationTextField);
        this.add(weeksDurationTextFieldPanel);

        this.maximumCapacity = new JLabel("Maximum Capacity");
        JPanel maximumCapacityPanel = new JPanel();
        maximumCapacityPanel.add(maximumCapacity);
        this.add(maximumCapacityPanel);

        this.maximumCapacityTextField = new JTextField(25);
        JPanel maximumCapacityTextFieldPanel = new JPanel();
        maximumCapacityTextFieldPanel.add(maximumCapacityTextField);
        this.add(maximumCapacityTextFieldPanel);

        this.teacher = new JLabel("teacher");
        JPanel teacherPanel = new JPanel();
        teacherPanel.add(teacher);
        this.add(teacherPanel);

        this.teacherTextField = new JTextField(25);
        JPanel teacherTextFieldPanel = new JPanel();
        teacherTextFieldPanel.add(teacherTextField);
        this.add(teacherTextFieldPanel);

    }

    public JTextField getNameTextField() {
        return nameTextField;
    }

    public JTextField getIdTextField() {
        return idTextField;
    }

    public JTextField getFeeTextField() {
        return feeTextField;
    }

    public JTextField getMidtermsTextField() {
        return midtermsTextField;
    }

    public JTextField getWeeksDurationTextField() {
        return weeksDurationTextField;
    }

    public JTextField getMaximumCapacityTextField() {
        return maximumCapacityTextField;
    }

    public JTextField getTeacherTextField() {
        return teacherTextField;
    }
}

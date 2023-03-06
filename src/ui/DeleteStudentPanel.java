package ui;

import exeptions.*;
import service.StudentService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteStudentPanel extends JPanel implements ActionListener {

    private JLabel studentNID;
    private JTextField studentNIDTextField;
    private JPanel deletePanel;

    private GeneralButtonPanel buttons;
    private GeneralTitle title;
    private WindowManager windowManager;

    public DeleteStudentPanel(WindowManager windowManager){
        this.windowManager = windowManager;
        assemble();
    }

    private void assemble(){
        this.setLayout(new BorderLayout());

        this.title = new GeneralTitle("Delete Student");
        this.add(title, BorderLayout.NORTH);

        this.deletePanel = new JPanel();
        this.studentNID = new JLabel("Student NID");
        deletePanel.add(studentNID);
        this.studentNIDTextField = new JTextField(10);
        deletePanel.add(studentNIDTextField);

        this.add(this.deletePanel, BorderLayout.CENTER);

        this.buttons = new GeneralButtonPanel();
        this.add(buttons, BorderLayout.SOUTH);

        this.buttons.getOkButton().addActionListener(this);
        this.buttons.getCancelButton().addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Long nidEntered = Long.parseLong(this.getStudentNIDTextField().getText());
        StudentService studentService = new StudentService();

        try {
            JOptionPane.showMessageDialog(null, "Are you sure to delete Student?", "Delete Student", JOptionPane.QUESTION_MESSAGE);
            studentService.delete(nidEntered);
            if (actionEvent.getSource() == this.buttons.getOkButton()) {
            }
        } catch (EmptyFieldException e) {
            JOptionPane.showMessageDialog(null, "There cannot be EMPTY fields");
        } catch (EntityNotExistException ex) {
            JOptionPane.showMessageDialog(null, "Sutent does not exist");
        } catch (UnableCloseConnectionException ex) {
            JOptionPane.showMessageDialog(null, "Failed connection close");
        } catch (OperationException ex) {
            JOptionPane.showMessageDialog(null, "Operation Error");
        } catch (UnableConnectionException ex) {
            JOptionPane.showMessageDialog(null, "Failed connection");
        }
        JOptionPane.showMessageDialog(null, "Ok");

        if (actionEvent.getSource() == this.buttons.getCancelButton()){
            windowManager.redirectToAdministrator();
        }
    }
    public JTextField getStudentNIDTextField() {
        return studentNIDTextField;
    }
}

package ui.admins;

import entities.Student;
import exeptions.OperationException;
import exeptions.UnableCloseConnectionException;
import exeptions.UnableConnectionException;
import service.StudentService;
import ui.WindowManager;
import ui.admins.StudentTableModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class StudentsTablePanel extends JPanel implements ActionListener {

    private JTable studentsTable ;
    private StudentTableModel studentTableModel;
    private WindowManager manager;

    private JScrollPane scrollPane;
    private JButton fillTableButton;


    public StudentsTablePanel(WindowManager manager) {
        super();
        this.manager = manager;
        assemble();
    }

    private void assemble() {
        BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
        this.setLayout(layout);

        studentTableModel = new StudentTableModel();
        studentsTable = new JTable(studentTableModel);
        scrollPane = new JScrollPane(studentsTable);
        this.add(scrollPane);

        fillTableButton = new JButton("Fill Table");
        fillTableButton.addActionListener(this);
        this.add(fillTableButton);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        StudentService studentService = new StudentService();
        try {
            List<Student> listAllStudents = studentService.list();
            studentTableModel.setContent(listAllStudents);
            studentTableModel.fireTableDataChanged();
        } catch (UnableConnectionException ex) {
            ex.printStackTrace();
        } catch (UnableCloseConnectionException ex) {
            ex.printStackTrace();
        } catch (OperationException ex) {
            ex.printStackTrace();
        }

    }
}

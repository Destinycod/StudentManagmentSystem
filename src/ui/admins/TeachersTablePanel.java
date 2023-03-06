package ui.admins;

import entities.Teacher;
import exeptions.OperationException;
import exeptions.UnableCloseConnectionException;
import exeptions.UnableConnectionException;
import service.TeacherService;
import ui.WindowManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class TeachersTablePanel extends JPanel implements ActionListener {

    private JTable teachersTable ;
    private TeacherTableModel teacherTableModel;
    private WindowManager manager;

    private JScrollPane scrollPane;
    private JButton fillTableButton;


    public TeachersTablePanel(WindowManager manager) {
        super();
        this.manager = manager;
        assemble();
    }

    private void assemble() {
        BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
        this.setLayout(layout);

        teacherTableModel = new TeacherTableModel();
        teachersTable = new JTable(teacherTableModel);
        scrollPane = new JScrollPane(teachersTable);
        this.add(scrollPane);

        fillTableButton = new JButton("Fill Table");
        fillTableButton.addActionListener(this);
        this.add(fillTableButton);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        TeacherService teacherService = new TeacherService();
        try {
            List<Teacher> listAllTeachers = teacherService.list();
            teacherTableModel.setContent(listAllTeachers);
            teacherTableModel.fireTableDataChanged();
        } catch (UnableConnectionException ex) {
            ex.printStackTrace();
        } catch (UnableCloseConnectionException ex) {
            ex.printStackTrace();
        } catch (OperationException ex) {
            ex.printStackTrace();
        }
    }
}

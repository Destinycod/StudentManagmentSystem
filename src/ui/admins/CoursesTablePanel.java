package ui.admins;

import entities.Course;
import exeptions.OperationException;
import exeptions.UnableCloseConnectionException;
import exeptions.UnableConnectionException;
import service.CourseService;
import ui.WindowManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CoursesTablePanel extends JPanel implements ActionListener {

    private JTable courseTable ;
    private CourseTableModel courseTableModel;
    private WindowManager manager;

    private JScrollPane scrollPane;
    private JButton fillTableButton;


    public CoursesTablePanel(WindowManager manager) {
        super();
        this.manager = manager;
        assemble();
    }

    private void assemble() {
        BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
        this.setLayout(layout);

        courseTableModel = new CourseTableModel();
        courseTable = new JTable(courseTableModel);
        scrollPane = new JScrollPane(courseTable);
        this.add(scrollPane);

        fillTableButton = new JButton("Fill Table");
        fillTableButton.addActionListener(this);
        this.add(fillTableButton);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        CourseService courseService = new CourseService();
        try {
            List<Course> listAllCourses = courseService.list();
            courseTableModel.setContent(listAllCourses);
            courseTableModel.fireTableDataChanged();
        } catch (UnableConnectionException ex) {
            ex.printStackTrace();
        } catch (UnableCloseConnectionException ex) {
            ex.printStackTrace();
        } catch (OperationException ex) {
            ex.printStackTrace();
        }

    }
}

package ui.reports;

import entities.Course;
import exeptions.OperationException;
import exeptions.UnableCloseConnectionException;
import exeptions.UnableConnectionException;
import service.CourseService;
import ui.WindowManager;
import ui.reports.AllCoursesReportTableModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AllCoursesReportTablePanel extends JPanel implements ActionListener {

    private JTable allCoursesTable ;
    private AllCoursesReportTableModel allCoursesReportTable;
    private WindowManager manager;

    private JScrollPane scrollPane;
    private JButton fillTableButton;
    private JButton goBack;

    public AllCoursesReportTablePanel(WindowManager manager) {
        super();
        this.manager = manager;
        assemble();
    }

    private void assemble() {
        BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
        this.setLayout(layout);

        allCoursesReportTable = new AllCoursesReportTableModel();
        allCoursesTable = new JTable(allCoursesReportTable);
        scrollPane = new JScrollPane(allCoursesTable);
        this.add(scrollPane);

        fillTableButton = new JButton("Fill Table");
        fillTableButton.addActionListener(this);
        this.add(fillTableButton);

        this.goBack = new JButton("Go back");
        goBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manager.redirectToReportView();
            }
        });
        this.add(goBack);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        CourseService courseService = new CourseService();
        try {
            List<Course> listAllCoursesReport = courseService.list();
            allCoursesReportTable.setContent(listAllCoursesReport);
            allCoursesReportTable.fireTableDataChanged();
        } catch (UnableConnectionException ex) {
            ex.printStackTrace();
        } catch (UnableCloseConnectionException ex) {
            ex.printStackTrace();
        } catch (OperationException ex) {
            ex.printStackTrace();
        }
    }

}

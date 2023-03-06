package ui.qualifications;

import entities.Course;
import entities.Qualification;
import exeptions.OperationException;
import exeptions.UnableCloseConnectionException;
import exeptions.UnableConnectionException;
import service.CourseService;
import service.QualificationService;
import ui.WindowManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class QualificationsTablePanel extends JPanel implements ActionListener {

    private JTable qualificationsTable;
    private QualificationsTableModel qualificationsTableModel;
    private WindowManager manager;
    private Long id;

    private JScrollPane scrollPane;
    private JButton fillTableButton;

    public QualificationsTablePanel(WindowManager manager, Long id) {
        super();
        this.manager = manager;
        this.id = id;
        assemble();
    }

    private void assemble() {
        BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
        this.setLayout(layout);

        qualificationsTableModel = new QualificationsTableModel();
        qualificationsTable = new JTable(qualificationsTableModel);
        scrollPane = new JScrollPane(qualificationsTable);
        this.add(scrollPane);

        fillTableButton = new JButton("Fill Table");
        fillTableButton.addActionListener(this);
        this.add(fillTableButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        QualificationService qualificationService = new QualificationService();
        try {
            List<Qualification> qualificationList = qualificationService.listForTeacher(id);
            qualificationsTableModel.setContent(qualificationList);
            qualificationsTableModel.fireTableDataChanged();
        } catch (UnableConnectionException ex) {
            ex.printStackTrace();
        } catch (UnableCloseConnectionException ex) {
            ex.printStackTrace();
        } catch (OperationException ex) {
            ex.printStackTrace();
        }
    }
}

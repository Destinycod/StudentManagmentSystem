package ui.admins;

import ui.GeneralButtonPanel;
import ui.WindowManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReportViewPanel extends JPanel implements ActionListener { //TODO

    protected WindowManager manager;
    private JComboBox reportType;
    private GeneralButtonPanel generalButtonPanel;

    public ReportViewPanel(WindowManager manager){
        this.manager = manager;
        assemble();
    }

    public void assemble(){
        this.setLayout(new GridLayout(2,1));

        this.reportType = new JComboBox(); //TODO -CHANGE TO ENGLISH
        reportType.addItem("Recaudación de todos los cursos");
        reportType.addItem("Recaudación de cada curso");
        reportType.addItem("Anotados de cada curso");
        reportType.addItem("Anotados vs Aprobados");
        this.add(reportType);

        this.generalButtonPanel = new GeneralButtonPanel();
        this.add(generalButtonPanel);
        //this.generalButtonPanel.getOkButton().addActionListener(this);
        this.generalButtonPanel.getOkButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(reportType.getSelectedItem() == "Recaudación de todos los cursos") {
                    manager.redirectToAllCoursesReportTablePanel();
                }
            }
        });
        this.generalButtonPanel.getCancelButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manager.redirectToAdministrator();
            }
        });
    }

    public void actionPerformed(ActionEvent actionEvent) {

    }

}

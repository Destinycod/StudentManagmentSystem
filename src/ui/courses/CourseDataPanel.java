package ui.courses;

import ui.EntityDataPanel;
import ui.WindowManager;

import javax.swing.*;
import java.awt.*;

public class CourseDataPanel extends EntityDataPanel {

    private JLabel id;
    private JTextField entityId;
    private JLabel name;
    private JTextField entityName;
    private JLabel price;
    private JTextField entityPrice;
    private JLabel midterms;
    private JTextField entityMidterms;
    private JLabel startDate;
    private JTextField entityStartDate;
    private JLabel endDate;
    private JTextField entityEndDate;
    private JLabel quota;
    private JTextField entityQuota;
    private JButton searchButton;
    private JTextField searchTextF;

    public CourseDataPanel(WindowManager manager) {
        super(manager);
    }

    @Override
    public void assembleForm() {
        this.setLayout(new GridLayout(8,3));

        this.id = new JLabel("ID");
        this.add(id);

        this.entityId = new JTextField(5);
        this.add(entityId);

        this.name = new JLabel("Name");
        this.add(name);

        this.entityName = new JTextField(25);
        this.add(entityName);

        this.price = new JLabel("Price");
        this.add(price);

        this.entityPrice = new JTextField(25);
        this.add(entityPrice);

        this.midterms = new JLabel("Midterms");
        this.add(midterms);

        this.entityMidterms = new JTextField(10);
        this.add(entityMidterms);

        this.startDate = new JLabel("Start Date");
        this.add(startDate);

        this.entityStartDate = new JTextField(10);
        this.add(entityStartDate);

        this.endDate = new JLabel("End Date");
        this.add(endDate);

        this.entityEndDate = new JTextField(10);
        this.add(entityEndDate);

        this.quota = new JLabel("Quota");
        this.add(quota);

        this.entityQuota = new JTextField(10);
        this.add(entityQuota);

        this.searchButton = new JButton("Search"); //Busca por id del curso
        this.add(searchButton);

        this.searchTextF = new JTextField(10);
        this.add(searchTextF);
    }

    public JTextField getEntityId() {
        return entityId;
    }

    public void setEntityId(JTextField entityid) {
        this.entityId = entityid;
    }

    public JTextField getEntityName() {
        return entityName;
    }

    public void setEntityName(JTextField entityName) {
        this.entityName = entityName;
    }

    public JTextField getEntityPrice() {
        return entityPrice;
    }

    public void setEntityPrice(JTextField entityPrice) {
        this.entityPrice = entityPrice;
    }

    public JTextField getEntityMidterms() {
        return entityMidterms;
    }

    public void setEntityMidterms(JTextField entityMidterms) {
        this.entityMidterms = entityMidterms;
    }

    public JTextField getEntityStartDate() {
        return entityStartDate;
    }

    public void setEntityStartDate(JTextField entityStartDate) {
        this.entityStartDate = entityStartDate;
    }

    public JTextField getEntityEndDate() {
        return entityEndDate;
    }

    public void setEntityEndDate(JTextField entityEndDate) {
        this.entityEndDate = entityEndDate;
    }

    public JTextField getEntityQuota() {
        return entityQuota;
    }

    public void setEntityQuota(JTextField entityQuota) {
        this.entityQuota = entityQuota;
    }

    public JButton getSearchButton() {
        return searchButton;
    }

    public void setSearchButton(JButton searchButton) {
        this.searchButton = searchButton;
    }

    public JTextField getSearchTextF() {
        return searchTextF;
    }

    public void setSearchTextF(JTextField searchTextF) {
        this.searchTextF = searchTextF;
    }
}

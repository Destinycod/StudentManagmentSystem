package ui.admins;

import entities.Course;
import exeptions.*;
import service.CourseService;
import ui.CRUDButtons;
import ui.WindowManager;
import ui.courses.CourseDataPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.LocalDate;

public class CourseViewPanel extends JPanel implements ActionListener {

    protected WindowManager manager;
    private CourseDataPanel courseDataPanel;
    private CRUDButtons crudButtons;
    private CoursesTablePanel coursesTablePanel;

    public CourseViewPanel(WindowManager manager){
        this.manager = manager;
        assemble();
    }

    public void assemble(){
        this.setLayout(new GridLayout(2,2));

        this.courseDataPanel = new CourseDataPanel(manager);
        this.add(this.courseDataPanel);
        this.courseDataPanel.getSearchButton().addActionListener(this);

        this.coursesTablePanel = new CoursesTablePanel(manager);
        this.add(coursesTablePanel);

        this.crudButtons = new CRUDButtons();
        this.add(crudButtons);
        this.crudButtons.getAddButton().addActionListener(this);
        this.crudButtons.getGoBackButton().addActionListener(this);
        this.crudButtons.getEditButton().addActionListener(this);
        this.crudButtons.getDeleteButton().addActionListener(this);
    }

    public void actionPerformed(ActionEvent actionEvent) {
        CourseService courseService = new CourseService();

        if (actionEvent.getSource() == this.crudButtons.getGoBackButton()){
            manager.redirectToAdministrator();
        }
        if (actionEvent.getSource() == this.courseDataPanel.getSearchButton()){
            Long searchValue = Long.parseLong(this.courseDataPanel.getSearchTextF().getText());
            try {
                this.courseDataPanel.getEntityId().setText(String.valueOf(courseService.search(searchValue).getId()));
                this.courseDataPanel.getEntityName().setText(courseService.search(searchValue).getName());
                this.courseDataPanel.getEntityPrice().setText(String.valueOf(courseService.search(searchValue).getPrice()));
                this.courseDataPanel.getEntityMidterms().setText(String.valueOf(courseService.search(searchValue).getMidtermsRequired()));
                this.courseDataPanel.getEntityStartDate().setText(String.valueOf(courseService.search(searchValue).getStartDate()));
                this.courseDataPanel.getEntityEndDate().setText(String.valueOf(courseService.search(searchValue).getEndDate()));
                this.courseDataPanel.getEntityQuota().setText(String.valueOf(courseService.search(searchValue).getQuota()));
                System.out.println("tamaño de enrollment, courseViewPanel" + courseService.search(searchValue).getEnrollments().size()); //TODO
                this.courseDataPanel.getSearchTextF().setText("");
            } catch (EmptyFieldException e) {
                JOptionPane.showMessageDialog(null, "There cannot be EMPTY fields");
            } catch (EntityNotExistException e) {
                JOptionPane.showMessageDialog(null, "The ID does not exist");
            } catch (UnableCloseConnectionException e) {
                JOptionPane.showMessageDialog(null, "The connection could not be closed");
            } catch (UnableConnectionException e) {
                JOptionPane.showMessageDialog(null, "The connection could not be established");
            } catch (OperationException e) {
                JOptionPane.showMessageDialog(null, "Operation Error");
            }
        }

        if(actionEvent.getSource() == this.crudButtons.getAddButton()){
            Course course = new Course();
            course.setId(Long.valueOf(this.courseDataPanel.getEntityId().getText()));
            course.setName(this.courseDataPanel.getEntityName().getText());
            course.setPrice(Double.parseDouble(this.courseDataPanel.getEntityPrice().getText()));
            course.setMidtermsRequired(Integer.parseInt(this.courseDataPanel.getEntityMidterms().getText()));
            course.setStartDate(LocalDate.parse(this.courseDataPanel.getEntityStartDate().getText()));
            course.setEndDate(Date.valueOf(this.courseDataPanel.getEntityEndDate().getText()));
            course.setQuota(Integer.parseInt(this.courseDataPanel.getEntityQuota().getText()));
            try {
                courseService.create(course);
            } catch (EmptyFieldException e) {
                JOptionPane.showMessageDialog(null, "There cannot be EMPTY fields");
            } catch (EntityAlreadyExistException e) {
                JOptionPane.showMessageDialog(null, "The student ALREADY exist");
            } catch (UnableCloseConnectionException e) {
                JOptionPane.showMessageDialog(null, "The connection could not be closed");
            } catch (UnableConnectionException e) {
                JOptionPane.showMessageDialog(null, "The connection could not be established");
            } catch (OperationException e) {
                JOptionPane.showMessageDialog(null, "Operation Error");
            }
        }

        if(actionEvent.getSource() == this.crudButtons.getEditButton()){
            Course course = new Course();
            course.setId(Long.valueOf(this.courseDataPanel.getEntityId().getText()));
            course.setName(this.courseDataPanel.getEntityName().getText());
            course.setPrice(Double.parseDouble(this.courseDataPanel.getEntityPrice().getText()));
            course.setMidtermsRequired(Integer.parseInt(this.courseDataPanel.getEntityMidterms().getText()));
            course.setStartDate(LocalDate.parse(this.courseDataPanel.getEntityStartDate().getText()));
            course.setEndDate(Date.valueOf(this.courseDataPanel.getEntityEndDate().getText()));
            course.setQuota(Integer.parseInt(this.courseDataPanel.getEntityQuota().getText()));
            try {
                courseService.update(course);
            } catch (EmptyFieldException e) {
                JOptionPane.showMessageDialog(null, "There cannot be EMPTY fields");
            } catch (EntityNotExistException e) {
                JOptionPane.showMessageDialog(null, "The NID does not exist");
            } catch (UnableCloseConnectionException e) {
                JOptionPane.showMessageDialog(null, "The connection could not be closed");
            } catch (UnableConnectionException e) {
                JOptionPane.showMessageDialog(null, "The connection could not be established");
            } catch (OperationException e) {
                JOptionPane.showMessageDialog(null, "Operation Error");
            }
        }

        if(actionEvent.getSource() == this.crudButtons.getDeleteButton()){
            try {
                courseService.delete(Long.valueOf(this.courseDataPanel.getEntityId().getText()));
            } catch (EmptyFieldException e) {
                JOptionPane.showMessageDialog(null, "There cannot be EMPTY fields");
            } catch (EntityNotExistException e) {
                JOptionPane.showMessageDialog(null, "The NID does not exist");
            } catch (UnableCloseConnectionException e) {
                JOptionPane.showMessageDialog(null, "The connection could not be closed");
            } catch (UnableConnectionException e) {
                JOptionPane.showMessageDialog(null, "The connection could not be established");
            } catch (OperationException e) {
                JOptionPane.showMessageDialog(null, "Operation Error");
            }
        }
    }
}

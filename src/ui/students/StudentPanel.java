package ui.students;

import entities.Student;
import ui.AbstractDataPanel;
import ui.WindowManager;

public class StudentPanel extends AbstractDataPanel {

    public StudentPanel(WindowManager manager, Student student) {
        super(manager);
        fillData(student);
    }

    public void fillData(Student student) {
        StudentDataPanel studentData = (StudentDataPanel) this.entityData;
        studentData.getEntityName().setText(student.getName());
        studentData.getEntityLastName().setText(student.getLastName());
        studentData.getEntityNID().setText(String.valueOf(student.getNid()));
        studentData.getEntityPassword().setText(student.getPassword());
    }

    public void fillTable(){

    }

    @Override
    public void setEntityDataPanel() {
        this.entityData = new StudentDataPanel(manager);
    }

    @Override
    public void setEntityTablePanel() {

    }

    /*
    private WindowManager windowManager;
    private GeneralTitle title;
    public EntityDataPanel entityDataPanel;
    private CoursePanel courseViewPanel;
    private JButton enrollButton;

    public StudentPanel(){

    }
    public StudentPanel(WindowManager windowManager){
        this.windowManager = windowManager;
        assemble();
    }

    private void assemble(){
        this.setLayout(new BorderLayout());

        this.title = new GeneralTitle("Student");
        this.add(this.title, BorderLayout.NORTH);

        this.entityDataPanel = new EntityDataPanel();
        this.add(this.entityDataPanel, BorderLayout.WEST);

        this.courseViewPanel = new CoursePanel();
        this.add(this.courseViewPanel, BorderLayout.EAST);

        this.enrollButton = new JButton("Enroll in a Course");
        this.add(this.enrollButton, BorderLayout.SOUTH);


    }*/

}

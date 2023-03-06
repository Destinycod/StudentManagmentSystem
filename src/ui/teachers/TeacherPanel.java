package ui.teachers;

import entities.Teacher;
import ui.AbstractDataPanel;
import ui.WindowManager;
import ui.qualifications.QualificationsTable;
import ui.qualifications.QualificationsTablePanel;
import ui.students.StudentDataPanel;

public class TeacherPanel extends AbstractDataPanel {

    public TeacherPanel(WindowManager manager, Teacher teacher) {
        super(manager);
        fillData(teacher);
        fillTable(teacher);
    }

    public void fillData(Teacher teacher) {
        TeacherDataPanel teacherData = (TeacherDataPanel) this.entityData;
        teacherData.getEntityName().setText(teacher.getName());
        teacherData.getEntityLastName().setText(teacher.getLastName());
        teacherData.getEntityNID().setText(String.valueOf(teacher.getNid()));
        teacherData.getEntityPassword().setText(teacher.getPassword());
    }

    Long id;
    public void fillTable(Teacher teacher){
        QualificationsTable qualificationsTable = (QualificationsTable) this.entityTablePanel;
        //qualificationsTable.assemble();
        this.id = teacher.getNid();
    }

    @Override
    public void setEntityDataPanel() {
        this.entityData = new TeacherDataPanel(manager);
    }

    @Override
    public void setEntityTablePanel() {

    }

   /* @Override
    public void setEntityTablePanel() {
        this.entityTablePanel = new QualificationsTablePanel(manager, id);
    }*/

}

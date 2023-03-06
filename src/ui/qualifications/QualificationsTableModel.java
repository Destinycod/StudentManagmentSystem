package ui.qualifications;

import entities.Qualification;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class QualificationsTableModel extends AbstractTableModel {

    private static final int COLUMN_ID = 0;
    private static final int COLUMN_SCORE = 1;
    private static final int COLUMN_COURSE_ID = 2;
    private static final int COLUMN_COURSE_NAME = 3;

    private String[] columnNames = {"ID", "Score", "Course ID", "Course Name"};

    private Class[] columnTypes = {Integer.class, Integer.class, Integer.class, String.class};

    private List<Qualification> content;

    public QualificationsTableModel() {
        content = new ArrayList<Qualification>();
    }

    public QualificationsTableModel(List<Qualification> inicialContent) {
        content = inicialContent;
    }

    public int getRowCount() {
        return content.size();
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Qualification qualification = content.get(rowIndex);

        Object result = null;
        switch(columnIndex) {
            case COLUMN_ID:
                result = qualification.getId();
                break;
            case COLUMN_SCORE:
                result = qualification.getQualification();
                break;
            case COLUMN_COURSE_ID:
                result = qualification.getCourse().getId();
                break;
            case COLUMN_COURSE_NAME:
                result = qualification.getCourse().getName();
                break;
            default:
                result = new String("");
        }
        return result;
    }

    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        super.setValueAt(value, rowIndex, columnIndex);
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Class getColumnClass(int col) {
        return columnTypes[col];
    }

    public List<Qualification> getContent() {
        return content;
    }

    public void setContent(List<Qualification> content) {
        this.content = content;
    }
}

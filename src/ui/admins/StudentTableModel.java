package ui.admins;

import entities.Student;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class StudentTableModel extends AbstractTableModel {

    private static final int COLUMN_NAME = 0;
    private static final int COLUMN_LAST_NAME = 1;
    private static final int COLUMN_NID = 2;
    private static final int COLUMN_PASSWORD = 3;

    private String[] columnNames = {"Name", "Last Name", "NID", "Password"};

    private Class[] columnTypes = {String.class, String.class, Integer.class, String.class };

    private List<Student> content;

    public StudentTableModel() {
        content = new ArrayList<Student>();
    }

    public StudentTableModel(List<Student> inicialContent) {
        content = inicialContent;
    }

    public int getRowCount() {
        return content.size();
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Student student = content.get(rowIndex);

        Object result = null;
        switch(columnIndex) {
            case COLUMN_NAME:
                result = student.getName();
                break;
            case COLUMN_LAST_NAME:
                result = student.getLastName();
                break;
            case COLUMN_NID:
                result = student.getNid();
                break;
            case COLUMN_PASSWORD:
                result = student.getPassword();
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

    public List<Student> getContent() {
        return content;
    }

    public void setContent(List<Student> content) {
        this.content = content;
    }
}

package ui.reports;

import entities.Course;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;
//TODO CHECK
public class AllCoursesReportTableModel extends AbstractTableModel {

    private static final int COLUMN_ID = 0;
    private static final int COLUMN_NAME = 1;
    private static final int COLUMN_TOTAL = 2;

    private String[] columnNames = {"ID", "Name", "Total"};

    private Class[] columnTypes = {Integer.class, String.class, Double.class};

    private List<Course> content;

    public AllCoursesReportTableModel() {
        content = new ArrayList<Course>();
    }

    public AllCoursesReportTableModel(List<Course> inicialContent) {
        content = inicialContent;
    }

    public int getRowCount() {
        return content.size();
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Course course = content.get(rowIndex);

        Object result = null;
        switch(columnIndex) {
            case COLUMN_ID:
                result = course.getId();
                break;
            case COLUMN_NAME:
                result = course.getName();
                break;
            case COLUMN_TOTAL:
                result = (course.getPrice() * course.getEnrollments().size());
                System.out.println("Precio: " + course.getPrice());
                System.out.println("Anotados: " + course.getEnrollments().size());
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

    public List<Course> getContent() {
        return content;
    }

    public void setContent(List<Course> content) {
        this.content = content;
    }
}

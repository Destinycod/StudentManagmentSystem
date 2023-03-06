package ui.admins;

import entities.Course;

import javax.swing.table.AbstractTableModel;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CourseTableModel extends AbstractTableModel {

    private static final int COLUMN_ID = 0;
    private static final int COLUMN_NAME = 1;
    private static final int COLUMN_PRICE = 2;
    private static final int COLUMN_MIDTERMS = 3;
    private static final int COLUMN_START_DATE = 4;
    private static final int COLUMN_END_DATE = 5;
    private static final int COLUMN_QUOTA = 6;

    private String[] columnNames = {"Id", "Name", "Price", "Midterms", "Start Date", "End Date",
            "Quota"};

    private Class[] columnTypes = {Long.class, String.class, Double.class, Integer.class,
            LocalDate.class, LocalDate.class, Integer.class};

    private List<Course> content;

    public CourseTableModel(){
        content = new ArrayList<Course>();
    }

    public CourseTableModel(List<Course> inicialContent) {
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
            case COLUMN_PRICE:
                result = course.getPrice();
                break;
            case COLUMN_MIDTERMS:
                result = course.getMidtermsRequired();
                break;
            case COLUMN_START_DATE:
                result = course.getStartDate();
                break;
            case COLUMN_END_DATE:
                result = course.getEndDate();
                break;
            case COLUMN_QUOTA:
                result = course.getQuota();
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

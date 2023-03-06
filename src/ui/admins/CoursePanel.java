package ui.admins;

import javax.swing.*;
import java.awt.*;
//TODO EVALUAR SI SE ELIMINA
//Hacer a modo de tabla
public class CoursePanel extends JPanel {

    private JLabel courseName;
    private JLabel name;

    public CoursePanel(){
        assemble();
    }

    private void assemble(){
        this.setLayout(new FlowLayout());
        this.name = new JLabel("Course Name");
        this.add(name);
    }
}

package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CourseRegistrationPanel extends JPanel implements ActionListener {

    private GeneralButtonPanel buttons;
    private GeneralTitle title;
    private CourseFormPanel courseFormPanel;
    private WindowManager windowManager;

    public CourseRegistrationPanel(WindowManager windowManager){
        this.windowManager = windowManager;
        assemble();
    }

    private void assemble(){
        this.setLayout(new BorderLayout());

        this.title = new GeneralTitle("Course Registration");
        this.add(this.title,BorderLayout.NORTH);

        this.courseFormPanel = new CourseFormPanel();
        this.add(this.courseFormPanel,BorderLayout.CENTER);

        this.buttons = new GeneralButtonPanel();
        this.add(this.buttons,BorderLayout.SOUTH);

        this.buttons.getOkButton().addActionListener(this);
        this.buttons.getCancelButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {


        //if()
    }
}

package ui;

import javax.swing.*;

public abstract class EntityDataPanel extends JPanel {

    private WindowManager manager;

    public EntityDataPanel(WindowManager manager) {
        this.manager = manager;
        assembleForm();
    }

    public abstract void assembleForm();

}

package ui;

import javax.swing.*;

public abstract class AbstractEntityTablePanel extends JPanel { //TODO VER SI SE VA

    private WindowManager manager;

    public AbstractEntityTablePanel(WindowManager manager) {
        this.manager = manager;
        assemble();
    }

    public abstract void assemble();
}

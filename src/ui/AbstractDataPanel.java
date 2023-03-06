package ui;

import javax.swing.*;

public abstract class AbstractDataPanel extends JPanel {

    protected WindowManager manager;
    protected EntityDataPanel entityData;
    protected AbstractEntityTablePanel entityTablePanel;
    protected GeneralButtonPanel buttons;

    public AbstractDataPanel(WindowManager manager) {
        this.manager = manager;
        this.setEntityDataPanel();
        this.setEntityTablePanel();
        this.setGeneralButtonPanel();
        assemble();
    }

    public void assemble() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(entityData);
        this.add(entityTablePanel);
        this.add(buttons);
    }

    private void setGeneralButtonPanel() {
        this.buttons = new GeneralButtonPanel();
    }

    public abstract void setEntityDataPanel();

    public abstract void setEntityTablePanel();
}

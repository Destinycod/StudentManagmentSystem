package ui;

import javax.swing.*;

public class GeneralButtonPanel extends JPanel {

    private JButton okButton;
    private JButton cancelButton;

    public GeneralButtonPanel(/*WindowManager manager*/){
        //this.manager = manager;
        assemble();
    }

    private void assemble(){
        this.okButton = new JButton("Ok");
        this.add(okButton);

        this.cancelButton = new JButton("Cancel");
        this.add(cancelButton);
    }

    public JButton getOkButton() {
        return okButton;
    }

    public JButton getCancelButton() {
        return cancelButton;
    }
}

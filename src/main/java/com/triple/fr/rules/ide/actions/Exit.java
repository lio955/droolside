package com.triple.fr.rules.ide.actions;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Exit extends AbstractAction {

    public Exit() {
        super("Quit");
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        System.exit(0);
    }
}

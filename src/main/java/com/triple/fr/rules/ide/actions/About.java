package com.triple.fr.rules.ide.actions;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class About extends AbstractAction {

    public About() {
        super("About");
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        (new com.triple.fr.rules.ide.gui.About()).setVisible(true);
    }
}

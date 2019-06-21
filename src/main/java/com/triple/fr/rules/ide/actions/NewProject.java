package com.triple.fr.rules.ide.actions;

import com.triple.fr.rules.ide.gui.Project;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class NewProject extends AbstractAction {

    public NewProject() {
        super("New project");
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Project.getInstance().setVisible(true);

    }
}

package com.triple.fr.rules.ide.actions;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class CreateProject extends AbstractAction {
    public CreateProject() {
        super("Create project");
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        (new com.triple.fr.rules.ide.tasks.CreateProject()).execute();
    }
}

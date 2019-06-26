package com.triple.fr.rules.ide.actions;

import com.triple.fr.rules.ide.gui.Project;
import com.triple.fr.rules.ide.tasks.CreateProject;
import org.jdesktop.swingx.error.ErrorInfo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.logging.Level;

public class SetupProject extends AbstractAction {
    public SetupProject() {
        super("Setup project");
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        CreateProject createProject = new CreateProject(Project.getInstance().getParentDirectory().getText() + File.separator + Project.getInstance().getScenario().getText());
        try {
            createProject.execute();
        } catch (Exception e) {
            ErrorInfo errorInfo = new ErrorInfo("Error creating project", "Cannot create project"
                    , e.getMessage(), ",", e, Level.SEVERE, null);
            ActionEvent event = new ActionEvent(errorInfo, 0, e.getMessage());
            (new ShowError()).actionPerformed(event);
        }
        Project.getInstance().setVisible(false);
    }
}

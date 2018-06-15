package com.triple.fr.rules.ide.gui;

import com.triple.fr.rules.ide.actions.ChooseDirectory;
import com.triple.fr.rules.ide.application.AppDroolsIDE;
import com.triple.fr.rules.ide.actions.CreateProject;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.swingx.JXButton;
import org.jdesktop.swingx.JXLabel;
import org.jdesktop.swingx.JXPanel;
import org.jdesktop.swingx.JXTextArea;

import javax.swing.*;
import java.awt.*;

public class Project extends JDialog {

    private static final Project instance =  new Project();

    private JXTextArea parentDirectory= new JXTextArea("directory");
    private JXTextArea scenario= new JXTextArea("new_scenario");

    private Project() {
        super(AppDroolsIDE.getInstance().getMainPanel());
        setTitle("New project");
        Dimension parentSize = getParent().getSize();
        Point p = getParent().getLocation();
        setLocation(p.x + parentSize.width / 4, p.y + parentSize.height / 4);
        setContentPane(new JXPanel());
        parentDirectory.setColumns(50);
        scenario.setColumns(50);
        getContentPane().setLayout(new MigLayout("wrap 3"));
        getContentPane().add(new JXLabel("Parent directory : "));
        getContentPane().add(parentDirectory);
        getContentPane().add(new JXButton(new ChooseDirectory()));
        getContentPane().add(new JXLabel("Name : "));
        getContentPane().add(scenario,"span,grow");
        getContentPane().add(new JXButton(new CreateProject()),"span,grow");
        pack();
        setModal(true);
    }

    public static Project getInstance() {
        return instance;
    }

    public JXTextArea getParentDirectory() {
        return parentDirectory;
    }

    public JXTextArea getScenario() {
        return scenario;
    }
}

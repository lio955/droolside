package com.triple.fr.rules.ide.actions;

import com.triple.fr.rules.ide.application.AppDroolsIDE;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;

public class OpenProject extends AbstractAction {

    public OpenProject() {
        super("Open project");
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select project's rules.csv");
        if (fileChooser.showOpenDialog(AppDroolsIDE.getInstance().getMainPanel().getCurrentTextArea()) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            AppDroolsIDE.getInstance().getMainPanel().removeAll();


        }
    }
}

package com.triple.fr.rules.ide.actions;

import com.triple.fr.rules.ide.application.AppDroolsIDE;
import com.triple.fr.rules.ide.gui.Project;
import org.jdesktop.swingx.error.ErrorInfo;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;

public class ChooseDirectory extends AbstractAction {
    public ChooseDirectory() {
        super("Choose dir");
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JFileChooser jFileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnValue = jFileChooser.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jFileChooser.getSelectedFile();
            System.out.println(selectedFile.getAbsolutePath());
            try {
                Project.getInstance().getParentDirectory().setText(selectedFile.getAbsolutePath());
                //AppDroolsIDE.getInstance().getMainPanel().getTextArea().setText(new Scanner(selectedFile).useDelimiter("\\A").next());
            } catch (Exception e) {
                ErrorInfo errorInfo = new ErrorInfo("Error choosing directory","Cannot open directory"
                        , e.getMessage(),",",e, Level.SEVERE, null);
                ActionEvent event = new ActionEvent(errorInfo, 0, e.getMessage());
                (new ShowError()).actionPerformed(event);
            }
        }
    }
}

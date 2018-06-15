package com.triple.fr.rules.ide.actions;

import com.triple.fr.rules.ide.application.AppDroolsIDE;
import org.jdesktop.swingx.error.ErrorInfo;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;

public class OpenFile extends AbstractAction {
    public OpenFile() {
        super("Open file");
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JFileChooser jFileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        int returnValue = jFileChooser.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jFileChooser.getSelectedFile();
            System.out.println(selectedFile.getAbsolutePath());
            try {
                AppDroolsIDE.getInstance().getMainPanel().getTextArea().setText(new Scanner(selectedFile).useDelimiter("\\A").next());
            } catch (FileNotFoundException e) {
                ErrorInfo errorInfo = new ErrorInfo("Error while opening file","Cannot open file"
                        , e.getMessage(),",",e, Level.SEVERE, null);
                ActionEvent event = new ActionEvent(errorInfo, 0, e.getMessage());
                (new ShowError()).actionPerformed(event);
            }
        }
    }
}

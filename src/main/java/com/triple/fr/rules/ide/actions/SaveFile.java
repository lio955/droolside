package com.triple.fr.rules.ide.actions;

import com.triple.fr.rules.ide.application.AppDroolsIDE;
import com.triple.fr.rules.ide.tasks.SaveDRL;
import org.jdesktop.swingx.error.ErrorInfo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.logging.Level;

public class SaveFile extends AbstractAction {
    public SaveFile() {
        super("Save file");
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Save file");
        if (fileChooser.showSaveDialog(AppDroolsIDE.getInstance().getMainPanel().getTextArea()) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try {
                SaveDRL saveDRL = new SaveDRL(file.getAbsolutePath(), AppDroolsIDE.getInstance().getMainPanel().getTextArea().getText());
                saveDRL.execute();
            } catch (Exception e) {
                ErrorInfo errorInfo = new ErrorInfo("Error saving file", "Cannot save file"
                        , e.getMessage(), ",", e, Level.SEVERE, null);
                ActionEvent event = new ActionEvent(errorInfo, 0, e.getMessage());
                (new ShowError()).actionPerformed(event);
            }
        }
    }
}

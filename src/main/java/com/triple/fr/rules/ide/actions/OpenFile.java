package com.triple.fr.rules.ide.actions;

import com.triple.fr.rules.ide.application.AppDroolsIDE;
import com.triple.fr.rules.ide.gui.TextArea;
import com.triple.fr.rules.ide.tasks.OpenDRL;
import org.fife.ui.rtextarea.RTextScrollPane;
import org.jdesktop.swingx.error.ErrorInfo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.logging.Level;

public class OpenFile extends AbstractAction {
    public OpenFile() {
        super("Open file");
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Open file");
        if (fileChooser.showOpenDialog(AppDroolsIDE.getInstance().getMainPanel().getCurrentTextArea()) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try {
                OpenDRL openDRL = new OpenDRL(file.getAbsolutePath());
                openDRL.execute();
                TextArea textArea = new TextArea();
                textArea.setText(openDRL.getText());
                AppDroolsIDE.getInstance().getMainPanel().getTabbedPane().addTab(file.getName(), new RTextScrollPane(textArea));
                //AppDroolsIDE.getInstance().getMainPanel().getTabbedPane().
            } catch (Exception e) {
                ErrorInfo errorInfo = new ErrorInfo("Error opening file", "Cannot open file"
                        , e.getMessage(), ",", e, Level.SEVERE, null);
                ActionEvent event = new ActionEvent(errorInfo, 0, e.getMessage());
                (new ShowError()).actionPerformed(event);
            }
        }
    }
}

package com.triple.fr.rules.ide.actions;

import com.triple.fr.rules.ide.application.AppDroolsIDE;
import com.triple.fr.rules.ide.gui.TextArea;
import com.triple.fr.rules.ide.tasks.OpenProjectDirectory;
import org.apache.commons.lang3.StringUtils;
import org.fife.ui.rtextarea.RTextScrollPane;
import org.jdesktop.swingx.error.ErrorInfo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;

public class OpenProject extends AbstractAction {

    public OpenProject() {
        super("Open project");
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select project's rules.csv");
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        if (fileChooser.showOpenDialog(AppDroolsIDE.getInstance().getMainPanel().getCurrentTextArea()) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            AppDroolsIDE.getInstance().getMainPanel().getTabbedPane().removeAll();
            OpenProjectDirectory openProjectDirectory = new OpenProjectDirectory(file.getAbsolutePath());

            try {
                openProjectDirectory.execute();
                for (String fileDRL : openProjectDirectory.getDrlFiles()) {
                    TextArea textArea = new TextArea();
                    List<String> lines = Files.readAllLines(Paths.get(fileDRL), StandardCharsets.UTF_8);
                    textArea.setText(StringUtils.join(lines, "\n"));
                    AppDroolsIDE.getInstance().getMainPanel().getTabbedPane().addTab(fileDRL, new RTextScrollPane(textArea));
                }
            } catch (Exception e) {
                ErrorInfo errorInfo = new ErrorInfo("Error opening project", "Cannot open project"
                        , e.getMessage(), ",", e, Level.SEVERE, null);
                ActionEvent event = new ActionEvent(errorInfo, 0, e.getMessage());
                (new ShowError()).actionPerformed(event);
            }

        }
    }
}

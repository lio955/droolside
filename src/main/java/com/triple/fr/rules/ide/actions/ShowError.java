package com.triple.fr.rules.ide.actions;

import com.triple.fr.rules.ide.application.AppDroolsIDE;
import org.jdesktop.swingx.JXErrorPane;
import org.jdesktop.swingx.error.ErrorInfo;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ShowError extends AbstractAction {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JXErrorPane.showDialog(AppDroolsIDE.getInstance().getMainPanel(), (ErrorInfo) actionEvent.getSource());
    }
}

package com.triple.fr.rules.ide.application;

import com.triple.fr.rules.ide.gui.MainPanel;

import javax.swing.*;

public class AppDroolsIDE {

    private MainPanel mainPanel;

    private static final AppDroolsIDE instance= new AppDroolsIDE();

    private AppDroolsIDE() {
        mainPanel= new MainPanel();
    }

    public static AppDroolsIDE getInstance() {
        return instance;
    }


    public MainPanel getMainPanel() {
        return mainPanel;
    }

    public static void main(String[] args) {
        // Start all Swing applications on the EDT.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                AppDroolsIDE.getInstance().getMainPanel().setVisible(true);
            }
        });
    }
}

package com.triple.fr.rules.ide;

import com.triple.fr.rules.ide.gui.MainPanel;

import javax.swing.*;

public class AppDroolsIDE {

    public static void main(String[] args) {
        // Start all Swing applications on the EDT.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainPanel().setVisible(true);
            }
        });
    }
}

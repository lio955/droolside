package com.triple.fr.rules.ide.gui;

import net.miginfocom.swing.MigLayout;
import org.fife.ui.rtextarea.RTextScrollPane;
import org.jdesktop.swingx.JXFrame;
import org.jdesktop.swingx.JXPanel;

public class MainPanel extends JXFrame {

    private static final String TITLE = "Drools IDE";

    public MainPanel() {
        super();
        setTitle(TITLE);
        setContentPane(new JXPanel());
        getContentPane().setLayout(new MigLayout());

        add(new RTextScrollPane(new TextArea()));

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }
}

package com.triple.fr.rules.ide.gui;

import net.miginfocom.swing.MigLayout;
import org.fife.ui.rtextarea.RTextScrollPane;
import org.jdesktop.swingx.JXFrame;
import org.jdesktop.swingx.JXPanel;

import javax.swing.*;

public class MainPanel extends JXFrame {

    private static final String TITLE = "Drools IDE";

    private TextArea textArea;

    private JTabbedPane tabbedPane;

    public MainPanel() {
        super();
        textArea = new TextArea();
        setTitle(TITLE);
        setJMenuBar(new Menu());
        setContentPane(new JXPanel());
        getContentPane().setLayout(new MigLayout());
        tabbedPane = new JTabbedPane();
        tabbedPane.addTab("New", new RTextScrollPane(textArea));
        add(tabbedPane);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }

    public TextArea getCurrentTextArea() {
        return textArea;
    }

    public JTabbedPane getTabbedPane() {
        return tabbedPane;
    }
}

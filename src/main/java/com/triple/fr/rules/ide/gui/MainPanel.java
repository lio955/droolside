package com.triple.fr.rules.ide.gui;

import net.miginfocom.swing.MigLayout;
import org.fife.ui.rtextarea.RTextScrollPane;
import org.jdesktop.swingx.JXFrame;
import org.jdesktop.swingx.JXPanel;

public class MainPanel extends JXFrame {

    private static final String TITLE = "Drools IDE";

    private TextArea textArea;

    public MainPanel() {
        super();
        textArea= new TextArea();
        setTitle(TITLE);
        setJMenuBar(new Menu());
        setContentPane(new JXPanel());
        getContentPane().setLayout(new MigLayout());

        add(new RTextScrollPane(textArea));

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }

    public TextArea getTextArea() {
        return textArea;
    }
}

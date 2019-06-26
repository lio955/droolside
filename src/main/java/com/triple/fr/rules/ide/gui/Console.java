package com.triple.fr.rules.ide.gui;

import org.jdesktop.swingx.JXTextArea;

import java.awt.*;

public class Console extends JXTextArea {
    private static final int COLUMNS = 120;
    private static final int ROWS = 20;

    public Console() {
        setBackground(Color.BLACK);
        setForeground(Color.WHITE);
        setFont(this.getFont().deriveFont(Font.BOLD, this.getFont().getSize()));
        setColumns(COLUMNS);
        setRows(ROWS);
    }
}

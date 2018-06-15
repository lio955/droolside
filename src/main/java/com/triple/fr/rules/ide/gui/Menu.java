package com.triple.fr.rules.ide.gui;

import com.triple.fr.rules.ide.actions.About;
import com.triple.fr.rules.ide.actions.Exit;
import com.triple.fr.rules.ide.actions.OpenFile;

import javax.swing.*;

public class Menu extends JMenuBar {

    public Menu() {
        super();
        JMenu menuFile = new JMenu("File");
        add(menuFile);

        menuFile.add(new JMenuItem(new OpenFile()));

        menuFile.add(new JMenuItem(new Exit()));

        JMenu menuAbout = new JMenu("Help");
        add(menuAbout);
        menuAbout.add(new JMenuItem(new About()));

    }
}

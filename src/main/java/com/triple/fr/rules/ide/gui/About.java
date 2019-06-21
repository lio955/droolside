package com.triple.fr.rules.ide.gui;

import com.triple.fr.rules.ide.application.AppDroolsIDE;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.swingx.JXDialog;
import org.jdesktop.swingx.JXLabel;
import org.jdesktop.swingx.JXPanel;

import java.awt.*;

public class About extends JXDialog {

    public About() {
        super(AppDroolsIDE.getInstance().getMainPanel(), new JXPanel());
        Dimension parentSize = getParent().getSize();
        Point p = getParent().getLocation();
        setLocation(p.x + parentSize.width / 4, p.y + parentSize.height / 4);
        getContentPane().add(new JXPanel());
        getContentPane().setLayout(new MigLayout("wrap 1"));
        getContentPane().add(new JXLabel("Drools editor V1.0.0"));
        pack();
        setModal(true);
    }
}

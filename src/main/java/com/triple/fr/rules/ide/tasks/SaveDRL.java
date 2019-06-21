package com.triple.fr.rules.ide.tasks;

import javax.swing.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SaveDRL extends SwingWorker {

    private String fileName;
    List<String> lines;

    public SaveDRL(final String fileName, String text) {
        this.fileName = fileName;
        this.lines = new ArrayList<String>(Arrays.asList(text.split("\n")));

    }

    @Override
    protected Object doInBackground() throws Exception {
        Files.write(Paths.get(fileName), lines, StandardCharsets.UTF_8);
        return null;
    }
}

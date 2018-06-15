package com.triple.fr.rules.ide.tasks;

import javax.swing.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CreateProject extends SwingWorker {
    @Override
    protected Object doInBackground() throws Exception {
        Path path = Paths.get("/home/lionel/scenario/input");
        Files.createDirectories(path);
        return null;
    }

    @Override
    protected void done() {
        super.done();
    }
}

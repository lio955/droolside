package com.triple.fr.rules.ide.tasks;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CreateProject {

    private String folderName;

    public CreateProject(String folderName) {
        this.folderName = folderName;
    }

    public void execute() throws Exception {
        Path path = Paths.get(folderName);
        Files.createDirectories(path);
        Files.
    }

}

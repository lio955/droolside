package com.triple.fr.rules.ide.tasks;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class CreateProject {

    private String folderName;

    public CreateProject(String folderName) {
        this.folderName = folderName;
    }

    public void execute() throws Exception {
        Files.createDirectories(Paths.get(folderName));
        Files.createDirectories(Paths.get(folderName + File.separator + "input"));
        Files.createDirectories(Paths.get(folderName + File.separator + "output"));
        Files.createDirectories(Paths.get(folderName + File.separator + "expected"));
        try {
            InputStream src = CreateProject.class.getResourceAsStream("/rules.csv");
            Files.copy(src, Paths.get(folderName + File.separator + "rules.csv"), StandardCopyOption.REPLACE_EXISTING);
            src = CreateProject.class.getResourceAsStream("/rules.drl");
            Files.copy(src, Paths.get(folderName + File.separator + "rules.drl"), StandardCopyOption.REPLACE_EXISTING);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
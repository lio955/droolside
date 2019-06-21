package com.triple.fr.rules.ide.tasks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OpenProjectDirectory {

    private String folderName;
    private List<String> drlFiles;

    public OpenProjectDirectory(String folderName) {
        this.folderName = folderName;
    }

    public void execute() throws Exception {
        try (Stream<Path> walk = Files.list(Paths.get(folderName))) {

            drlFiles = walk.map(x -> x.toString())
                    .filter(f -> f.endsWith(".drl")).collect(Collectors.toList());


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> getDrlFiles() {
        return drlFiles;
    }
}

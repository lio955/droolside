package com.triple.fr.rules.ide.tasks;

import org.apache.commons.lang3.StringUtils;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class OpenDRL {

    private String fileName;
    private String text;

    public OpenDRL(final String fileName) {
        this.fileName = fileName;

    }

    public void execute() throws Exception {
        List<String> lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
        text = StringUtils.join(lines, "\n");

    }

    public String getText() {
        return this.text;
    }
}

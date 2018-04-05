package com.triple.fr.rules.ide.drools;

import org.fife.ui.rsyntaxtextarea.CodeTemplateManager;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.templates.CodeTemplate;
import org.fife.ui.rsyntaxtextarea.templates.StaticCodeTemplate;

public class DroolsCodeTemplateManager  {


    public static void configure() {
        CodeTemplateManager codeTemplateManager= RSyntaxTextArea.getCodeTemplateManager();
        CodeTemplate codeTemplate_rule = new StaticCodeTemplate("r", "rule \"Rule 1\"\n" +
                "when\n" +
                "then\n" +
                "end", null);
        codeTemplateManager.addTemplate(codeTemplate_rule);
    }
}



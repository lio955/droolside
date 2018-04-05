package com.triple.fr.rules.ide.gui;

import com.triple.fr.rules.ide.drools.DroolsCodeTemplateManager;
import com.triple.fr.rules.ide.drools.DroolsFoldParser;
import org.fife.ui.rsyntaxtextarea.AbstractTokenMakerFactory;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.TokenMakerFactory;
import org.fife.ui.rsyntaxtextarea.folding.CurlyFoldParser;
import org.fife.ui.rsyntaxtextarea.folding.FoldParserManager;

public class TextArea extends RSyntaxTextArea {

    private static final int COLUMNS = 120;
    private static final int ROWS = 40;

    public TextArea() {
        super();
        setColumns(COLUMNS);
        setRows(ROWS);
        AbstractTokenMakerFactory atmf = (AbstractTokenMakerFactory) TokenMakerFactory.getDefaultInstance();
        atmf.putMapping("text/mvel", "com.triple.fr.rules.ide.drools.DroolsTokenMaker");
        setTemplatesEnabled(true);
        DroolsCodeTemplateManager.configure();

        FoldParserManager.get().addFoldParserMapping("text/mvel", new DroolsFoldParser());
        setSyntaxEditingStyle("text/mvel");

        setCodeFoldingEnabled(true);


        setAntiAliasingEnabled(true);
        setAutoscrolls(true);
        setCodeFoldingEnabled(true);
    }
}

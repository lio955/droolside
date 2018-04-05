package com.triple.fr.rules.ide.drools;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.Token;
import org.fife.ui.rsyntaxtextarea.folding.Fold;
import org.fife.ui.rsyntaxtextarea.folding.FoldParser;
import org.fife.ui.rsyntaxtextarea.folding.FoldType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.text.BadLocationException;
import java.util.ArrayList;
import java.util.List;


public class DroolsFoldParser implements FoldParser {
    private static Logger logger = LoggerFactory.getLogger(DroolsFoldParser.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Fold> getFolds(RSyntaxTextArea textArea) {

        List<Fold> folds = new ArrayList<Fold>();

        Fold currentFold = null;
        int lineCount = textArea.getLineCount();

        try {
            for (int line = 0; line < lineCount; line++) {

                textArea.
                Token t = textArea.getTokenListForLine(line);
                while (t != null && t.isPaintable()) {

                    if ("rule".equals(new String(t.getTextArray()))) {

                        currentFold = new Fold(FoldType.CODE, textArea, t.getOffset());
                        logger.info("rule");
                    }
                    if ("end".equals(new String(t.getTextArray()))) {
                        logger.info("end");
                        currentFold.setEndOffset(t.getOffset());
                        folds.add(currentFold);
                    }
                    t = t.getNextToken();

                }

            }

        } catch (BadLocationException e) {
            e.printStackTrace();
        }
        return folds;
    }
}
package com.swigder.geni.language;

import com.intellij.lexer.FlexAdapter;

public class GeniScriptLexerAdapter extends FlexAdapter {
    public GeniScriptLexerAdapter() {
        super(new GeniScriptLexer(null));
    }

}

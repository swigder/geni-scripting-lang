package com.swigder.geni.language;

import com.intellij.lang.Language;

public class GeniScriptLanguage extends Language {
    public static final GeniScriptLanguage INSTANCE = new GeniScriptLanguage();

    private GeniScriptLanguage() {
        super("GeniScript");
    }
}

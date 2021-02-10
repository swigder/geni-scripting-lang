package com.swigder.geni.language;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class GeniScriptFileType extends LanguageFileType {

    public static final GeniScriptFileType INSTANCE = new GeniScriptFileType();

    private GeniScriptFileType() {
        super(GeniScriptLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "GeniScript File";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "GeniScript language file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "geni";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return GeniScriptIcons.FILE;
    }

}

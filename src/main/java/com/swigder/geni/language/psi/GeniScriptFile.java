package com.swigder.geni.language.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import com.swigder.geni.language.GeniScriptFileType;
import com.swigder.geni.language.GeniScriptLanguage;
import org.jetbrains.annotations.NotNull;

public class GeniScriptFile extends PsiFileBase {
    public GeniScriptFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, GeniScriptLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return GeniScriptFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "GeniScript File";
    }

}

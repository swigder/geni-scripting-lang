package com.swigder.geni.language.psi;

import com.intellij.psi.tree.IElementType;
import com.swigder.geni.language.GeniScriptLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class GeniScriptElementType extends IElementType {
    public GeniScriptElementType(@NotNull @NonNls String debugName) {
        super(debugName, GeniScriptLanguage.INSTANCE);
    }
}

package com.swigder.geni.language.psi;

import com.intellij.psi.tree.IElementType;
import com.swigder.geni.language.GeniScriptLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class GeniScriptTokenType extends IElementType {
    public GeniScriptTokenType(@NotNull @NonNls String debugName) {
        super(debugName, GeniScriptLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "GeniScriptTokenType." + super.toString();
    }

}

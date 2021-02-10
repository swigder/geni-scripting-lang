package com.swigder.geni.language;

import com.intellij.lang.ASTNode;
import com.intellij.lang.folding.FoldingBuilderEx;
import com.intellij.lang.folding.FoldingDescriptor;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.util.PsiTreeUtil;
import com.swigder.geni.language.psi.GeniScriptCommandWithProperties;
import com.swigder.geni.language.psi.GeniScriptRootSubroutine;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GeniScriptFoldingBuilder extends FoldingBuilderEx {
    @Override
    public FoldingDescriptor @NotNull [] buildFoldRegions(@NotNull PsiElement root, @NotNull Document document, boolean quick) {
        List<FoldingDescriptor> descriptors = new ArrayList<>();

        Collection<GeniScriptCommandWithProperties> commands =
                PsiTreeUtil.findChildrenOfType(root, GeniScriptCommandWithProperties.class);
        for (final GeniScriptCommandWithProperties command : commands) {
            descriptors.add(new FoldingDescriptor(command.getNode(),
                    new TextRange(command.getTextRange().getStartOffset(),
                            command.getTextRange().getEndOffset())));
        }

        Collection<GeniScriptRootSubroutine> root_subroutines =
                PsiTreeUtil.findChildrenOfType(root, GeniScriptRootSubroutine.class);
        for (final GeniScriptRootSubroutine root_subroutine : root_subroutines) {
            descriptors.add(new FoldingDescriptor(root_subroutine.getNode(),
                    new TextRange(root_subroutine.getTextRange().getStartOffset(),
                            root_subroutine.getTextRange().getEndOffset())));
        }

        return descriptors.toArray(new FoldingDescriptor[descriptors.size()]);
    }

    @Override
    public @Nullable String getPlaceholderText(@NotNull ASTNode node) {
        if (node.getPsi() instanceof GeniScriptCommandWithProperties) {
            return node.getPsi(GeniScriptCommandWithProperties.class).getCommand().getText();
        }
        if (node.getPsi() instanceof GeniScriptRootSubroutine) {
            return node.getPsi(GeniScriptRootSubroutine.class).getText();
        }
        return null;
    }

    @Override
    public boolean isCollapsedByDefault(@NotNull ASTNode node) {
        return false;
    }
}

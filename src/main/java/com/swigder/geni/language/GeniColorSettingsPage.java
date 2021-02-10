package com.swigder.geni.language;

import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Map;

public class GeniColorSettingsPage implements ColorSettingsPage {

    private static final AttributesDescriptor[] DESCRIPTORS = new AttributesDescriptor[]{
            new AttributesDescriptor("Keyword", GeniScriptSyntaxHighlighter.KEYWORD),
            new AttributesDescriptor("Key", GeniScriptSyntaxHighlighter.KEY),
            new AttributesDescriptor("Separator", GeniScriptSyntaxHighlighter.SEPARATOR),
            new AttributesDescriptor("Value", GeniScriptSyntaxHighlighter.VALUE),
            new AttributesDescriptor("Bad Value", GeniScriptSyntaxHighlighter.BAD_CHARACTER)
    };

    @Nullable
    @Override
    public Icon getIcon() {
        return GeniScriptIcons.FILE;
    }

    @NotNull
    @Override
    public SyntaxHighlighter getHighlighter() {
        return new GeniScriptSyntaxHighlighter();
    }

    @NotNull
    @Override
    public String getDemoText() {
        return "# You are reading the \".geni\" file.\n" +
                "add_tree\n" +
                "\n" +
                "about_me: hello\n" +
                "\n" +
                "end_new\n";
    }

    @Nullable
    @Override
    public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
        return null;
    }

    @NotNull
    @Override
    public AttributesDescriptor[] getAttributeDescriptors() {
        return DESCRIPTORS;
    }

    @NotNull
    @Override
    public ColorDescriptor[] getColorDescriptors() {
        return ColorDescriptor.EMPTY_ARRAY;
    }

    @NotNull
    @Override
    public String getDisplayName() {
        return "GeniScript";
    }

}
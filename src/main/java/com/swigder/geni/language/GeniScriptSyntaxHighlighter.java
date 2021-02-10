package com.swigder.geni.language;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import com.swigder.geni.language.psi.GeniScriptTypes;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class GeniScriptSyntaxHighlighter extends SyntaxHighlighterBase {

    public static final TextAttributesKey KEYWORD =
            createTextAttributesKey("GENI_SCRIPT_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD);

    public static final TextAttributesKey SEPARATOR =
            createTextAttributesKey("GENI_SCRIPT_SEPARATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    public static final TextAttributesKey KEY =
            createTextAttributesKey("GENI_SCRIPT_KEY", DefaultLanguageHighlighterColors.GLOBAL_VARIABLE);
    public static final TextAttributesKey VALUE =
            createTextAttributesKey("GENI_SCRIPT_VALUE", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey COMMENT =
            createTextAttributesKey("GENI_SCRIPT_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey BAD_CHARACTER =
            createTextAttributesKey("GENI_SCRIPT_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER);


    private static final TextAttributesKey[] KEYWORD_KEYS = new TextAttributesKey[]{KEYWORD};

    private static final TextAttributesKey[] BAD_CHAR_KEYS = new TextAttributesKey[]{BAD_CHARACTER};
    private static final TextAttributesKey[] SEPARATOR_KEYS = new TextAttributesKey[]{SEPARATOR};
    private static final TextAttributesKey[] KEY_KEYS = new TextAttributesKey[]{KEY};
    private static final TextAttributesKey[] VALUE_KEYS = new TextAttributesKey[]{VALUE};
    private static final TextAttributesKey[] COMMENT_KEYS = new TextAttributesKey[]{COMMENT};
    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

    Set<IElementType> COMMAND_TYPES = Set.of(
            GeniScriptTypes.END_NEW,
            GeniScriptTypes.POP_ROOT,
            GeniScriptTypes.POP_ROOTS,
            GeniScriptTypes.PUSH_ROOT,
            GeniScriptTypes.SET_ROOT,
            GeniScriptTypes.UPDATE_PROFILE,
            GeniScriptTypes.ADD_CHILDREN,
            GeniScriptTypes.ADD_PARTNER,
            GeniScriptTypes.ADD_PARENTS,
            GeniScriptTypes.ADD_TREE
    );

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new GeniScriptLexerAdapter();
    }

    @NotNull
    @Override
    public TextAttributesKey @NotNull [] getTokenHighlights(IElementType tokenType) {
        if (COMMAND_TYPES.contains(tokenType)) {
            return KEYWORD_KEYS;
        }

        if (tokenType.equals(GeniScriptTypes.SEPARATOR)) {
            return SEPARATOR_KEYS;
        } else if (tokenType.equals(GeniScriptTypes.KEY)) {
            return KEY_KEYS;
        } else if (tokenType.equals(GeniScriptTypes.VALUE)) {
            return VALUE_KEYS;
        } else if (tokenType.equals(GeniScriptTypes.COMMENT)) {
            return COMMENT_KEYS;
        } else if (tokenType.equals(TokenType.BAD_CHARACTER)) {
            return BAD_CHAR_KEYS;
        } else {
            return EMPTY_KEYS;
        }
    }

}

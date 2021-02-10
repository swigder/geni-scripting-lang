package com.swigder.geni.language;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.swigder.geni.language.psi.GeniScriptTypes;
import com.intellij.psi.TokenType;

%%

%class GeniScriptLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}

END_LINE=\r|\n|\r\n
WHITE_SPACE=[\ \n\t\f]
FIRST_VALUE_CHARACTER=[^ \n\f\\] | "\\"{END_LINE} | "\\".
VALUE_CHARACTER=[^\n\f\\] | "\\"{END_LINE} | "\\".
END_OF_LINE_COMMENT=("#"|"!")[^\r\n]*
SEPARATOR=[: ]
KEY_CHARACTER=[^:=\ \n\t\f\\] | "\\ "

%state WAITING_VALUE

%%

<YYINITIAL>end_new {return GeniScriptTypes.END_NEW;}

<YYINITIAL>pop_root {return GeniScriptTypes.POP_ROOT;}
<YYINITIAL>pop_roots {return GeniScriptTypes.POP_ROOTS;}
<YYINITIAL>push_root {return GeniScriptTypes.PUSH_ROOT;}
<YYINITIAL>set_root {return GeniScriptTypes.SET_ROOT;}

<YYINITIAL>update_profile {return GeniScriptTypes.UPDATE_PROFILE;}
<YYINITIAL>add_children {return GeniScriptTypes.ADD_CHILDREN;}
<YYINITIAL>add_partner {return GeniScriptTypes.ADD_PARTNER;}
<YYINITIAL>add_parents {return GeniScriptTypes.ADD_PARENTS;}
<YYINITIAL>add_tree {return GeniScriptTypes.ADD_TREE;}



//<YYINITIAL> {END_OF_LINE_COMMENT}                           { yybegin(YYINITIAL); return GeniScriptTypes.COMMENT; }
//
<YYINITIAL> {KEY_CHARACTER}+ { yybegin(YYINITIAL); return GeniScriptTypes.KEY; }

<YYINITIAL> {SEPARATOR} { yybegin(WAITING_VALUE); return GeniScriptTypes.SEPARATOR; }

//<WAITING_VALUE> {END_LINE}({END_LINE}|{WHITE_SPACE})+               { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }
//
<WAITING_VALUE> {WHITE_SPACE}+ { yybegin(WAITING_VALUE); return TokenType.WHITE_SPACE; }

<WAITING_VALUE> {FIRST_VALUE_CHARACTER}{VALUE_CHARACTER}* { yybegin(YYINITIAL); return GeniScriptTypes.VALUE; }

({END_LINE}|{WHITE_SPACE})+ { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }

[^] { return TokenType.BAD_CHARACTER; }

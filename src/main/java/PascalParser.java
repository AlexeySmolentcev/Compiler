// Generated from Pascal by ANTLR 4.7
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PascalParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, INT=30, NAME=31, ENDOFLINE=32;
	public static final int
		RULE_module = 0, RULE_constants = 1, RULE_var = 2, RULE_variable = 3, 
		RULE_type = 4, RULE_statement = 5, RULE_if_statement = 6, RULE_if_else_statement = 7, 
		RULE_while_statement = 8, RULE_for_statement = 9, RULE_appropriation_statement = 10, 
		RULE_write_statement = 11, RULE_expression = 12, RULE_sum = 13, RULE_take = 14, 
		RULE_condition = 15, RULE_mod = 16;
	public static final String[] ruleNames = {
		"module", "constants", "var", "variable", "type", "statement", "if_statement", 
		"if_else_statement", "while_statement", "for_statement", "appropriation_statement", 
		"write_statement", "expression", "sum", "take", "condition", "mod"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'BEGIN'", "'END.'", "'CONST'", "' = '", "';'", "'VAR'", "': '", 
		"'INTEGER'", "'ARRAY [0..'", "'] OF INTEGER'", "'IF ('", "') THEN'", "'END;'", 
		"'END'", "'ELSE'", "'WHILE ('", "') DO'", "'FOR VAR '", "' TO '", "' DO'", 
		"' := '", "'WRITELN('", "');'", "' + '", "' - '", "'['", "']'", "' <> '", 
		"' MOD '"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, "INT", "NAME", "ENDOFLINE"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Pascal"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PascalParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ModuleContext extends ParserRuleContext {
		public TerminalNode ENDOFLINE() { return getToken(PascalParser.ENDOFLINE, 0); }
		public ConstantsContext constants() {
			return getRuleContext(ConstantsContext.class,0);
		}
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ModuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_module; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterModule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitModule(this);
		}
	}

	public final ModuleContext module() throws RecognitionException {
		ModuleContext _localctx = new ModuleContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_module);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(34);
				constants();
				}
			}

			setState(38);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(37);
				var();
				}
			}

			setState(40);
			match(T__0);
			setState(41);
			match(ENDOFLINE);
			setState(45);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__10) | (1L << T__15) | (1L << T__17) | (1L << T__21) | (1L << NAME))) != 0)) {
				{
				{
				setState(42);
				statement();
				}
				}
				setState(47);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(48);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstantsContext extends ParserRuleContext {
		public List<TerminalNode> ENDOFLINE() { return getTokens(PascalParser.ENDOFLINE); }
		public TerminalNode ENDOFLINE(int i) {
			return getToken(PascalParser.ENDOFLINE, i);
		}
		public TerminalNode NAME() { return getToken(PascalParser.NAME, 0); }
		public TerminalNode INT() { return getToken(PascalParser.INT, 0); }
		public ConstantsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constants; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterConstants(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitConstants(this);
		}
	}

	public final ConstantsContext constants() throws RecognitionException {
		ConstantsContext _localctx = new ConstantsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_constants);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			match(T__2);
			setState(51);
			match(ENDOFLINE);
			setState(52);
			match(NAME);
			setState(53);
			match(T__3);
			setState(54);
			match(INT);
			setState(55);
			match(T__4);
			setState(56);
			match(ENDOFLINE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarContext extends ParserRuleContext {
		public TerminalNode ENDOFLINE() { return getToken(PascalParser.ENDOFLINE, 0); }
		public List<VariableContext> variable() {
			return getRuleContexts(VariableContext.class);
		}
		public VariableContext variable(int i) {
			return getRuleContext(VariableContext.class,i);
		}
		public VarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitVar(this);
		}
	}

	public final VarContext var() throws RecognitionException {
		VarContext _localctx = new VarContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_var);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			match(T__5);
			setState(59);
			match(ENDOFLINE);
			setState(61); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(60);
				variable();
				}
				}
				setState(63); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NAME );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(PascalParser.NAME, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ENDOFLINE() { return getToken(PascalParser.ENDOFLINE, 0); }
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitVariable(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			match(NAME);
			setState(66);
			match(T__6);
			setState(67);
			type();
			setState(68);
			match(T__4);
			setState(69);
			match(ENDOFLINE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(PascalParser.NAME, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_type);
		try {
			setState(75);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__7:
				enterOuterAlt(_localctx, 1);
				{
				setState(71);
				match(T__7);
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 2);
				{
				setState(72);
				match(T__8);
				setState(73);
				match(NAME);
				setState(74);
				match(T__9);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public If_statementContext if_statement() {
			return getRuleContext(If_statementContext.class,0);
		}
		public If_else_statementContext if_else_statement() {
			return getRuleContext(If_else_statementContext.class,0);
		}
		public While_statementContext while_statement() {
			return getRuleContext(While_statementContext.class,0);
		}
		public For_statementContext for_statement() {
			return getRuleContext(For_statementContext.class,0);
		}
		public Appropriation_statementContext appropriation_statement() {
			return getRuleContext(Appropriation_statementContext.class,0);
		}
		public Write_statementContext write_statement() {
			return getRuleContext(Write_statementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_statement);
		try {
			setState(83);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(77);
				if_statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(78);
				if_else_statement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(79);
				while_statement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(80);
				for_statement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(81);
				appropriation_statement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(82);
				write_statement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class If_statementContext extends ParserRuleContext {
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public List<TerminalNode> ENDOFLINE() { return getTokens(PascalParser.ENDOFLINE); }
		public TerminalNode ENDOFLINE(int i) {
			return getToken(PascalParser.ENDOFLINE, i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public If_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterIf_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitIf_statement(this);
		}
	}

	public final If_statementContext if_statement() throws RecognitionException {
		If_statementContext _localctx = new If_statementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_if_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			match(T__10);
			setState(86);
			condition();
			setState(87);
			match(T__11);
			setState(88);
			match(ENDOFLINE);
			setState(89);
			match(T__0);
			setState(90);
			match(ENDOFLINE);
			setState(92); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(91);
				statement();
				}
				}
				setState(94); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__10) | (1L << T__15) | (1L << T__17) | (1L << T__21) | (1L << NAME))) != 0) );
			setState(96);
			match(T__12);
			setState(97);
			match(ENDOFLINE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class If_else_statementContext extends ParserRuleContext {
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public List<TerminalNode> ENDOFLINE() { return getTokens(PascalParser.ENDOFLINE); }
		public TerminalNode ENDOFLINE(int i) {
			return getToken(PascalParser.ENDOFLINE, i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public If_else_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_else_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterIf_else_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitIf_else_statement(this);
		}
	}

	public final If_else_statementContext if_else_statement() throws RecognitionException {
		If_else_statementContext _localctx = new If_else_statementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_if_else_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			match(T__10);
			setState(100);
			condition();
			setState(101);
			match(T__11);
			setState(102);
			match(ENDOFLINE);
			setState(103);
			match(T__0);
			setState(104);
			match(ENDOFLINE);
			setState(106); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(105);
				statement();
				}
				}
				setState(108); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__10) | (1L << T__15) | (1L << T__17) | (1L << T__21) | (1L << NAME))) != 0) );
			setState(110);
			match(T__13);
			setState(111);
			match(ENDOFLINE);
			setState(112);
			match(T__14);
			setState(113);
			match(ENDOFLINE);
			setState(114);
			match(T__0);
			setState(115);
			match(ENDOFLINE);
			setState(117); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(116);
				statement();
				}
				}
				setState(119); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__10) | (1L << T__15) | (1L << T__17) | (1L << T__21) | (1L << NAME))) != 0) );
			setState(121);
			match(T__12);
			setState(122);
			match(ENDOFLINE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class While_statementContext extends ParserRuleContext {
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public List<TerminalNode> ENDOFLINE() { return getTokens(PascalParser.ENDOFLINE); }
		public TerminalNode ENDOFLINE(int i) {
			return getToken(PascalParser.ENDOFLINE, i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public While_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterWhile_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitWhile_statement(this);
		}
	}

	public final While_statementContext while_statement() throws RecognitionException {
		While_statementContext _localctx = new While_statementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_while_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			match(T__15);
			setState(125);
			condition();
			setState(126);
			match(T__16);
			setState(127);
			match(ENDOFLINE);
			setState(128);
			match(T__0);
			setState(129);
			match(ENDOFLINE);
			setState(131); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(130);
				statement();
				}
				}
				setState(133); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__10) | (1L << T__15) | (1L << T__17) | (1L << T__21) | (1L << NAME))) != 0) );
			setState(135);
			match(T__12);
			setState(136);
			match(ENDOFLINE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class For_statementContext extends ParserRuleContext {
		public Appropriation_statementContext appropriation_statement() {
			return getRuleContext(Appropriation_statementContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<TerminalNode> ENDOFLINE() { return getTokens(PascalParser.ENDOFLINE); }
		public TerminalNode ENDOFLINE(int i) {
			return getToken(PascalParser.ENDOFLINE, i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public For_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterFor_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitFor_statement(this);
		}
	}

	public final For_statementContext for_statement() throws RecognitionException {
		For_statementContext _localctx = new For_statementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_for_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			match(T__17);
			setState(139);
			appropriation_statement();
			setState(140);
			match(T__18);
			setState(141);
			expression();
			setState(142);
			match(T__19);
			setState(143);
			match(ENDOFLINE);
			setState(144);
			match(T__0);
			setState(145);
			match(ENDOFLINE);
			setState(147); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(146);
				statement();
				}
				}
				setState(149); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__10) | (1L << T__15) | (1L << T__17) | (1L << T__21) | (1L << NAME))) != 0) );
			setState(151);
			match(T__12);
			setState(152);
			match(ENDOFLINE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Appropriation_statementContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(PascalParser.NAME, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode ENDOFLINE() { return getToken(PascalParser.ENDOFLINE, 0); }
		public TakeContext take() {
			return getRuleContext(TakeContext.class,0);
		}
		public Appropriation_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_appropriation_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterAppropriation_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitAppropriation_statement(this);
		}
	}

	public final Appropriation_statementContext appropriation_statement() throws RecognitionException {
		Appropriation_statementContext _localctx = new Appropriation_statementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_appropriation_statement);
		try {
			setState(169);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(154);
				match(NAME);
				setState(155);
				match(T__20);
				setState(156);
				expression();
				setState(157);
				match(T__4);
				setState(158);
				match(ENDOFLINE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(160);
				match(NAME);
				setState(161);
				match(T__20);
				setState(162);
				expression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(163);
				take();
				setState(164);
				match(T__20);
				setState(165);
				expression();
				setState(166);
				match(T__4);
				setState(167);
				match(ENDOFLINE);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Write_statementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode ENDOFLINE() { return getToken(PascalParser.ENDOFLINE, 0); }
		public Write_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_write_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterWrite_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitWrite_statement(this);
		}
	}

	public final Write_statementContext write_statement() throws RecognitionException {
		Write_statementContext _localctx = new Write_statementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_write_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(171);
			match(T__21);
			setState(172);
			expression();
			setState(173);
			match(T__22);
			setState(174);
			match(ENDOFLINE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(PascalParser.INT, 0); }
		public TerminalNode NAME() { return getToken(PascalParser.NAME, 0); }
		public SumContext sum() {
			return getRuleContext(SumContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_expression);
		try {
			setState(179);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(176);
				match(INT);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(177);
				match(NAME);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(178);
				sum();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SumContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(PascalParser.NAME, 0); }
		public TerminalNode INT() { return getToken(PascalParser.INT, 0); }
		public SumContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sum; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterSum(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitSum(this);
		}
	}

	public final SumContext sum() throws RecognitionException {
		SumContext _localctx = new SumContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_sum);
		try {
			setState(187);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(181);
				match(NAME);
				setState(182);
				match(T__23);
				setState(183);
				match(INT);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(184);
				match(NAME);
				setState(185);
				match(T__24);
				setState(186);
				match(INT);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TakeContext extends ParserRuleContext {
		public List<TerminalNode> NAME() { return getTokens(PascalParser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(PascalParser.NAME, i);
		}
		public TerminalNode INT() { return getToken(PascalParser.INT, 0); }
		public TakeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_take; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterTake(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitTake(this);
		}
	}

	public final TakeContext take() throws RecognitionException {
		TakeContext _localctx = new TakeContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_take);
		try {
			setState(197);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(189);
				match(NAME);
				setState(190);
				match(T__25);
				setState(191);
				match(NAME);
				setState(192);
				match(T__26);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(193);
				match(NAME);
				setState(194);
				match(T__25);
				setState(195);
				match(INT);
				setState(196);
				match(T__26);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConditionContext extends ParserRuleContext {
		public List<TerminalNode> NAME() { return getTokens(PascalParser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(PascalParser.NAME, i);
		}
		public TerminalNode INT() { return getToken(PascalParser.INT, 0); }
		public ModContext mod() {
			return getRuleContext(ModContext.class,0);
		}
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitCondition(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_condition);
		try {
			setState(209);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(199);
				match(NAME);
				setState(200);
				match(T__27);
				setState(201);
				match(NAME);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(202);
				match(NAME);
				setState(203);
				match(T__3);
				setState(204);
				match(INT);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(205);
				mod();
				setState(206);
				match(T__3);
				setState(207);
				match(INT);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ModContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(PascalParser.NAME, 0); }
		public TakeContext take() {
			return getRuleContext(TakeContext.class,0);
		}
		public ModContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mod; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterMod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitMod(this);
		}
	}

	public final ModContext mod() throws RecognitionException {
		ModContext _localctx = new ModContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_mod);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
			match(NAME);
			setState(212);
			match(T__28);
			setState(213);
			take();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\"\u00da\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\5\2&\n\2\3\2\5\2)\n\2\3\2\3\2\3\2\7\2.\n\2\f\2\16\2\61\13\2\3\2\3"+
		"\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\6\4@\n\4\r\4\16\4A\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\5\6N\n\6\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\5\7V\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\6\b_\n\b\r\b\16\b`\3\b\3\b\3\b\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\6\tm\n\t\r\t\16\tn\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\6\tx\n\t\r\t\16\ty\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\6\n\u0086"+
		"\n\n\r\n\16\n\u0087\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\6\13\u0096\n\13\r\13\16\13\u0097\3\13\3\13\3\13\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00ac\n\f\3\r\3\r\3\r"+
		"\3\r\3\r\3\16\3\16\3\16\5\16\u00b6\n\16\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\5\17\u00be\n\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00c8\n"+
		"\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u00d4\n\21"+
		"\3\22\3\22\3\22\3\22\3\22\2\2\23\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36"+
		" \"\2\2\2\u00df\2%\3\2\2\2\4\64\3\2\2\2\6<\3\2\2\2\bC\3\2\2\2\nM\3\2\2"+
		"\2\fU\3\2\2\2\16W\3\2\2\2\20e\3\2\2\2\22~\3\2\2\2\24\u008c\3\2\2\2\26"+
		"\u00ab\3\2\2\2\30\u00ad\3\2\2\2\32\u00b5\3\2\2\2\34\u00bd\3\2\2\2\36\u00c7"+
		"\3\2\2\2 \u00d3\3\2\2\2\"\u00d5\3\2\2\2$&\5\4\3\2%$\3\2\2\2%&\3\2\2\2"+
		"&(\3\2\2\2\')\5\6\4\2(\'\3\2\2\2()\3\2\2\2)*\3\2\2\2*+\7\3\2\2+/\7\"\2"+
		"\2,.\5\f\7\2-,\3\2\2\2.\61\3\2\2\2/-\3\2\2\2/\60\3\2\2\2\60\62\3\2\2\2"+
		"\61/\3\2\2\2\62\63\7\4\2\2\63\3\3\2\2\2\64\65\7\5\2\2\65\66\7\"\2\2\66"+
		"\67\7!\2\2\678\7\6\2\289\7 \2\29:\7\7\2\2:;\7\"\2\2;\5\3\2\2\2<=\7\b\2"+
		"\2=?\7\"\2\2>@\5\b\5\2?>\3\2\2\2@A\3\2\2\2A?\3\2\2\2AB\3\2\2\2B\7\3\2"+
		"\2\2CD\7!\2\2DE\7\t\2\2EF\5\n\6\2FG\7\7\2\2GH\7\"\2\2H\t\3\2\2\2IN\7\n"+
		"\2\2JK\7\13\2\2KL\7!\2\2LN\7\f\2\2MI\3\2\2\2MJ\3\2\2\2N\13\3\2\2\2OV\5"+
		"\16\b\2PV\5\20\t\2QV\5\22\n\2RV\5\24\13\2SV\5\26\f\2TV\5\30\r\2UO\3\2"+
		"\2\2UP\3\2\2\2UQ\3\2\2\2UR\3\2\2\2US\3\2\2\2UT\3\2\2\2V\r\3\2\2\2WX\7"+
		"\r\2\2XY\5 \21\2YZ\7\16\2\2Z[\7\"\2\2[\\\7\3\2\2\\^\7\"\2\2]_\5\f\7\2"+
		"^]\3\2\2\2_`\3\2\2\2`^\3\2\2\2`a\3\2\2\2ab\3\2\2\2bc\7\17\2\2cd\7\"\2"+
		"\2d\17\3\2\2\2ef\7\r\2\2fg\5 \21\2gh\7\16\2\2hi\7\"\2\2ij\7\3\2\2jl\7"+
		"\"\2\2km\5\f\7\2lk\3\2\2\2mn\3\2\2\2nl\3\2\2\2no\3\2\2\2op\3\2\2\2pq\7"+
		"\20\2\2qr\7\"\2\2rs\7\21\2\2st\7\"\2\2tu\7\3\2\2uw\7\"\2\2vx\5\f\7\2w"+
		"v\3\2\2\2xy\3\2\2\2yw\3\2\2\2yz\3\2\2\2z{\3\2\2\2{|\7\17\2\2|}\7\"\2\2"+
		"}\21\3\2\2\2~\177\7\22\2\2\177\u0080\5 \21\2\u0080\u0081\7\23\2\2\u0081"+
		"\u0082\7\"\2\2\u0082\u0083\7\3\2\2\u0083\u0085\7\"\2\2\u0084\u0086\5\f"+
		"\7\2\u0085\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0085\3\2\2\2\u0087"+
		"\u0088\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u008a\7\17\2\2\u008a\u008b\7"+
		"\"\2\2\u008b\23\3\2\2\2\u008c\u008d\7\24\2\2\u008d\u008e\5\26\f\2\u008e"+
		"\u008f\7\25\2\2\u008f\u0090\5\32\16\2\u0090\u0091\7\26\2\2\u0091\u0092"+
		"\7\"\2\2\u0092\u0093\7\3\2\2\u0093\u0095\7\"\2\2\u0094\u0096\5\f\7\2\u0095"+
		"\u0094\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u0095\3\2\2\2\u0097\u0098\3\2"+
		"\2\2\u0098\u0099\3\2\2\2\u0099\u009a\7\17\2\2\u009a\u009b\7\"\2\2\u009b"+
		"\25\3\2\2\2\u009c\u009d\7!\2\2\u009d\u009e\7\27\2\2\u009e\u009f\5\32\16"+
		"\2\u009f\u00a0\7\7\2\2\u00a0\u00a1\7\"\2\2\u00a1\u00ac\3\2\2\2\u00a2\u00a3"+
		"\7!\2\2\u00a3\u00a4\7\27\2\2\u00a4\u00ac\5\32\16\2\u00a5\u00a6\5\36\20"+
		"\2\u00a6\u00a7\7\27\2\2\u00a7\u00a8\5\32\16\2\u00a8\u00a9\7\7\2\2\u00a9"+
		"\u00aa\7\"\2\2\u00aa\u00ac\3\2\2\2\u00ab\u009c\3\2\2\2\u00ab\u00a2\3\2"+
		"\2\2\u00ab\u00a5\3\2\2\2\u00ac\27\3\2\2\2\u00ad\u00ae\7\30\2\2\u00ae\u00af"+
		"\5\32\16\2\u00af\u00b0\7\31\2\2\u00b0\u00b1\7\"\2\2\u00b1\31\3\2\2\2\u00b2"+
		"\u00b6\7 \2\2\u00b3\u00b6\7!\2\2\u00b4\u00b6\5\34\17\2\u00b5\u00b2\3\2"+
		"\2\2\u00b5\u00b3\3\2\2\2\u00b5\u00b4\3\2\2\2\u00b6\33\3\2\2\2\u00b7\u00b8"+
		"\7!\2\2\u00b8\u00b9\7\32\2\2\u00b9\u00be\7 \2\2\u00ba\u00bb\7!\2\2\u00bb"+
		"\u00bc\7\33\2\2\u00bc\u00be\7 \2\2\u00bd\u00b7\3\2\2\2\u00bd\u00ba\3\2"+
		"\2\2\u00be\35\3\2\2\2\u00bf\u00c0\7!\2\2\u00c0\u00c1\7\34\2\2\u00c1\u00c2"+
		"\7!\2\2\u00c2\u00c8\7\35\2\2\u00c3\u00c4\7!\2\2\u00c4\u00c5\7\34\2\2\u00c5"+
		"\u00c6\7 \2\2\u00c6\u00c8\7\35\2\2\u00c7\u00bf\3\2\2\2\u00c7\u00c3\3\2"+
		"\2\2\u00c8\37\3\2\2\2\u00c9\u00ca\7!\2\2\u00ca\u00cb\7\36\2\2\u00cb\u00d4"+
		"\7!\2\2\u00cc\u00cd\7!\2\2\u00cd\u00ce\7\6\2\2\u00ce\u00d4\7 \2\2\u00cf"+
		"\u00d0\5\"\22\2\u00d0\u00d1\7\6\2\2\u00d1\u00d2\7 \2\2\u00d2\u00d4\3\2"+
		"\2\2\u00d3\u00c9\3\2\2\2\u00d3\u00cc\3\2\2\2\u00d3\u00cf\3\2\2\2\u00d4"+
		"!\3\2\2\2\u00d5\u00d6\7!\2\2\u00d6\u00d7\7\37\2\2\u00d7\u00d8\5\36\20"+
		"\2\u00d8#\3\2\2\2\22%(/AMU`ny\u0087\u0097\u00ab\u00b5\u00bd\u00c7\u00d3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
package by.epam.businesslayer;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.epam.exception.TextTypeNotFoundException;
import by.epam.model.entity.ILexeme;
import by.epam.model.entity.Leaf;
import by.epam.model.entity.LexemeType;
import by.epam.model.entity.TextBlock;

public class StringParser {

	private StringInfo sInfo = new StringInfo();
	
	private final static String CODEBLOCK_PATTERN = "^(class|public|private|protected|void|int|String|long|"
									+ "char|boolean|double|if|while|for|interface|\\}|\\{).*[;\\{]$";
	
	private final static String TEXT_SPLIT = "\\n";
	
	private final static String PARAGRAPH_SPLIT = "[!|\\?|\\.|;]";
	
	private final static String CODEBLOCK_SPLIT = "[!\"\' \\(\\),\\.-=:;\\?\\[\\]\\{\\}]";
	
	private final static String SENTENCE_SPLIT = "[!\"\' \\(\\),\\.-=:;\\?\\[\\]\\{\\}]";
	
	private final static String PUNCTUATION_PATTERN = "[!\"\' \\(\\),\\.-=:;\\?\\[\\]\\{\\}]";
	
	//return punctuation indexes
	private ArrayList<Integer> punctuationIndexes(String str, String regEx) {
		ArrayList<Integer> indexes = new ArrayList<Integer>();
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(str);
		while (m.find()) {
			int index = m.start();
			indexes.add(index);
		}
		return indexes;
	}
	
	private ArrayList<String> split(String str, String regEx) {
		ArrayList<String> retStrs = new ArrayList<String>();
		ArrayList<Integer> indexes = punctuationIndexes(str, regEx);
		indexes.add(str.length());
		int beginIndex = 0;
		for (Integer ind : indexes) {
			if (beginIndex > 0) {
				String s = ((Character) str.charAt(beginIndex)).toString().trim();
				if (!s.isEmpty()) {
					retStrs.add(s);
				}
				s = str.substring(beginIndex + 1, ind).trim();
				if (!s.isEmpty()) {
					retStrs.add(s);
				}
			} else {
				String s = str.substring(beginIndex, ind).trim();
				if (!s.isEmpty()) {
					retStrs.add(s);
				}
			}
			beginIndex = ind;
		}
		return retStrs;
	}
	
	private ArrayList<String> splitParagraph(String str, String regEx) {
		ArrayList<String> retStrs = new ArrayList<String>();
		ArrayList<Integer> indexes = punctuationIndexes(str, regEx);
		indexes.add(str.length() - 1);
		int beginIndex = 0;
		for (Integer ind : indexes) {
			ind++;
			String s = str.substring(beginIndex, ind).trim();
			if (!s.isEmpty()) {
				retStrs.add(s);
			}
			beginIndex = ind;
		}
		return retStrs;
	}
	
	//parsing String str to tree of ILexemes
	private void parse(String str, ILexeme lex) throws TextTypeNotFoundException {
		str = str.trim();
		String type = lex.getType();
		ArrayList<String> splStr;
		switch (type) {
			case LexemeType.SENTENCE:
				splStr = split(str, SENTENCE_SPLIT);
				for (String ss : splStr) {
					ILexeme chL;
					if (sInfo.isFitRegEx(ss, PUNCTUATION_PATTERN)) {
						chL = new Leaf(ss, LexemeType.PUNCTUATION);
					} else {
						chL = new Leaf(ss, LexemeType.WORD);
					}
					lex.addElement(chL);
				}
				break;
			case LexemeType.CODEBLOCK:
				splStr = split(str, CODEBLOCK_SPLIT);
				for (String ss : splStr) {
					ILexeme chL = new TextBlock(LexemeType.WORD);
					lex.addElement(chL);
					parse(ss, chL);
				}
				break;
			case LexemeType.PARAGRAPH:
				splStr = splitParagraph(str, PARAGRAPH_SPLIT);
				for (String ss : splStr) {
					ILexeme chL = new TextBlock(LexemeType.SENTENCE);
					lex.addElement(chL);
					parse(ss, chL);
				}
				break;
			case LexemeType.TEXT:
				splStr = split(str, TEXT_SPLIT);
				for (String ss : splStr) {
					ILexeme chL;
					if (sInfo.isFitRegEx(ss, CODEBLOCK_PATTERN)) {
						chL = new TextBlock(LexemeType.CODEBLOCK);
					} else {
						chL = new TextBlock(LexemeType.PARAGRAPH);
					}
					lex.addElement(chL);
					parse(ss, chL);
				}
				break;
			default:
				break;
		}

	}
	
	public ILexeme parse(String str) throws TextTypeNotFoundException{
		ILexeme text = new TextBlock(LexemeType.TEXT);
		parse(str, text);
		return text;
	}
}
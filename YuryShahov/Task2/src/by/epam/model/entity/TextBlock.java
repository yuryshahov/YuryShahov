package by.epam.model.entity;

import java.util.ArrayList;
import java.util.List;

public class TextBlock implements ILexeme, Comparable<ILexeme> {

	//collection for childs this class instance
	private List<ILexeme> elements = new ArrayList<ILexeme>();
	
	//instance type
	private String type;
	
	public TextBlock(String type) {
		this.type = type;
	}

	@Override
	public Iterable<ILexeme> getElements() {
		return elements;
	}
	
	@Override
	public String getType() {
		return type;
	}
	
	@Override
	public void addElement(ILexeme lexeme) {
		elements.add(lexeme);
	}

	@Override
	public int compareTo(ILexeme lex) {
		return this.toString().compareTo(lex.toString());
	}
	
	@Override
	public int wordsCount() {
		int sum = 0;
		Iterable<ILexeme> lexs = getElements();
		for (ILexeme lex : lexs) {
			sum += lex.wordsCount();
		}
		return sum;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((elements == null) ? 0 : elements.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TextBlock other = (TextBlock) obj;
		if (elements == null) {
			if (other.elements != null)
				return false;
		} else if (!elements.equals(other.elements))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		StringBuilder buff = new StringBuilder();
		Iterable<ILexeme> lexs = getElements();
		for (ILexeme lex : lexs) {
			if (LexemeType.WORD.equals(lex.getType())) {
				buff.append(" ");
			}
			buff.append(lex.toString());
		}
		if (LexemeType.PARAGRAPH.equals(getType())) {
			buff.append("\r\n");
		}
		return buff.toString();
	}
}

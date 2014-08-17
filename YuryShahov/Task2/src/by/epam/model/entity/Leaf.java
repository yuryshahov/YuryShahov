package by.epam.model.entity;

//type for leaf of tree lexemes
public class Leaf implements ILexeme, Comparable<ILexeme> {

	//leaf content
	private String content;
	
	private String type;
	
	public Leaf(String content, String type) {
		this.content = content;
		this.type = type;
	}
	
	@Override
	public String getType() {
		return type;
	}
	
	@Override
	public void addElement(ILexeme lexeme) {
		//метод заглушка
	}
	
	//количество слов в даннок элементе
	@Override
	public int wordsCount() {
		return (LexemeType.WORD.equals(type)) ? 1 : 0;
	}

	@Override
	public Iterable<ILexeme> getElements() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String toString() {
		return content;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
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
		Leaf other = (Leaf) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		return true;
	}

	@Override
	public int compareTo(ILexeme lex) {
		return this.toString().compareTo(lex.toString());
	}
}

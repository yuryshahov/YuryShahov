package by.epam.model.entity;

public interface ILexeme {
	
	void addElement(ILexeme lexeme);
	
	String getType();
	
	int wordsCount();
	
	Iterable<ILexeme> getElements();
}

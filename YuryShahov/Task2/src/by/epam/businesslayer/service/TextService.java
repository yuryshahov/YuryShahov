package by.epam.businesslayer.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import by.epam.model.comparator.WordsCountComparator;
import by.epam.model.entity.ILexeme;
import by.epam.model.entity.LexemeType;

public class TextService {
	
	//variable for using in follow methods
	private List<ILexeme> lexes;
	
	//searching sentences in lexeme
	private void findByType(ILexeme lex, String type) {
		Iterable<ILexeme> childs = lex.getElements();
		if (childs != null) {
			for (ILexeme ch : childs) {
				if (ch.getType().equals(type)) {
					lexes.add(ch);
				}
				findByType(ch, type);
			}
		}
	}
	
	//sort sentences by words quantity for each sentences
	public List<ILexeme> sotrTextByWordsCount(ILexeme lex) {
		lexes = new ArrayList<ILexeme>();
		findByType(lex, LexemeType.SENTENCE);
		Collections.sort(lexes, new WordsCountComparator());
		return lexes;
	}

	//choosing exclusive words from first sentence which not founded in others
	public List<ILexeme> exclusiveWords(ILexeme lex) {
		List<ILexeme> retWords = new ArrayList<ILexeme>();
		SortedSet<ILexeme> allWords = new TreeSet<ILexeme>();

		//choosing all words after first sentence
		List<ILexeme> sents = (List<ILexeme>) lex.getElements();
		for (int i = 1; i < sents.size(); i++) {
			ILexeme l = sents.get(i);
			lexes = new ArrayList<ILexeme>();
			findByType(l, LexemeType.WORD);
			for (ILexeme s : sents) {
				allWords.add(s);
			}
		}
		

		//searching exclusive words
		if (sents.size() > 0) {
			lexes = new ArrayList<ILexeme>();
			ILexeme firstSentence = sents.get(0);
			findByType(firstSentence, LexemeType.WORD);
			for (ILexeme w : lexes) {
				if (!allWords.contains(w)) {
					retWords.add(w);
				}
			}
		}
		return retWords;
	}
}

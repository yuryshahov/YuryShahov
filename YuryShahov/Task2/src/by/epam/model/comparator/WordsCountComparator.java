package by.epam.model.comparator;

import java.util.Comparator;

import by.epam.model.entity.ILexeme;

public class WordsCountComparator implements Comparator<ILexeme> {

	@Override
	public int compare(ILexeme l1, ILexeme l2) {
		int res = l1.wordsCount() - l2.wordsCount();
		if (res != 0) {
			return res;
		}
		return 0;
	}

}

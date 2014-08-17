package by.epam.model.loader;

import java.util.List;

import by.epam.exception.FilePathException;
import by.epam.model.entity.ILexeme;

public class FilePrinter extends FileLoader {
	
	public void print(String path, String title, List<ILexeme> arLexs) throws FilePathException {
		StringBuilder sb = new StringBuilder();
		sb.append(title + "\r\n");
		for (ILexeme al : arLexs) {
			sb.append(al);
			sb.append("\r\n");
		}
		String cont = sb.toString().trim();
		writeTextFile(path, cont);
	}
}

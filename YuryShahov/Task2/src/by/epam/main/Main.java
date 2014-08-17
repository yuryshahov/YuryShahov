package by.epam.main;

import java.io.*;
import java.util.Formatter;
import java.util.List;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import by.epam.businesslayer.StringParser;
import by.epam.businesslayer.service.TextService;
import by.epam.exception.FilePathException;
import by.epam.exception.TextTypeNotFoundException;
import by.epam.model.config.ConfigString;
import by.epam.model.entity.ILexeme;
import by.epam.model.loader.FileLoader;
import by.epam.model.loader.FilePrinter;

public class Main {

	public static Logger LOG;
	
	public static void main(String[] args) throws IOException {
		try {	
			PropertyConfigurator.configure(ConfigString.CONFIG_FILE_PATH);
			LOG = Logger.getLogger(Main.class);
			TextService ts = new TextService();
			Formatter formatter = new Formatter();
			FileLoader fl = new FileLoader();
			FilePrinter fp = new FilePrinter();
			StringParser parser = new StringParser();
			
			//file loading
			String bufStr = fl.readTextFile(ConfigString.TEXT_INPUT_FILE);
						
			//use Locale to formating
			bufStr = formatter.format(new Locale("ru", "RU"),  "%s", bufStr).toString();
			formatter.close();

			ILexeme lex = parser.parse(bufStr);
			
			//sort lexemes
			List<ILexeme> sortedLex = ts.sotrTextByWordsCount(lex);
			
			//choosing exclusive words form first sentence which not exist in others
			List<ILexeme> exclusiveWords = ts.exclusiveWords(lex);
			
			//write sorted results to file
			fp.print(ConfigString.SORTEDSENTENCIES_FILE, "Sorted sentencies:", sortedLex);	
			
			//write exclusive results to file
			fp.print(ConfigString.EXCLUSIVE_FILE, 
										"Exclusive words form first sentence:", exclusiveWords);
			
			System.out.println("All done!!!");
		} catch (FilePathException e) {
			LOG.error("", e);
		} catch (TextTypeNotFoundException e) {
			LOG.error("", e);
		}
	}
}

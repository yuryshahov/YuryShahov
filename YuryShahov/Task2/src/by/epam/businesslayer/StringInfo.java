package by.epam.businesslayer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringInfo {
	
	public boolean isFitRegEx(String str, String regEx) {
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(str);
		return m.matches();
	}
}

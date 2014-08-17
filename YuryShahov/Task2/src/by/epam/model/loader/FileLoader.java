package by.epam.model.loader;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

import by.epam.exception.FilePathException;

import static by.epam.main.Main.LOG;

public class FileLoader {
	
	//reading file to string
	public String readTextFile(String path) throws FilePathException {
		Reader r = null;
		StringBuilder sb = new StringBuilder();
		try {
			char[] buff = new char[4196];
			r = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF8"));
			int index = 0;
			while ((index = r.read(buff, 0, 4196)) > 0) {
				sb.append(new String(buff, 0, index));
			}
		} catch (IOException e) {
			throw new FilePathException();
		} finally {
			try {
				if (r != null) {
					r.close();
				}
			} catch (IOException e) {
				LOG.error("", e);
			}
		}
		return sb.toString();
	}
	
	//writing string to file
	public void writeTextFile(String path, String content) throws FilePathException {
		Writer w = null;
		try {
			w = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path)));
			w.write(content);
		} catch (IOException e) {
			throw new FilePathException();
		} finally {
			try {
				if (w != null) {
					w.close();
				}
			} catch (IOException e) {
				LOG.error("", e);
			}
		}
	}
}

package by.epam.model.builder;

import java.io.IOException;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import by.epam.exception.ErrorException;

public class CarSaxBuilder extends CarBuilder {

	private XMLReader reader;
	
	private CarHandler handler;
	
	public CarSaxBuilder() throws ErrorException {
		handler = new CarHandler();
		try {
			reader = XMLReaderFactory.createXMLReader();
			reader.setContentHandler(handler);
		} catch (SAXException e) {
			throw new ErrorException(e);
		}
	}
	
	@Override
	public void buildSetCars(String path) throws ErrorException {
		try {
			reader.parse(path);
			cars = handler.getCars();
		} catch (IOException e) {
			throw new ErrorException(e);
		} catch (SAXException e) {
			throw new ErrorException(e);
		}
	}

}

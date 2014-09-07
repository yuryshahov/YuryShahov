package by.epam.model.factory;

import by.epam.exception.ErrorException;
import by.epam.model.builder.CarBuilder;
import by.epam.model.builder.CarDomBuilder;
import by.epam.model.builder.CarSaxBuilder;
import by.epam.model.builder.CarStaxBuilder;

public class CarBuilderFactory {
	
	public enum TypeParser {
		DOM, SAX, STAX;
	}
	
	public CarBuilder createBuilder(TypeParser type) throws ErrorException {
		switch (type) {
			case DOM:
				return new CarDomBuilder();
			case SAX:
				return new CarSaxBuilder();
			case STAX:
				return new CarStaxBuilder();
			default:
				throw new ErrorException();
		}
	}
}

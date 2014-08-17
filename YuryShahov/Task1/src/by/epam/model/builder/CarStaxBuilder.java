package by.epam.model.builder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import by.epam.exception.ErrorException;
import by.epam.model.entity.PassengerCar;
import static by.epam.main.Main.LOG;

public class CarStaxBuilder extends CarBuilder {

	private XMLInputFactory inputFactory;
	
	public CarStaxBuilder() {
		inputFactory = XMLInputFactory.newInstance();
	}
	
	private String xmlText(XMLStreamReader reader) throws ErrorException {
		String text = null;
		try {
			if (reader.hasNext()) {
				reader.next();
				text = reader.getText();
			}
		} catch (XMLStreamException e) {
			throw new ErrorException(e);
		}
		return text;
	}
	
	@Override
	public void buildSetCars(String path) throws ErrorException {
		FileInputStream inputStream = null;
		XMLStreamReader reader = null;
		String name;
		PassengerCar car = null;
		try {
			inputStream = new FileInputStream(new File(path));
			reader = inputFactory.createXMLStreamReader(inputStream);
			while (reader.hasNext()) {
				int type = reader.next();
				if (type == XMLStreamConstants.START_ELEMENT) {
					name = reader.getLocalName();
					String s = xmlText(reader);
					switch (name) {
						case CarTag.ID:
							car.setId(Long.parseLong(s));
							break;
						case CarTag.BRAND:
							car.setBrand(s);
							break;
						case CarTag.COST:
							car.setCost(Double.parseDouble(s));
							break;
						case CarTag.DISPLACEMENT:
							car.setDisplacement(Double.parseDouble(s));
							break;
						case CarTag.FUELCONSUMPTION:
							car.setFuelConsumption(Double.parseDouble(s));
							break;
						case CarTag.MAXSPEED:
							car.setMaxSpeed(Double.parseDouble(s));
							break;
						case CarTag.SEATS:
							car.setSeats(Integer.parseInt(s));
							break;
						case CarTag.YEAR:
							car.setYear(Integer.parseInt(s));
							break;
						case CarTag.CAR:
							car = new PassengerCar();
							cars.add(car);
							break;
						case CarTag.CARS:
							break;
						default:
							LOG.warn("Tag " + s + " is not exists!!!");
							break;
					}
				}
			}
		} catch (FileNotFoundException e) {
			throw new ErrorException(e);
		} catch (XMLStreamException e) {
			throw new ErrorException(e);
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (XMLStreamException e) {
				LOG.warn(e);
			}
		}
	}

}

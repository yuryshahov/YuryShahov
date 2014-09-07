package by.epam.model.builder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import by.epam.model.entity.ICar;
import by.epam.model.entity.PassengerCar;

public class CarHandler extends DefaultHandler {

	private PassengerCar current = null;
	
	private String currentTag = null;
	
	private static Set<String> carTags = new HashSet<String>();
	
	private List<ICar> cars;

	public List<ICar> getCars() {
		return cars;
	}
	
	public CarHandler() {
		cars = new ArrayList<ICar>();
		carTags.add(CarTag.ID);
		carTags.add(CarTag.BRAND);
		carTags.add(CarTag.COST);
		carTags.add(CarTag.DISPLACEMENT);
		carTags.add(CarTag.MAXSPEED);
		carTags.add(CarTag.FUELCONSUMPTION);
		carTags.add(CarTag.SEATS);
		carTags.add(CarTag.YEAR);
	}

	@Override
	public void startElement(String uri, String localName, String gName,
										Attributes attrs) throws SAXException {
		if (carTags.contains(localName)) {
			currentTag = localName;
		} else if (CarTag.CAR.equals(localName)) {
			current = new PassengerCar();
		}
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) {
		if ("car".equals(localName)) {
			cars.add(current);
		}
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String s = new String(ch, start, length).trim();
		if (!s.isEmpty()) {
			if (currentTag != null) {
				switch (currentTag) {
					case CarTag.ID:
						current.setId(Long.parseLong(s));
						break;
					case CarTag.BRAND:
						current.setBrand(s);
						break;
					case CarTag.COST:
						current.setCost(Double.parseDouble(s));
						break;
					case CarTag.DISPLACEMENT:
						current.setDisplacement(Double.parseDouble(s));
						break;
					case CarTag.FUELCONSUMPTION:
						current.setFuelConsumption(Double.parseDouble(s));
						break;
					case CarTag.MAXSPEED:
						current.setMaxSpeed(Double.parseDouble(s));
						break;
					case CarTag.SEATS:
						current.setSeats(Integer.parseInt(s));
						break;
					case CarTag.YEAR:
						current.setYear(Integer.parseInt(s));
						break;
					default:
					//	LOG.warn("Attribute " + s + " is not exists!!!");
						break;
				}
			}
		}
	}
}

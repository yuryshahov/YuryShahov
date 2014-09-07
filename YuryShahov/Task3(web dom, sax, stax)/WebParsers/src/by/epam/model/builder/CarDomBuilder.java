package by.epam.model.builder;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import by.epam.exception.ErrorException;
import by.epam.exception.LogicException;
import by.epam.model.entity.ICar;
import by.epam.model.entity.PassengerCar;

public class CarDomBuilder extends CarBuilder {

	private DocumentBuilder db;

	public CarDomBuilder() throws ErrorException {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			db = dbf.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			throw new ErrorException(e);
		}
	}
	
	private String getElementValue(Element el, String elName) throws LogicException {
		NodeList chList = el.getElementsByTagName(elName);
		if (chList.getLength() > 0) {
			return chList.item(0).getTextContent();
		} else {
			throw new LogicException();
		}
	}
	
	private ICar buildCar(Element carElement) throws LogicException {
		ArrayList<Object> retCars = new ArrayList<Object>();
		PassengerCar pcar = new PassengerCar();
		
		String id = getElementValue(carElement, "id");
		pcar.setId(Long.parseLong(id));
		
		String brand = getElementValue(carElement, "brand");
		pcar.setBrand(brand);
		
		String cost = getElementValue(carElement, "cost");
		pcar.setCost(Double.parseDouble(cost));
		
		String displacement = getElementValue(carElement, "displacement");
		pcar.setDisplacement(Double.parseDouble(displacement));
		
		String maxspeed = getElementValue(carElement, "maxspeed");
		pcar.setMaxSpeed(Double.parseDouble(maxspeed));
		
		String fuelconsumption = getElementValue(carElement, "fuelconsumption");
		pcar.setFuelConsumption(Double.parseDouble(fuelconsumption));
		
		String seats = getElementValue(carElement, "seats");
		pcar.setSeats(Integer.parseInt(seats));
		
		String year = getElementValue(carElement, "year");
		pcar.setYear(Integer.parseInt(year));

		retCars.add(pcar);
		
		return pcar;
	}
	
	@Override
	public void buildListCars(String path) throws ErrorException, LogicException {
		Document doc = null;
		try {
			
			doc = db.parse(path);
			Element root = doc.getDocumentElement();
			
			NodeList studentsList = root.getElementsByTagName(CarTag.CAR);
			for (int i = 0; i < studentsList.getLength(); i++) {
				Element carElement = (Element) studentsList.item(i);
				ICar student;
				student = buildCar(carElement);
				
				cars.add(student);
			}
		} catch (IOException e) {
			throw new ErrorException(e);
		} catch (SAXException e) {
			throw new ErrorException(e);
		} catch (LogicException e) {
			throw e;
		}
	}
	
}

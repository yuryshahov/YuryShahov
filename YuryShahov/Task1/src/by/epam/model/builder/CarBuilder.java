package by.epam.model.builder;

import java.util.ArrayList;
import java.util.List;

import by.epam.exception.ErrorException;
import by.epam.exception.LogicException;
import by.epam.model.entity.ICar;

public abstract class CarBuilder {
	
	protected List<ICar> cars;
	
	public abstract void buildSetCars(String path) throws ErrorException, LogicException;
	
	public CarBuilder() {
		cars = new ArrayList<ICar>();
	}
	
	public final List<ICar> getCars() {
		return cars;
	}
}

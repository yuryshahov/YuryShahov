package by.epam.model.service;

import java.util.ArrayList;
import java.util.List;

import by.epam.model.bean.CarToAdd;

//hard code class
public class CarToAddService {
	
	//returns information about cars which will be add to taxi station collection
	public static List<CarToAdd> carsToAdd() {
		List<CarToAdd> retC = new ArrayList<CarToAdd>();
		CarToAdd cta = new CarToAdd();
		cta.setId(1);
		cta.setCarId(1);
		cta.setCarNumber("1234443");
		retC.add(cta);
		
		cta = new CarToAdd();
		cta.setId(2);
		cta.setCarId(1);
		cta.setCarNumber("3243435");
		retC.add(cta);
		
		cta = new CarToAdd();
		cta.setId(3);
		cta.setCarId(3);
		cta.setCarNumber("2545435");
		retC.add(cta);
		
		cta = new CarToAdd();
		cta.setId(4);
		cta.setCarId(5);
		cta.setCarNumber("356565");
		retC.add(cta);
		
		cta = new CarToAdd();
		cta.setId(5);
		cta.setCarId(6);
		cta.setCarNumber("6797879");
		retC.add(cta);
		
		cta = new CarToAdd();
		cta.setId(6);
		cta.setCarId(4);
		cta.setCarNumber("1234443");
		retC.add(cta);
		
		return retC;
	}
}

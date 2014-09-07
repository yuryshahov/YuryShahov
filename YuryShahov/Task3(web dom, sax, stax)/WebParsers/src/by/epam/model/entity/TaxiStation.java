package by.epam.model.entity;

import java.util.ArrayList;
import java.util.List;

//класс для хранения автомобилей, их общей стоимости
//и сохренеия в файл TaxiStation.xml
public class TaxiStation {
	
	private List<ICar> cars;
	
	public TaxiStation() {
		cars = new ArrayList<ICar>();
	}
	
	public double getCost() {
		double scost = 0.0D;
		for (ICar car : cars) {
			 scost += car.getCost();
		}
		return scost;
	}
	
	public Iterable<ICar> getCars() {
		return cars;
	}
	
	public int getCarQuantity() {
		return cars.size();
	}

	public void addCar(ICar car) {
		long carId = 0L;
		//установка нахождение нового id для автомобиля
		if (cars.size() > 0) {
			// id последнего автомобиля в коллекции
			carId = cars.get(cars.size() - 1).getId();
			carId++;
		} else {
			carId = 1;
		}
		car.setId(carId);
		cars.add(car);
	}
	
	public void addCars(List<ICar> cars) {
		for (ICar c : cars) {
			addCar(c);
		}
	}
	
	public void removeCar(int index) {
		cars.remove(index);
	}
	
	public void removeCar(ICar car) {
		cars.remove(car);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cars == null) ? 0 : cars.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TaxiStation other = (TaxiStation) obj;
		if (cars == null) {
			if (other.cars != null)
				return false;
		} else if (!cars.equals(other.cars))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("TaxiStation [cars=");
		sb.append(cars);
		sb.append(", totalCost=");
		sb.append(getCost());
		sb.append("]");
		return sb.toString();
	}
}

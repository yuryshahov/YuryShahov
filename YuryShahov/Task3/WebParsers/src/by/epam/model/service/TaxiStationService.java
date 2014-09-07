package by.epam.model.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

import by.epam.model.bean.CarToAdd;
import by.epam.model.comparator.FuelConsumptionComparator;
import by.epam.model.entity.ICar;
import by.epam.model.entity.PassengerCar;
import by.epam.model.entity.TaxiStation;
import by.epam.model.entity.TaxiStationCar;

public class TaxiStationService {
	
	//индексирование по заданному в getterName геттеру для быстрого поиска
	public static TreeMap<Long, ICar> mapCarsById(List<ICar> cars) {
		TreeMap<Long, ICar> carsMaped = new TreeMap<Long, ICar>();
		for (Object ocar : cars) {
			ICar car = (ICar) ocar;
			carsMaped.put(car.getId(), (ICar) car);
		}
		return carsMaped;
	}
	
	//выбор автомобилей для автопарка согласно данным в carsToAdd
	public static List<ICar> selectTaxiStationCars(TreeMap<Long, ICar> carsMapedById, 
												 	List<CarToAdd> carsToAdd) {
		List<ICar> selectedCar = new ArrayList<ICar>();
		for (CarToAdd car : carsToAdd) {
			PassengerCar c = (PassengerCar) carsMapedById.get(car.getCarId());
			TaxiStationCar taxiCar = new TaxiStationCar();
			taxiCar.setBrand(c.getBrand());
			taxiCar.setCost(c.getCost());
			taxiCar.setDisplacement(c.getDisplacement());
			taxiCar.setFuelConsumption(c.getFuelConsumption());
			taxiCar.setMaxSpeed(c.getMaxSpeed());
			taxiCar.setYear(c.getYear());
			taxiCar.setCarNumber(car.getCarNumber());
			taxiCar.setSeats(c.getSeats());
			selectedCar.add(taxiCar);
		}
		return selectedCar;
	}
	
	//добавление автомобиля в коллекцию
	public static void addCarsToTaxiStation(TaxiStation station, List<TaxiStationCar> taxiCars) {
		for (ICar car : taxiCars) {
			station.addCar(car);
		}
	}
	
	//сортировка автомобилей по расходу топлива
	public static void sortByFuelConsumption(List<ICar> cars) {
		Collections.sort(cars, new FuelConsumptionComparator());
	}
	
	//поиск автомобиля по параметрам скорости
	public static List<ICar> findCarsByMaxSpeed(List<ICar> taxiCars, 
												double minSpeed, double maxSpeed) {
		List<ICar> retList = new ArrayList<ICar>();
		for (ICar car : taxiCars) {
			if ((car.getMaxSpeed() >= minSpeed) && (car.getMaxSpeed() <= maxSpeed)) {
				retList.add(car);
			}
		}
		return retList;
	}
}

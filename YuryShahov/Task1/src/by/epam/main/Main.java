package by.epam.main;

import java.util.List;
import java.util.TreeMap;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import by.epam.constant.ConfigString;
import by.epam.exception.ErrorException;
import by.epam.exception.LogicException;
import by.epam.model.bean.CarToAdd;
import by.epam.model.bean.MaxSpeedSearch;
import by.epam.model.builder.CarBuilder;
import by.epam.model.entity.ICar;
import by.epam.model.entity.TaxiStation;
import by.epam.model.factory.CarBuilderFactory;
import by.epam.model.service.CarToAddService;
import by.epam.model.service.TaxiStationService;

public class Main {

	public static Logger LOG;
	
	public static void main(String[] args) {
		
		//taxi station collection
		TaxiStation ts;
		PropertyConfigurator.configure(ConfigString.CONFIG_FILE_PATH);
		LOG = Logger.getLogger(Main.class);
		try {
			
			//creating builder factory for creating car's builder
			CarBuilderFactory cbf = new CarBuilderFactory();
			
			//creating builder for downloading cars form xml
			//in this case will be created builder with dom parser
			//but you could creating sax or stax parser too
			CarBuilder domBuilder = cbf.createBuilder(CarBuilderFactory.TypeParser.DOM);
			
			domBuilder.buildSetCars(ConfigString.CAR_PATH);
			
			//cars loaded with dom builder
			List<ICar> carsDom = domBuilder.getCars();
			
			System.out.println(carsDom);
			
			CarBuilder saxBuilder = cbf.createBuilder(CarBuilderFactory.TypeParser.SAX);
			
			saxBuilder.buildSetCars(ConfigString.CAR_PATH);
			
			//cars loaded with sax builder
			List<ICar> carsSax = saxBuilder.getCars();
			
			System.out.println(carsSax);
			
			CarBuilder staxBuilder = cbf.createBuilder(CarBuilderFactory.TypeParser.STAX);
			
			staxBuilder.buildSetCars(ConfigString.CAR_PATH);
			
			//cars loaded with stax builder
			List<ICar> cars = staxBuilder.getCars();
			
			//maping cars by id for best searching
			TreeMap<Long, ICar> mapedCars = TaxiStationService.mapCarsById(cars);
			
			List<CarToAdd> carsToAdd = CarToAddService.carsToAdd();
			
			//creating taxi station cars
			List<ICar> taxiCars = TaxiStationService.selectTaxiStationCars(mapedCars, carsToAdd);
			
			//sort taxi cars by fuel consumtion
			TaxiStationService.sortByFuelConsumption(taxiCars);

			//selecting cars between 200 and 260 speed values
			List<ICar> maxMinSpeedCars = TaxiStationService.findCarsByMaxSpeed(taxiCars, 200, 260);
			System.out.println(maxMinSpeedCars);
			
			//creating taxi station
			ts = new TaxiStation();
			
			//initializing taxi station object
			ts.addCars(taxiCars);
			
			System.out.println(ts);
			
			System.out.println("All done");
		} catch (LogicException e) {
			LOG.error(e);
		} catch (ErrorException e) {
			LOG.error(e);
		}
	}

}

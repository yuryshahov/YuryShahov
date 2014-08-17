package by.epam.model.loading;

import java.util.ArrayList;

import by.epam.exception.ErrorException;
import by.epam.exception.LogicException;
import by.epam.model.bean.CarToAdd;
import by.epam.model.bean.MaxSpeedSearch;
import by.epam.model.entity.ICar;

//интерфейс для загрузки данных
public interface ILoader {
	
	//загрузка автомобилей
	ArrayList<ICar> loadCars(String path) throws LogicException, ErrorException;
		
	//загрузка информации о добавляемых автомобилях
	ArrayList<CarToAdd> loadCarsToAdd(String path) throws LogicException, ErrorException;
	
	//загрузка информации о параметрах скорости для поиска
	MaxSpeedSearch loadSpeedSearch(String path) throws LogicException, ErrorException;
}

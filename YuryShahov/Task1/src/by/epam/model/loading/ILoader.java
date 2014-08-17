package by.epam.model.loading;

import java.util.ArrayList;

import by.epam.exception.ErrorException;
import by.epam.exception.LogicException;
import by.epam.model.bean.CarToAdd;
import by.epam.model.bean.MaxSpeedSearch;
import by.epam.model.entity.ICar;

//��������� ��� �������� ������
public interface ILoader {
	
	//�������� �����������
	ArrayList<ICar> loadCars(String path) throws LogicException, ErrorException;
		
	//�������� ���������� � ����������� �����������
	ArrayList<CarToAdd> loadCarsToAdd(String path) throws LogicException, ErrorException;
	
	//�������� ���������� � ���������� �������� ��� ������
	MaxSpeedSearch loadSpeedSearch(String path) throws LogicException, ErrorException;
}

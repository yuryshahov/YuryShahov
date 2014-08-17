package by.epam.model.bean;

public class MaxSpeedSearch {
	
	//нижняя грацица для поиска по максимальной скорости
	private double maxSpeedLeft;
	
	//верхняя грацица для поиска по максимальной скорости
	private double maxSpeedRight;
	
	public double getMaxSpeedLeft() {
		return maxSpeedLeft;
	}

	public void setMaxSpeedLeft(double maxSpeedLeft) {
		this.maxSpeedLeft = maxSpeedLeft;
	}

	public double getMaxSpeedRight() {
		return maxSpeedRight;
	}

	public void setMaxSpeedRight(double maxSpeedRight) {
		this.maxSpeedRight = maxSpeedRight;
	}
}

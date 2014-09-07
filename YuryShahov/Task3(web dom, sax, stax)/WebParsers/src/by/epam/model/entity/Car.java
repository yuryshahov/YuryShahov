package by.epam.model.entity;


public class Car implements ICar, Comparable<Car> {
	
	//уникальный номер автомобиля
	private long id;
	
	//марка авомобиля
	private String brand;
	
	//расход топлива
	private double fuelConsumption;
	
	//объем двигателя
	private double displacement;
	
	//максимальная скорость
	private double maxSpeed;
	
	//год выпуска
	private int year;
	
	//стоимость
	private double cost;
		
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getFuelConsumption() {
		return fuelConsumption;
	}

	public void setFuelConsumption(double fuelConsumption) {
		this.fuelConsumption = fuelConsumption;
	}

	public double getDisplacement() {
		return displacement;
	}

	public void setDisplacement(double displacement) {
		this.displacement = displacement;
	}

	public double getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(double maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	@Override
	public int compareTo(Car car) {
		if (this.fuelConsumption < car.fuelConsumption) {
			return -1;
		} 
		if (this.fuelConsumption > car.fuelConsumption) {
			return 1;
		}
		return 0;
	};
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		long temp;
		temp = Double.doubleToLongBits(cost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(displacement);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(fuelConsumption);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + (int) (id ^ (id >>> 32));
		temp = Double.doubleToLongBits(maxSpeed);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + year;
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
		Car other = (Car) obj;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand)) {
			return false;
		}
		if (Double.doubleToLongBits(cost) != Double
				.doubleToLongBits(other.cost)) {
			return false;
		}
		if (Double.doubleToLongBits(displacement) != Double
				.doubleToLongBits(other.displacement)) {
			return false;
		}
		if (Double.doubleToLongBits(fuelConsumption) != Double
				.doubleToLongBits(other.fuelConsumption)) {
			return false;
		}
		if (id != other.id) {
			return false;
		}
		if (Double.doubleToLongBits(maxSpeed) != Double
				.doubleToLongBits(other.maxSpeed)) {
			return false;
		}
		if (year != other.year) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Car [id=");
		sb.append(id);
		sb.append(", brand=");
		sb.append(brand);
		sb.append(", fuelConsumption=");
		sb.append(fuelConsumption);
		sb.append(", displacement=");
		sb.append(displacement);
		sb.append(", maxSpeed=");
		sb.append(maxSpeed);
		sb.append(", year=");
		sb.append(year);
		sb.append(", cost=");
		sb.append(cost);
		sb.append("]");
		return sb.toString();
	}
	
	
}

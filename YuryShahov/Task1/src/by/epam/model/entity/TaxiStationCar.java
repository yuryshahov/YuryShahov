package by.epam.model.entity;

//автомобиль автопарка
public class TaxiStationCar extends PassengerCar {
	
	//регистрационный номер автомобиля
	private String carNumber;

	public String getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((carNumber == null) ? 0 : carNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		TaxiStationCar other = (TaxiStationCar) obj;
		if (carNumber == null) {
			if (other.carNumber != null)
				return false;
		} else if (!carNumber.equals(other.carNumber))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("TaxiStationCar [carNumber=");
		sb.append(carNumber);
		sb.append(", ");
		sb.append(super.toString());
		sb.append("]");
		return sb.toString();
	}
}

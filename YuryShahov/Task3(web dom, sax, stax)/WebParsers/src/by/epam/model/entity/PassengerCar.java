package by.epam.model.entity;

//пассажирский автомобиль
public class PassengerCar extends Car {
	
	//число мест для сидения
	private int seats;

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + seats;
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
		PassengerCar other = (PassengerCar) obj;
		if (seats != other.seats)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("PassengerCar [seats=");
		sb.append(seats);
		sb.append(", ");
		sb.append(super.toString());
		sb.append("]");
		return sb.toString();
	}

	
}

package by.epam.model.bean;

//contains information for inserting taxistation cars
public class CarToAdd {
	
	//unique identifier
	private long id;
	
	//car identifier to select
	private long carId;
	
	//car number
	private String carNumber;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getCarId() {
		return carId;
	}

	public void setCarId(long carId) {
		this.carId = carId;
	}

	public String getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}
}

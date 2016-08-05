package by.pvt.dudko.company.entities;

public class Car {
	private int idCar;
	private String mark;
	private int seatCount;
	private int mass;
	private int volume;
	private int condition;
	private int idDriver;
	private int typeCar;
	
	public Car(){}
	
	public Car(int idCar,int typeCar, String mark, int seatCount, int mass, int volume, int idDriver, int condition) {
		this.mark = mark;
		this.seatCount = seatCount;
		this.idCar = idCar;
		this.idDriver = idDriver;
		this.mass = mass;
		this.volume = volume;
		this.condition = condition;
		this.typeCar = typeCar;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public void setIdCar(int idCar) {
		this.idCar = idCar;
	}
	public void setTypeCar(int typeCar) {
		this.typeCar = typeCar;
	}

	public void setSeetCount(int seatCount) {
		this.seatCount = seatCount;
	}

	public void setMass(int mass) {
		this.mass = mass;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}
	public void setIdDriver(int idDriver) {
		this.idDriver = idDriver;
	}

	public void setCondition(int condition) {
		this.condition = condition;
	}

	
	public String getMark() {
		return mark;
	}

	public int getIdCar() {
		return idCar;
	}
	public int getTypeCar() {
		return typeCar;
	}

	public int getSeatCount() {
		return seatCount;
	}

	public int getMass() {
		return mass;
	}

	public int getVolume() {
		return volume;
	}

	public int getCondition() {
		return condition;
	}
	public int getIdDriver() {
		return idDriver;
	}
}

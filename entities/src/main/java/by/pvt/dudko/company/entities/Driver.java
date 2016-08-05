package by.pvt.dudko.company.entities;

public class Driver {
	private String name;
	private Integer idDriver;

	public Driver(String name, int idDriver) {
		this.name = name;
		this.idDriver = idDriver;
	}

	public void setName() {
		this.name = name;
	}

	public void setIdDriver() {
		this.idDriver = idDriver;
	}

	public String getName() {
		return name;
	}

	public int getIdDriver() {
		return idDriver;
	}

}

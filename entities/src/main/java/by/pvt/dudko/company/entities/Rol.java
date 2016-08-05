package by.pvt.dudko.company.entities;

public class Rol {
	private String rol;
	private Integer idRol;

	public Rol(String rol, int idRol) {
		this.rol = rol;
		this.idRol = idRol;
	}

	public void setRol() {
		this.rol = rol;
	}

	public void setIdRol() {
		this.idRol = idRol;
	}

	public String getRol() {
		return rol;
	}

	public int getIdRol() {
		return idRol;
	}
}

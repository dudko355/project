package by.pvt.dudko.company.entities;

public class Client {
	private int idClient;
	private String password;
	private int rol;
	private String login;

	public Client(){}
	
	public Client(int idClient, int rol, String login, String password) {
		this.idClient = idClient;
		this.rol = rol;
		this.login = login;
		this.password = password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public int getRol() {
		return rol;
	}

	public int getIdClient() {
		return idClient;
	}

	public String getLogin() {
		return login;
	}
}

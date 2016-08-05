package by.pvt.dudko.company.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.pvt.dudko.company.dao.ClientDao;
import by.pvt.dudko.company.dao.impl.utils.CloseConnect;
import by.pvt.dudko.company.db.ConnectionUtil;
import by.pvt.dudko.company.entities.Client;


public class MySqlClientDao implements ClientDao {
	
	private static MySqlClientDao instance;
	
	public static synchronized MySqlClientDao getInstance() {
		if (instance == null) {
			instance = new MySqlClientDao();
		}
		return instance;
	}
	private MySqlClientDao() {
		}

	@Override
	public Client get(long key) throws Exception {
		Connection connection =ConnectionUtil.getConnection();
		Client client = null;
		String sql = "SELECT idClient,rol,login,password FROM USER  WHERE idClient=?;";
		PreparedStatement stm = connection.prepareStatement(sql);
		stm.setLong(1, key);
		ResultSet rs = stm.executeQuery();
		while (rs.next()) {
			int idClient = rs.getInt(1);
			int rol = rs.getInt(2);
			String login = rs.getString(3);
			String password = rs.getString(4);
			client = new Client(idClient, rol, login, password);
		}
		CloseConnect.close(rs, stm);
		return client;
	}
	
	public Client getClientByLoginName(String log,String pass) throws SQLException{
		Connection connection =ConnectionUtil.getConnection();
		Client client = null;
		String sql = "SELECT idClient,rol,login,password FROM USER  WHERE login=? and password=?;";
		PreparedStatement stm = connection.prepareStatement(sql);
		stm.setString(1, log);
		stm.setString(2, pass);
		ResultSet rs = stm.executeQuery();
		while (rs.next()) {
			int idClient = rs.getInt(1);
			int rol = rs.getInt(2);
			String login = rs.getString(3);
			String password = rs.getString(4);
			client = new Client(idClient, rol, login, password);
		}
		CloseConnect.close(rs, stm);
		return client;
		
	}

	@Override
	public Client create(Client client) throws Exception {
		Connection connection =ConnectionUtil.getConnection();
		int rol = client.getRol();
		int idClient = client.getIdClient();
		String login = client.getLogin();
		String password = client.getPassword();
     	String sqlp = "INSERT INTO USER VALUES(?,?,?,?);";
		PreparedStatement stm = connection.prepareStatement(sqlp);
		stm.setInt(1,idClient);
		stm.setInt(2, 2);
		stm.setString(3, login);
		stm.setString(4, password);
		int rs = stm.executeUpdate();
		//if (rs==0){}
		CloseConnect.close(stm);
		return client;
	}

	@Override
	public void update(Client client) throws Exception {
		Connection connection =ConnectionUtil.getConnection();
		int rol = client.getRol();
		int idClient = client.getIdClient();
		String login = client.getLogin();
		String password = client.getPassword();
		String sql = "UPDATE USER SET rol= ? ,login= ? ,password= ?  WHERE idClient= ? ;";
		PreparedStatement stm = connection.prepareStatement(sql);
		stm.setInt(1, rol);
		stm.setString(2, login);
		stm.setString(3, password);
		stm.setInt(4 ,idClient);
		int rs = stm.executeUpdate();
		CloseConnect.close(stm);
	}

	@Override
	public void delete(long id) throws Exception {
		Connection connection =ConnectionUtil.getConnection();
		String sql = "DELETE FROM USER WHERE idClient= ? ;";
		PreparedStatement stm = connection.prepareStatement(sql);
		stm.setLong(1, id);
		int rs = stm.executeUpdate();
		CloseConnect.close(stm);
	}

	@Override
	public List<Client> getClient() throws Exception {
		Connection connection =ConnectionUtil.getConnection();
		Client client = null;
		String sql = "SELECT * FROM USER";
		PreparedStatement stm = connection.prepareStatement(sql);
		ResultSet rs = stm.executeQuery();
		List<Client> list = new ArrayList<Client>();
		while (rs.next()) {
			int idClient = rs.getInt(1);
			int rol = rs.getInt(2);
			String login = rs.getString(3);
			String password = rs.getString(4);
			client = new Client(idClient, rol, login, password);
			list.add(client);
		}
		CloseConnect.close(rs, stm);
		return list;

	}

}

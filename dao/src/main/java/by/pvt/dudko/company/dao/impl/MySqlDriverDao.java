package by.pvt.dudko.company.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import by.pvt.dudko.company.dao.DriverDao;
import by.pvt.dudko.company.dao.impl.utils.CloseConnect;
import by.pvt.dudko.company.db.ConnectionUtil;
import by.pvt.dudko.company.entities.Driver;

public class MySqlDriverDao implements DriverDao {

	private static MySqlDriverDao instance;
	

	public static synchronized MySqlDriverDao getInstance() {
		if (instance == null) {
			instance = new MySqlDriverDao();
		}
		return instance;
	}

	private MySqlDriverDao() {
		}

	@Override
	public Driver get(long key) throws Exception {
		Connection connection =ConnectionUtil.getConnection();
		Driver driver = null;
		String sql = "SELECT d.idDriver,d.name " + " FROM Driver d " + " WHERE d.idDriver=?;";
		PreparedStatement stm = connection.prepareStatement(sql);
		stm.setLong(1, key);
		ResultSet rs = stm.executeQuery();
		while (rs.next()) {
			int idDriver = rs.getInt(1);
			String name = rs.getString(2);
			driver = new Driver(name, idDriver);
		}
		CloseConnect.close(rs, stm);
		return driver;
	}

	@Override
	public Driver create(Driver driver) throws Exception {
		Connection connection =ConnectionUtil.getConnection();
		String name = driver.getName();
		int idDriver = driver.getIdDriver();
		String sql = "Insert into DRIVER VALUES( ? , ? );";
		PreparedStatement stm = connection.prepareStatement(sql);
		stm.setInt(1, idDriver);
		stm.setString(2, name);
		int rs = stm.executeUpdate();
		CloseConnect.close(stm);
		return driver;
	}

	@Override
	public void update(Driver driver) throws Exception {
		Connection connection =ConnectionUtil.getConnection();
		String name = driver.getName();
		int idDriver = driver.getIdDriver();
		String sqldriver = "UPDATE DRIVER SET(name= ? ) WHERE idDriver= ? ;";
		PreparedStatement stm = connection.prepareStatement(sqldriver);
		stm.setString(1, name);
		stm.setInt(2, idDriver);
		int rs = stm.executeUpdate();
		CloseConnect.close(stm);
	}

	@Override
	public void delete(long id) throws Exception {
		Connection connection =ConnectionUtil.getConnection();
		String sqldriver = "DELETE FROM DRIVER WHERE idDriver= ? ;";
		PreparedStatement stm = connection.prepareStatement(sqldriver);
		stm.setLong(1, id);
		int rs = stm.executeUpdate();
		CloseConnect.close(stm);
	}

	@Override
	public List<Driver> getDriver() throws Exception {
		Connection connection =ConnectionUtil.getConnection();
		Driver driver = null;
		String sql = "SELECT d.idDriver,d.name FROM Driver d";
		PreparedStatement stm = connection.prepareStatement(sql);
		ResultSet rs = stm.executeQuery();
		List<Driver> list = new ArrayList<Driver>();
		while (rs.next()) {
			int idDriver = rs.getInt(1);
			String name = rs.getString(2);
			driver = new Driver(name, idDriver);
			list.add(driver);
		}
		CloseConnect.close(rs, stm);
		return list;

	}
}

package by.pvt.dudko.company.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import by.pvt.dudko.company.dao.RolDao;
import by.pvt.dudko.company.dao.impl.utils.CloseConnect;
import by.pvt.dudko.company.db.ConnectionUtil;
import by.pvt.dudko.company.entities.Rol;



public class MySqlRolDao implements RolDao {

	private static MySqlRolDao instance;
	
	public static synchronized MySqlRolDao getInstance() {
		if (instance == null) {
			instance = new MySqlRolDao();
		}
		return instance;
	}
	private MySqlRolDao() {
			}

	@Override
	public Rol get(long key) throws Exception {
		Connection connection =ConnectionUtil.getConnection();
		Rol roll = null;
		String sql = "SELECT idRol,rol  FROM ROL  WHERE idRol=?;";
		PreparedStatement stm = connection.prepareStatement(sql);
		stm.setLong(1, key);
		ResultSet rs = stm.executeQuery();
		while (rs.next()) {
			int idRol = rs.getInt(1);
			String rol = rs.getString(2);
			roll = new Rol(rol, idRol);
		}
		CloseConnect.close(rs, stm);
		return roll;
	}

	@Override
	public Rol create(Rol roll) throws Exception {
		Connection connection =ConnectionUtil.getConnection();
		String rol = roll.getRol();
		int idRol = roll.getIdRol();
		String sql = "Insert into ROL VALUES(" + idRol + "," + rol + ");";
		PreparedStatement stm = connection.prepareStatement(sql);
		int rs = stm.executeUpdate();
		CloseConnect.close(stm);
		return roll;
	}

	@Override
	public void update(Rol roll) throws Exception {
		Connection connection =ConnectionUtil.getConnection();
		String rol = roll.getRol();
		int idRol = roll.getIdRol();
		String sqldriver = "UPDATE ROL SET(name=" + rol + ") WHERE idDriver=" + idRol + ";";
		PreparedStatement stm = connection.prepareStatement(sqldriver);
		int rs = stm.executeUpdate();
		CloseConnect.close(stm);
	}

	@Override
	public void delete(long id) throws Exception {
		Connection connection =ConnectionUtil.getConnection();
		String sql = "DELETE FROM ROL WHERE idRol=" + id + ";";
		PreparedStatement stm = connection.prepareStatement(sql);
		int rs = stm.executeUpdate();
		CloseConnect.close(stm);
	}

	@Override
	public List<Rol> getRol() throws Exception {
		Connection connection =ConnectionUtil.getConnection();
		Rol roll = null;
		String sql = "SELECT idRol,rol FROM ROL";
		PreparedStatement stm = connection.prepareStatement(sql);
		ResultSet rs = stm.executeQuery();
		List<Rol> list = new ArrayList<Rol>();
		while (rs.next()) {
			int idRol = rs.getInt(1);
			String rol = rs.getString(2);
			roll = new Rol(rol, idRol);
			list.add(roll);
		}
		CloseConnect.close(rs, stm);
		return list;

	}
}

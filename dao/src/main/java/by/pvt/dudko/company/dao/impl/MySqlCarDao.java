package by.pvt.dudko.company.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

import by.pvt.dudko.company.dao.CarDao;
import by.pvt.dudko.company.dao.impl.utils.CloseConnect;
import by.pvt.dudko.company.db.ConnectionUtil;
import by.pvt.dudko.company.entities.Car;

public class MySqlCarDao implements CarDao {

	private static MySqlCarDao instance;

	public static synchronized MySqlCarDao getInstance() {

		if (instance == null) {
			instance = new MySqlCarDao();
		}
		return instance;
	}

	private MySqlCarDao() {
	}

	@Override
	public Car get(long key) throws Exception {
		Connection connection = ConnectionUtil.getConnection();
		Car car = null;
		String sql = "SELECT c.idCar,c.typeCar,c.driver,c.conditions,f.mark,f.valume,f.mass,f.seatCount "
				+ " FROM CAR c JOIN FEATURES f ON c.typeCar=f.typeCar  WHERE c.idCar=?;";
		PreparedStatement stm = connection.prepareStatement(sql);
		stm.setLong(1, key);
		ResultSet rs = stm.executeQuery();
		while (rs.next()) {
			int idCar = rs.getInt(1);
			int typeCar = rs.getInt(2);
			int idDriver = rs.getInt(3);
			int condition = rs.getInt(4);
			String mark = rs.getString(5);
			int valume = rs.getInt(6);
			int mass = rs.getInt(7);
			int seatCount = rs.getInt(8);
			car = new Car(idCar, typeCar, mark, seatCount, mass, valume, idDriver, condition);
			
		}
		CloseConnect.close(rs, stm);
		return car;
	}

	@Override
	public Car create(Car car) throws Exception {
		Connection connection = ConnectionUtil.getConnection();
		int k = 0;
		int condition = car.getCondition();
		int idCar = car.getIdCar();
		String mark = car.getMark();
		int mass = car.getMass();
		int seatCount = car.getSeatCount();
		int valume = car.getVolume();
		int idDriver = car.getIdDriver();
		int typeCar = car.getTypeCar();
		String sqlcar = "Insert into CAR VALUES( ? , ? , ? , ? );";
		PreparedStatement stm = connection.prepareStatement(sqlcar);
		stm.setInt(1, idCar);
		stm.setInt(2, typeCar);
		stm.setInt(3, idDriver);
		stm.setInt(4, condition);
		int rs = stm.executeUpdate();
		String sql = "SELECT typeCar FROM FEATURES;";
		stm = connection.prepareStatement(sql);
		ResultSet rs1 = stm.executeQuery();
		while (rs1.next()) {
			int typeCar1 = rs1.getInt(1);
			if (typeCar == typeCar1) {
				k = 1;
			}
		}
		if (k == 0) {
			String sqlfeatures = "Insert into FEATURES VALUES( ? , ? , ? , ? , ? );";
			stm = connection.prepareStatement(sqlfeatures);
			stm.setInt(1, typeCar);
			stm.setString(2, mark);
			stm.setInt(3, valume);
			stm.setInt(4, mass);
			stm.setInt(5, seatCount);
			rs = stm.executeUpdate();
		}
		CloseConnect.close(stm);
		return car;
	}

	@Override
	public void update(Car car) throws Exception {
		Connection connection = ConnectionUtil.getConnection();
		int k = 0;
		int condition = car.getCondition();
		int idCar = car.getIdCar();
		String mark = car.getMark();
		int mass = car.getMass();
		int seatCount = car.getSeatCount();
		int valume = car.getVolume();
		int idDriver = car.getIdDriver();
		int typeCar = car.getTypeCar();
		String sqlcar = "UPDATE CAR SET typeCar= ? ,driver= ? ,conditions= ?  WHERE idCar= ? ;";
		PreparedStatement stm = connection.prepareStatement(sqlcar);
		stm.setInt(1, typeCar);
		stm.setInt(2, idDriver);
		stm.setInt(3, condition);
		stm.setInt(4, idCar);
		int rs = stm.executeUpdate();
		String sql = "SELECT typeCar FROM FEATURES;";
		stm = connection.prepareStatement(sql);
		ResultSet rs1 = stm.executeQuery();
		while (rs1.next()) {
			int typeCarf = rs1.getInt(1);
			if (typeCar == typeCarf) {
				k = 1;
			}
		}
		if (k == 0) {
			String sqlfeatures = "Insert into FEATURES VALUES( ? , ? , ? , ? , ? );";
			stm.setInt(1, typeCar);
			stm.setString(2, mark);
			stm.setInt(3, valume);
			stm.setInt(4, mass);
			stm.setInt(5, seatCount);
			rs = stm.executeUpdate();
		}
		CloseConnect.close(rs1, stm);
	}

	@Override
	public void delete(long id) throws Exception {
		Connection connection = ConnectionUtil.getConnection();
		String sqlcar = "DELETE FROM CAR WHERE idCar= ? ;";
		PreparedStatement stm = connection.prepareStatement(sqlcar);
		stm.setLong(1, id);
		int rs = stm.executeUpdate();
		CloseConnect.close(stm);
	}

	@Override
	public void deleteFeatures(long id) throws Exception {
		Connection connection = ConnectionUtil.getConnection();
		String sqlfeatures = "DELETE FROM FEATURES WHERE typeCar= ? ;";
		PreparedStatement stm = connection.prepareStatement(sqlfeatures);
		stm.setLong(1, id);
		int rs = stm.executeUpdate();
		CloseConnect.close(stm);
	}

	@Override
	public List<Car> getCar() throws Exception {
		Connection connection = ConnectionUtil.getConnection();
		Car car = null;
		String sql = "SELECT c.idCar,c.typeCar,c.driver,c.conditions,f.mark,f.valume,f.mass,f.seatCount "
				+ " FROM CAR c " + " JOIN FEATURES f ON c.typeCar=f.typeCar;";
		PreparedStatement stm = connection.prepareStatement(sql);
		ResultSet rs = stm.executeQuery();
		List<Car> list = new ArrayList<Car>();
		while (rs.next()) {
			int idCar = rs.getInt(1);
			int typeCar = rs.getInt(2);
			int idDriver = rs.getInt(3);
			int condition = rs.getInt(4);
			String mark = rs.getString(5);
			int valume = rs.getInt(6);
			int mass = rs.getInt(7);
			int seatCount = rs.getInt(8);
			car = new Car(idCar, typeCar, mark, seatCount, mass, valume, idDriver, condition);
			list.add(car);
		}
		CloseConnect.close(rs, stm);
		return list;

	}
}
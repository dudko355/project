package by.pvt.dudko.company.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import by.pvt.dudko.company.dao.TripDao;
import by.pvt.dudko.company.dao.impl.utils.CloseConnect;
import by.pvt.dudko.company.db.ConnectionUtil;
import by.pvt.dudko.company.entities.Client;
import by.pvt.dudko.company.entities.Order;
import by.pvt.dudko.company.entities.Trip;
import by.pvt.dudko.company.utils.UtilDate;

public class MySqlTripDao implements TripDao {
	
	private static MySqlTripDao instance;

	public static synchronized MySqlTripDao getInstance() {
		if (instance == null) {
			instance = new MySqlTripDao();
		}
		return instance;
	}

	private MySqlTripDao() {
		}

	@Override
	public Trip get(long key) throws Exception {
		Connection connection = ConnectionUtil.getConnection();
		Trip trip = null;
		String sql = "SELECT idOrder,idClient,idTrip,target,dateBegin,dateFinish,dictanse,idCar,conditionTrip "
				+ " FROM TRIP   WHERE idOrder= ? ;";
		PreparedStatement stm = connection.prepareStatement(sql);
		stm.setLong(1, key);
		ResultSet rs = stm.executeQuery();
		while (rs.next()) {
			int idOrder = rs.getInt(1);
			int idClient = rs.getInt(2);
			int idTrip = rs.getInt(3);
			String target = rs.getString(4);
			String dateBegin = rs.getString(5);
			String dateFinish = rs.getString(6);
			int dictanse = rs.getInt(7);
			int idCar = rs.getInt(8);
			int conditionTrip = rs.getInt(9);
			trip = new Trip(target, dictanse, idCar, idOrder, idClient, idTrip, Order.date(dateBegin),
					Order.date(dateFinish), conditionTrip);
		}
		CloseConnect.close(rs, stm);
		return trip;
	}

	@Override
	public Trip create(Trip trip) throws Exception {
		Connection connection = ConnectionUtil.getConnection();
		int idOrder = trip.getIdOrder();
		int idClient = trip.getIdClient();
		int idTrip = trip.getIdTrip();
		String target = trip.getTarget();
		java.sql.Date dateBegin = UtilDate.toSqlDate(trip.getDateBegin());
		java.sql.Date dateFinish = UtilDate.toSqlDate(trip.getDateFinish());
		int dictanse = trip.getDictanse();
		int idCar = trip.getIdCar();
		int conditionTrip = trip.getConditionTrip();
		String sql = "Insert into TRIP VALUES(?,?,?,?,?,?,?,?,?);";
		PreparedStatement stm = connection.prepareStatement(sql);
		stm.setInt(1, idOrder);
		stm.setInt(2, idClient);
		stm.setInt(3, idTrip);
		stm.setString(4, target);
		stm.setDate(5, dateBegin);
		stm.setDate(6, dateFinish);
		stm.setInt(7, dictanse);
		stm.setInt(8, idCar);
		stm.setInt(9, conditionTrip);
		int rs = stm.executeUpdate();
		CloseConnect.close(stm);
		return trip;
	}

	@Override
	public void update(Trip trip) throws Exception {
		Connection connection = ConnectionUtil.getConnection();
		int idOrder = trip.getIdOrder();
		int idClient = trip.getIdClient();
		int idTrip = trip.getIdTrip();
		String target = trip.getTarget();
		java.sql.Date dateBegin = UtilDate.toSqlDate(trip.getDateBegin());
		java.sql.Date dateFinish =UtilDate.toSqlDate( trip.getDateFinish());
		int dictanse = trip.getDictanse();
		int idCar = trip.getIdCar();
		int conditionTrip = trip.getConditionTrip();
		String sql = "UPDATE TRIP SET  idClient = ? , "
				+ "idTrip = ? , target = ? , dateBegin = ? , dateFinish = ? , dictanse = ? , "
				+ "idCar = ? , conditionTrip = ?  WHERE idOrder = ? ;";
		PreparedStatement stm = connection.prepareStatement(sql);
		
		stm.setInt(1, idClient);
		stm.setInt(2, idTrip);
		stm.setString(3, target);
		stm.setDate(4, dateBegin);
		stm.setDate(5, dateFinish);
		stm.setInt(6, dictanse);
		stm.setInt(7, idCar);
		stm.setInt(8, conditionTrip);
		stm.setInt(9, idOrder);
		int rs = stm.executeUpdate();
		CloseConnect.close(stm);
	}

	@Override
	public void delete(long id) throws Exception {
		Connection connection = ConnectionUtil.getConnection();
		String sql = "DELETE FROM TRIP WHERE idOrder=?;";
		PreparedStatement stm = connection.prepareStatement(sql);
		stm.setLong(1, id);
		int rs = stm.executeUpdate();
		CloseConnect.close(stm);
	}

	@Override
	public List<Trip> getTrip() throws Exception {
		Connection connection = ConnectionUtil.getConnection();
		Trip trip = null;
		String sql = "SELECT * FROM TRIP ;";
		PreparedStatement stm = connection.prepareStatement(sql);
		ResultSet rs = stm.executeQuery();
		List<Trip> list = new ArrayList<Trip>();
		while (rs.next()) {
			int idOrder = rs.getInt(1);
			int idClient = rs.getInt(2);
			int idTrip = rs.getInt(3);
			String target = rs.getString(4);
			String dateBegin = rs.getString(5);
			String dateFinish = rs.getString(6);
			int dictanse = rs.getInt(7);
			int idCar = rs.getInt(8);
			int conditionTrip = rs.getInt(9);
			trip = new Trip(target, dictanse, idCar, idOrder, idClient, idTrip, Order.date(dateBegin),
					Order.date(dateFinish), conditionTrip);
			list.add(trip);
		}
		CloseConnect.close(rs, stm);
		return list;

	}
	
	public List getAllClient(Client client) throws Exception {
		Connection connection = ConnectionUtil.getConnection();
		List<Trip> list = new ArrayList<Trip>();
		Trip trip = null;
		int key=client.getIdClient();
		String sql = "SELECT * FROM TRIP   WHERE idClient= ? ;";
		PreparedStatement stm = connection.prepareStatement(sql);
		stm.setLong(1, key);
		ResultSet rs = stm.executeQuery();
		while (rs.next()) {
			int idOrder = rs.getInt(1);
			int idClient = rs.getInt(2);
			int idTrip = rs.getInt(3);
			String target = rs.getString(4);
			String dateBegin = rs.getString(5);
			String dateFinish = rs.getString(6);
			int dictanse = rs.getInt(7);
			int idCar = rs.getInt(8);
			int conditionTrip = rs.getInt(9);
			trip = new Trip(target, dictanse, idCar, idOrder, idClient, idTrip, Order.date(dateBegin),
					Order.date(dateFinish), conditionTrip);
			list.add(trip);
		}
		CloseConnect.close(rs, stm);
		return list;
	}
}

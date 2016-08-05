package by.pvt.dudko.company.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import by.pvt.dudko.company.dao.OrderDao;
import by.pvt.dudko.company.dao.impl.utils.CloseConnect;
import by.pvt.dudko.company.db.ConnectionUtil;
import by.pvt.dudko.company.entities.Order;

public class MySqlOrderDao implements OrderDao {
	
	private static MySqlOrderDao instance;

	public static synchronized MySqlOrderDao getInstance() {
		if (instance == null) {
			instance = new MySqlOrderDao();
		}
		return instance;
	}

	private MySqlOrderDao() {
		}

	@Override
	public Order get(long key) throws Exception {
		Connection connection = ConnectionUtil.getConnection();
		Order order = null;
		String sql = "SELECT idOrder, idClient, target, dictanse, dateBegin, dateFinish, volume, mass, seatCount"
				+ " FROM ORDERS WHERE idOrder = ? ;";
		PreparedStatement stm = connection.prepareStatement(sql);
		stm.setInt(1, (int) key);
		ResultSet rs = stm.executeQuery();
		while (rs.next()) {
			int idOrder = rs.getInt(1);
			int idClient = rs.getInt(2);
			String target = rs.getString(3);
			int dictanse = rs.getInt(4);
			String dateBegin = rs.getString(5);
			String dateFinish = rs.getString(6);
			int volume = rs.getInt(7);
			int mass = rs.getInt(8);
			int seatCount = rs.getInt(9);
			order = new Order(idOrder, idClient, target, dictanse, Order.date(dateBegin), Order.date(dateFinish),
					seatCount, mass, volume);
		}
		CloseConnect.close(rs, stm);
		return order;
	}

	@Override
	public Order create(Order order) throws Exception {
		Connection connection = ConnectionUtil.getConnection();
		int idOrder = order.getIdOrder();
		int idClient = order.getIdClient();
		String target = order.getTarget();
		int dictanse = order.getDictanse();
		java.sql.Date dateBegin = order.getDateBegin();
		java.sql.Date dateFinish = order.getDateFinish();
		int seatCount = order.getSeatCount();
		int mass = order.getMass();
		int volume = order.getVolume();
		String sql = "Insert into ORDERS VALUES(?,?,?,?,?,?,?,?,?);";
		PreparedStatement stm = connection.prepareStatement(sql);
		stm.setInt(1, idOrder);
		stm.setInt(2, idClient);
		stm.setString(3, target);
		stm.setInt(4, dictanse);
		stm.setDate(5, dateBegin);
		stm.setDate(6, dateFinish);
		stm.setInt(7, volume);
		stm.setInt(8, mass);
		stm.setInt(9, seatCount);
		int rs = stm.executeUpdate();
		CloseConnect.close(stm);
		return order;
	}

	@Override
	public void update(Order order) throws Exception {
		Connection connection = ConnectionUtil.getConnection();
		int idOrder = order.getIdOrder();
		int idClient = order.getIdClient();
		String target = order.getTarget();
		int dictanse = order.getDictanse();
		java.sql.Date dateBegin = order.getDateBegin();
		java.sql.Date dateFinish = order.getDateFinish();
		int seatCount = order.getSeatCount();
		int mass = order.getMass();
		int volume = order.getVolume();
		String sql = "UPDATE ORDERS SET idOrder = ?, idClient = ? , target = ? , dictanse= ? ,"
				+ " dateBegin = ? , dateFinish= ? , volume = ? , mass = ? , seatCount = ? WHERE idOrder = ? ;";
		PreparedStatement stm = connection.prepareStatement(sql);
		stm.setInt(1, idOrder);
		stm.setInt(2, idClient);
		stm.setString(3, target);
		stm.setInt(4, dictanse);
		stm.setDate(5, dateBegin);
		stm.setDate(6, dateFinish);
		stm.setInt(7, volume);
		stm.setInt(8, mass);
		stm.setInt(9, seatCount);
		int rs = stm.executeUpdate();
		CloseConnect.close(stm);
	}

	@Override
	public void delete(long id) throws Exception {
		Connection connection = ConnectionUtil.getConnection();
		String sql = "DELETE FROM ORDERS WHERE idOrder= ? ;";
		PreparedStatement stm = connection.prepareStatement(sql);
		stm.setLong(1, id);
		int rs = stm.executeUpdate();
		CloseConnect.close(stm);
	}

	@Override
	public List<Order> getOrder() throws Exception {
		Connection connection = ConnectionUtil.getConnection();
		Order order = null;
		String sql = "SELECT * FROM ORDERS ;";
		PreparedStatement stm = connection.prepareStatement(sql);
		ResultSet rs = stm.executeQuery();
		List<Order> list = new ArrayList<Order>();
		while (rs.next()) {
			int idOrder = rs.getInt(1);
			int idClient = rs.getInt(2);
			String target = rs.getString(3);
			int dictanse = rs.getInt(4);
			String dateBegin = rs.getString(5);
			String dateFinish = rs.getString(6);
			int volume = rs.getInt(7);
			int mass = rs.getInt(8);
			int seatCount = rs.getInt(9);
			order = new Order(idOrder, idClient, target, dictanse, Order.date(dateBegin), Order.date(dateFinish),
					seatCount, mass, volume);
			list.add(order);
		}
		CloseConnect.close(rs, stm);
		return list;

	}
}

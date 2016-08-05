package by.pvt.dudko.company.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import by.pvt.dudko.company.dao.impl.MySqlOrderDao;
import by.pvt.dudko.company.db.ConnectionUtil;
import by.pvt.dudko.company.entities.Client;
import by.pvt.dudko.company.entities.Order;
import by.pvt.dudko.company.entities.Trip;
import by.pvt.dudko.company.utils.UtilDate;

public class OrderServiceImpl {

	private MySqlOrderDao mySqlOrderDao = MySqlOrderDao.getInstance();
	private static final Logger log = Logger.getLogger(OrderServiceImpl.class);

	/**
	 * all orders
	 */
	public List<Order> allOrder() {
		List<Order> list = new ArrayList<Order>();

		try {
			ConnectionUtil.getConnection().setAutoCommit(false);
			list = mySqlOrderDao.getOrder();
			ConnectionUtil.getConnection().commit();
		} catch (Exception e) {
			try {
				log.error("Tranzakzion allOrder fail", e);
				ConnectionUtil.getConnection().rollback();
			} catch (SQLException e1) {
				log.error(e1.getMessage());
			}
		}
		return list;
	}

	/**
	 * next number order
	 */
	public int numberOrder() {
		OrderServiceImpl orderServiceImpl = new OrderServiceImpl();
		int k=0;
		for(Order order:orderServiceImpl.allOrder()){
			if(k < order.getIdOrder()){
				k=order.getIdOrder();
			}
		}
		k=k+1;
		return k;
	}

	public Order formOrder(Client c, String target, String dictanse, String dateBegin, String dateFinish, String volume,
			String mass, String seatCount) {
		OrderServiceImpl orderServiceImpl = new OrderServiceImpl();
		Order order = new Order();
		order.setDateBegin(dateBegin);
		order.setDateFinish(dateFinish);
		order.setDictanse(Integer.parseInt(dictanse.trim()));
		order.setIdClient(c.getIdClient());
		order.setIdOrder(orderServiceImpl.numberOrder());
		order.setMass(Integer.parseInt(mass.trim()));
		order.setSeatCount(Integer.parseInt(seatCount.trim()));
		order.setTarget(target);
		order.setVolume(Integer.parseInt(volume.trim()));

		return order;

	}

	public void fixationOrder(Order order) {

		try {
			mySqlOrderDao.create(order);
		} catch (Exception e) {

			log.error("fixation Order is fail", e);

		}
	}

}

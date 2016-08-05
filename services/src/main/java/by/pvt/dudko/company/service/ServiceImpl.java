package by.pvt.dudko.company.service;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import by.pvt.dudko.company.dao.impl.MySqlOrderDao;
import by.pvt.dudko.company.db.ConnectionUtil;
import by.pvt.dudko.company.entities.Car;
import by.pvt.dudko.company.entities.Client;
import by.pvt.dudko.company.entities.Order;
import by.pvt.dudko.company.entities.Trip;

public class ServiceImpl {
	private OrderServiceImpl orderServiceImpl = new OrderServiceImpl();
	private AdminServiceImpl adminServiceImpl = new AdminServiceImpl();
	private TripServiceImpl tripServiceImpl = new TripServiceImpl();
	private MySqlOrderDao mySqlOrderDao = MySqlOrderDao.getInstance();
	private static final Logger log = Logger.getLogger(ServiceImpl.class);
	/**
	 * by fixing the application transaction
	 */
	public void tranzakzion(Client client, String target, String dictanse, String dateBegin, String dateFinish,
			String volume, String mass, String seatCount) {
				
		try {
			ConnectionUtil.getConnection().setAutoCommit(false);
			Order order = orderServiceImpl.formOrder(client, target, dictanse, dateBegin, dateFinish, volume, mass,
					seatCount);
			Car car = adminServiceImpl.scheduleCar(order);
			Trip trip = adminServiceImpl.scheduleTrip(order, car, client);
			orderServiceImpl.fixationOrder(order);
		
			tripServiceImpl.fixationTrip(trip);
			
			ConnectionUtil.getConnection().commit();
			log.info("Tranzakzion ServiceImpl is good,order is fixation in the database");
		} catch (IllegalArgumentException e) {
			String message = "Car is not found";
			log.error(message,e);
			throw new IllegalArgumentException("Car is not found");
		} catch (SQLException e) {
			try {
				log.error("Tranzakzion ServiceImpl fail",e);
				ConnectionUtil.getConnection().rollback();
			} catch (SQLException e1) {
				log.error(e1.getMessage());
			}
		}
	}
}

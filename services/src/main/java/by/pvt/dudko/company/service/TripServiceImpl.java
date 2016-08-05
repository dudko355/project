package by.pvt.dudko.company.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import by.pvt.dudko.company.dao.impl.MySqlOrderDao;
import by.pvt.dudko.company.dao.impl.MySqlTripDao;
import by.pvt.dudko.company.db.ConnectionUtil;
import by.pvt.dudko.company.entities.Car;
import by.pvt.dudko.company.entities.Client;
import by.pvt.dudko.company.entities.Order;
import by.pvt.dudko.company.entities.Trip;
import by.pvt.dudko.company.utils.UtilDate;

public class TripServiceImpl {
	private MySqlOrderDao mySqlOrderDao = MySqlOrderDao.getInstance();
	private MySqlTripDao mySqlTripDao = MySqlTripDao.getInstance();
	private CarServiceImpl carServiceImpl=new CarServiceImpl();
	private static final Logger log = Logger.getLogger(TripServiceImpl.class);

	/**
	 * all trip
	 */
	public List<Trip> allTrip() {

		List<Trip> list = new ArrayList<Trip>();
		try {
			ConnectionUtil.getConnection().setAutoCommit(false);
			list = mySqlTripDao.getTrip();
			ConnectionUtil.getConnection().commit();
		} catch (Exception e) {
			try {
				log.error("Tranzakzion allTrip fail", e);
				ConnectionUtil.getConnection().rollback();
			} catch (SQLException e1) {
				log.error(e1.getMessage());
			}
		}
		return list;
	}

	/**
	 * change condition trip
	 */
	public void changeCondTrip(Trip trip, int condition) {

		try {
			ConnectionUtil.getConnection().setAutoCommit(false);
			trip.setConditionTrip(condition);
			mySqlTripDao.update(trip);
			ConnectionUtil.getConnection().commit();
		} catch (Exception e) {
			try {
				log.error("Tranzakzion allTrip fail", e);
				ConnectionUtil.getConnection().rollback();
			} catch (SQLException e1) {
				log.error(e1.getMessage());
			}
		}
	}

	public void fixationTrip(Trip trip) {
		Car car=carServiceImpl.getCar(trip.getIdCar());
		try {
			ConnectionUtil.getConnection().setAutoCommit(false);
			mySqlTripDao.create(trip);
			carServiceImpl.changeConditionCar(car, 1);
			ConnectionUtil.getConnection().commit();
		} catch (Exception e) {
			try {
				log.error("Tranzakzion fixationTrip fail", e);
				ConnectionUtil.getConnection().rollback();
			} catch (SQLException e1) {
				log.error(e1.getMessage());
			}
		}
	}

	public void deleteTrip(Trip trip) {
		try {
			ConnectionUtil.getConnection().setAutoCommit(false);
			mySqlTripDao.delete((long) trip.getIdOrder());
			mySqlOrderDao.delete((long) trip.getIdOrder());
			ConnectionUtil.getConnection().commit();
		} catch (Exception e) {
			log.error("Tranzakzion deleteTrip fail", e);
			try {
				ConnectionUtil.getConnection().rollback();
			} catch (SQLException e1) {
				log.error(e);
			}
		}
	}

	public List getTripUser(Client client) {
		List<Trip> list=new ArrayList();
		try {
			ConnectionUtil.getConnection().setAutoCommit(false);
			list=mySqlTripDao.getAllClient(client);
			ConnectionUtil.getConnection().commit();
		} catch (Exception e) {
			log.error("Tranzakzion get Trip user fail", e);
			try {
				ConnectionUtil.getConnection().rollback();
			} catch (SQLException e1) {
				log.error(e);
			}
		}
		return list;
	}
}

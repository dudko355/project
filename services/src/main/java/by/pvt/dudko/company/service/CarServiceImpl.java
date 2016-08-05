package by.pvt.dudko.company.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;

import by.pvt.dudko.company.dao.impl.MySqlCarDao;
import by.pvt.dudko.company.dao.impl.MySqlTripDao;
import by.pvt.dudko.company.db.ConnectionUtil;
import by.pvt.dudko.company.entities.Car;
import by.pvt.dudko.company.entities.Client;
import by.pvt.dudko.company.entities.Trip;

public class CarServiceImpl {
	
	private MySqlCarDao mySqlCarDao = MySqlCarDao.getInstance();
	private static final Logger log = Logger.getLogger(CarServiceImpl.class);
	
	/**
	 * All cars
	 */
	public List<Car> allCar() {
		List<Car> list = new ArrayList<Car>();
		try {
			ConnectionUtil.getConnection().setAutoCommit(false);
			list = mySqlCarDao.getCar();
			ConnectionUtil.getConnection().commit();
		} catch (Exception e) {
			try {
				log.error("Tranzakzion allcar fail",e);
				ConnectionUtil.getConnection().rollback();
			} catch (SQLException e1) {
				log.error(e.getMessage());
			}
		}
		return list;
	}

	/**
	 * definition of key condition machines
	 */
	public int conditionCar(long key) {
		Car car = new Car();
		try {
			ConnectionUtil.getConnection().setAutoCommit(false);
			car = mySqlCarDao.get(key);
			ConnectionUtil.getConnection().commit();
		} catch (Exception e) {
			try {
				log.error("Tranzakzion conditionCar fail",e);
				ConnectionUtil.getConnection().rollback();
			} catch (SQLException e1) {
				log.error(e1.getMessage());
			}
		}
		return car.getCondition();

	}
	
	
	/**
	 * definition of key  machines
	 */
	public Car getCar(long key) {
		Car car = new Car();
		try {
			ConnectionUtil.getConnection().setAutoCommit(false);
			car = mySqlCarDao.get(key);
			ConnectionUtil.getConnection().commit();
		} catch (Exception e) {
			try {
				log.error("Tranzakzion get Car fail",e);
				ConnectionUtil.getConnection().rollback();
			} catch (SQLException e1) {
				log.error(e1.getMessage());
			}
		}
		return car;

	}


	/**
	 * definition of machines condition car
	 */
	public int condCar(Car car) {
		CarServiceImpl carServiceImpl = new CarServiceImpl();
		return carServiceImpl.conditionCar(car.getIdCar());

	}

	/**
	 * change condition car
	 */

	public void changeConditionCar(Car car, int condition) {
		try {
			ConnectionUtil.getConnection().setAutoCommit(false);
			car.setCondition(condition);
			mySqlCarDao.update(car);
			ConnectionUtil.getConnection().commit();

		} catch (Exception e) {
			try {
				log.error("Tranzakzion change conditionCar fail",e);
				ConnectionUtil.getConnection().rollback();
			} catch (Exception e1) {
				log.error(e1.getMessage());
			}
		}
	}

}
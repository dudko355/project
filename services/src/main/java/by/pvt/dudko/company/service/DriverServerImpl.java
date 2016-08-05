package by.pvt.dudko.company.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import by.pvt.dudko.company.dao.impl.MySqlDriverDao;
import by.pvt.dudko.company.dao.impl.MySqlOrderDao;
import by.pvt.dudko.company.db.ConnectionUtil;
import by.pvt.dudko.company.entities.Car;
import by.pvt.dudko.company.entities.Driver;

public class DriverServerImpl {
	private MySqlDriverDao mySqlDriverDao = MySqlDriverDao.getInstance();
	private static final Logger log = Logger.getLogger(DriverServerImpl.class);
	/**
	 * all drivers
	 */

	public List<Driver> allDriver() {
		List<Driver> list = new ArrayList<Driver>();
		
		try {
			ConnectionUtil.getConnection().setAutoCommit(false);
			list = mySqlDriverDao.getDriver();
			ConnectionUtil.getConnection().commit();
		} catch (Exception e) {
			try {
				log.error("Tranzakzion allDriver fail",e);
				ConnectionUtil.getConnection().rollback();
			} catch (SQLException e1) {
				log.error(e1.getMessage());
			}
		}
		return list;
	}

}

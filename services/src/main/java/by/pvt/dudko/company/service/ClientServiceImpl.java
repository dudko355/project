package by.pvt.dudko.company.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import by.pvt.dudko.company.dao.impl.MySqlClientDao;
import by.pvt.dudko.company.db.ConnectionUtil;
import by.pvt.dudko.company.entities.Car;
import by.pvt.dudko.company.entities.Client;
import by.pvt.dudko.company.entities.Order;
import by.pvt.dudko.company.entities.Trip;

public class ClientServiceImpl {
	private TripServiceImpl tripServiceImpl = new TripServiceImpl();
	private MySqlClientDao mySqlClientDao = MySqlClientDao.getInstance();
	private static final Logger log = Logger.getLogger(ClientServiceImpl.class);

	/**
	 * all client
	 */
	public List<Client> allClient() {
		List<Client> list = new ArrayList<Client>();
		try {
			ConnectionUtil.getConnection().setAutoCommit(false);
			list = mySqlClientDao.getClient();
			ConnectionUtil.getConnection().commit();
		} catch (Exception e) {
			try {
				log.error("Tranzakzion allClient fail", e);
				ConnectionUtil.getConnection().rollback();
			} catch (SQLException e1) {
				log.error(e1);
			}
		}
		return list;
	}

	/**
	 * true if the user has
	 */

	public boolean inspectionClient(List<Client> list, String login, String password) {
		int k = 0;
		boolean b = false;
		for (Client c : list) {
			if ((c.getPassword().equals(password) && c.getLogin().equals(login))) {
				b = true;
				String message = "enter client" + c.getIdClient();
				log.info(message);
			}

		}
		return b;
	}

	/**
	 * return Client if the user has(else null)
	 */
	public Client userFrom(String login, String password) {
		Client client = null;

		try {
			ConnectionUtil.getConnection().setAutoCommit(false);
			client = mySqlClientDao.getClientByLoginName(login, password);
			ConnectionUtil.getConnection().commit();
		} catch (Exception e) {
			try {
				log.error("Tranzakzion user from fail", e);
				ConnectionUtil.getConnection().rollback();
			} catch (SQLException e1) {
				log.error(e1);
			}
		}

		return client;
	}

	/**
	 * return Client if the user has
	 */
	public Client user(List<Client> list, String login, String password) {
		int k = 0;
		Client b = null;
		for (Client c : list) {
			if (c.getPassword().equals(password) && c.getLogin().equals(login)) {
				b = c;
			}
		}
		return b;
	}

	/**
	 * entered into the database
	 */
	public Client registration(String password, String login) {
		Client client = null;
		int k = allClient().size() + 1;
		client = new Client(k, 2, login, password);

		try {
			ConnectionUtil.getConnection().setAutoCommit(false);
			client = mySqlClientDao.create(client);
			ConnectionUtil.getConnection().commit();
		} catch (Exception e) {

			log.error("Tranzakzion allClient fail", e);
			try {
				ConnectionUtil.getConnection().rollback();
			} catch (SQLException e1) {
				log.error(e.getMessage());
			}
		}
		return client;
	}

	/**
	 * see the client orders
	 */
	public List tripClient(Client c) {
		List<Trip> list1 = new ArrayList<Trip>();
		for (Trip t : tripServiceImpl.allTrip()) {
			if (t.getIdClient() == c.getIdClient()) {
				list1.add(t);
			}
		}
		return list1;
	}

	/**
	 * delete user
	 */
	public void deleteUser(Client client) {
		try {
			mySqlClientDao.delete((long) client.getIdClient());
			log.info("client is delete");
		} catch (Exception e) {
			log.error(e);
		}
	}
}

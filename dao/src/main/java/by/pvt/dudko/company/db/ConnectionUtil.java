package by.pvt.dudko.company.db;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import by.pvt.dudko.company.dao.impl.utils.CloseConnect;

public class ConnectionUtil {
	private static DataSource instance;
	private static ThreadLocal<Connection> connection = new ThreadLocal<>();
	private static final Logger log = Logger.getLogger(ConnectionUtil.class);

	private ConnectionUtil() {
	}

	public static Connection getConnection() {
		try {
			if (instance == null) {
				instance = DataSource.getInstance();
			}
			if (connection.get() == null) {
				connection.set((Connection) instance.getConnection());
			}

		} catch (IOException e) {
			log.error("input output error",e);
		} catch (SQLException e) {
			log.error("Error connecting to the database",e);
		} catch (PropertyVetoException e) {
			log.error("Invalid setting value",e);
		}

		return connection.get();
	}

}

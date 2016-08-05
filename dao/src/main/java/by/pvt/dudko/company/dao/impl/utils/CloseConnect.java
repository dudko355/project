package by.pvt.dudko.company.dao.impl.utils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import by.pvt.dudko.company.dao.impl.MySqlCarDao;

public class CloseConnect {
	private static final Logger log = Logger.getLogger(CloseConnect.class);
	public static void close(ResultSet rs, PreparedStatement stm) {
		try {
			rs.close();
			stm.close();
		} catch (SQLException e) {
			 log.error("close Statement or close ResultSet failed", e);
		}

	}

	public static void close(PreparedStatement stm) {
		try {
			stm.close();
		} catch (SQLException e) {
			log.error("close Statement failed", e);
		}

	}
}

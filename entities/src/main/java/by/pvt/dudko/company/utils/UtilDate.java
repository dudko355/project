package by.pvt.dudko.company.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

public class UtilDate {
	private static final Logger log = Logger.getLogger(UtilDate.class);
	public static Date date(String date) {
		Date Date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date = sdf.parse(date);
			
		} catch (ParseException e) {
			log.error(e);
		}
		return Date;
	}
	public static java.sql.Date toSqlDate(java.util.Date date){
		 java.util.Date utilDate = date;
		 java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		return sqlDate;
		
	}
	
}

package by.pvt.dudko.company.entities;




import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import by.pvt.dudko.company.utils.UtilDate;

public class Order {
	private int idOrder;
	private int idClient;
	private String target;
	private int dictanse;
	private Date dateBegin;
	private Date dateFinish;
	private int seatCount;
	private int mass;
	private int volume;

	public Order() {
	}

	public Order(int idOrder, int idClient, String target, int dictanse, Date dateBegin, Date dateFinish, int seatCount,
			int mass, int volume) {

		this.idOrder = idOrder;
		this.idClient = idClient;
		this.target = target;
		this.dictanse = dictanse;
		this.dateBegin = dateBegin;
		this.dateFinish = dateFinish;
		this.seatCount = seatCount;
		this.mass = mass;
		this.volume = volume;
	}

	public static Date date(String date) {
		Date Date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date = sdf.parse(date);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return Date;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public void setDictanse(int dictanse) {
		this.dictanse = dictanse;
	}

	public void setDateBegin(String dateBegin) {
		 this.dateBegin= Order.date(dateBegin);
		 
	}

	public void setDateFinish(String dateFinish) {
		this.dateFinish = Order.date(dateFinish);
		 
	}

	public void setSeatCount(int seatCount) {
		this.seatCount = seatCount;
	}

	public void setMass(int mass) {
		this.mass = mass;
	}

	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public int getSeatCount() {
		return seatCount;
	}

	public int getIdOrder() {
		return idOrder;
	}

	public int getIdClient() {
		return idClient;
	}

	public int getMass() {
		return mass;
	}

	public int getVolume() {
		return volume;
	}

	public String getTarget() {
		return target;
	}

	public int getDictanse() {
		return dictanse;
	}

	public java.sql.Date getDateBegin() {
		return UtilDate.toSqlDate(dateBegin);
	}

	public java.sql.Date getDateFinish() {
		return UtilDate.toSqlDate(dateFinish);
		
	}
}
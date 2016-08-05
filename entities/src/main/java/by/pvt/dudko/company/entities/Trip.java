package by.pvt.dudko.company.entities;


import java.text.SimpleDateFormat;
import java.util.Date;

import by.pvt.dudko.company.utils.UtilDate;

public class Trip {
	private int dictanse;
	private String target;
	private int idCar;
	private int idOrder;
	private int idClient;
	private int idTrip;
	private Date dateBegin;
	private Date dateFinish;
	private int conditionTrip;
	
	public Trip() {
	}
	public Trip(String target, int dictanse, int idCar, int idOrder, int idClient, int idTrip, Date dateBegin,
			Date dateFinish, int conditionTrip) {
		this.target = target;
		this.dictanse = dictanse;
		this.idCar = idCar;
		this.idOrder = idOrder;
		this.idClient = idClient;
		this.idTrip = idTrip;
		this.dateBegin = dateBegin;
		this.dateFinish = dateFinish;
		this.conditionTrip = conditionTrip;
	}
	public void setIdCar(int idCar) {
		this.idCar=idCar;
	}
	
	public void setConditionTrip(int conditionTrip) {
		this.conditionTrip = conditionTrip;
	}

	public int getConditionTrip() {
		return conditionTrip;
	}

	public void setIdTrip(int idTrip) {
		this.idTrip=idTrip;
	}
	
	public int getIdTrip() {
		return idTrip;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public void setDictanse(int dictanse) {
		this.dictanse = dictanse;
	}

	public void setDateBegin(String dateBegin) {
		this.dateBegin = Order.date(dateBegin);
		
	}

	public void setDateFinish(String dateFinish) {
		this.dateFinish = Order.date(dateFinish);
		
	}

	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	
	public int getIdOrder() {
		return idOrder;
	}
	public int getIdCar() {
		return idCar;
	}

	public int getIdClient() {
		return idClient;
	}
	public String getTarget() {
		return target;
	}

	public int getDictanse() {
		return dictanse;
	}

	public Date getDateBegin() {
		return dateBegin;
	}

	public Date getDateFinish() {
		return dateFinish;
	}
}

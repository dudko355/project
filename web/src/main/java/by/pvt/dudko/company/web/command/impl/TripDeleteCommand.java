package by.pvt.dudko.company.web.command.impl;

import javax.servlet.http.HttpServletRequest;

import by.pvt.dudko.company.entities.Car;
import by.pvt.dudko.company.entities.Trip;
import by.pvt.dudko.company.service.CarServiceImpl;
import by.pvt.dudko.company.service.OrderServiceImpl;
import by.pvt.dudko.company.service.TripServiceImpl;
import by.pvt.dudko.company.web.impl.constant.ConstantsPages;
import by.pvt.dudko.company.web.impl.contract.ICommand;

public class TripDeleteCommand implements ICommand {
	private CarServiceImpl carServiceImpl=new CarServiceImpl();
	private OrderServiceImpl  orderServiceImpl=new  OrderServiceImpl();
	private TripServiceImpl  tripServiceImpl=new  TripServiceImpl();
	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		int idTrip = Integer.parseInt((request.getParameter("delete_trip")));
		for(Trip trip:tripServiceImpl.allTrip()){
			if(trip.getIdTrip()==idTrip){
				Car car=carServiceImpl.getCar(trip.getIdCar());
				carServiceImpl.changeConditionCar(car, 0);
				tripServiceImpl.deleteTrip(trip);	
				page=ConstantsPages.PAGES_CLIENT;
			}
		}
		return page;
	}

}

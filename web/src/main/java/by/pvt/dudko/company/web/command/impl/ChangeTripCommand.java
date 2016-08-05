package by.pvt.dudko.company.web.command.impl;

import javax.servlet.http.HttpServletRequest;

import by.pvt.dudko.company.entities.Car;
import by.pvt.dudko.company.entities.Trip;
import by.pvt.dudko.company.service.CarServiceImpl;
import by.pvt.dudko.company.service.TripServiceImpl;
import by.pvt.dudko.company.web.impl.constant.ConstantsPages;
import by.pvt.dudko.company.web.impl.contract.ICommand;

public class ChangeTripCommand implements ICommand {
	private TripServiceImpl tripServiceImpl = new TripServiceImpl();
	@Override
	public String execute(HttpServletRequest request) {
		String page=null;
		int idTrip = Integer.parseInt((request.getParameter("change_condition")));
		int cond = Integer.parseInt((request.getParameter("condition")).trim());
		if(cond==(-1)||cond==0||cond==1){
		for(Trip trip:tripServiceImpl.allTrip()){
			if(trip.getIdTrip()==idTrip){
				
				tripServiceImpl.changeCondTrip(trip, cond);
				page=ConstantsPages.PAGES_ADMIN;
			}
		}
		}else{
			page=ConstantsPages.ERROR;
		}
		
		return page;
	}

}

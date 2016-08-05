package by.pvt.dudko.company.web.command.impl;

import javax.servlet.http.HttpServletRequest;

import by.pvt.dudko.company.service.TripServiceImpl;
import by.pvt.dudko.company.web.impl.constant.ConstantsPages;
import by.pvt.dudko.company.web.impl.contract.ICommand;

public class ChangeCondTripCommand implements ICommand {
	private TripServiceImpl tripServiceImpl = new TripServiceImpl();
	@Override
	public String execute(HttpServletRequest request) {
		request.getSession().setAttribute("ALLTRIP", tripServiceImpl.allTrip());
		String page = ConstantsPages.CHANGE_TRIP;
		return page;
	}

}

package by.pvt.dudko.company.web.command.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.pvt.dudko.company.entities.Client;
import by.pvt.dudko.company.entities.Trip;
import by.pvt.dudko.company.service.ClientServiceImpl;
import by.pvt.dudko.company.service.TripServiceImpl;
import by.pvt.dudko.company.web.impl.constant.ConstantsPages;
import by.pvt.dudko.company.web.impl.contract.ICommand;

public class AccountDeleteCommand implements ICommand {
	private ClientServiceImpl clientServiceImpl = new ClientServiceImpl();
	private TripServiceImpl tripServiceImpl = new TripServiceImpl();

	@Override
	public String execute(HttpServletRequest request) {
		int i = 0;
		List<Trip> list = new ArrayList();
		String page = null;
		Client client = (Client) request.getSession().getAttribute("USER");
		list = tripServiceImpl.getTripUser(client);
		for (Trip trip : list) {
			if (trip.getConditionTrip() == (1)) {
				tripServiceImpl.deleteTrip(trip);
			} else {
				i = i + 1;
			}
		}
		if (i == 0) {
			clientServiceImpl.deleteUser(client);
			request.getSession().removeAttribute("USER");
			page = ConstantsPages.PAGES_BASE;
		} else {
			page = ConstantsPages.WARNING;
		}
		return page;
	}

}

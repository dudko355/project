package by.pvt.dudko.company.web.command.impl;

import javax.servlet.http.HttpServletRequest;

import by.pvt.dudko.company.entities.Client;
import by.pvt.dudko.company.service.ClientServiceImpl;
import by.pvt.dudko.company.web.impl.constant.ConstantsPages;
import by.pvt.dudko.company.web.impl.contract.ICommand;

public class MyOrderCommand implements ICommand{
	private ClientServiceImpl clientServiceImpl=new ClientServiceImpl();
	@Override
	public String execute(HttpServletRequest request) {
		String page=null;
		Client client = (Client) request.getSession().getAttribute("USER");
		request.getSession().setAttribute("trips",clientServiceImpl.tripClient(client));
		page= ConstantsPages.ORDERS;
		return page;
	}

}

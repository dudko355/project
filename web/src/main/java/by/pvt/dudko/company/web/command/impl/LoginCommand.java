package by.pvt.dudko.company.web.command.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import by.pvt.dudko.company.entities.Client;
import by.pvt.dudko.company.service.ClientServiceImpl;
import by.pvt.dudko.company.web.impl.constant.ConstantsPages;
import by.pvt.dudko.company.web.impl.contract.ICommand;

public class LoginCommand implements ICommand {
	private ClientServiceImpl clientServiceImpl = new ClientServiceImpl();

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		Client client = null;
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		client=clientServiceImpl.userFrom(login, password);
		if (!(client==null)) {
			page = ConstantsPages.PAGES_CLIENT;
			HttpSession user=request.getSession();
			user.setAttribute("USER", client);
		} else {
			page = ConstantsPages.ERROR;
			return page;
		}
		
		return page;
	}

}

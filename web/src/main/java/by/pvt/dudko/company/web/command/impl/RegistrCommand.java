package by.pvt.dudko.company.web.command.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import by.pvt.dudko.company.entities.Client;
import by.pvt.dudko.company.service.ClientServiceImpl;
import by.pvt.dudko.company.web.impl.constant.ConstantsPages;
import by.pvt.dudko.company.web.impl.contract.ICommand;

public class RegistrCommand implements ICommand {
	private ClientServiceImpl clientServiceImpl = new ClientServiceImpl();

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		Client client = null;
		String login = request.getParameter("login").trim();
		String password = request.getParameter("password").trim();
		client=clientServiceImpl.userFrom(login, password);
		if (!login.isEmpty() && !password.isEmpty()
				&& (client==null)) {

			client = clientServiceImpl.registration(password, login);
			HttpSession user=request.getSession();
			user.setAttribute("USER", client);
			page = ConstantsPages.PAGES_CLIENT;
		} else {
			page = ConstantsPages.ERROR;
		}

		return page;

	}

}

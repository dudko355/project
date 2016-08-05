package by.pvt.dudko.company.web.command.impl;

import javax.servlet.http.HttpServletRequest;

import by.pvt.dudko.company.web.impl.constant.ConstantsPages;
import by.pvt.dudko.company.web.impl.contract.ICommand;

public class ChangeLocaleCommand implements ICommand{

	
	public  String execute(HttpServletRequest request) {
 		String locale = request.getParameter("locale");
		request.getSession().setAttribute("locale", locale);
		return ConstantsPages.PAGES_BASE;
		
	}

}

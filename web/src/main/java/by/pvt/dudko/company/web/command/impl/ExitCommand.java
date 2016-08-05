package by.pvt.dudko.company.web.command.impl;

import javax.servlet.http.HttpServletRequest;

import by.pvt.dudko.company.entities.Client;
import by.pvt.dudko.company.web.impl.constant.ConstantsPages;
import by.pvt.dudko.company.web.impl.contract.ICommand;

public class ExitCommand implements ICommand  {

	@Override
	public String execute(HttpServletRequest request) {
		String nextpage=null;
		request.getSession().removeAttribute("USER");
		nextpage=ConstantsPages.PAGES_BASE;
		return nextpage;
	}

}

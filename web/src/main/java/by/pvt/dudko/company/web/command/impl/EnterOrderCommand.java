package by.pvt.dudko.company.web.command.impl;

import javax.servlet.http.HttpServletRequest;

import by.pvt.dudko.company.web.impl.constant.ConstantsPages;
import by.pvt.dudko.company.web.impl.contract.ICommand;

public class EnterOrderCommand implements ICommand {

	@Override
	public String execute(HttpServletRequest request) {
		String nextpage = null;
		nextpage = ConstantsPages.PAGES_ORDER;
		return nextpage;
	}

}

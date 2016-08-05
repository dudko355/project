package by.pvt.dudko.company.web.command.impl;

import javax.servlet.http.HttpServletRequest;

import by.pvt.dudko.company.service.CarServiceImpl;
import by.pvt.dudko.company.web.impl.constant.ConstantsPages;
import by.pvt.dudko.company.web.impl.contract.ICommand;

public class ChangeCondCarCommand implements ICommand {
	private CarServiceImpl carServiceImpl = new CarServiceImpl();
	@Override
	public String execute(HttpServletRequest request) {
		request.getSession().setAttribute("ALLCAR", carServiceImpl.allCar());
		String page = ConstantsPages.CHANGE_CAR_COND;
		return page;
	}

}

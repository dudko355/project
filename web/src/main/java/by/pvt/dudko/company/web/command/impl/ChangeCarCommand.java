package by.pvt.dudko.company.web.command.impl;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import by.pvt.dudko.company.entities.Car;
import by.pvt.dudko.company.service.CarServiceImpl;
import by.pvt.dudko.company.web.command.CommandFactory;
import by.pvt.dudko.company.web.impl.constant.ConstantsPages;
import by.pvt.dudko.company.web.impl.contract.ICommand;

public class ChangeCarCommand implements ICommand {
	private CarServiceImpl carServiceImpl = new CarServiceImpl();
	@Override
	public String execute(HttpServletRequest request) {
		String page=null;
		int idCar = Integer.parseInt((request.getParameter("change_condition")));
		int cond = Integer.parseInt((request.getParameter("condition")).trim());
		if(cond==(-1)||cond==0||cond==1){
		for(Car car:carServiceImpl.allCar()){
			if(car.getIdCar()==idCar){
				
				carServiceImpl.changeConditionCar(car, cond);
				page=ConstantsPages.PAGES_ADMIN;
			}
		}
		}else{
			
			page=ConstantsPages.ERROR;
		}
		
		return page;
	}

}

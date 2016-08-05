package by.pvt.dudko.company.web.command.impl;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import by.pvt.dudko.company.entities.Car;
import by.pvt.dudko.company.entities.Client;
import by.pvt.dudko.company.service.AdminServiceImpl;
import by.pvt.dudko.company.service.CarServiceImpl;
import by.pvt.dudko.company.service.ClientServiceImpl;
import by.pvt.dudko.company.service.DriverServerImpl;
import by.pvt.dudko.company.service.TripServiceImpl;
import by.pvt.dudko.company.web.impl.constant.ConstantsPages;
import by.pvt.dudko.company.web.impl.contract.ICommand;

public class AdminEnterCommand implements ICommand {
	private AdminServiceImpl adminServiceImpl = new AdminServiceImpl();
	private DriverServerImpl driverServerImpl = new DriverServerImpl();
	private CarServiceImpl carServiceImpl = new CarServiceImpl();
	private ClientServiceImpl clientServiceImpl = new ClientServiceImpl();

	@Override
	public String execute(HttpServletRequest request) {
		ArrayList<Car> list = new ArrayList<Car>();
		String page = null;
		Client client = null;
		for (Client c : clientServiceImpl.allClient()) {
			if (c.getIdClient() == 1) {
				client = c;
				request.getSession().setAttribute("ADMIN", client);

			}
		}
		request.getSession().setAttribute("CARS", adminServiceImpl.brokenCars());
		request.getSession().setAttribute("DRIVER", driverServerImpl.allDriver());
		

		for (Car car : carServiceImpl.allCar()) {
			if (carServiceImpl.condCar(car) == 1) {
				list.add(car);
			}
		}
		request.getSession().setAttribute("CARTRIP", list);

		page = ConstantsPages.CAR;
		return page;
	}

}

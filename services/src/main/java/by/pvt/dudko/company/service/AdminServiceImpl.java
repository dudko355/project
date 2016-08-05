package by.pvt.dudko.company.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import by.pvt.dudko.company.dao.impl.MySqlOrderDao;
import by.pvt.dudko.company.db.ConnectionUtil;
import by.pvt.dudko.company.entities.Car;
import by.pvt.dudko.company.entities.Client;
import by.pvt.dudko.company.entities.Order;
import by.pvt.dudko.company.entities.Trip;

public class AdminServiceImpl {
	private TripServiceImpl tripService = new TripServiceImpl();
	private OrderServiceImpl orderServiceImpl = new OrderServiceImpl();
	private CarServiceImpl carServise = new CarServiceImpl();
	private static final Logger log = Logger.getLogger(AdminServiceImpl.class);

	public Car scheduleCar(Order order) {
		List<Car> list = new ArrayList<Car>();
		Car car = new Car();

		for (Car ca : carServise.allCar()) {
			if (carServise.condCar(ca) == 0) {
				if (order.getMass() <= ca.getMass() && order.getSeatCount() <= ca.getSeatCount()
						&& order.getVolume() <= ca.getVolume()) {
					list.add(ca);
				}
			}
		}
		if (!list.isEmpty()) {
			car = list.get(0);
		} else {
			String message = "Car is not found";
			log.info(message);
			throw new IllegalArgumentException(message);
		}
		return car;
	}

	public Trip scheduleTrip(Order order, Car car, Client client) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Trip trip = new Trip();
		trip.setTarget(order.getTarget());
		trip.setDateBegin(sdf.format(order.getDateBegin()));
		trip.setDateFinish(sdf.format(order.getDateFinish()));
		trip.setDictanse(order.getDictanse());
		trip.setIdCar(car.getIdCar());
		trip.setIdClient(client.getIdClient());
		trip.setIdOrder(order.getIdOrder());
		trip.setIdTrip(order.getIdOrder());
		trip.setConditionTrip(-1);
		String message = "new trip is fill";
		log.info(message);
		return trip;
	}

	public ArrayList<Car> brokenCars() {
		List<Car> list = new ArrayList<Car>();
		for (Car c : carServise.allCar()) {
			if (carServise.condCar(c) == (-1)) {
				list.add(c);
			}
		}
		return (ArrayList<Car>) list;

	}

}

package by.pvt.dudko.company;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import by.pvt.dudko.company.entities.Car;
import by.pvt.dudko.company.entities.Order;
import by.pvt.dudko.company.service.AdminServiceImpl;

public class AdminServiceImplTest
{
	private AdminServiceImpl adminServiceImpl;

	@Before
	public void init() {
		adminServiceImpl = new AdminServiceImpl();
	}

	@After
	public void destroy() {
		adminServiceImpl = null;
	}

	@Test
	public void testScheduleCar() {

		Order order = new Order();
		order.setMass(10);
		order.setSeatCount(2);
		order.setVolume(10);
		Car car = adminServiceImpl.scheduleCar(order);
		Assert.assertEquals(false, car == null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testScheduleCarTwo() {

		Order order = new Order();
		order.setMass(1000);
		order.setSeatCount(2);
		order.setVolume(10);
		adminServiceImpl.scheduleCar(order);
	}

	@Test
	public void testBrokenCars() {
		List<Car> brokenCars = adminServiceImpl.brokenCars();
		List<Car> brokenCar = new ArrayList();
		for (Car car : brokenCars) {
			if (car.getCondition() == (-1)) {
				brokenCar.add(car);
			}
		}
		Assert.assertEquals(true, brokenCars.size() == brokenCar.size());
	}
}

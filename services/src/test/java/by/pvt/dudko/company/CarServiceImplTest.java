package by.pvt.dudko.company;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import by.pvt.dudko.company.entities.Car;
import by.pvt.dudko.company.service.CarServiceImpl;

public class CarServiceImplTest {
	private CarServiceImpl carServiceImpl;

	@Before
	public void init() {
		carServiceImpl = new CarServiceImpl();
	}

	@After
	public void destroy() {
		carServiceImpl = null;
	}

	@Test
	public void testConditionCar() {
		Assert.assertEquals(true, carServiceImpl.conditionCar(1) == 1 || carServiceImpl.conditionCar(1) == -1
				|| carServiceImpl.conditionCar(1) == 0);

	}

	@Test
	public void testGetCar() {
		Assert.assertEquals(true, (carServiceImpl.getCar(1)) instanceof Car);
	}
	@Test
	public void testChangeConditionCar() {
		carServiceImpl.changeConditionCar(carServiceImpl.getCar(1),-1);
		Integer cond=carServiceImpl.getCar(1).getCondition();
		Assert.assertEquals(true,-1==cond);
	}
}

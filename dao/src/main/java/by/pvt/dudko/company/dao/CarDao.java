package by.pvt.dudko.company.dao;

import java.sql.SQLException;
import java.util.List;

import by.pvt.dudko.company.dao.contract.IDao;
import by.pvt.dudko.company.entities.Car;

public interface CarDao extends IDao<Car> {
	/**
	 * Calls Dao get() method
	 * @param id  - id car
	 * @return object of car
	 * @throws Exception
	 */
	Car get(long id) throws Exception;

	/**
	 * Calls Dao create() method
	 * @param entity  - object of car
	 * @throws Exception
	 */
	Car create(Car t) throws Exception;

	/**
	 * Calls Dao update() method
	 * @param entity  - object of car
	 * @throws Exception
	 */
	void update(Car t) throws Exception;

	/**
	 * Calls Dao delete() method
	 * @param id - id of car
	 * @throws Exception
	 */
	void delete(long id) throws Exception;

	/**
	 * Calls Dao delete() method
	 * @param id - id of car features
	 * @throws Exception
	 */
	void deleteFeatures(long id) throws Exception;

	/**
	 * Calls Dao getAll() method
	 * @return list of car objects
	 * @throws Exception
	 */
	public List<Car> getCar() throws Exception;
}

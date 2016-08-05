package by.pvt.dudko.company.dao;

import java.util.List;

import by.pvt.dudko.company.dao.contract.IDao;
import by.pvt.dudko.company.entities.Driver;



public interface DriverDao extends IDao<Driver>{
	/**
	 * Calls Dao get() method
	 * @param id  - id Driver
	 * @return object of Driver
	 * @throws Exception
	 */
	Driver get(long id) throws Exception;
	/**
	 * Calls Dao create() method
	 * @param entity  - object of Driver
	 * @throws Exception
	 */
	Driver create(Driver t)throws Exception;
	/**
	 * Calls Dao update() method
	 * @param entity  - object of Driver
	 * @throws Exception
	 */
	 void update(Driver t)throws Exception;
		/**
		 * Calls Dao delete() method
		 * @param id - id of Driver
		 * @throws Exception
		 */

	 void delete(long id)throws Exception;
	 /**
		 * Calls Dao getAll() method
		 * @return list of Driver objects
		 * @throws Exception
		 */
   public List<Driver> getDriver()throws Exception;
}

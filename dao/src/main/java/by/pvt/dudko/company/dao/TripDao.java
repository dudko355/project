package by.pvt.dudko.company.dao;

import java.util.List;

import by.pvt.dudko.company.dao.contract.IDao;
import by.pvt.dudko.company.entities.Trip;



public interface TripDao extends IDao<Trip>{
	/**
	 * Calls Dao get() method
	 * @param id  - id  Trip
	 * @return object of  Trip
	 * @throws Exception
	 */
	Trip get(long id) throws Exception;
	/**
	 * Calls Dao create() method
	 * @param entity  - object of  Trip
	 * @throws Exception
	 */
	Trip create(Trip t)throws Exception;
	/**
	 * Calls Dao update() method
	 * @param entity  - object of  Trip
	 * @throws Exception
	 */
	 void update(Trip t)throws Exception;
		/**
		 * Calls Dao delete() method
		 * @param id - id of  Trip
		 * @throws Exception
		 */

	 void delete(long id)throws Exception;
	 /**
		 * Calls Dao getAll() method
		 * @return list of  Trip objects
		 * @throws Exception
		 */
   public List<Trip> getTrip()throws Exception;
}

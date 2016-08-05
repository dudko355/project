package by.pvt.dudko.company.dao;

import java.util.List;

import by.pvt.dudko.company.dao.contract.IDao;
import by.pvt.dudko.company.entities.Order;


public interface OrderDao extends IDao<Order>{
	/**
	 * Calls Dao get() method
	 * @param id  - id Order
	 * @return object of Order
	 * @throws Exception
	 */
	Order get(long id) throws Exception;
	/**
	 * Calls Dao create() method
	 * @param entity  - object of Order
	 * @throws Exception
	 */
	Order create(Order t)throws Exception;
	/**
	 * Calls Dao update() method
	 * @param entity  - object of Order
	 * @throws Exception
	 */
	 void update(Order t)throws Exception;
		/**
		 * Calls Dao delete() method
		 * @param id - id of Order
		 * @throws Exception
		 */

	 void delete(long id)throws Exception;
	 /**
		 * Calls Dao getAll() method
		 * @return list of Order objects
		 * @throws Exception
		 */
   public List<Order> getOrder()throws Exception;

}

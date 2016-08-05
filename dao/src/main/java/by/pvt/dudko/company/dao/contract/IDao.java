package by.pvt.dudko.company.dao.contract;



public interface IDao <T> {
	  /**
     * Calls Dao get() method
     * @param id - id of entity
     * @return object of derived class Entity
     * @throws SQLException
     */
	 T get(long id) throws Exception;

	/**
	 * Calls Dao create() method
	 * 
	 * @param entity
	 *            - object of derived class Entity
	 * @throws SQLException
	 */
	 T create(T t)throws Exception;
	 /**
	     * Calls Dao update() method
	     * @param entity - object of derived class Entity
	     * @throws SQLException
	     */
	 void update(T t)throws Exception;
	  /**
	     * Calls Dao delete() method
	     * @param id - id of entity
	     * @throws SQLException
	     */
	 void delete(long id) throws Exception;
	
}

package by.pvt.dudko.company.dao;

import java.sql.SQLException;
import java.util.List;

import by.pvt.dudko.company.dao.contract.IDao;
import by.pvt.dudko.company.entities.Client;


public interface ClientDao extends IDao<Client>{
	/**
	 * Calls Dao get() method
	 * @param id  - id client
	 * @return object of client
	 * @throws Exception
	 */
	Client get(long id) throws Exception;
	/**
	 * Calls Dao create() method
	 * @param entity  - object of client
	 * @throws Exception
	 */
	Client create(Client t)throws Exception;
	/**
	 * Calls Dao update() method
	 * @param entity  - object of client
	 * @throws Exception
	 */
	 void update(Client t)throws Exception;
	 /**
		 * Calls Dao delete() method
		 * @param id - id of client
		 * @throws Exception
		 */
	 void delete(long id)throws Exception;
	 /**
	     *  Calls Dao getAll() method
	     * @return list of objects of client
	     * @throws Exception
	     */
   public List<Client> getClient()throws Exception;

}

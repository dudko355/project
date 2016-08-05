package by.pvt.dudko.company.dao;

import java.util.List;

import by.pvt.dudko.company.dao.contract.IDao;
import by.pvt.dudko.company.entities.Client;
import by.pvt.dudko.company.entities.Rol;

public interface RolDao extends IDao<Rol>{
	/**
	 * Calls Dao get() method
	 * @param id  - id Rol
	 * @return object of Rol
	 * @throws Exception
	 */
	Rol get(long id) throws Exception;
	/**
	 * Calls Dao create() method
	 * @param entity  - object of Rol
	 * @throws Exception
	 */
	Rol create(Rol t)throws Exception;
	/**
	 * Calls Dao update() method
	 * @param entity  - object of Rol
	 * @throws Exception
	 */
	 void update(Rol t)throws Exception;
		/**
		 * Calls Dao delete() method
		 * @param id - id of Rol
		 * @throws Exception
		 */

	 void delete(long id)throws Exception;
	 /**
		 * Calls Dao getAll() method
		 * @return list of Rol objects
		 * @throws Exception
		 */
   public List<Rol> getRol()throws Exception;


}

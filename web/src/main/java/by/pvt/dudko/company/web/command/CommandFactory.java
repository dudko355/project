package by.pvt.dudko.company.web.command;

import org.apache.log4j.Logger;

import by.pvt.dudko.company.service.AdminServiceImpl;
import by.pvt.dudko.company.web.command.constant.Commands;
import by.pvt.dudko.company.web.command.impl.AccountDeleteCommand;
import by.pvt.dudko.company.web.command.impl.AdminEnterCommand;
import by.pvt.dudko.company.web.command.impl.ChangeCarCommand;
import by.pvt.dudko.company.web.command.impl.ChangeCondCarCommand;
import by.pvt.dudko.company.web.command.impl.ChangeCondTripCommand;
import by.pvt.dudko.company.web.command.impl.ChangeLocaleCommand;
import by.pvt.dudko.company.web.command.impl.ChangeTripCommand;
import by.pvt.dudko.company.web.command.impl.EnterOrderCommand;
import by.pvt.dudko.company.web.command.impl.ExitAdminCommand;
import by.pvt.dudko.company.web.command.impl.ExitCommand;
import by.pvt.dudko.company.web.command.impl.LoginCommand;
import by.pvt.dudko.company.web.command.impl.MyOrderCommand;
import by.pvt.dudko.company.web.command.impl.OrderCommand;
import by.pvt.dudko.company.web.command.impl.RegistrCommand;
import by.pvt.dudko.company.web.command.impl.ReturnClientPageCommand;
import by.pvt.dudko.company.web.command.impl.TripDeleteCommand;
import by.pvt.dudko.company.web.impl.contract.ICommand;

public class CommandFactory {
	private static final Logger log = Logger.getLogger(CommandFactory.class);
	 public static ICommand getCommand(String page) {
	        Commands currentCommand = Commands.valueOf(page.toUpperCase());
	        switch (currentCommand) {
	            case LOGIN:
	                return new LoginCommand();
	            case REGISTRATION:
	                return new RegistrCommand();
	            case PAGE_ORDER:
	                return new OrderCommand();
	            case CLIENT_PAGE:
	                return new ExitCommand();
	            case MY_ORDERS:
	                return new MyOrderCommand(); 
	            case CHANGE_CAR:
	            	return new ChangeCarCommand();
	            case CHANGE_TRIP:
	            	return new ChangeTripCommand();
	            case PAGES_BASE:
	            	return new AdminEnterCommand();
	            case CHANGE_LOCALE:
	            	return new ChangeLocaleCommand();
	            case CHANGE_COND_TRIP:
	            	return new ChangeCondTripCommand();
	            case CHANGE_COND_CAR:
	            	return new ChangeCondCarCommand();
	            case EXIT_ADMIN:
	            	return new ExitAdminCommand();
	            case NOT_CAR:
	            	return new EnterOrderCommand();
	            case RETURN:
	            	return new ReturnClientPageCommand();
	            case CLIENT_TRIP:
	            	return new TripDeleteCommand();
	            case DELETE_ACCOUNT:
	            	return new AccountDeleteCommand();
	            default:
	            	log.info("not found command in factory");
	               throw new IllegalArgumentException("Such command doesn't exist");
	        }
	    }
}

package by.pvt.dudko.company.web.command.impl;

import java.sql.SQLException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.mysql.fabric.xmlrpc.base.Data;

import by.pvt.dudko.company.dao.impl.MySqlOrderDao;
import by.pvt.dudko.company.entities.Car;
import by.pvt.dudko.company.entities.Client;
import by.pvt.dudko.company.entities.Order;
import by.pvt.dudko.company.entities.Trip;
import by.pvt.dudko.company.service.AdminServiceImpl;
import by.pvt.dudko.company.service.OrderServiceImpl;
import by.pvt.dudko.company.service.ServiceImpl;
import by.pvt.dudko.company.service.TripServiceImpl;
import by.pvt.dudko.company.utils.UtilDate;
import by.pvt.dudko.company.web.command.CommandFactory;
import by.pvt.dudko.company.web.impl.constant.ConstantsPages;
import by.pvt.dudko.company.web.impl.contract.ICommand;

public class OrderCommand implements ICommand {
	private ServiceImpl serviceImpl = new ServiceImpl();
	private static final Logger log = Logger.getLogger(OrderCommand.class);
	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		String target = request.getParameter("target").trim();
		String dictanse = request.getParameter("distanse").trim();
		String dateBegin = request.getParameter("dateBegin").trim();
		String dateFinish = request.getParameter("dateFinish").trim();
		String volume = request.getParameter("volume").trim();
		String mass = request.getParameter("mass").trim();
		String seatCount = request.getParameter("seatCount").trim();
		Client client = (Client) request.getSession().getAttribute("USER");
		Date dateB=UtilDate.date(dateBegin);
		Date dateF=UtilDate.date(dateFinish);
        Date date=new Date();
		try {
			if (!target.isEmpty() && !dictanse.isEmpty() && !dateBegin.isEmpty() && !dateFinish.isEmpty() && dateF.after(dateB )&& dateB.after(date) ) {
				serviceImpl.tranzakzion(client, target, dictanse, dateBegin, dateFinish, volume, mass, seatCount);
				page = ConstantsPages.PAGES_CLIENT;
			} else {
				log.info("INCORRECT DATA on the ORDER FORM");
				page = ConstantsPages.INCORRECT;
			}
		
		} catch (Exception e) {
			log.error("car not found",e);
			page = ConstantsPages.CAR_NOT_FOUND;
		} finally {
			return page;
		}

	}

}
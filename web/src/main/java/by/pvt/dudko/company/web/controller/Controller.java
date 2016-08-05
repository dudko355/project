package by.pvt.dudko.company.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import by.pvt.dudko.company.dao.impl.MySqlClientDao;
import by.pvt.dudko.company.db.ConnectionUtil;
import by.pvt.dudko.company.entities.Client;
import by.pvt.dudko.company.web.command.CommandFactory;
import by.pvt.dudko.company.web.impl.contract.ICommand;


/**
 * Servlet implementation class Controller
 */
 
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(Controller.class);
	public Controller() {
		super();
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		processRequest(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);

	}
	private void processRequest(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
		 String page = request.getParameter("page");
		 
	        if (page != null) {
	        	
	            ICommand command = CommandFactory.getCommand(page);
	            String nextPage = command.execute(request);
	            RequestDispatcher requestDispatcher = request.getRequestDispatcher(nextPage);
	            requestDispatcher.forward(request, response);
	        } else {
	        	log.info("Param page is not specified");
	        	throw new IllegalArgumentException("Param page is not specified");
	        }	
	}
}

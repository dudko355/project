package by.pvt.dudko.company.web.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import by.pvt.dudko.company.web.command.CommandFactory;

public class LoginFilter implements Filter {
	private static final Logger log = Logger.getLogger(LoginFilter.class);
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws ServletException, IOException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		HttpSession session = request.getSession();
		String indexURI = request.getContextPath() + "/index.jsp";
		String loginURI = request.getContextPath() + "/start_page.jsp";
		String loginFotmURI = request.getContextPath() + "/login.jsp";
		String registrationFormURI = request.getContextPath() + "/registration.jsp";
		String errorFormURI = request.getContextPath() + "/error.jsp";
		String adminURI = request.getContextPath() + "/admin.jsp";
		
		boolean loggedIn = session != null
				&& (session.getAttribute("USER") != null || session.getAttribute("ADMIN") != null);

		boolean admin = adminURI.equals(request.getRequestURI());
		boolean loginRequest = (loginFotmURI.equals(request.getRequestURI())
				|| registrationFormURI.equals(request.getRequestURI()) || loginURI.equals(request.getRequestURI())
				|| errorFormURI.equals(request.getRequestURI())) || indexURI.equals(request.getRequestURI());

		boolean admin1 = "PAGES_BASE".equals(request.getParameter("page"));
		boolean myServlet = "/Project/Controller".equals(request.getRequestURI());
		boolean login = "login".equals(request.getParameter("page"));
		boolean registration = "registration".equals(request.getParameter("page"));
		boolean language = "CHANGE_LOCALE".equals(request.getParameter("page"));

		if (myServlet && admin1) {
			chain.doFilter(request, response);
		} else if (myServlet && login) {
			chain.doFilter(request, response);
		} else if (myServlet && registration) {
			chain.doFilter(request, response);
		} else if (loggedIn || loginRequest || admin) {
			chain.doFilter(request, response);
		} else if (myServlet && language) {
			chain.doFilter(request, response);
		} else {
			log.info("unauthorized entry");
			request.getRequestDispatcher("/start_page.jsp").forward(request, response);

		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

	// ...
}

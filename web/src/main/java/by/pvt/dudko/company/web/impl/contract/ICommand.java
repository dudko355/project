package by.pvt.dudko.company.web.impl.contract;

import javax.servlet.http.HttpServletRequest;

/**
 * This interface implements a pattern command
 * This interface causes methods a business-logic and sends results on jsp
  */
public interface ICommand {
    String execute(HttpServletRequest request);
}

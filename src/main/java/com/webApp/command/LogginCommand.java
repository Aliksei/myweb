package com.webApp.command;

import com.webApp.dao.AccountDao;
import com.webApp.entities.User;
import com.webApp.utils.ConfigUtils;

import javax.servlet.http.HttpServletRequest;

public class LogginCommand implements ICommand {

    public String execute(HttpServletRequest request) {
        String view ;
        String login = request.getParameter("login");
        String pass = request.getParameter("password");

        AccountDao accountDao = (AccountDao) request.getServletContext().getAttribute("dao");

        User user = accountDao.getUserByLogin(login);
        if (user != null && user.getPassword().equals(pass) ) {

            String sessionId = request.getSession().getId();
            request.getSession().setAttribute("session_id",sessionId);
            request.getSession().setAttribute("dao",login);

            request.setAttribute("user_name", login);
            view = ConfigUtils.getProperty("path.page.main");
        } else {
            request.setAttribute("errorLoginPassMessage",
                    ConfigUtils.getProperty("message.loginerror"));
            view = ConfigUtils.getProperty("path.page.login");
        }
        return view;
    }
}

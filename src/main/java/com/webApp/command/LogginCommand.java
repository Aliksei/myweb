package com.webApp.command;

import com.webApp.dao.ProfileDaoXmlImpl;
import com.webApp.dao.UserDaoXmlImpl;
import com.webApp.entities.User;
import com.webApp.utils.ConfigUtils;

import javax.servlet.http.HttpServletRequest;

public class LogginCommand implements ICommand {

    public String execute(HttpServletRequest request) {
        String view ;
        String login = request.getParameter("login");
        String pass = request.getParameter("password");

        UserDaoXmlImpl userDao = (UserDaoXmlImpl) request.getServletContext().getAttribute("userDao");
        ProfileDaoXmlImpl profileDaoXml = (ProfileDaoXmlImpl) request.getServletContext().getAttribute("profileDao");

        User user = userDao.getUserByLogin(login);
        if (user != null && user.getPassword().equals(pass) ) {

            String sessionId = request.getSession().getId();
            request.getSession().setAttribute("session_id",sessionId);
            request.getSession().setAttribute("user",login);

            request.getSession().setAttribute("tickets",profileDaoXml.getTickets(login));

            view = ConfigUtils.getProperty("path.page.main");
        } else {
            request.setAttribute("errorLoginPassMessage",
                    ConfigUtils.getProperty("message.loginerror"));
            view = ConfigUtils.getProperty("path.page.login");
        }
        return view;
    }
}

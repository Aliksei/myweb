package com.webApp.command;

import com.webApp.dao.ProfileDaoXmlImpl;
import com.webApp.dao.UserDaoXmlImpl;
import com.webApp.entities.User;
import com.webApp.utils.ConfigUtils;

import javax.servlet.http.HttpServletRequest;

public class RegisterCommand implements ICommand{

    public String execute(HttpServletRequest request) {

        String view ;
        String login = request.getParameter("login");
        String pass = request.getParameter("password");
        UserDaoXmlImpl accountDao = (UserDaoXmlImpl) request.getServletContext().getAttribute("userDao");
        ProfileDaoXmlImpl profileDao = (ProfileDaoXmlImpl) request.getServletContext().getAttribute("profileDao");

        if ( login != null && pass!=null && !login.isEmpty() && !pass.isEmpty()){
            accountDao.createUser(new User(login,pass));
            profileDao.createProfile(login);
            view = ConfigUtils.getProperty("path.page.login");
        }else {
            request.setAttribute("errorMessagePassMessage",
                    ConfigUtils.getProperty("message.registration.error"));
            view = ConfigUtils.getProperty("path.page.registration");
        }
        return view;
    }
}

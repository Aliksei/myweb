package com.webApp.command;

import com.webApp.utils.ConfigUtils;
import com.webApp.dao.AccountDao;
import com.webApp.entities.User;

import javax.servlet.http.HttpServletRequest;

public class RegisterCommand implements ICommand{

    public String execute(HttpServletRequest request) {

        String view ;
        String login = request.getParameter("login");
        String pass = request.getParameter("password");
        AccountDao accountDao = (AccountDao) request.getServletContext().getAttribute("dao");

        if ( login != null && pass!=null && !login.isEmpty() && !pass.isEmpty()){
            accountDao.addNewUser(new User(login,pass));
            view = ConfigUtils.getProperty("path.page.login");
        }else {
            request.setAttribute("errorMessagePassMessage",
                    ConfigUtils.getProperty("message.registration.error"));
            view = ConfigUtils.getProperty("path.page.registration");
        }
        return view;
    }
}

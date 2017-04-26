package com.tkachuk.command;

import com.tkachuk.ConfigUtils;
import com.tkachuk.user.AccountService;
import com.tkachuk.user.User;

import javax.servlet.http.HttpServletRequest;

public class RegisterCommand implements ICommand{

    public String execute(HttpServletRequest request, AccountService accountService) {

        String view ;
        String login = request.getParameter("login");
        String pass = request.getParameter("password");

        if ( login != null && pass!=null && !login.isEmpty() && !pass.isEmpty()){
            accountService.addNewUser(new User(login,pass));
            view = ConfigUtils.getProperty("path.page.login");
        }else {
            request.setAttribute("errorMessagePassMessage",
                    ConfigUtils.getProperty("message.registration.error"));
            view = ConfigUtils.getProperty("path.page.registration");
        }
        return view;
    }
}

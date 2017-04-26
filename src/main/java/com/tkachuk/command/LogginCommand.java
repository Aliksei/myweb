package com.tkachuk.command;

import com.tkachuk.ConfigUtils;
import com.tkachuk.user.AccountService;
import com.tkachuk.user.User;

import javax.servlet.http.HttpServletRequest;

public class LogginCommand implements ICommand {

    public String execute(HttpServletRequest request, AccountService accountService) {
        String view ;
        String login = request.getParameter("login");
        String pass = request.getParameter("password");

        User user = accountService.getUserByLogin(login);

        if (user != null && user.getPassword().equals(pass) ) {


            String sessionId = request.getSession().getId();
            accountService.addSession(sessionId,user);

            request.setAttribute("user", login);
            view = ConfigUtils.getProperty("path.page.main");
        } else {
            request.setAttribute("errorLoginPassMessage",
                    ConfigUtils.getProperty("message.loginerror"));
            view = ConfigUtils.getProperty("path.page.login");
        }
        return view;
    }
}

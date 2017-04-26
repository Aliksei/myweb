package com.tkachuk.command;

import com.tkachuk.ConfigUtils;
import com.tkachuk.user.AccountService;

import javax.servlet.http.HttpServletRequest;

public class LogoutCommand implements ICommand {

    public String execute(HttpServletRequest request, AccountService accountService) {
        String page = ConfigUtils.getProperty("path.page.index");
        String sessionId = request.getSession().getId();
        accountService.deleteSession(sessionId);
        request.getSession().invalidate();
        return page;
    }

}

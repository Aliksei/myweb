package com.tkachuk.command;

import com.tkachuk.ConfigUtils;
import com.tkachuk.user.AccountService;

import javax.servlet.http.HttpServletRequest;

public class EmptyCommand implements ICommand {

    public String execute(HttpServletRequest request, AccountService accountService) {
        String page = ConfigUtils.getProperty("path.page.login");
        return page;
    }
}

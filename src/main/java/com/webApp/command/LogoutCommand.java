package com.webApp.command;

import com.webApp.utils.ConfigUtils;

import javax.servlet.http.HttpServletRequest;

public class LogoutCommand implements ICommand {

    public String execute(HttpServletRequest request) {
        request.getSession().invalidate();
        return ConfigUtils.getProperty("path.page.index");
    }

}

package com.webApp.command;

import com.webApp.utils.ConfigUtils;

import javax.servlet.http.HttpServletRequest;

public class EmptyCommand implements ICommand {

    public String execute(HttpServletRequest request) {
        return  ConfigUtils.getProperty("path.page.login");
    }
}

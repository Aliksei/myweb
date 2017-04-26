package com.tkachuk.command;

import com.tkachuk.user.AccountService;

import javax.servlet.http.HttpServletRequest;

public interface ICommand {


    String execute(HttpServletRequest request, AccountService accountService);

}

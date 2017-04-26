package com.tkachuk.controller;

import com.tkachuk.ConfigUtils;
import com.tkachuk.command.CommandManager;
import com.tkachuk.command.ICommand;
import com.tkachuk.user.AccountService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/controller")
public class Servlet extends HttpServlet {

    private final AccountService accountService = new AccountService();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        handleRequest(req,resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        handleRequest(req,resp);
    }

    private void handleRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String view;

        CommandManager commandManager = new CommandManager();

        ICommand command = commandManager.defineCommand(req);
        view = command.execute(req,accountService);
        if (view != null){
            getServletContext().getRequestDispatcher(view).forward(req,resp);
        }else {
            view = ConfigUtils.getProperty("path.page.index");
            req.getSession().setAttribute("nullPage",
                    ConfigUtils.getProperty("message.nullpage"));
            resp.sendRedirect(req.getContextPath() + view);
        }
    }

}
package com.webApp.controller;

import com.webApp.command.CommandManager;
import com.webApp.command.ICommand;
import com.webApp.dao.UserDaoXmlImpl;
import com.webApp.utils.ConfigUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/controller")
public class Servlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        getServletContext().setAttribute("dao",new UserDaoXmlImpl());
    }

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
        view = command.execute(req);
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
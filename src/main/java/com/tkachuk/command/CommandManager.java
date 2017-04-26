package com.tkachuk.command;

import javax.servlet.http.HttpServletRequest;

public class CommandManager {

    public ICommand defineCommand(HttpServletRequest request){

        ICommand currentCommand = new EmptyCommand();
        String command = request.getParameter("command");
        if (command == null || command.isEmpty() ){
            return currentCommand;
        }
        CommandTypes currentEnum = CommandTypes.valueOf(command.toUpperCase());
        currentCommand = currentEnum.getCurrentCommand();
        return currentCommand;
    }

}

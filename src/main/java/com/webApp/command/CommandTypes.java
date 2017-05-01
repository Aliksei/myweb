package com.webApp.command;

public enum CommandTypes {

    LOGIN {
        {
            this.command = new LogginCommand();
        }
    },
    LOGOUT {
        {
            this.command = new LogoutCommand();
        }
    },
    REGISTER{
        {
            this.command = new RegisterCommand();
        }
    };

    ICommand command;

    public ICommand getCurrentCommand(){
        return command;
    }

}

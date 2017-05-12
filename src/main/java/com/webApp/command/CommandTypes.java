package com.webApp.command;

public enum CommandTypes {

    LOGIN {
        {
            this.command = new LogginCommand();
        }
    },
    BUY {
        {
            this.command = new BuyCommand();
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

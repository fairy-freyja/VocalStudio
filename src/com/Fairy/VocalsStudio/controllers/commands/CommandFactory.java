package com.Fairy.VocalsStudio.controllers.commands;

/**
 * Created by Wyvern on 12.05.2015.
 */
public class CommandFactory {

    public Command getCommand(String uri){

        switch (uri) {
            case "/login":
                return new LoginCommand();
            case "/registration":
                return new RegistrationCommand();
            case "/userHome":
                return new UserHomeCommand();
        }

        return null;
    }


}

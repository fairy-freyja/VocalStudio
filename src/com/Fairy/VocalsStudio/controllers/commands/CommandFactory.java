package com.Fairy.VocalsStudio.controllers.commands;

/**
 * Created by Wyvern on 12.05.2015.
 */
public class CommandFactory {

    public static Command getCommand(String uri){

        switch (uri) {
            case "/":
                return new DefaultCommand();
            case "/login":
                return new LoginCommand();
            case "/registration":
                return new RegistrationCommand();
            case "/userHome":
                return new UserHomeCommand();
            case "/lessonRequest":
                return new LessonRequestCommand();
            case "/some":
                return new SomeCommand();
            case "/adminSchedule":
                return new AdminScheduleCommand();
            case "/confirmed":
                return new ConfirmedCommand();
            case "/profile":
                return new ProfileCommand();
            case "/usersList":
                return new UserListCommand();
            default:
//                return null;
                return new ErrorCommand();
        }
    }
}

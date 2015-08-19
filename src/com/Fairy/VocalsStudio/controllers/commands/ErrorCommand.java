package com.Fairy.VocalsStudio.controllers.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Fairy on 6/2/2015.
 */
public class ErrorCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return "error.jsp";
    }
}

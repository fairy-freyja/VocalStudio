package com.Fairy.VocalsStudio.controllers.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Fairy on 5/26/2015.
 */
public class DefaultCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return "index.jsp";
    }
}

package com.Fairy.VocalsStudio.controllers.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Fairy on 5/27/2015.
 */
public class SomeCommand implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getMethod().toLowerCase().equals("post")){
            String select1 = req.getParameter("date");
            if(select1 != null) {
                req.getSession().setAttribute("select1", "you choose" + select1);
            }

        }

        return "index.jsp";
    }
}

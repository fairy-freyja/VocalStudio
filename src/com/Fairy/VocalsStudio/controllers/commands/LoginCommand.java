package com.Fairy.VocalsStudio.controllers.commands;

import com.Fairy.VocalsStudio.services.LoginService;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Wyvern on 12.05.2015.
 */
public class LoginCommand implements Command {
    private LoginService ls = new LoginService();
    private Logger log = Logger.getLogger(LoginCommand.class);

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {


        if (req.getMethod().toLowerCase().equals("get")) {

            if(req.getParameter("submit.logout") != null){
                req.getSession().invalidate();
                log.log(Level.INFO, "user logout, session have been invalidate");
                req.getSession().setAttribute("menu", "simpleMenu");
            }
            return "index.jsp";
        }

        resp.setContentType("text/html; charset=UTF-8");

        String loginParam = req.getParameter("login");
        String passwordParam = req.getParameter("password");

        if (ls.checkLoginPass(loginParam, passwordParam)) {
            req.getSession().setAttribute("user", ls.findUserByLogin(loginParam));
            String role = ls.findUserByLogin(loginParam).getRole();
            req.getSession().setAttribute("role", role);
            try {
                if(role.equals("user")) {
                    resp.sendRedirect("/userHome");
                } else {
                    resp.sendRedirect("/");
                }
                String massage = "user \"" + loginParam + "\" have been logged";
                log.log(Level.INFO, massage);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        } else {
            req.setAttribute("Failed", "wrong login or password");
            log.log(Level.ERROR,"Failed wrong login or password");
        }
        log.log(Level.INFO, "ololo");
        return "index.jsp";
    }
}

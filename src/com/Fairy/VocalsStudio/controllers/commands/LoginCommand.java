package com.Fairy.VocalsStudio.controllers.commands;

import com.Fairy.VocalsStudio.dao.DaoFactory;
import com.Fairy.VocalsStudio.dao.UserDao;
import com.Fairy.VocalsStudio.models.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 * Created by Wyvern on 12.05.2015.
 */
public class LoginCommand implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {

        if(req.getMethod().toLowerCase().equals("get")){
            return "index.jsp";
        }

        resp.setContentType("text/html; charset=UTF-8");

        System.out.println("get connection to DB");
        String loginParam = req.getParameter("login");

        UserDao ud = DaoFactory.getInstance().createUserDao();
        User user = null;
        try {
            user = ud.findByLogin(loginParam);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (user != null) {
            String passwordParam = req.getParameter("password");
            System.out.println("req.getParameter(login) = " + loginParam);
            if (user.getPassword().equals(passwordParam)) {
                req.getSession().setAttribute("user", user);
                return "/userHome";
            } else {
                System.out.println("in else");
                req.setAttribute("Failed", "Неправильный пароль");
            }
        } else {
            req.setAttribute("Failed", "Нету такого пользователя, попробуйте снова.");

        }
//        req.getRequestDispatcher("/login").forward(req, resp);
        return "/login";
    }

}

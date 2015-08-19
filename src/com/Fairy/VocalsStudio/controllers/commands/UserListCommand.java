package com.Fairy.VocalsStudio.controllers.commands;

import com.Fairy.VocalsStudio.dao.DaoFactory;
import com.Fairy.VocalsStudio.dao.UserDao;
import com.Fairy.VocalsStudio.models.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Fairy on 6/12/2015.
 */
public class UserListCommand implements Command {
    private UserDao ud = DaoFactory.getInstance().createUserDao();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        List<User> users = ud.findAll();
        request.getSession().setAttribute("listUser", users);
        return "index.jsp";
    }
}

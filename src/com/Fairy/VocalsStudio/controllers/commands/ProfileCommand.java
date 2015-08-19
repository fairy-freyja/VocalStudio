package com.Fairy.VocalsStudio.controllers.commands;

import com.Fairy.VocalsStudio.dao.DaoFactory;
import com.Fairy.VocalsStudio.dao.UserDao;
import com.Fairy.VocalsStudio.models.User;
import com.Fairy.VocalsStudio.models.UserBuilder;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 * Created by Fairy on 6/12/2015.
 */
public class ProfileCommand implements Command {
    private UserDao ud = DaoFactory.getInstance().createUserDao();
    private Logger log = Logger.getLogger(ProfileCommand.class);

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {

        if(req.getMethod().toLowerCase().equals("post")) {
            int id = Integer.parseInt(req.getParameter("id"));
            String login = req.getParameter("login");
            String password = req.getParameter("password");
            String name = req.getParameter("name");
            String surname = req.getParameter("surname");
            String phoneNumber = req.getParameter("phoneNumber");
            String email = req.getParameter("email");
            String sex = req.getParameter("sex");
            User newUser = new UserBuilder().setIdUser(id).setLogin(login).setPassword(password).setName(name)
                    .setSurname(surname).setPhoneNumber(phoneNumber).setEmail(email).setSex(sex).build();
            try {
                ud.update(newUser);
                req.getSession().setAttribute("user", newUser);
            } catch (SQLException e) {
                e.printStackTrace();
                log.log(Level.ERROR, e);
            }
        } else {
            if (req.getParameter("idUser") != null) {

                int idUser = Integer.parseInt(req.getParameter("idUser"));
                User user = null;
                try {
                    user = ud.find(idUser);
                } catch (SQLException e) {
                    e.printStackTrace();
                    log.log(Level.ERROR, e);
                }
                req.getSession().setAttribute("currentUser", user);
            } else {
                System.out.println("currentUser = user");
                req.getSession().setAttribute("currentUser", req.getSession().getAttribute("user"));
            }
        }
        return "index.jsp";
    }
}

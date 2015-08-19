package com.Fairy.VocalsStudio.controllers.commands;

import com.Fairy.VocalsStudio.models.User;
import com.Fairy.VocalsStudio.models.UserBuilder;
import com.Fairy.VocalsStudio.services.RegisterService;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


/**
 * Created by Wyvern on 13.05.2015.
 */
public class RegistrationCommand implements Command{
    private RegisterService rs = new RegisterService();

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {

        if(req.getMethod().toLowerCase().equals("get")){
            return "index.jsp";
        }

        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String sex = req.getParameter("sex");
        String phone_number = req.getParameter("phone_number");

        if(rs.checkRegisterInputs(login, password, email)) {
            System.out.println("input validate OK");
            if(rs.createUser(login, password, name, surname, phone_number, email, sex)){
                User user = rs.findUserByLogin(login);
                req.getSession().setAttribute("user", user);
                req.getSession().setAttribute("role", user.getRole());
                try {
                    resp.sendRedirect("/userHome");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }
        }
        req.setAttribute("Failed", "Invalid login or password");
        return "index.jsp";
    }
}

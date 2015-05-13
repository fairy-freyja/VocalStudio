package com.Fairy.VocalsStudio.controllers.commands;

import com.Fairy.VocalsStudio.logic.DBConnectionFactory;
import com.Fairy.VocalsStudio.logic.InputValidator;
import com.Fairy.VocalsStudio.models.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Wyvern on 13.05.2015.
 */
public class RegistrationCommand implements Command{
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
        String role = "user";
        String phone_number = req.getParameter("phone_number");

        System.out.println(login + " " + password);

        if(login != null && password != null && email != null
                && InputValidator.validateLogin(login)
                && InputValidator.validatePassword(password)
                && InputValidator.validateEmail(email)){
            System.out.println("input validate OK");

            Connection con = null;
            try{
                con = DBConnectionFactory.getDBConnection();
//                id_user | login | password | name     | surname | phone_number | email   | sex  | role
                con.createStatement().executeUpdate("INSERT into users VALUES ('" + login
                        + "', '" + password + "', '" + name + "', '" + surname + "', '" +  phone_number + "', '" +  email + "', '" + sex  + "', '" + role + "');");
                User user = new User(login, password, email);
                req.setAttribute("user", user);
                return "/userHome" ;
            } catch (SQLException e) {
                e.printStackTrace();
            } finally{
                if(con != null)
                    try {
                        con.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
            }
        } else {
            req.setAttribute("Failed", "Invalid login or password" );
            return "WEB-INF/registr.jsp";
        }

        return null;
    }


}

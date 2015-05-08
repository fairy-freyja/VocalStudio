package com.Fairy.VocalsStudio.servlets;

/**
 * Created by Wyvern on 08.05.2015.
 */

import com.Fairy.VocalsStudio.models.UserBean;
import com.Fairy.VocalsStudio.models.DBConnectionFactory;
import com.Fairy.VocalsStudio.models.InputValidator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Wyvern on 19.04.2015.
 */
@WebServlet ("/registration")
public class Register extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String email = req.getParameter("email");

        System.out.println(login + " " + password);
        if(login != null && password != null && email != null
                && InputValidator.validateLogin(login)
                && InputValidator.validatePassword(password)
                && InputValidator.validateEmail(email)){
            System.out.println("lololo");
            Connection con = null;
            try{
                con = DBConnectionFactory.getDBConnection();
                con.createStatement().executeUpdate("INSERT into auth VALUES ('" + login
                        + "'," + Integer.valueOf(password) + ", '" + email + "');");
                UserBean user = new UserBean(login, password, email);
                req.setAttribute("user", user);
                req.getRequestDispatcher("/registration").forward(req, resp);
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
            req.getRequestDispatcher("/register").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/regestr.jsp").forward(req, resp);
    }
}

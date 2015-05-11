package com.Fairy.VocalsStudio.servlets;

import com.Fairy.VocalsStudio.models.DBConnectionFactory;
import com.Fairy.VocalsStudio.models.UserBean;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/login")
public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("login post");
        Connection con = null;
        resp.setContentType("text/html; charset=UTF-8");
        UserBean user;
        try {
            con = DBConnectionFactory.getDBConnection();

            System.out.println("get connection to DB");
            String loginParam = req.getParameter("login");
            String passwordParam = req.getParameter("password");
            System.out.println("req.getParameter(login) = " + loginParam);
            ResultSet result = con.createStatement().executeQuery("SELECT * FROM users WHERE login='" +
                    loginParam + "';");

            if (result.next()) {
                int id_userBD  = result.getInt("id_user");
                String loginBD = result.getString("login");
                String passwordBD = result.getString("password");
                String nameBD = result.getString("name");
                String surnameBD = result.getString("surname");
                int phone_numberBD = result.getInt("phone_number");
                String emailBD = result.getString("email");
                String sexBD = result.getString("sex");
                String roleBD = result.getString("role");



                if (passwordBD.equals(passwordParam)) {
                    user = new UserBean(id_userBD, loginBD, passwordBD, nameBD, surnameBD, phone_numberBD, emailBD, sexBD, roleBD);
                    req.getSession().setAttribute("user", user);
                    req.getRequestDispatcher("/userHome").forward(req, resp);
                } else {
                    System.out.println("in else");
                    req.setAttribute("Failed", "Неправильный пароль");
                    req.getRequestDispatcher("/login").forward(req, resp);
                }
            } else {
                req.setAttribute("Failed", "Нету такого пользователя, попробуйте снова.");
                req.getRequestDispatcher("/login").forward(req, resp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/login.jsp").forward(req, resp);
    }
}

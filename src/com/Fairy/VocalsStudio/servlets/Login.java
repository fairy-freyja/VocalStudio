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
            System.out.println("req.getParameter(login) = " + loginParam);
            ResultSet result = con.createStatement().executeQuery("SELECT * FROM users WHERE login='" +
                   loginParam + "';");

            if (result.next()) {
                int id_userBD  = result.getInt("id_user");
                System.out.println("get id_userBD - success; id_userBD = " + id_userBD );

                String loginBD = result.getString("login");
                System.out.println("get loginBD - success; loginBD = " + loginBD );

                String passwordBD = result.getString("password");
                System.out.println("get passwordBD - success; passwordBD = " + passwordBD );

                String nameBD = result.getString("name");
                System.out.println("get nameBD - success; nameBD = " + nameBD);

                String surnameBD = result.getString("surname");
                System.out.println("get surnameBD - success; surnameBD = " + surnameBD);

                int phone_numberBD = result.getInt("phone_number");
                System.out.println("get phone_numberBD - success; phone_numberBD = " + phone_numberBD);

                String emailBD = result.getString("email");
                System.out.println("get emailBD - success; emailBD = " + emailBD);

                String sexBD = result.getString("sex");
                System.out.println("get sexBD - success; sexBD = " + sexBD);

                String roleBD = result.getString("role");
                System.out.println("get roleBD - success; nameBD = " + nameBD);

                String passwordParam = req.getParameter("password");
                System.out.println("result is not null, passwordBD = " + passwordBD + " passwordParam = " + passwordParam);

                if (passwordBD.equals(passwordParam)) {
                    user = new UserBean(id_userBD, loginBD, passwordBD, nameBD, surnameBD, phone_numberBD, emailBD, sexBD, roleBD);
                    req.getSession().setAttribute("user", user);
                    req.getRequestDispatcher("/userHome").forward(req, resp);
                } else {
                    System.out.println("in else");
                    req.setAttribute("Failed", "Неправильный пароль");
                    req.getRequestDispatcher("WEB-INF/login.jsp").forward(req, resp);
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

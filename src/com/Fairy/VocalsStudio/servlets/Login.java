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
        Connection con = null;
        resp.setContentType("text/html; charset=UTF-8");
        UserBean user;
        try {
            con = DBConnectionFactory.getDBConnection();
            ResultSet result = con.createStatement().executeQuery("SELECT * FROM auth WHERE login='" +
                    req.getParameter("login") + "';");
            if (result.next()) {

                System.out.println(Integer.valueOf(req.getParameter("password")));
                if (result.getInt("password") == Integer.valueOf(req.getParameter("password"))) {
                    user = new UserBean(result.getString("login"), String.valueOf(result.getInt("password")), result.getString("email"));
                    req.getSession().setAttribute("user", user);
                    req.getRequestDispatcher("/login").forward(req,resp);
                } else {
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

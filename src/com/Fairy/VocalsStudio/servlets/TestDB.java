package com.Fairy.VocalsStudio.servlets;

import com.Fairy.VocalsStudio.models.DBConnectionFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Hashtable;

/**
 * Created by Wyvern on 03.05.2015.
 */
public class TestDB extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection con = null;
        try {
            con = DBConnectionFactory.getDBConnection();
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM users");
            while (rs.next()) {
                resp.getWriter().println(rs.getString("name"));
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
}

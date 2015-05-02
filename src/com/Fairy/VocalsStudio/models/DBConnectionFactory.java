package com.Fairy.VocalsStudio.models;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Wyvern on 03.05.2015.
 */
public class DBConnectionFactory {
    private static volatile DataSource ds;

    private static synchronized void init() {
        if (ds == null) {
            try {
                ds = (DataSource) new InitialContext().lookup("java:comp/env/jdbc/MyDataSource");
            } catch (NamingException e) {
                e.printStackTrace();
            }
        }
    }

    public static Connection getDBConnection() throws SQLException {
        if (ds == null) {
            init();
        }
        return ds.getConnection();
    }
}

package com.Fairy.VocalsStudio.dao;

import com.Fairy.VocalsStudio.jdbc.JdbcDaoFactory;

/**
 * Created by Wyvern on 12.05.2015.
 */
public abstract class DaoFactory {
    public static DaoFactory getInstance(){
        return new JdbcDaoFactory();
    };
    public abstract UserDao createUserDao();
}

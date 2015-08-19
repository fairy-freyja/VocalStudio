package com.Fairy.VocalsStudio.dao;

import com.Fairy.VocalsStudio.jdbc.JdbcDaoFactory;

/**
 * Created by Wyvern on 12.05.2015.
 */
public abstract class DaoFactory {

    private static DaoType daoType;

    public static DaoFactory getInstance(){
        switch (daoType) {
            case JDBC:
                return new JdbcDaoFactory();
            default:
                // TODO: right some error massage in default case
                return new JdbcDaoFactory();
        }
    }

    public abstract UserDao createUserDao();

    public abstract LessonRequestDao createLessonRequestDao();

    public abstract MaterialsDao createMaterialsDao();

    public static void setType(DaoType type){
        daoType = type;
    }

    public enum DaoType{
        JDBC;
    }
}

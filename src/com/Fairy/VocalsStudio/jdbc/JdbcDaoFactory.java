package com.Fairy.VocalsStudio.jdbc;

import com.Fairy.VocalsStudio.dao.DaoFactory;
import com.Fairy.VocalsStudio.dao.LessonRequestDao;
import com.Fairy.VocalsStudio.dao.MaterialsDao;
import com.Fairy.VocalsStudio.dao.UserDao;

/**
 * Created by Wyvern on 12.05.2015.
 */
public class JdbcDaoFactory extends DaoFactory {
    @Override
    public UserDao createUserDao() {
        return new JdbsUserDao();
    }

    @Override
    public LessonRequestDao createLessonRequestDao() {
        return new JdbcLessonRequestDao();
    }

    @Override
    public MaterialsDao createMaterialsDao() {
        return null;
    }
}

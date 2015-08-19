package com.Fairy.VocalsStudio.services;

import com.Fairy.VocalsStudio.dao.DaoFactory;
import com.Fairy.VocalsStudio.dao.UserDao;
import com.Fairy.VocalsStudio.models.User;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.sql.SQLException;

/**
 * Created by Fairy on 6/12/2015.
 */
public class ProfileService {
    private UserDao ud = DaoFactory.getInstance().createUserDao();
    private Logger log = Logger.getLogger(UserHomeService.class);

    public int updateUser(User value){
        int countUpdate = 0;
        try {
            countUpdate = ud.update(value);
        } catch (SQLException e) {
            e.printStackTrace();
            log.log(Level.ERROR, e);
        }
        return countUpdate;
    }
}

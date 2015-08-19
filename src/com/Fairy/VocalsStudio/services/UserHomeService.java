package com.Fairy.VocalsStudio.services;

import com.Fairy.VocalsStudio.dao.DaoFactory;
import com.Fairy.VocalsStudio.dao.LessonRequestDao;
import com.Fairy.VocalsStudio.dao.UserDao;
import com.Fairy.VocalsStudio.models.LessonRequest;
import com.Fairy.VocalsStudio.models.User;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Fairy on 6/10/2015.
 */
public class UserHomeService {
    private LessonRequestDao lrd = DaoFactory.getInstance().createLessonRequestDao();
    private Logger log = Logger.getLogger(UserHomeService.class);
    private UserDao ud = DaoFactory.getInstance().createUserDao();

    public List<LessonRequest> findConfirmedByUserID(int id)throws SQLException {
        try {
            List<LessonRequest> listLR = lrd.findByStatusForUser(id, "confirmed");
            return listLR;
        } catch (SQLException e) {
            e.printStackTrace();
            log.log(Level.ERROR, e);
        }
        return null;
    }

    public List<LessonRequest> findNotConfirmedByUserID(int id) throws SQLException {
        try {
            List<LessonRequest> listLR = lrd.findByStatusForUser(id, "not confirmed");
            return listLR;
        } catch (SQLException e) {
            e.printStackTrace();
            log.log(Level.ERROR, e);
        }
        return null;
    }

    public User findUser(int id) {
        try {
            return ud.find(id);
        } catch (SQLException e) {
            e.printStackTrace();
            log.log(Level.ERROR, e);
        }
        return null;
    }
}

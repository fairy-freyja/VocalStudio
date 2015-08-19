package com.Fairy.VocalsStudio.services;

import com.Fairy.VocalsStudio.dao.DaoFactory;
import com.Fairy.VocalsStudio.dao.LessonRequestDao;
import com.Fairy.VocalsStudio.dao.UserDao;
import com.Fairy.VocalsStudio.models.LessonRequest;
import com.Fairy.VocalsStudio.models.User;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fairy on 6/11/2015.
 */
public class AdminScheduleService {
    private Logger log = Logger.getLogger(AdminScheduleService.class);
    private LessonRequestDao lrd = DaoFactory.getInstance().createLessonRequestDao();
    private UserDao ud = DaoFactory.getInstance().createUserDao();

    public List<LessonRequest> selectConfirmed(){
            List<LessonRequest> result = null;
            Date date = new Date(new java.util.Date().getTime());
            try {
                result = lrd.selectByStatusForAdmin("confirmed", date);
            } catch (SQLException e) {
                e.printStackTrace();
                log.log(Level.ERROR, e);
            }
            return result;
    }

    public List<LessonRequest> selectNotConfirmed(){
        List<LessonRequest> result = null;
        Date date = new Date(new java.util.Date().getTime());
        try {
            result = lrd.selectByStatusForAdmin("not confirmed", date);
        } catch (SQLException e) {
            e.printStackTrace();
            log.log(Level.ERROR, e);
        }
        return result;
    }

    public List<User> selectUserWithConfirmedRequests ()throws SQLException{
        List<User> result = null;
        try {
            result = ud.selectUsersByLRStatus("confirmed");
        } catch (SQLException e) {
            e.printStackTrace();
            log.log(Level.ERROR, e);
        }
        return result;
    }

    public List<User> selectUserWithNotConfirmedRequests ()throws SQLException{
        List<User> result = null;
        try {
            result = ud.selectUsersByLRStatus("not confirmed");
        } catch (SQLException e) {
            e.printStackTrace();
            log.log(Level.ERROR, e);
        }
        return result;
    }

    public List<LessonRequest> findAllByUserID(int id) throws SQLException {
        try {
            List<LessonRequest> listLR = lrd.findAllByUserID(id);
            return listLR;
        } catch (SQLException e) {
            e.printStackTrace();
            log.log(Level.ERROR, e);
        }
        return null;
    }

    public void completeLRUser(LessonRequest lr) {
        User user = lr.getLrUser();
        try {
            user = ud.find(user.getIdUser());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        lr.setLrUser(user);
    }
}

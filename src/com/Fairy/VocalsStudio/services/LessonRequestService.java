package com.Fairy.VocalsStudio.services;

import com.Fairy.VocalsStudio.dao.DaoFactory;
import com.Fairy.VocalsStudio.dao.LessonRequestDao;
import com.Fairy.VocalsStudio.dao.UserDao;
import com.Fairy.VocalsStudio.models.LessonRequest;
import com.Fairy.VocalsStudio.models.LessonRequestBuilder;
import com.Fairy.VocalsStudio.models.User;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
**
 * Created by Fairy on 6/9/2015.
 */
public class LessonRequestService {
    private LessonRequestDao lrd = DaoFactory.getInstance().createLessonRequestDao();
    private UserDao ud = DaoFactory.getInstance().createUserDao();
    private Logger log = Logger.getLogger(LessonRequestService.class);

    public LessonRequestService(){}

    public void createLessonRequest(int id, String date, String time) throws SQLException {
        LessonRequest lr = new LessonRequestBuilder().setLrIdUser(id).setDate(date).setTime(time).build();

        lrd.create(lr);
    }

    public void createLessonRequest(User user, String date, String time) throws SQLException {
        LessonRequest lr = new LessonRequestBuilder().setLrIdUser(user).setDate(date).setTime(time).build();
        lrd.create(lr);
    }



}

package com.Fairy.VocalsStudio.controllers.commands;

import com.Fairy.VocalsStudio.dao.DaoFactory;
import com.Fairy.VocalsStudio.dao.LessonRequestDao;
import com.Fairy.VocalsStudio.models.LessonRequest;
import com.Fairy.VocalsStudio.models.LessonRequestBuilder;
import com.Fairy.VocalsStudio.models.User;
import com.Fairy.VocalsStudio.services.LessonRequestService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Wyvern on 22.05.2015.
 */
public class LessonRequestCommand implements Command {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {

        LessonRequestService lrs = new LessonRequestService();

        if(req.getMethod().toLowerCase().equals("get")){
            return "index.jsp";
        }


        User user = (User) req.getSession().getAttribute("user");

        String d =  req.getParameter("date");
        String t = req.getParameter("time") + ":00";
        int userId = user.getIdUser();

        try {
            lrs.createLessonRequest(userId, d, t);
        } catch (SQLException e) {
            req.setAttribute("LRFAILED", "Some failed in creation of lesson rquest");
            try {
                resp.sendRedirect("/lessonRequest");
                return null;
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        return "index.jsp";
    }
}

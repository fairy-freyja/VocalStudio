package com.Fairy.VocalsStudio.controllers.commands;

import com.Fairy.VocalsStudio.dao.DaoFactory;
import com.Fairy.VocalsStudio.dao.LessonRequestDao;
import com.Fairy.VocalsStudio.services.LessonRequestService;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 * Created by Fairy on 6/11/2015.
 */
public class ConfirmedCommand implements Command {
    LessonRequestDao lrd = DaoFactory.getInstance().createLessonRequestDao();
    LessonRequestService lrs = new LessonRequestService();
    private Logger log = Logger.getLogger(ConfirmedCommand.class);

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        String confirmed = req.getParameter("idLessonRequest");
        System.out.println("id lesson request is " +confirmed);
        if(confirmed != null) {
            try {
                int i = lrd.changeStatus(Integer.parseInt(confirmed), "confirmed");
                if(i>0) {
                    req.getSession().setAttribute("message", "Status was change successfully");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                req.getSession().setAttribute("message", "Some trouble heppend with status changing");
                log.log(Level.ERROR, e);
            }
        }
        req.setAttribute("page", "someExample");
        return "index.jsp";
    }
}

package com.Fairy.VocalsStudio.controllers.commands;

import com.Fairy.VocalsStudio.models.LessonRequest;
import com.Fairy.VocalsStudio.services.AdminScheduleService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Fairy on 6/11/2015.
 */
public class AdminScheduleCommand implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        AdminScheduleService ass = new AdminScheduleService();
        System.out.println("");

        List<LessonRequest> listLR = ass.selectConfirmed();
        for (LessonRequest lr : listLR) {
            ass.completeLRUser(lr);
        }
        req.getSession().setAttribute("listLRConfirmed", listLR);


        List<LessonRequest> listLRNot = ass.selectNotConfirmed();
        for (LessonRequest lr : listLRNot) {
            ass.completeLRUser(lr);
        }
        req.getSession().setAttribute("listLRNotConfirmed", listLRNot);

        return "index.jsp";
    }
}

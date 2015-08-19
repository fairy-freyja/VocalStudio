package com.Fairy.VocalsStudio.controllers.commands;

import com.Fairy.VocalsStudio.models.LessonRequest;
import com.Fairy.VocalsStudio.models.User;
import com.Fairy.VocalsStudio.services.UserHomeService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Wyvern on 13.05.2015.
 */
public class UserHomeCommand implements Command {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        UserHomeService uhs = new UserHomeService();

        User user = null;

        String id = req.getParameter("idUser");

        if(id != null){
           user = uhs.findUser(Integer.parseInt(id));
            req.getSession().setAttribute("currentUser", user);
        }else {
            user = (User) req.getSession().getAttribute("user");
        }

        try {
            List<LessonRequest> listLR = uhs.findConfirmedByUserID(user.getIdUser());
            req.getSession().setAttribute("listLRConfirmed", listLR);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            List<LessonRequest> listLR = uhs.findNotConfirmedByUserID(user.getIdUser());
            req.getSession().setAttribute("listLRNotConfirmed", listLR);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "index.jsp";
    }
}

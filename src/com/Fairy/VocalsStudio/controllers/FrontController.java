package com.Fairy.VocalsStudio.controllers;

import com.Fairy.VocalsStudio.controllers.commands.Command;
import com.Fairy.VocalsStudio.controllers.commands.CommandFactory;
import com.Fairy.VocalsStudio.dao.DaoFactory;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Wyvern on 12.05.2015.
 */
@WebServlet ("/")
public class FrontController extends HttpServlet {
    private Logger log = Logger.getLogger(FrontController.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.log(Level.INFO, "user do GET");
        process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.log(Level.INFO, "user do POST");
        process(req, resp);
    }

    private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DaoFactory.setType(DaoFactory.DaoType.JDBC);
        String uri = req.getRequestURI();
        log.log(Level.INFO, "uri = " + uri);
        String view = new CommandFactory().getCommand(uri).execute(req, resp);
        log.log(Level.INFO, "view = " + view);
        log.log(Level.INFO, "page = " + req.getAttribute("page"));
        if(view != null){
            req.getRequestDispatcher(view).forward(req, resp);
        }
    }
}

package com.Fairy.VocalsStudio.filters;

import com.Fairy.VocalsStudio.models.UserBean;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/**
 * Created by Wyvern on 08.05.2015.
 */
@WebFilter ("/registration")
public class LoggedFilter implements Filter {
    private FilterConfig fc;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        fc = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        HttpSession userSession = req.getSession(false);
        if(userSession != null){
            UserBean user = (UserBean) userSession.getAttribute("user");
            if(user != null){
                req.getRequestDispatcher("/userHome").forward(req, resp);
            }
        }
        filterChain.doFilter(req, resp);
    }

    @Override
    public void destroy() {

    }
}

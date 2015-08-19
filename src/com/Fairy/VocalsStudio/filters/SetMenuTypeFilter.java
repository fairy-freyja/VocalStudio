package com.Fairy.VocalsStudio.filters;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Fairy on 6/3/2015.
 */

@WebFilter("/*")
public class SetMenuTypeFilter implements Filter {
    private FilterConfig fc;
    private Logger log = Logger.getLogger(SetMenuTypeFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
       fc = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        String role = (String) req.getSession().getAttribute("role");

        if (role != null) {
            switch (role) {
                case "user":
                    req.getSession().setAttribute("menu", "userMenu");
                    log.log(Level.INFO, "set to session scope Attribute {menu} = userMenu");
                    break;
                case "admin":
                    req.getSession().setAttribute("menu", "adminMenu");
                    log.log(Level.INFO, "set to session scope Attribute {menu} = adminMenu");
                    break;
                default:
                    req.getSession().setAttribute("menu", null);
                    log.log(Level.ERROR, "set to session scope Attribute {menu} = null");
            }
        } else {
            req.getSession().setAttribute("menu", "simpleMenu");
            log.log(Level.INFO, "set to session scope Attribute {menu} = simpleMenu");
        }
        filterChain.doFilter(req, resp);
    }

    @Override
    public void destroy() {

    }
}

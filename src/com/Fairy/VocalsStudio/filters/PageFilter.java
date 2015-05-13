package com.Fairy.VocalsStudio.filters;

import com.Fairy.VocalsStudio.logic.PageMapping;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Created by Wyvern on 12.05.2015.
 */
@WebFilter ("/*")
public class PageFilter implements Filter {
    private FilterConfig fc;
    private PageMapping pm;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        fc = filterConfig;
        try {
            pm = new PageMapping();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        String path = req.getRequestURI();
        String page = pm.getValue(path);
        req.setAttribute("page", page);
        filterChain.doFilter(req, resp);
    }

    @Override
    public void destroy() {

    }


}

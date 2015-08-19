package com.Fairy.VocalsStudio.filters;

import com.Fairy.VocalsStudio.logic.PageMapping;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

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
    private String[] staticFiles = {".css", ".jpg", ".js", ".png", ".gif"};
    private Logger log = Logger.getLogger(PageFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        fc = filterConfig;
        try {
            pm = new PageMapping();
        } catch (IOException e) {
            log.log(Level.ERROR, "some problem with web/resources/properties/page_url_mapping.properties", e);
            e.printStackTrace();
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        String path = req.getRequestURI();
        log.log(Level.INFO, "path = " + path);

        boolean notStatic=true;
        for(String s:staticFiles){
            if(path.contains(s)){
                notStatic = false;
            }
        }

        if(notStatic) {
            String page = pm.getValue(path);
            req.setAttribute("page", page);
            log.log(Level.INFO, "set to request scope Attribute {page} = " + page);
        }
        filterChain.doFilter(req, resp);
    }

    @Override
    public void destroy() {
    }
}

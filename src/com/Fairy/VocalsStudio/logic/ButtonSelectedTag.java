package com.Fairy.VocalsStudio.logic;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * Created by Wyvern on 12.05.2015.
 */
public class ButtonSelectedTag extends SimpleTagSupport{
    private String check;

    public void setCheck(String check) {
        this.check = check;
    }

    @Override
    public void doTag() throws JspException, IOException {
        String text ="class=\"selected\"";
        PageContext pageContext = (PageContext) getJspContext();
        ServletRequest req = pageContext.getRequest();
        String currentPage = (String) req.getAttribute("page");
        if(check.equals(currentPage)){
            getJspContext().getOut().print(text);
        }
    }
}

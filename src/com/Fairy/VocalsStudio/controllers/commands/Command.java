package com.Fairy.VocalsStudio.controllers.commands;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Wyvern on 12.05.2015.
 */
public interface Command {
     public String execute(HttpServletRequest request, HttpServletResponse response);
}

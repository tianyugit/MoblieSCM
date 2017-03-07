package com.sise.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class SysInit implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent arg0) {

    }

    public void contextInitialized(ServletContextEvent event) {
        ServletContext application = event.getServletContext();
        String sysname = application.getInitParameter("sysname");
        application.setAttribute("sysname", sysname);
    }

}

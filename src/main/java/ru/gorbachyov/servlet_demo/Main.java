package ru.gorbachyov.servlet_demo;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Start main class");
        String weppAppHome = "C:/Users/gorba/IdeaProjects/servletHomework/src/main/webapp";
        Server server = new Server(8099);
        WebAppContext webapp = new WebAppContext();
        webapp.setContextPath("/");
        webapp.setCompactPath(true);
        webapp.setDescriptor(weppAppHome + "/WEB-INF/web.xml");
        webapp.setResourceBase(weppAppHome);
        webapp.setParentLoaderPriority(true);
        server.setHandler(webapp);
        server.start();
        System.out.println("OK: server started");


    }
}

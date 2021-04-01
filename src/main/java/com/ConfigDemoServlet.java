package com;

import jdk.nashorn.internal.objects.Global;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

public class ConfigDemoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username =request.getParameter("username");
        String studentid =request.getParameter("studentid");
        PrintWriter writer = response.getWriter();
        writer.println("<br>username :"+username);
        writer.println("<br>studentid :"+studentid);
        writer.close();


    }
}

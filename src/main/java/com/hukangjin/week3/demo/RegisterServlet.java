package com.hukangjin.week3.demo;

import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

//@WebServlet(
        //urlPatterns = {"/jdbc"},
        //initParams = {
                //@WebInitParam(name="driver",value = "com.microsoft.sqlserver.jdbc.SQLServerDriver"),
               // @WebInitParam(name="url",value = "jdbc:sqlserver://localhost;databaseName=userdb"),
                //@WebInitParam(name="username",value = "sa"),
               // @WebInitParam(name="password",value = "admin123456789")

        //},loadOnStartup = 1
//)

public class RegisterServlet extends HttpServlet {
    Connection con=null;
    public void init() throws ServletException {
        ServletConfig config = getServletConfig();
        String driver = config.getInitParameter("driver");
        String url = config.getInitParameter("url");
        String username = config.getInitParameter("username");
        String password = config.getInitParameter("password");

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
            System.out.println("init()-->" + con);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

        @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username =request.getParameter("username");
        String password =request.getParameter("password");
        String email =request.getParameter("email");
        String gender =request.getParameter("gender");
        String birthDate =request.getParameter("birthDate");
        //PrintWriter writer = response.getWriter();
        //writer.println("<br>username :"+username);
        //writer.println("<br> password :"+password);
        //writer.println("<br>email :"+email);
        //writer.println("<br>gender :"+gender);
        //writer.println("<br>birthDate :"+birthDate);
        //writer.close();
        response.setContentType("text/html charset=utf-8");
        PrintWriter out=response.getWriter();
        String sql1 = "select * from usertable ";
        try {
            ResultSet re = con.createStatement().executeQuery(sql1);
            out.println("<table border='1' align='center'>");
            out.println("<tr>");
            out.println("<td>"+"id"+"</td>");
            out.println("<td>"+"username"+"</td>");
            out.println("<td>"+"password"+"</td>");
            out.println("<td>"+"email"+"</td>");
            out.println("<td>"+"gender"+"</td>");
            out.println("<td>"+"birthdate"+"</td>");
            out.println("</tr>");
            while (re.next()) {

                out.println("<tr>");
                out.println("<td>"+re.getInt("id")+"</td>");
                out.println("<td>"+re.getString("username")+"</td>");
                out.println("<td>"+re.getString("password")+"</td>");
                out.println("<td>"+re.getString("email")+"</td>");
                out.println("<td>"+re.getString("gender")+"</td>");
                out.println("<td>"+re.getString("birthdate")+"</td>");
                out.println("</tr>");
            }
            out.println("</table>");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        PrintWriter writer=response.getWriter();
        writer.println("<br>username :"+ username);
        writer.println("<br>password :"+ password);
        writer.println("<br>email :"+ email);
        writer.println("<br>gender :"+ gender);
        writer.println("<br>birthDate :"+ birthDate);
        writer.close();
    }

}



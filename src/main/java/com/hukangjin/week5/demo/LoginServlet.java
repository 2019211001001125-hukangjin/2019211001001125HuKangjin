package com.hukangjin.week5.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "LoginServlet", value = "/login",
        initParams = {
                @WebInitParam(name="driver",value = "com.microsoft.sqlserver.jdbc.SQLServerDriver"),
                @WebInitParam(name="url",value = "jdbc:sqlserver://localhost;databaseName=userdb"),
                @WebInitParam(name="username",value = "sa"),
                @WebInitParam(name="password",value = "admin123456789")
        }
)
public class LoginServlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException{
        super.init();
        ServletConfig config=getServletConfig();
        String driver= config.getInitParameter("driver");
        String url= config.getInitParameter("url");
        String username= config.getInitParameter("username");
        String password= config.getInitParameter("password");

        try {
            Class.forName(driver);
            con= DriverManager.getConnection(url,username,password);
            System.out.println("连接成功");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String Password=request.getParameter("password");
        String sql = "select username,password from hkj where username='"+username+"' and password='"+Password+"'";
        PrintWriter out = response.getWriter();
        try {
            ResultSet rs = con.createStatement().executeQuery(sql);
            if(rs.next()){
                out.println("Login Success!!!");
                out.println("Welcome"+username);
            }else{
                out.println("Username or Password Error!!!");
            }
            out.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

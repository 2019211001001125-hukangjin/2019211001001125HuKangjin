package com.hukangjin.week5.demo;

import com.hukangjin.dao.UserDao;
import com.hukangjin.model.User;

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

        con= (Connection) getServletContext().getAttribute("con");



//        ServletConfig config=getServletConfig();
//        String driver= config.getInitParameter("driver");
//        String url= config.getInitParameter("url");
//        String username= config.getInitParameter("username");
//        String password= config.getInitParameter("password");
//
//        try {
//            Class.forName(driver);
//            con= DriverManager.getConnection(url,username,password);
//            System.out.println("连接成功");
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String Password = request.getParameter("password");
        UserDao userDao=new UserDao();
        try {
            User user=userDao.findByUsernamePassword(con,username, Password);
            if (user!=null){
                String rememberMe=request.getParameter("rememberMe");
                if (rememberMe!=null && rememberMe.equals("1")){
                    Cookie usernameCookie=new Cookie("cUsername",user.getUsername());
                    Cookie passwordCookie=new Cookie("cPassword",user.getPassword());
                    Cookie rememberMeCookie=new Cookie("cRememberMe",rememberMe);
                    usernameCookie.setMaxAge(5);
                    passwordCookie.setMaxAge(5);
                    rememberMeCookie.setMaxAge(5);
                    response.addCookie(usernameCookie);
                    response.addCookie(passwordCookie);
                    response.addCookie(rememberMeCookie);
                }
//                Cookie c=new Cookie("sessionid",""+user.getId());
//                        c.setMaxAge(10*60);
                HttpSession session=request.getSession();
                System.out.println("session id-->"+session.getId());
                session.setMaxInactiveInterval(10);


                session.setAttribute("user",user);
                request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request,response);
            }else{
                request.setAttribute("message","Username or Password Error!!!");
                request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

//        String sql = "select username,password from hkj where username='"+username+"' and password='"+Password+"'";
//        PrintWriter out = response.getWriter();
//        try {
//            ResultSet rs = con.createStatement().executeQuery(sql);
//            if(rs.next()){
//                out.println("Login Success!!!");
//                out.println("Welcome"+username);
//            }else{
//                out.println("Username or Password Error!!!");
//            }
//            out.close();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//    }
    }}

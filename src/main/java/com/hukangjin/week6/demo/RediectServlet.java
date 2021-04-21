package com.hukangjin.week6.demo;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
@WebServlet(name = "RediectServlet",value= "/rediect")
public class RediectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("before redirect");

        //response.sendRedirect("index.jsp");
        System.out.println("after redirect");
        response.sendRedirect("/2019211001001125HuKangjin_war_exploded/index.jsp");
        response.sendRedirect("https://www.baidu.com/");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

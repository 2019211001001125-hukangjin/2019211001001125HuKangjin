package com.hukangjin.controlle;

import com.hukangjin.dao.UserDao;
import com.hukangjin.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.SimpleTimeZone;

@WebServlet(name = "UpdateUserServlet", value = "/updateUser")
public class UpdateUserServlet extends HttpServlet {
    Connection con;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/updateUser.jsp").forward(request,response);

    }
    public void init() throws ServletException{
        con =(Connection)getServletContext().getAttribute("con");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        Integer id = Integer.parseInt(request.getParameter("id"));
        //Date birthDate = Date.valueOf(request.getParameter("brithDate"));
        Date birthDate=Date.valueOf(request.getParameter("birthdate"));
//        String birthdate = request.getParameter("birthDate");
        //SimpleDateFormat num =new SimpleDateFormat();
            User user=new User();
            user.setId(id);
            user.setUsername(username);
            user.setEmail(email);
            user.setGender(gender);
            user.setBirthDate(birthDate);
            user.setPassword(password);
            UserDao userDao=new UserDao();

//        } catch (ParseException e) {
//            e.printStackTrace();
//        }

        try {
            userDao.updateUser(con,user);
            HttpSession session=request.getSession();
            session.setMaxInactiveInterval(30);
            session.setAttribute("user",user);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request,response);
    }
}

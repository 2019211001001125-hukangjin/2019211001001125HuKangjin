<%--
  Created by IntelliJ IDEA.
  User: 86150
  Date: 2021/4/21
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>User Info</h1>
<%
    Cookie [] allCookies=request.getCookies();
    for (Cookie c:allCookies){
        out.println("<br/>"+c.getName()+"---"+c.getValue());
    }
%>
<table>
    <tr>
        <td>Username:</td><td><%=request.getAttribute("username")%></td>
    </tr><tr>
    <td>Password:</td><td><%=request.getAttribute("password")%></td>
</tr><tr>
    <td>Email:</td><td><%=request.getAttribute("email")%></td>
</tr><tr>
    <td>Gender:</td><td><%=request.getAttribute("gender")%></td>
</tr><tr>
    <td>Birth Date:</td><td><%=request.getAttribute("birthDate")%></td>
</tr>
</table>
<%@include file="footer.jsp"%>

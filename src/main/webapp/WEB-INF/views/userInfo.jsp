<%@ page import="com.hukangjin.model.User" %><%--
  Created by IntelliJ IDEA.
  User: 86150
  Date: 2021/4/21
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp"%>
<h1>User Info</h1>
<%

%>
<%
    User u=(User) session.getAttribute("user");
%>
<table>
        <td>Username:</td><td><%=u.getUsername()%></td>
    </tr><tr>
    <td>Password:</td><td><%=u.getPassword()%></td>
</tr>
    <tr>
    <td>Email:</td><td><%=u.getEmail()%></td>
</tr><tr>
    <td>Gender:</td><td><%=u.getGender()%></td>
</tr><tr>
    <td>Birth Date:</td><td><%=u.getBirthDate()%></td>
</tr>
</table>
<a href="updateUser">Update</a>
<%@include file="footer.jsp"%>

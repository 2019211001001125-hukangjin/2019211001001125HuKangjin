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
    User u1=(User) session.getAttribute("user");
%>
<table>
        <td>Username:</td><td><%=u1.getUsername()%></td>
    </tr><tr>
    <td>Password:</td><td><%=u1.getPassword()%></td>
</tr>
    <tr>
    <td>Email:</td><td><%=u1.getEmail()%></td>
</tr><tr>
    <td>Gender:</td><td><%=u1.getGender()%></td>
</tr><tr>
    <td>Birth Date:</td><td><%=u1.getBirthDate()%></td>
</tr>
</table>
<a href="updateUser">Update</a>
<%@include file="footer.jsp"%>

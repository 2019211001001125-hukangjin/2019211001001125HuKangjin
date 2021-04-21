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
    User user=(User) request.getAttribute("user");
%>
<table>
    <tr>
        <td>Username:</td><td><%=user.getUsername()%></td>
    </tr><tr>
    <td>Password:</td><td><%=user.getPassword()%></td>
</tr><tr>
    <td>Email:</td><td><%=user.getEmail()%></td>
</tr><tr>
    <td>Gender:</td><td><%=user.getGender()%></td>
</tr><tr>
    <td>Birth Date:</td><td><%=user.getBirthDate()%></td>
</tr>
</table>
<%@include file="footer.jsp"%>

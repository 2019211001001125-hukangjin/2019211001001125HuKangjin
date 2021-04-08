<%--
  Created by IntelliJ IDEA.
  User: 86150
  Date: 2021/4/8
  Time: 19:02
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp"%>
<h1><%= "Login" %></h1>
<form method="post" action="login">
    username<input type="text" name="username"/><br/>
    password<input type="password" name="password"/><br/>
    <input type="submit" value="login"/>
</form>
<%@include file="footer.jsp"%>

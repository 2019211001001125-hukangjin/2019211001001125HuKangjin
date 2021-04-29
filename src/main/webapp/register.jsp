<%--
  Created by IntelliJ IDEA.
  User: 86150
  Date: 2021/3/25
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp"%><br/>
<form method="post" action="config">
    username<input type="text" name="username"/><br/>
    password<input type="password" name="password"/><br/>
    Email<input type="text" name="email"/><br/>
    Gender:<input type="radio" name="gender" value="Male">Male<input type="radio" name="gender" value="Female">Female<br/>
    Date of Birth :<input type="text" name="birthDate"><br/>
    <input type="submit" value="config"/>
</form>
<%@include file="footer.jsp"%>


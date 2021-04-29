<%--
  Created by IntelliJ IDEA.
  User: 86150
  Date: 2021/4/8
  Time: 19:02
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp"%>
<h1><%= "Login" %></h1>
<%
    if(!((request.getAttribute("message"))==null)){
        out.println(request.getAttribute("message"));
    }
%>
<%
    Cookie[] allCookies=request.getCookies();
    String username="",password="",rememberMeVal="";
    if (allCookies!=null){
        for (Cookie c:allCookies) {
            if (c.getName().equals("cUsername")){
                username=c.getValue();
            }
            if (c.getName().equals("cPassword")){
                password=c.getValue();
            }
            if (c.getName().equals("cRememberMeVal")){
                rememberMeVal=c.getValue();
            }
        }
    }
%>
<form method="post" action="login">
    username<input type="text" name="username" value="<%=username%>"><br/>
    password<input type="password" name="password" value="<%=password%>"><br/>
<input type="checkbox" name="rememberMe" value="1" <%=rememberMeVal.equals(1) ?"checked":""%>checked/>RememberMe<br/>
    <input type="submit" value="login"/>
</form>
<%@include file="footer.jsp"%>

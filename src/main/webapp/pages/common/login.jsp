<%--
  Created by IntelliJ IDEA.
  User: SergLion
  Date: 24.02.2017
  Time: 19:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Login</title>
</head>
<body>
<c:out value="${sessionScope.message}"/>
<form name="loginForm" method="post" action="${pageContext.servletContext.contextPath}/login">
    Username: <input type="text" name="login"/> <br/>
    Password: <input type="password" name="password"/> <br/>
    <input type="submit" value="Login"/>

</form>


</body>
</html>

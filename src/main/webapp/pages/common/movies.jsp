<%--
  Created by IntelliJ IDEA.
  User: SergLion
  Date: 23.02.2017
  Time: 22:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
<c:forEach items="${movieDTOList}" var="movies">
    <a href="${pageContext.servletContext.contextPath}/movie?id=${movies.id}">${movies.title}</a><br/>
    </c:forEach>
</center>
</body>
</html>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 style="color:green" align="center">This is Welcome page</h1>
<br>
<form:form method="POST" action="${pageContext.request.contextPath}/logout">
<input type="submit" value="LOGOUT">
</form:form>
</body>
</html>
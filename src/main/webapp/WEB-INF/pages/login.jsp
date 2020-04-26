<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>LOGIN PAGE</h1><br>

<%
if(request.getParameter("error")!=null)
{
	%>
	<h1>Invalid Username or password</h1>
	<%
}
%>

<form:form method="POST" action="${pageContext.request.contextPath}/login">

Enter Username<input type="text" name="username"><br>
Enter Password<input type="password" name="password"><br>
<input type="submit" value="SIGNIN">
</form:form>

</body>
</html>
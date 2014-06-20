<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Application Home Page</title>
</head>
<body>
	<c:choose>
		<c:when test="${not empty email}">
			Welcome, ${email} (<a href="<c:url value="/logout" />">Logout</a>)
			<br>
			You have reached application home page
		</c:when>
		<c:otherwise>
		<%
		response.sendRedirect("/sign-in");
		%>
		</c:otherwise>
	</c:choose>
</body>
</html>
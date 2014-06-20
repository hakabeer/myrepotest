<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="jumbotron">				
	<c:url value="/login" var="loginAction" />
	<form:form commandName="loginForm" action="${loginAction}" method="POST">
		<form:input path="email" placeholder="email" />
		<form:password path="password" placeholder="password" />
		<button>Login</button>
	</form:form>
</div>
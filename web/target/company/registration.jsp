<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.Map"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<fmt:setLocale value="${locale}" />
<fmt:setBundle basename="local" />

<title><fmt:message key="rregistration" /></title>
</head>
<body>
	<header>
		<h1>
			<fmt:message key="rregistration" />
		</h1>
	</header>

	<section>
		<div>
			<form action="Controller" method="post">
				<fmt:message key="login" />
				: <input type="text" name="login">
				<c:out value="${messages['login']}" />
				<br> <br>
				<fmt:message key="password" />
				: <input type="password" name="password">
				<c:out value="${messages['password']}" />
				<br> <br> <input type="submit"
					value="<fmt:message key="login" />"> <input type="hidden"
					name="page" value="registration" />
			</form>
		</div>
	</section>
	<footer>
		<p><fmt:formatDate value="${now}" dateStyle="full"/> 
		<p>
	</footer>
</body>
</html>

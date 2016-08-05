<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<fmt:setLocale value="${locale}" />
<fmt:setBundle basename="local" />

<title><fmt:message key="my" /></title>
</head>
<body>
	<header>
		<h1>
			<fmt:message key="my" />
		</h1>
	</header>
	<nav>
		<a href="Controller?page=MY_ORDERS"><button>
				<fmt:message key="orders" />
			</button></a> <a href="Controller?page=NOT_CAR"><button>
				<fmt:message key="make" />
			</button></a>

		<div>
			<form action="Controller" method="post">
				<input type="hidden" name="page" value="CLIENT_PAGE" /> 
				<input type="submit" value="<fmt:message key="logout" />">
			</form>
			<form action="Controller" method="post">
				<input type="hidden" name="page" value="DELETE_ACCOUNT" /> 
				<input type="submit" value="<fmt:message key="deleteAcount" />">
			</form>
		</div>
	</nav>
	<section>
		<br />
	</section>
	<footer>
		<p>2016</p>
	</footer>
</body>
</html>

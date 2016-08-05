<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.Date"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<fmt:setLocale value="${locale}" />
<fmt:setBundle basename="local" />

<title><fmt:message key="thePage" /></title>
</head>
<body>

	<header>
		<h1>
			<fmt:message key="thePage" />
		</h1>
	</header>
	<section>
		<div>
			<form action="Controller" method="post">

				<fmt:message key="target" />
				: <input type="text" name="target">
				<c:out value="${messages['target']}" />
				<br> <br>
				<fmt:message key="distanse" />
				: <select name="distanse">
					<c:forEach var="i" begin="1" end="10">
						<option value="${i*10}">${i*10}</option>
					</c:forEach>
				</select> <br> <br>
				<fmt:message key="dateBegin" />(yyyy-MM-dd)
				: <input type="text" name="dateBegin" /> <br> <br>
				<fmt:message key="dateFinish" />(yyyy-MM-dd)
				: <input type="text" name="dateFinish" /> <br> <br>
				<fmt:message key="volume" />
				: <select name="volume">
					<c:forEach var="i" begin="1" end="50">
						<option value="${i}">${i}</option>
					</c:forEach>
				</select> <br> <br>
				<fmt:message key="mass" />
				: <select name="mass">
					<c:forEach var="i" begin="1" end="50">
						<option value="${i}">${i}</option>
					</c:forEach>
				</select> <br> <br>
				<fmt:message key="count" />
				: <select name="seatCount">
					<c:forEach var="i" begin="1" end="4">
						<option value="${i}">${i}</option>
					</c:forEach>
				</select> <br> <br> <input type="submit" value="<fmt:message key="true" />"> <input
					type="hidden" name="page" value="PAGE_ORDER" />
			</form>
		</div>
		<nav>
			<a href="Controller?page=RETURN"><button><fmt:message key="backClient" /></button></a>
		</nav>
	</section>
	<footer>
		<p>©2016
		<p>
	</footer>
</body>
</html>

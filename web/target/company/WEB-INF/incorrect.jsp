<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<fmt:setLocale value="${locale}" />
<fmt:setBundle basename="local" />

<title><fmt:message key="error" /></title>
</head>
<body>
	<header>
		<h1>
			<fmt:message key="error" />
		</h1>
	</header>

	<nav>
		<a href="Controller?page=NOT_CAR"><button>
				<fmt:message key="back" />
			</button></a>
	</nav>
	<section>
		<div>
			<h2>
				<fmt:message key="incorrect" />
			</h2>
		</div>
	</section>
	<footer>
		<p>2016
		<p>
	</footer>
</body>
</html>
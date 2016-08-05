<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<fmt:setLocale value="${locale}" />
<fmt:setBundle basename="local" />

<title><fmt:message key="aadminPage" /></title>
</head>
<body>
	<header>
		<h1>
			<fmt:message key="aadminPage" />
		</h1>
	</header>

	<nav>

		<div>
			<form action="Controller" method="post">
				<input type="hidden" name="page" value="CLIENT_PAGE" /> <input
					type="submit" value="<fmt:message key="exit"/>">
			</form>
		</div>


		<div>
			<form action="Controller" method="post">
				<input type="hidden" name="page" value="PAGES_BASE" /> <input
					type="submit" value="<fmt:message key="inf"/>">
			</form>
		</div>


	</nav>
	<section></section>
	<footer>
		<p>2016</p>
	</footer>
</body>
</html>
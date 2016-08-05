<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>

<fmt:setLocale value="${locale}" />
<fmt:setBundle basename="local" />
<title><fmt:message key="ccarBase" /></title>
</head>
<body>



	<header>

		<h1>
			<fmt:message key="ccarBase" />
		</h1>
	</header>
	<input type="hidden" name="page" value="start_page" />
	<nav>
		<a href="login.jsp"><button>
				<fmt:message key="login" />
			</button></a> <a href="registration.jsp"><button>
				<fmt:message key="registration" />
			</button></a> <a href="admin.jsp"><button>
				<fmt:message key="admin" />
			</button></a>

	</nav>
	<h1></h1>
	<a href="index.jsp"><fmt:message key="language" /></a>
	<section>
		<br />
		<div>
			<fmt:message key="hi" />
		</div>
	</section>
	<footer>
		<p><fmt:formatDate value="${now}" dateStyle="full"/> </p>
	</footer>
</body>
</html>

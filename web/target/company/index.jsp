<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
</head>
<body>
<fmt:setLocale value="${locale}" />
<fmt:setBundle basename="local" />
	<p>
		<fmt:message key="language" />
	</p>
	<div>
	
	<span> 
		<a href="Controller?page=CHANGE_LOCALE&locale=en"><fmt:message key="en"/></a> 
		<a href="Controller?page=CHANGE_LOCALE&locale=ru"><fmt:message key="ru"/></a>
		</span>
	</div>

</body>
</html>
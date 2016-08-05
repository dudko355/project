<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<fmt:setLocale value="${locale}" />
<fmt:setBundle basename="local" />

<title><fmt:message key="orders" /></title>
</head>
<body>
	<header>
		<h1>
			<fmt:message key="myOrders" />
		</h1>
	</header>
	<nav>
		<a href="Controller?page=RETURN"><button>
				<fmt:message key="backClient" />
			</button></a>

		<div>
			<h3>
				<fmt:message key="your" />
			</h3>
			<table>
				<thead>
					<tr>
						<th><fmt:message key="idOrder" /></th>
						<th><fmt:message key="target" /></th>
						<th><fmt:message key="dateBegin" /></th>
						<th><fmt:message key="dateFinish" /></th>
						<th><fmt:message key="changeCondiTtrip" /></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="trip" items="${trips}">
						<tr>
							<td><c:out value="${trip.idOrder}" /></td>
							<td><c:out value="${trip.target}" /></td>
							<td>
							<fmt:formatDate value="${trip.dateBegin}" dateStyle="full" /></td>
							<td><fmt:formatDate value="${trip.dateFinish}" dateStyle="full"/></td>
							<td>
							
							<c:choose>
									<c:when test="${trip.conditionTrip=='-1'}">
										<form action="Controller" method="post">
										<input type="hidden" name="page" value="CLIENT_TRIP" />
										<input type="submit" value="<fmt:message key="delete" />">
			 			             	<input type="hidden" name="delete_trip" value="${trip.idTrip}" />
										</form>
									</c:when>
									<c:otherwise>
										<fmt:message key="tripEnded" />
									</c:otherwise>
								</c:choose>
							
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</nav>
	<footer>
		<p>2016
		<p>
	</footer>
</body>
</html>

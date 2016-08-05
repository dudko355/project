<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="java.util.Map"%>
<html>
<head>
<fmt:setLocale value="${locale}" />
<fmt:setBundle basename="local" />

<title><fmt:message key="adminPage" /></title>
</head>
<body>
	<header>
		<h1>
			<fmt:message key="changeTrip" />
		</h1>
	</header>
	<nav>
		<a href="Controller?page=EXIT_ADMIN"><button>
				<fmt:message key="adminPage" />
			</button></a>
	</nav>
	<section>
		<div>
			<h3>
				<fmt:message key="changeTrip" />

			</h3>
			<table>
				<thead>
					<tr>
						<th><fmt:message key="idTrip" /></th>
						<th><fmt:message key="idCar" /></th>
						<th><fmt:message key="target" /></th>
						<th><fmt:message key="idClient" /></th>
						<th><fmt:message key="condition" /></th>
						<th><fmt:message key="changeCondiTtrip" /></th>


					</tr>
				</thead>
				<tbody>
					<c:forEach var="trip" items="${ALLTRIP}">
						<tr>
							<td><c:out value="${trip.idTrip}" /></td>
							<td><c:out value="${trip.idCar}" /></td>
							<td><c:out value="${trip.target}" /></td>
							<td><c:out value="${trip.idClient}" /></td>
							<td><c:choose>
									<c:when test="${trip.conditionTrip=='-1'}">
										<fmt:message key="tripNotStart" />

									</c:when>
									<c:when test="${trip.conditionTrip=='0'}">
										<fmt:message key="tripStart" />

									</c:when>
									<c:when test="${trip.conditionTrip=='1'}">
										<fmt:message key="tripEnded" />

									</c:when>
									<c:otherwise>
										<fmt:message key="error" />

									</c:otherwise>
								</c:choose>
							<td />
							<td>
								<form action="Controller" method="post">
									<p>
										<select name="condition">
											<option></option>
											<option value="-1"><fmt:message key="tripNotStart" /></option>
											<option value="0"><fmt:message key="tripStart" /></option>
											<option value="1"><fmt:message key="tripEnded" /></option>
										</select>
										<c:out value="${messages['condition']}" />
										<input type="submit" value="<fmt:message key="apply" />">
										<input type="hidden" name="page" value="CHANGE_TRIP" /> <input
											type="hidden" name="change_condition" value="${trip.idTrip}" />
								</form>
							</td>


						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</section>
	<footer>
		<p>2016
		<p>
	</footer>
</body>
</html>
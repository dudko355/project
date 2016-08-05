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
			<fmt:message key="changeCar" />
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
				<fmt:message key="changeCar" />
			</h3>
			<table>
				<thead>
					<tr>
						<th><fmt:message key="idCar" /></th>
						<th><fmt:message key="mark" /></th>
						<th><fmt:message key="condition" /></th>
						<th><fmt:message key="changeConditCar" /></th>


					</tr>
				</thead>
				<tbody>
					<c:forEach var="car" items="${ALLCAR}">
						<tr>
							<td><c:out value="${car.idCar}" /></td>
							<td><c:out value="${car.mark}" /></td>

							<td><c:choose>
									<c:when test="${car.condition=='-1'}">
										<fmt:message key="carBroken" />

									</c:when>
									<c:when test="${car.condition=='0'}">
										<fmt:message key="carWork" />

									</c:when>
									<c:when test="${car.condition=='1'}">
										<fmt:message key="carTrip" />

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
											<option value="-1"><fmt:message key="carBroken" /></option>
											<option value="0"><fmt:message key="carWork" /></option>
											<option value="1"><fmt:message key="carTrip" /></option>
										</select>
										<c:out value="${messages['condition']}" />
										<input type="submit" value="<fmt:message key="apply" />">
										<input type="hidden" name="page" value="CHANGE_CAR" /> 
										<input type="hidden" name="change_condition" value="${car.idCar}" />
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
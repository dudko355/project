<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<fmt:setLocale value="${locale}" />
<fmt:setBundle basename="local" />

<title><fmt:message key="inf" /></title>
</head>
<body>
	<header>
		<h1>
			<fmt:message key="inf" />
		</h1>
	</header>
	<nav>
		<a href="Controller?page=CHANGE_COND_TRIP"><button>
				<fmt:message key="changeTrip" />
			</button></a> <a href="Controller?page=CHANGE_COND_CAR"><button>
				<fmt:message key="changeCar" />
			</button></a> <a href="Controller?page=EXIT_ADMIN"><button>
				<fmt:message key="exit" />
			</button></a>
	</nav>
	<section>
		<div>
			<h3>
				<fmt:message key="ccarRepain" />
			</h3>
			<table>
				<thead>
					<tr>
						<th><fmt:message key="idCar" /></th>
						<th><fmt:message key="mark" /></th>
						<th><fmt:message key="driver" /></th>

					</tr>
				</thead>
				<tbody>
					<c:forEach var="car" items="${CARS}">
						<tr>
							<td><c:out value="${car.idCar}" /></td>
							<td><c:out value="${car.mark}" /></td>
							<td><c:out value="${car.idDriver}" /></td>

						</tr>
					</c:forEach>
				</tbody>
			</table>

	<!-- 		<h3>
				<fmt:message key="ttrip" />
			</h3>
			<table>
				<thead>
					<tr>
						<th><fmt:message key="idTrip" /></th>
						<th><fmt:message key="target" /></th>
						<th><fmt:message key="idCar" /></th>
						<th><fmt:message key="idClient" /></th>
						<th><fmt:message key="condition" /></th>

					</tr>
				</thead>
				<tbody>
					<c:forEach var="trip" items="${ALLTRIP}">
						<tr>

							<td><c:out value="${trip.idTrip}" /></td>
							<td><c:out value="${trip.target}" /></td>
							<td><c:out value="${trip.idCar}" /></td>
							<td><c:out value="${trip.idClient}" /></td>

							<td><c:choose>
									<c:when test="${trip.conditionTrip=='-1'}">
										<fmt:message key="tripNotStart" />
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




						</tr>
					</c:forEach>
				</tbody>
			</table>

			<h3>
				<fmt:message key="carTrip" />
			</h3>
			<table>
				<thead>
					<tr>
						<th><fmt:message key="idCar" /></th>
						<th><fmt:message key="mark" /></th>
						<th><fmt:message key="driver" /></th>

					</tr>
				</thead>
				<tbody>
					<c:forEach var="car" items="${CARTRIP}">
						<tr>
							<td><c:out value="${car.idCar}" /></td>
							<td><c:out value="${car.mark}" /></td>
							<td><c:out value="${car.idDriver}" /></td>

						</tr>
					</c:forEach>
				</tbody>
			</table>    -->

			<h3>
				<fmt:message key="ddriver" />
			</h3>
			<table>
				<thead>
					<tr>
						<th><fmt:message key="idDriver" /></th>
						<th><fmt:message key="name" /></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="driver" items="${DRIVER}">
						<tr>
							<td><c:out value="${driver.idDriver}" /></td>
							<td><c:out value="${driver.name}" /></td>
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

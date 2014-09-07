<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Parser result</title>
</head>
<body>
	<div>
		<h1>Has parsed by ${ parserName } parser</h1>
	</div>
	<div>
		<a href="index.jsp">Back home</a>
	</div>
	<div>
		<table border="1">
			<tr>
				<th>Id</th><th>Brand</th><th>Fuel consumption</th><th>Displacement</th>
				<th>Max speed</th><th>Year</th><th>Cost</th><th>Seats</th>
			<tr>
			<c:forEach var="car" items="${ cars }">
				<tr>
					<td><c:out value="${ car.id }"/></td>
					<td><c:out value="${ car.brand }"/></td>
					<td><c:out value="${ car.fuelConsumption }"/></td>
					<td><c:out value="${ car.displacement }"/></td>
					<td><c:out value="${ car.maxSpeed }"/></td>
					<td><c:out value="${ car.year }"/></td>
					<td><c:out value="${ car.cost }"/></td>
					<td><c:out value="${ car.seats }"/></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
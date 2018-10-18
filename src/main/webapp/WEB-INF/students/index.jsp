<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>All Students Page</title>
	</head>
	<body>
		<h1>All Students</h1>
		<table>
			<thead>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Age</th>
					<th>Teacher</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${students}" var="student">
				<tr>
					<td><c:out value="${student.firstName}"/></td>
					<td><c:out value="${student.lastName}"/></td>
					<td><c:out value="${student.age}"/></td>
					<td><c:out value="${student.teacher.firstName}"/></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<a href="/students/new">New Student</a>
	</body>
</html>
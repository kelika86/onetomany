<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> <!-- need the form -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <!-- to iterate -->
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	</head>
	<body>
		<form:form action="/students" method="POST" modelAttribute="student"> <!-- call whatever attribute -->
			<p>
        <form:label path="firstName">First Name</form:label> <!-- the path has to match the attribute of the student -->
        <form:errors path="firstName"/>
        <form:input path="firstName"/>
    </p>
    <p>
        <form:label path="lastName">Last Name</form:label>
        <form:errors path="lastName"/>
        <form:textarea path="lastName"/>
    </p>
    <p>
        <form:label path="age">Age</form:label>
        <form:errors path="age"/>
        <form:input path="age"/>
    </p>
    <form:label path="teacher">Teacher:</form:label>
    <form:select path="teacher">
      <c:forEach items="${teachers}" var="teacher"> <!-- "teachers" is the value of the model and put $ sign in front/model attribute -->
      <option value="${teacher.id}"><c:out value="${teacher.firstName} ${teacher.lastName}"/></option>
      </c:forEach>
      </form:select>
    	<input type="submit" value="Submit"/>
		</form:form>
	</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Ninja</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class = "container-md-fluid m-5 p-5">
		<div class = "row justify-content-center">
			<div class = "col-5 align-self-center">
			<h1>Add Ninja</h1>
			<form:form action="/ninjas/new" method="post" modelAttribute="ninja">
				<form:select path="dojo" class="form-select form-select-lg mb-3" aria-label=".form-select-lg example">
				  <c:forEach var="dojo" items="${dojos}">
				  	<form:option value="${dojo}"><c:out value="${dojo.name}"></c:out></form:option>
				  </c:forEach>
				</form:select>
				<div class="form-floating my-3">
				  <form:input path="firstName" class="form-control" name = "firstName" id="floatingInput" placeholder="name@example.com"/>
				  <form:label path="firstName" for="floatingInput">Ninja First Name</form:label>
					<form:errors path="firstName" class = "my-3" style="color: red;"/>
				</div>
				<div class="form-floating my-3">
				  <form:input path="lastName" class="form-control" name = "lastName" id="floatingInput" placeholder="name@example.com"/>
				  <form:label path="lastName" for="floatingInput">Ninja Last Name</form:label>
					<form:errors path="lastName" class = "my-3" style="color: red;"/>
				</div>
				<div class="form-floating my-3">
				  <form:input path="age" class="form-control" name = "age" id="floatingInput" placeholder="name@example.com"/>
				  <form:label path="age" for="floatingInput">Ninja Age</form:label>
					<form:errors path="age" class = "my-3" style="color: red;"/>
				</div>
				<button type="submit" class="btn btn-outline-warning align-self-center">Add New</button>
			</form:form>
			</div>
		</div>
	</div>
</body>
</html>
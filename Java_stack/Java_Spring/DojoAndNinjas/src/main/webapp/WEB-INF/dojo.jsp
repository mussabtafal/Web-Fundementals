<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Dojo</title>
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
			<h1>Add Dojo</h1>
			<form:form action="/dojos/new" method="post" modelAttribute="dojo">
				<div class="form-floating my-3">
				  <form:input path="name" class="form-control" name = "name" id="floatingInput" placeholder="name@example.com"/>
				  <form:label path="name" for="floatingInput">Dojo Name</form:label>
					<form:errors path="name" class = "my-3" style="color: red;"/>
				</div>
				<button type="submit" class="btn btn-outline-warning align-self-center">Add New</button>
			</form:form>
			</div>
		</div>
	</div>
</body>
</html>
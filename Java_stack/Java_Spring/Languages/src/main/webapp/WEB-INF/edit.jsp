<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Language</title>
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
			<div class = "col-9 align-self-center ">
				<a href="/languages">Go Back</a>
			</div>
		</div>
		<div class = "row justify-content-center">
			<div class = "col-5 align-self-center">
			<h1>Edit Language</h1>
				<form:form action="/languages/${language.id}/edit" method="post" modelAttribute="language">
				<input type="hidden" name="_method" value="put">
					<div class="form-floating my-3">
					  <form:input path="name" class="form-control" name = "name" id="floatingInput" placeholder="name@example.com"/>
					  <form:label path="name" for="floatingInput">Language Name</form:label>
						<form:errors path="name" class = "my-3" style="color: red;"/>
					</div>
					<div class="form-floating mb-3">
					  <form:input path="creator" type="text" class="form-control" name = "vendor" id="floatingInput" placeholder="name@example.com"/>
					  <form:label path="creator" for="floatingInput">Creator</form:label>
						<form:errors path="creator" class = "my-3"  style="color: red;"/>
					</div>
					<div class="form-floating mb-3">
					  <form:input path="version" type="text" class="form-control" name = "version" id="floatingInput" placeholder="name@example.com"/>
					  <form:label path="version" for="floatingInput">Version</form:label>
					<form:errors path="version" class = "my-3" style="color: red;"/>
					</div>
					<button type="submit" class="btn btn-outline-warning align-self-center">Update</button>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>
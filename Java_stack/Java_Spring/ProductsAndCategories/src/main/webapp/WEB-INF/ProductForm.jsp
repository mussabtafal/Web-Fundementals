<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Form</title>
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
			<h1>Add Product</h1>
			<form:form action="/products/new" method="post" modelAttribute="product">
				<div class="form-floating my-3">
				  <form:input path="name" class="form-control" name = "name" id="floatingInput" placeholder="name@example.com"/>
				  <form:label path="name" for="floatingInput">Product Name</form:label>
					<form:errors path="name" class = "my-3" style="color: red;"/>
				</div>
				<div class="form-floating mb-4">
					  <form:textarea path="description" class="form-control" placeholder="Leave a comment here" id="floatingTextarea2" style="height: 100px"></form:textarea>
					  <form:label path="description" for="floatingTextarea2">Description</form:label>
					<form:errors path="description" class = "my-3" style="color: red;"/>
					</div>
				<div class="form-floating my-3">
				  <form:input path="price" class="form-control" name = "name" id="floatingInput" placeholder="name@example.com"/>
				  <form:label path="price" for="floatingInput">Price</form:label>
					<form:errors path="price" class = "my-3" style="color: red;"/>
				</div>
				<button type="submit" class="btn btn-outline-warning align-self-center">Create</button>
			</form:form>
			</div>
		</div>
	</div>
</body>
</html>
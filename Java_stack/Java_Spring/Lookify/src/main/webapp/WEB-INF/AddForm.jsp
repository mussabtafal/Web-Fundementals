<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Song</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
		<div class="container-md-fluid m-5 p-5">
			<div class = "row justify-content-center">
				<div class = "col-5 align-self-center">
					<h1>Add a new Song</h1>
					<form:form action="/songs/new" method="post" modelAttribute="song">
						<div class="form-floating my-3">
						  <form:input path="title" class="form-control" name = "title" id="floatingInput" placeholder="name@example.com"/>
						  <form:label path="title" for="floatingInput">Song Title</form:label>
							<form:errors path="title" class = "my-3" style="color: red;"/>
						</div>
						<div class="form-floating mb-3">
						  <form:input path="artist" type="text" class="form-control" name = "artist" id="floatingInput" placeholder="name@example.com"/>
						  <form:label path="artist" for="floatingInput">Artist</form:label>
							<form:errors path="artist" class = "my-3"  style="color: red;"/>
						</div>
						<div class="form-floating mb-3">
						  <form:input path="rating" type="number" min="1" max="10" class="form-control" name = "rating" id="floatingInput" placeholder="name@example.com"/>
						  <form:label path="rating" for="floatingInput">Rating</form:label>
						<form:errors path="rating" class = "my-3" style="color: red;"/>
						</div>
						<button type="submit" class="btn btn-outline-warning align-self-center">Add new</button>
					</form:form>
				</div>
			</div>
		</div>
</body>
</html>
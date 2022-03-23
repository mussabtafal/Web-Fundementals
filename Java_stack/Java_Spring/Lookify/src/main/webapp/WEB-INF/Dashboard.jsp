<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Songs</title>
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
		<div class = "row justify-content-center mb-5">
			<div class="col-3">
				<a href="songs/new">Add New</a>
			</div>
			<div class="col-3">
				<a href="search/topten/">Top Songs</a>
			</div>
			<form:form action="/search" method="post" modelAttribute="songArtist">
				<div class="form-floating my-3">
				  <form:input path="artist" class="form-control" name = "artist" id="floatingInput" placeholder="name@example.com"/>
				  <form:label path="artist" for="floatingInput">Artist</form:label>
					<form:errors path="artist" class = "my-3" style="color: red;"/>
					<button type="submit" class="btn btn-outline-warning align-self-center">Add</button>
				</div>
			</form:form>
		</div>
		<div class = "row justify-content-center mb-5">
			<div class = "col-9 align-self-center ">
				<h1 class = "mb-4">Songs</h1>
				<table class="table border col-5 mb-5">
				  <thead>
				    <tr>
				      <th scope="col">Name</th>
				      <th scope="col">Rating</th>
				      <th scope="col">Action</th>
				    </tr>
				  </thead>
				  <tbody>
				  <c:forEach var="song" items="${songs}">
				    <tr>
				      <th scope="row"><a href="/languages/<c:out value="${song.id}"></c:out>"><c:out value="${song.title}"></c:out></a></th>
				      <td><c:out value="${song.rating}"></c:out></td>
				      <td>
				      	<form action="/dashboard/<c:out value="${song.id}"></c:out>/delete" method="post">
					    	<input type="hidden" name="_method" value="delete">
					    	<button type="submit" class="btn btn-danger btn-sm mb-3 ms-4" value="Delete">Delete</button>
						</form>
				      </td>
				    </tr>
				    </c:forEach>
				</table>
			</div>
		</div>
	</div>	
</body>
</html>
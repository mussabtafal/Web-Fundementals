<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Programming Languages</title>
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
			<div class = "col-5 align-self-center ">
				<h1 class = "mb-4">Languages</h1>
				<table class="table border col-5 mb-5">
				  <thead>
				    <tr>
				      <th scope="col">Name</th>
				      <th scope="col">Creator</th>
				      <th scope="col">Version</th>
				      <th scope="col">Action</th>
				    </tr>
				  </thead>
				  <tbody>
				  <c:forEach var="lang" items="${languages}">
				    <tr>
				      <th scope="row"><a href="/languages/<c:out value="${lang.id}"></c:out>"><c:out value="${lang.name}"></c:out></a></th>
				      <td><c:out value="${lang.creator}"></c:out></td>
				      <td><c:out value="${lang.version}"></c:out></td>
				      <td style="display:flex;"><a href="languages/<c:out value="${lang.id}"></c:out>/edit">edit</a>
				      	<form action="/languages/<c:out value="${lang.id}"></c:out>/delete" method="post">
					    	<input type="hidden" name="_method" value="delete">
					    	<button type="submit" class="btn btn-danger btn-sm mb-3 ms-4" value="Delete">Delete</button>
						</form>
				      </td>
				    </tr>
				    </c:forEach>
				</table>
			</div>
		</div>
		<div class = "row justify-content-center">
			<div class = "col-5 align-self-center">
			<h1>Add a new Language</h1>
				<form:form action="/languages/new" method="post" modelAttribute="language">
					<div class="form-floating my-3">
					  <form:input path="name" class="form-control" name = "expense" id="floatingInput" placeholder="name@example.com"/>
					  <form:label path="name" for="floatingInput">Language Name</form:label>
						<form:errors path="name" class = "my-3" style="color: red;"/>
					</div>
					<div class="form-floating mb-3">
					  <form:input path="creator" type="text" class="form-control" name = "creator" id="floatingInput" placeholder="name@example.com"/>
					  <form:label path="creator" for="floatingInput">Creator</form:label>
						<form:errors path="creator" class = "my-3"  style="color: red;"/>
					</div>
					<div class="form-floating mb-3">
					  <form:input path="version" type="text" class="form-control" name = "version" id="floatingInput" placeholder="name@example.com"/>
					  <form:label path="version" for="floatingInput">Version</form:label>
					<form:errors path="version" class = "my-3" style="color: red;"/>
					</div>
					<button type="submit" class="btn btn-outline-warning align-self-center">Add</button>
				</form:form>
			</div>
		</div>
				
	</div>
</body>
</html>
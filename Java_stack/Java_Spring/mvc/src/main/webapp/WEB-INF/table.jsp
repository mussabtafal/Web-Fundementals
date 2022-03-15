<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book List</title>
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
				<h1 class = "mb-4">All Books</h1>
				<table class="table border col-5">
				  <thead>
				    <tr>
				      <th scope="col">ID</th>
				      <th scope="col">Title</th>
				      <th scope="col">Language</th>
				      <th scope="col"># Pages</th>
				    </tr>
				  </thead>
				  <tbody>
				  <c:forEach var="book" items="${books}">
				    <tr>
				      <th scope="row"><c:out value="${book.id}"></c:out></th>
				      <td><a href="/books/<c:out value="${book.id}"></c:out>"><c:out value="${book.title}"></c:out></a></td>
				      <td><c:out value="${book.language}"></c:out></td>
				      <td><c:out value="${book.numberOfPages}"></c:out></td>
				    </tr>
				    </c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Details</title>
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
				<h1 class = "mb-3"><strong>Title:</strong> <c:out value="${book.title}"/></h1>
				<p style = "font-size: 20px;"><strong>Description:</strong> <c:out value="${book.description}"/></p>
				<p style = "font-size: 20px;"><strong>Language:</strong> <c:out value="${book.language}"/></p>
				<p style = "font-size: 20px;"><strong>Number of pages:</strong> <c:out value="${book.numberOfPages}"/></p>
			</div>
		</div>
	</div>
</body>
</html>
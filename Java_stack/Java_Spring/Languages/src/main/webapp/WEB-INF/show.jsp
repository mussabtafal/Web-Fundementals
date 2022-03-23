<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Language Details</title>
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
				<h1 class = "mb-3"><strong>Language:</strong> <c:out value="${language.name}"/></h1>
				<p style = "font-size: 20px;"><strong>Creator:</strong> <c:out value="${language.creator}"/></p>
				<p style = "font-size: 20px;"><strong>Version:</strong> <c:out value="${language.version}"/></p>
			</div>
		</div>
		<div class = "row justify-content-center">
			<div class = "col-5 align-self-center" style="display: flex;">	
				<form action="/languages/${language.id}/delete" method="post">
				    <input type="hidden" name="_method" value="delete">
				    <button type="submit" class="btn btn-danger mt-2" value="Delete">Delete</button>
				</form>
				<form action="/languages/<c:out value="${language.id}"/>/edit" method="get">
				    <button type="submit" class="btn btn-info mt-2 ms-4">Edit</button>
				</form>
			</div>
		</div>			
	</div>
</body>
</html>
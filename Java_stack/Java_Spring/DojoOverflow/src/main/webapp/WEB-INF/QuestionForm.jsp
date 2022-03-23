<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Question</title>
</head>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<body>
	<div class = "contaner-md-fluid p-5 m-5">
		<div class = "row">
			<div class = "col-5">
				<h1 class="display-2">What is your Question?</h1>
				<form action="/questions/new/create" method="POST">
				    <p>
				        <label class="col-sm-2 col-form-label">Question:</label>
				        <input class="form-control col-sm-6" name="question"/>
				    </p>
				     <p>
				        <label class="col-sm-2 col-form-label">Tags:</label>
				        <input class="form-control col-sm-6" name="subject"/>
				    </p>
				    		 
				    <input type="submit" class="btn btn-warning" value="Submit"/>
				</form> 
			</div>
		</div>
	</div>
</body>
</html>
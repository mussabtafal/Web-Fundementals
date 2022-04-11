<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container-md-fluid p-5 m-5">
	    <div class="row">
	       <div class="col-3 align-self-end">
			<a href="/guest/login">Signing/SignUp</a>
	       </div>
	   </div>
	   <div class="row">
	       <div class="col-5 align-self-center">
			<h2>Find Places to swim and sleep on water bnb!</h2>
			<form action="/search">
	                <div class="form-floating my-3">
	                   <input name="location" type = "text" class="form-control" id="floatingInput" placeholder="name@example.com"/>
	                   <label for="floatingInput">Location:</label>
	                 </div>
	                 <button type="submit" class="btn btn-outline-warning align-self-center">Log In</button>
	            </form>
	       </div>
	   </div>
	 </div>
</body>
</html>
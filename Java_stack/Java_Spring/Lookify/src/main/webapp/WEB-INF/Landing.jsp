<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lookify Application</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container-md-fluid m-3 p-3">
		<div class="row text-center" style="height:250px">
			<h1 style="font-size: 70px;">Welcome to Lookify</h1>
		</div>
		<div class="row text-center mt-5">
			<a href="/dashboard" style="font-size: 20px;">Start Looking!</a>
		</div>
	</div>
</body>
</html>
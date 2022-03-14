<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Omikuji Form</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<h1 class = "text-center">Send an Omikuji!</h1>
	<form action="/omikuji/process" method="post">
		<div class = "container-md-fluid">
			<div class = "row justify-content-center">
				<div class = "col-5 m-5 p-5 border">
					<h2>Pick any number from 5 to 25</h2>
					<div class="form-floating mb-3">
					  <input type="number" name="number" min="5" max="25" class="form-control" id="floatingInput" placeholder="ex. 10">
					  <label for="floatingInput">Number</label>
					</div>
					<h2>Enter the name of any city.</h2>
					<div class="form-floating mb-3">
					  <input type="text" name="city" class="form-control" id="floatingInput" placeholder="ex. New York">
					  <label for="floatingInput"></label>
					</div>
					<h2>Enter the name of any real person.</h2>
					<div class="form-floating mb-3">
					  <input type="text" name="name" class="form-control" id="floatingInput" placeholder="ex. Joe Hike">
					  <label for="floatingInput"></label>
					</div>
					<h2>Enter a professional endeavor or hobby:</h2>
					<div class="form-floating mb-3">
					  <input type="text" class="form-control" name="hobby" id="floatingInput" placeholder="ex. New York">
					  <label for="floatingInput"></label>
					</div>
					<h2>Enter any type of living thing.</h2>
					<div class="form-floating mb-3">
					  <input type="text" class="form-control" name="animal" id="floatingInput" placeholder="ex. New York">
					  <label for="floatingInput"></label>
					</div>
					<h2>Say something nice someone:</h2>
					<div class="form-floating">
					  <textarea class="form-control" placeholder="Leave a comment here" name="nice" id="floatingTextarea2" style="height: 100px"></textarea>
					  <label for="floatingTextarea2">ex. God bless you.</label>
					</div>
					<input class="btn btn-primary" type="submit" value="Send">
				</div>
			</div>
		</div>
	</form>

</body>
</html>
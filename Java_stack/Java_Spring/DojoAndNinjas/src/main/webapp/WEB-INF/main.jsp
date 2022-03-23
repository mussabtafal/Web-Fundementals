<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dojo Ninjas</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container-md-fluid p5 m5">
		<div class = "row justify-content-center mb-5">
			<div class = "col-9 align-self-center ">
				<h1 class = "mb-4">Dojo Ninjas</h1>
				<table class="table border col-5 mb-5">
				  <thead>
				    <tr>
				      <th scope="col">First Name</th>
				      <th scope="col">Last Name</th>
				      <th scope="col">Age</th>
				    </tr>
				  </thead>
				  <tbody>
				  <c:forEach var="ninja" items="${dojo}">
				    <tr>
				      <th scope="row"><c:out value="${ninja.firstName}"></c:out></th>
				      <td><c:out value="${ninja.lastName}"></c:out></td>
				      <td><c:out value="${ninja.age}"></c:out></td>
				    </tr>
				    </c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>
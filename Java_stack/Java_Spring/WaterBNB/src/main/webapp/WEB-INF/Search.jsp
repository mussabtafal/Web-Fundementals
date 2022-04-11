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
	<body class="container my-4">
	<div class="row justify-content-end">
		<a href="/host/dashboard">Home</a>
		<a class="mx-3" href="/logout">Logout</a>
	</div>	
	<h3>Find your pool!</h3>
	<form action="/search">
        <div class="form-floating my-3">
           <input name="location" type = "text" class="form-control" id="floatingInput" placeholder="name@example.com"/>
           <label for="floatingInput">Location:</label>
         </div>
         <button type="submit" class="btn btn-outline-warning align-self-center">Log In</button>
    </form>
	<table class="table my-4">
		<thead>
			<tr>
				<th>Address</th>
				<th>Pool Size</th>
				<th>Cost per night</th>
				<th>Details</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${locations}" var="listing">
				<tr>
					<td><c:out value="${listing.address}"/></td>
					<td><c:out value="${listing.poolSize}"/></td>
					<td>$<c:out value="${listing.cost}"/></td>
					<td>
						<a href="/pools/${listing.id}">
							<c:out value="${listing.avg}"/>/5 - See more
						</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
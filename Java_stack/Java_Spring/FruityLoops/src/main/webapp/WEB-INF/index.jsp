<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fruity Loops</title>
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
				<table class="table border col-5">
				  <thead>
				    <tr>
				      <th scope="col">Name</th>
				      <th scope="col">Price</th>
				    </tr>
				  </thead>
				  <tbody>
				  <c:forEach var="fruit" items="${fruitList}">
				    <tr>
				      <th scope="row"><c:out value="${fruit.name}"></c:out></th>
				      <td><c:out value="${fruit.price}"></c:out></td>
				    </tr>
				    </c:forEach>
				</table>
			</div>
		</div>
	</div>

</body>
</html>
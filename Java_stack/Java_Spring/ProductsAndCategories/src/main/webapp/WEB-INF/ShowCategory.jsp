<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Category Details</title>
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
		<div class = "row justify-content-between">
			<div class="col-5">
				<h1>Category: <c:out value="${cat.name}"></c:out></h1>
				<h2>Products</h2>
				<ul>
					<c:forEach var="product" items="${cat.products}">
						<li><c:out value="${product.name}"></c:out></li>
					</c:forEach>
				</ul>
			</div>
			<div class = "col-2">
				<form action="/categories/${cat.id}/relate">
					<select name="product" class="form-select form-select-lg mb-3" aria-label=".form-select-lg example">
					  <c:forEach var="product" items="${allowedPro}">
					  	<option value="${product.id}"><c:out value="${product.name}"></c:out></option>
					  </c:forEach>
					</select>
					<button type="submit" class="btn-small btn-danger mt-2" value="Info">Add</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
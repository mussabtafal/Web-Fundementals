<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Questions</title>
</head>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<body>
	<div class = "container-md-fluid m5 p5">
		<div class = "row justify-content-center mb-5">
			<div class = "col-9 align-self-center ">
				<h1 class = "mb-4">Question Dashboard</h1>
				<table class="table border col-5 mb-5">
				  <thead>
				    <tr>
				      <th scope="col">Question</th>
				      <th scope="col">Tags</th>
				    </tr>
				  </thead>
				  <tbody>
				  <c:forEach var="question" items="${Questions}">
				    <tr>
				      <th scope="row"><a href="/questions/<c:out value="${question.id}"></c:out>"><c:out value="${question.question}"></c:out></a></th>
				      <td>
				      	<c:out value="${question.tags}"></c:out>
				      </td>
				    </tr>
				    </c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>
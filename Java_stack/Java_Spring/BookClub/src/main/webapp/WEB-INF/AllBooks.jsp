<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New</title>
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
            <div class = "col-5 ">
                <h1>Welcome, <c:out value="${user.userName}"></c:out>!</h1>
                <h5>Books From everyones shelves:</h5>
                <a href="/logout">Logout</a>
            </div>
              <div class = "col-3 ">
              <a href="/logout">Logout</a>
              <a href="/books/new">+Add to my shelves</a>
            </div>
        </div>
           <div class = "row justify-content-center">
            <div class = "col-7 align-self-center ">
            	<table class="table border col-5 mb-5">
				  <thead>
				    <tr>
				      <th scope="col">Id</th>
				      <th scope="col">Title</th>
				      <th scope="col">Author Name</th>
				      <th scope="col">Posted By</th>
				    </tr>
				  </thead>
				  <tbody>
				  <c:forEach var="book" items="${books}">
				    <tr>
				      <th scope="row"><c:out value="${book.id}"></c:out></th>
				      <td><a href="/books/${book.id}"><c:out value="${book.title}"></c:out></a></td>
				      <td><c:out value="${book.author}"></c:out></td>
				      <td><c:out value="${book.user.userName}"></c:out></td>
				    </tr>
				    </c:forEach>
				</table>
            </div>
        </div>
    </div>
</body>
</html>
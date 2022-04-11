<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listings Dashboard</title>
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
    		<div class = "col-7 ">
    			<h1>Welcome, <c:out value="${user.firstName}"></c:out>!</h1>
    			<h5>Here are some of the events in your state:</h5>
    		</div>
    		<div class = "col-2 ">
    			<p><a href="/logout">Logout</a></p>
    		</div>
    	</div>
    	<div class = "row justify-content-between">
            <div class = "col-9 ">
				<table class="table border col-5  ">
				  <thead>
				    <tr>
				      	<th scope="col" class = "col-1 ">Address</th>
				     	<th scope="col" class = "col-1 ">Pool Size</th>
				      	<th scope="col" class = "col-1 ">Cost per night</th>
				      	<th scope="col" class = "col-1 ">Details</th>
				    </tr>
				  </thead>
				  <tbody>
				    <c:forEach var="listing" items="${listings}">
				    <tr>
				        <td ><c:out value="${listing.address}"></c:out></td>
				    	<td><c:out value="${listing.poolSize}"></c:out></td>
				    	<td>$<c:out value="${listing.cost}"></c:out></td>
				    	<td>edit</td>
				    </tr>
				    </c:forEach>
				  </tbody>
				</table>
    		</div>
    		</div>
    	<div class = "row justify-content-between">
            <div class = "col-5 mt-5">
    			<h3>Create an Event</h3>
                <form:form action="/host/dashboard" method="post" modelAttribute="listing">
                <form:input type="hidden" path="host"  value="${user.id}"/>
                    <div class="form-floating my-3">
                      <form:input path="address" class="form-control" name = "name" id="floatingInput" placeholder="name@example.com"/>
                      <form:label path="address" for="floatingInput">Address:</form:label>
                      <form:errors path="address" class = "my-3" style="color: red;"/>
                    </div>
					<div class="form-floating mb-4">
                      	<form:textarea path="description" class="form-control" placeholder="Leave a comment here" name = "description" id="floatingTextarea2" style="height: 100px"></form:textarea>
                      	<form:label path="description" for="floatingTextarea2">description:</form:label>
                    	<form:errors path="description" class = "my-3" style="color: red;"/>
                    </div>
                    <div class="form-floating my-3">
	                      <form:input type="number" path="cost" class="form-control" name = "location" id="floatingInput" placeholder="name@example.com"/>
	                      <form:label path="cost" for="floatingInput">cost:</form:label>
	                      <form:errors path="cost" class = "my-3" style="color: red;"/>
                     </div>
                      <div class="form-floating my-3">
                     	 <form:select path="poolSize" class="form-control" >
						      <form:option value="Small" >Small</form:option>
						      <form:option value="Medium" >Medium</form:option>
						      <form:option value="Large" >Large</form:option>
				    	</form:select>
                      </div>
                    <button type="submit" class="btn btn-outline-warning align-self-center">Add Listing</button>
                    </form:form>
    		</div>
    		</div>
    </div>
    		
</body>
</html>
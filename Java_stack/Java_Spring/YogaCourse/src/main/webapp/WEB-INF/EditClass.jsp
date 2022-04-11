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
<title>Edit Course</title>
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
            <div class = "col-5 mt-5">
            	<h1><c:out value="${course.name}"></c:out></h1>
                <h3>Edit Course</h3>
                <form:form action="/classes/${course.id}/edit" method="post" modelAttribute="course">
                <input type="hidden" name="_method" value="put">
                <form:input type="hidden" path="id"  value="${course.id}"/>
                <form:input type="hidden" path="instructor"  value="${user.id}"/>
                    <div class="form-floating my-3">
                      <form:input path="name" class="form-control" name = "name" id="floatingInput" placeholder="name@example.com"/>
                      <form:label path="name" for="floatingInput">Name:</form:label>
                      <form:errors path="name" class = "my-3" style="color: red;"/>
                    </div>
                    <div class="form-floating my-3">
                      <form:input type="text" path="weekDay" class="form-control" name = "weekDay" id="floatingInput" placeholder="name@example.com"/>
                      <form:label path="weekDay" for="floatingInput">weekDay:</form:label>
                        <form:errors path="weekDay" class = "my-3" style="color: red;"/>
                    </div>
                    <div class="form-floating my-3">
                          <form:input type="number" min="0" path="price" class="form-control" name = "price" id="floatingInput" placeholder="name@example.com"/>
                          <form:label path="price" for="floatingInput">price</form:label>
                          <form:errors path="price" class = "my-3" style="color: red;"/>
                     </div>
                     <div class="form-floating my-3">
                      <form:input type="text" path="courseTime" class="form-control" name = "courseTime" id="floatingInput" placeholder="name@example.com"/>
                      <form:label path="courseTime" for="floatingInput">courseTime:</form:label>
                        <form:errors path="courseTime" class = "my-3" style="color: red;"/>
                    </div>
                    <div class="form-floating mb-4">
                      <form:textarea path="description" class="form-control" placeholder="Leave a comment here" name = "description" id="floatingTextarea2" style="height: 100px"></form:textarea>
                      <form:label path="description" for="floatingTextarea2">Description:</form:label>
                    <form:errors path="description" class = "my-3" style="color: red;"/>
                    </div>
                    <button type="submit" class="btn btn-outline-warning align-self-center">Edit</button>
                    </form:form>
                     <div class = "row justify-content-start mt-4 ">
	                    <form action="/classes/${course.id}/delete" method="post">
						    	<input type="hidden" name="_method" value="delete">
						    	<button type="submit" class="btn btn-danger btn-sm mb-3" value="Delete">Delete</button>
						</form>
					</div>
            </div>
            </div>
    </div>
            
</body>
</html>
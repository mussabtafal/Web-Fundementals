<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Project</title>
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
        <div class = "row justify-content-around">
            <div class = "col-5 ">
                <h2>Add a New Course!</h2>                
            </div>
            <div class = "col-2 ">
                <a href="/classes">Back to dashboard</a>
            </div>
        </div>
        <div class = "row justify-content-left">
            <div class = "col-7 align-self-center m-5">
                <form:form action="/classes/new" method="post" modelAttribute="course">
                    <form:input type="hidden" path="instructor"  value="${user.id}"/>
                    <div class="form-floating my-3">
	                      <form:input path="name" class="form-control" id="floatingInput" placeholder="name@example.com"/>
	                      <form:label path="name" for="floatingInput">Name:</form:label>
	                      <form:errors path="name" class = "my-3" style="color: red;"/>
                    </div>
                    <div class="form-floating my-3">
	                      <form:input path="weekDay" class="form-control"  id="floatingInput" placeholder="name@example.com"/>
	                      <form:label path="weekDay" for="floatingInput">Day of the Week:</form:label>
	                      <form:errors path="weekDay" class = "my-3" style="color: red;"/>
                    </div>
                    <div class="form-floating my-3">
	                      <form:input path="price" type = "number" min = "0" class="form-control"  id="floatingInput" placeholder="name@example.com"/>
	                      <form:label path="price" for="floatingInput">price:</form:label>
	                      <form:errors path="price" class = "my-3" style="color: red;"/>
                    </div>
                     <div class="form-floating my-3 col-3">
	                      <form:input path="courseTime" type = "text" class="form-control"  id="floatingInput" placeholder="name@example.com"/>
	                      <form:label path="courseTime" for="floatingInput">Time:</form:label>
	                      <form:errors path="courseTime" class = "my-3" style="color: red;"/>
                    </div>                    
                    <div class="form-floating mb-4">
	                      <form:textarea path="description" class="form-control" placeholder="Leave a comment here" name = "description" id="floatingTextarea2" style="height: 100px"></form:textarea>
	                      <form:label path="description" for="floatingTextarea2">description:</form:label>
	                      <form:errors path="description" class = "my-3" style="color: red;"/>
                    </div>
                    <button type="submit" class="btn btn-outline-warning align-self-center">Create</button>
                </form:form>
            </div>
            </div>
    </div>
            
</body>
</html>
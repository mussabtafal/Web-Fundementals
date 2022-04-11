<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Project</title>
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
                <h2>Add a New Project!</h2>                
            </div>
            <div class = "col-2 ">
                <a href="/dashboard">Back to dashboard</a>
            </div>
        </div>
        <div class = "row justify-content-left">
            <div class = "col-7 align-self-center m-5">
                <form:form action="/projects/${project.id}/edit" method="post" modelAttribute="project">
                    <input type="hidden" name="_method" value="put">
                    <form:input type="hidden" path="teamLeader"  value="${user.id}"/>
                    <form:input type="hidden" path="id"  value="${project.id}"/>
                    <div class="form-floating my-3">
                      <form:input path="title" class="form-control" name = "title" id="floatingInput" placeholder="name@example.com"/>
                      <form:label path="title" for="floatingInput">Title:</form:label>
                      <form:errors path="title" class = "my-3" style="color: red;"/>
                    </div>
                    <div class="form-floating mb-4">
                      <form:textarea path="description" class="form-control" placeholder="Leave a comment here" name = "description" id="floatingTextarea2" style="height: 100px"></form:textarea>
                      <form:label path="description" for="floatingTextarea2">description:</form:label>
                    <form:errors path="description" class = "my-3" style="color: red;"/>
                    </div>
                    <div class="form-floating my-3">
                      <form:input path="dueDate" type="date" class="form-control" name = "dueDate" id="floatingInput" placeholder="name@example.com"/>
                      <form:label path="dueDate" for="floatingInput">dueDate:</form:label>
                       <form:errors path="dueDate" class = "my-3" style="color: red;"/>
                    </div>
                    <button type="submit" class="btn btn-outline-warning align-self-center">Create</button>
                    </form:form>
            </div>
            </div>
    </div>
            
</body>
</html>
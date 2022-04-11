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
<title>New Task</title>
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
    	<div class = "row justify-content-between ">
            <div class = "col-5 ">
                <h2>Project: <c:out value="${project.title}"></c:out></h2>
                <h5>Project Lead:<c:out value="${project.teamLeader.userName}"></c:out></h5>                
            </div>
            <div class = "col-2 ">
                <a href="/dashboard">Back to Dashboard</a>
            </div>
        </div>
        <div class = "row justify-content-left">
            <div class = "col-7 align-self-center m-5">
                <form:form action="/projects/${project.id}/tasks" method="post" modelAttribute="task">
                    <form:input type="hidden" path="taskUser"  value="${user.id}"/>
                    <form:input type="hidden" path="taskProject"  value="${project.id}"/>
                    <div class="form-floating mb-4">
                      <form:textarea path="description" class="form-control" placeholder="Leave a comment here" name = "description" id="floatingTextarea2" style="height: 100px"></form:textarea>
                      <form:label path="description" for="floatingTextarea2">Add a Task ticket for this Team:</form:label>
                    <form:errors path="description" class = "my-3" style="color: red;"/>
                    </div>
                    <button type="submit" class="btn btn-outline-warning align-self-center">Submit</button>
                 </form:form>
            </div>
                <c:forEach var="task" items="${tasks}">
                	<jsp:useBean id="date" class="java.util.Date"/>
                    <p>Added By <c:out value="${task.taskUser.userName}"></c:out> at <fmt:formatDate value="${task.createdAt}" type="date" pattern="h:m aa  MMM dd"/></p>
                    <p><c:out value="${task.description}"></c:out></p>
                </c:forEach>
            </div>
        

    </div>
            
</body>
</html>
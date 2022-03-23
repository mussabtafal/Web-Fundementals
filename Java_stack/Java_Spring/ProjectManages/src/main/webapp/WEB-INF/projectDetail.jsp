<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Detail</title>
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
                <h2><c:out value="${project.title}"></c:out></h2>
            </div>
            <div class = "col-2 ">
                <a href="/books">Back to the shelves</a>
            </div>
        </div>
        <div class = "row justify-content-between mt-5">
         <div class = "col-3 align-self-center p-3" style="border-top:1px solid black;border-bottom:1px solid black ">
           <p ><c:out value="${project.description}"></c:out></p>
        </div>
    </div>
    <div class = "row justify-content-between mt-5">
         <div class = "col-3 align-self-center " >
         <p><a href="/projects/${project.id}/tasks">Tasks</a></p>
        </div>
    </div>


    </div>

</body>
</html>
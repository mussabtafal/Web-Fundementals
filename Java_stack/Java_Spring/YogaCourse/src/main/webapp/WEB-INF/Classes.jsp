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
<title>Class Dashboard</title>
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
                <h1>Namaste, <c:out value="${user.name}"></c:out>!</h1>
            </div>
            <div class = "col-2 ">
                <p><a href="/logout">Logout</a></p>
            </div>
            </div>
            <div class = "row justify-content-center">
            	<div class = "col-12 ">
                    <table class="table border col-5  ">
                  <thead>
                    <tr>
                       <th scope="col">Class Name</th>
                       <th scope="col">Instructor</th>
                       <th scope="col">Weekday</th>
                       <th scope="col">price</th>
                       <th scope="col">Time</th>
                    </tr>
                  </thead>
                  <tbody>
                    <c:forEach var="course" items="${courses}">
                    <jsp:useBean id="date" class="java.util.Date"/>                                     
                    <tr>
                        <td ><a href="/classes/${course.id}"><c:out value="${course.name}"></c:out></a>
                        <c:set var="id1" value="${course.instructor.id}"/>
                        <c:set var="id2" value="${user.id}"/>
                        <c:choose>
                            <c:when test="${(id1 == id2)}">
                                <a href="/classes/${course.id}/edit">Edit</a> 
                        </c:when>
                        </c:choose>
                        </td>
                        <td><c:out value="${course.instructor.name}"></c:out></td>
                        <td><c:out value="${course.weekDay}"></c:out></td>
                        <td><c:out value="${course.price}"></c:out></td>                           
                        <td><fmt:formatDate value="${course.courseTime}" type="date" pattern="h:m a"/></td>
                    </tr>
                    </c:forEach>
                  </tbody>
                </table>               
            </div>
        </div>
        <div class = "row justify-content-start">
        	<a href="/classes/new"><button type="submit" class="btn btn-outline-warning align-self-center">Add new Class !</button></a>
        </div>
    </div>           
</body>
</html>
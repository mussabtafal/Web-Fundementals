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
<title>Course Details</title>
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
                <h2><c:out value="${course.name}"></c:out> with <c:out value="${course.instructor.name}"></c:out></h2>
            </div>
            <div class = "col-2 ">
                <a href="/classes">Go Back</a>
            </div>
        </div>
        <div class = "row justify-content-between mt-5">
         <div class = "col-5 align-self-between p-3" >
           <h4>Day: <c:out value="${course.weekDay}"></c:out></h4>
           <h4>Cost : <c:out value="${course.price}"></c:out></h4>
           <h4>Time : <fmt:formatDate value="${course.courseTime}" type="date" pattern="h:m a"/></h4>
            <p><c:out value="${course.description}"></c:out></p>
        </div>
    </div>
        <div class = "row justify-content-between">
            <div class = "col-9 ">
                <h3>Students</h3>
                    <c:forEach var="item" items="${students}">
                    <jsp:useBean id="date" class="java.util.Date"/>
                    <p><c:out value="${item.name}"></c:out> <c:out value="${item.email}"></c:out></p>
                    </c:forEach>
            </div>
            </div>
        <div class = "row justify-content-between">
        <h1 style="color:#2b78e4">Add student to course</h1>
            <div class = "col-5 mt-5">
                <h2>Register</h2>
                <form:form action="/classes/${course.id}" method="post" modelAttribute="student">
                    <div class="form-floating my-3">
                      <form:input path="name" class="form-control" name = "name" id="floatingInput" placeholder="name@example.com"/>
                      <form:label path="name" for="floatingInput">Name:</form:label>
                        <form:errors path="name" class = "my-3" style="color: red;"/>
                    </div>
                    <div class="form-floating my-3">
                      <form:input type="email" path="email" class="form-control" name = "email" id="floatingInput" placeholder="name@example.com"/>
                      <form:label path="email" for="floatingInput">Email:</form:label>
                        <form:errors path="email" class = "my-3" style="color: red;"/>
                    </div>
                    <button type="submit" class="btn btn-outline-warning align-self-center">Submit</button>
                    </form:form>
            </div>
            <div class = "col-5 mt-5">
               <form action="/classes/${course.id}/relating" method="get">
                    <select class="form-select form-select-lg mb-3" aria-label=".form-select-lg example" name = "st">
                          <c:forEach var="student" items="${allStudents}">
                              <option value="${student.id}"><c:out value="${student.name}"></c:out>- <c:out value="${student.email}"></c:out></option>
                          </c:forEach>
                    </select>
                    <button type="submit" class="btn btn-outline-warning align-self-center">New Student</button>
                 </form>
            </div>
        </div>
    </div>
</body>
</html>
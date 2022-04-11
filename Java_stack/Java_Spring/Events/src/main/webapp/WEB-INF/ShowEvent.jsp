<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Event Details</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="containter-md-fluid p-5 m-5">
        <div class="row justify-content-between">
            <div class="col-5">
                <h2><c:out value="${event.name}"></c:out></h2>
                <p>Host: <c:out value="${event.host.firstName}"></c:out> <c:out value="${event.host.firstName}"></c:out></p>
                <p>Location: <c:out value="${event.location}"></c:out></p>
                <p>People who are attending: <c:out value="${event.joinedUsers.size()}"></c:out></p>
                <table class="table border col-5  ">
                  <thead>
                    <tr>
                          <th scope="col" class = "col-1">Name</th>
                          <th scope="col" class = "col-1">Location</th>
                    </tr>
                  </thead>
                  <tbody>
                    <c:forEach var="person" items="${event.joinedUsers}">              
                    <tr>
                        <td><c:out value="${person.firstName}"></c:out> <c:out value="${person.lastName}"></c:out></td>
                        <td><c:out value="${person.location}"></c:out></td>          
                     </tr> 
                    </c:forEach>
                    </tbody>
                </table>    
            </div>
            <div class="col-5">
            	<h3>Message Wall</h3>
            	<div class = "overflow-auto border p-4" style="height: 200px;">
           			<c:forEach var="message" items="${event.eventMessages}">
		        		<p><c:out value="${message.messageUser.firstName}"></c:out> <c:out value="${message.messageUser.lastName}"></c:out>: <c:out value="${message.text}"></c:out></p>
		   				<p class = "my-3">-----------------------------</p>
		   			</c:forEach>
		   		</div>
		   		<form:form action="/events/${event.id}" method="post" modelAttribute="message">
        		<form:input type="hidden" path="messageUser"  value="${user.id}"/>
        		<form:input type="hidden" path="messageEvent"  value="${event.id}"/>
       			<div class="form-floating my-3">
                     <form:input path="text" class="form-control" name = "text" id="floatingInput" placeholder="name@example.com"/>
                     <form:label path="text" for="floatingInput">Comment:</form:label>
                     <form:errors path="text" class = "my-3" style="color: red;"/>
          		</div>
          		<button type="submit" class="btn btn-outline-warning align-self-center">Comment</button>
                </form:form>
            </div>
        </div>
   </div>
</body>
</html>
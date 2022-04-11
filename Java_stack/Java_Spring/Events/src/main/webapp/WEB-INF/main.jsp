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
<title>Event Dashboard</title>
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
            <div class = "col-7 ">
                <h1>Welcome, <c:out value="${user.firstName}"></c:out>!</h1>
            </div>
            <div class = "col-2 ">
                <p><a href="/logout">Logout</a></p>
            </div>
            </div>
            <div class = "row justify-content-center">
            	<div class = "col-9 ">
                  <table class="table border col-5  ">
                  <thead>
                    <tr>
                          <th scope="col" class = "col-1">Name</th>
                          <th scope="col" class = "col-1">Date</th>
                          <th scope="col" class = "col-1">Location</th>
                          <th scope="col" class = "col-1">Host</th>
                          <th scope="col" class = "col-1">Action</th>
                    </tr>
                  </thead>
                  <tbody>
                    <c:forEach var="item" items="${inStateEvent}">
                    <jsp:useBean id="date" class="java.util.Date"/>                
                    <tr>
                        <td><a href="/events/${item.id}"><c:out value="${item.name}"></c:out></a></td>
                        <td><c:out value="${item.eventDate}"></c:out></td>
                        <td><c:out value="${item.location}"></c:out></td>
                        <td><c:out value="${item.host.firstName}"></c:out></td>
                        <c:set var="id1" value="${item.host.id}"/>
                        <c:set var="id2" value="${user.id}"/>
                            <c:choose>
                                <c:when test="${(id1 == id2)}">
                                    <td><a href="/events/${item.id}/edit">Edit</a>  <a href="/events/${item.id}/delete">Delete</a></td>
                            	</c:when>
                                <c:otherwise>
                                    <c:set var="attending" value="${false}"/>
                                    <c:forEach items="${item.joinedUsers}" var="attendee">
                                    <c:set var="user1" value="${attendee.id}"/>
                                    <c:set var="user2" value="${user.id}"/>
                                        <c:if test="${user1 == user2}">
                                            <c:set var="attending" value="${true}"/>
                                        </c:if>
                                    </c:forEach>
                                    <c:choose>
                                        <c:when test="${attending == false}">
                                            <td><a href="/events/${item.id}/join">Join</a></td>
                                        </c:when>
                                        <c:otherwise>
                                            <td>Attending | <a href="events/${item.id}/cancel">Cancel</a></td>
                                        </c:otherwise>
                                    </c:choose>
                                </c:otherwise>
                            </c:choose>                
                     </tr> 
                    </c:forEach>
                  </tbody>
                </table>
                 <table class="table border col-5  ">
                  <thead>
                    <tr>
                          <th scope="col" class = "col-1">Name</th>
                          <th scope="col" class = "col-1">Date</th>
                          <th scope="col" class = "col-1">Location</th>
                          <th scope="col" class = "col-1">Host</th>
                          <th scope="col" class = "col-1">Action</th>
                    </tr>
                  </thead>
                  <tbody>
                    <c:forEach var="item" items="${outStateEvent}">              
                    <tr>
                        <td><a href="/events/${item.id}"><c:out value="${item.name}"></c:out></a></td>
                        <td><c:out value="${item.eventDate}"></c:out></td>
                        <td><c:out value="${item.location}"></c:out></td>
                        <td><c:out value="${item.host.firstName}"></c:out></td>
                        <c:set var="id1" value="${item.host.id}"/>
                        <c:set var="id2" value="${user.id}"/>
                         <c:choose>
                                <c:when test="${(id1 == id2)}">
                                    <td><a href="/events/${item.id}/edit">Edit</a>  <a href="/events/${item.id}/delete">Delete</a></td>
                            	</c:when>
                                <c:otherwise>
                                    <c:set var="attending" value="${false}"/>
                                    <c:forEach items="${item.joinedUsers}" var="attendee">
                                    <c:set var="user1" value="${attendee.id}"/>
                                    <c:set var="user2" value="${user.id}"/>
                                        <c:if test="${user1 == user2}">
                                            <c:set var="attending" value="${true}"/>
                                        </c:if>
                                    </c:forEach>
                                    <c:choose>
                                        <c:when test="${attending == false}">
                                            <td><a href="/events/${item.id}/join">Join</a></td>
                                        </c:when>
                                        <c:otherwise>
                                            <td>Attending | <a href="events/${item.id}/cancel">Cancel</a></td>
                                        </c:otherwise>
                                    </c:choose>
                                </c:otherwise>
                            </c:choose>                  
                     </tr> 
                    </c:forEach>
                  </tbody>
                </table>                
            </div>
        </div>
        <div class = "row justify-content-center">
        	<div class = "col-4 ">
        	<form:form action="/events" method="post" modelAttribute="event">
        	<form:input type="hidden" path="host"  value="${user.id}"/>
       			<div class="form-floating my-3">
                     <form:input path="name" class="form-control" name = "name" id="floatingInput" placeholder="name@example.com"/>
                     <form:label path="name" for="floatingInput">Name:</form:label>
                     <form:errors path="name" class = "my-3" style="color: red;"/>
          		</div>
          		<div class="form-floating my-3">
                      <form:input type="date" path="eventDate" class="form-control" name = "eventDate" id="floatingInput" placeholder="name@example.com"/>
                      <form:label path="eventDate" for="floatingInput">Birthday:</form:label>
                      <form:errors path="eventDate" class = "my-3" style="color: red;"/>
                </div>
                <div class="form-floating my-3">
                      <form:input path="location" class="form-control" name = "lastName" id="floatingInput" placeholder="name@example.com"/>
                      <form:label path="location" for="floatingInput">location</form:label>
                      <form:select path="state" class="form-control" >
                          <form:option value="AL" >AL</form:option>
                          <form:option value="AK" >AK</form:option>
                          <form:option value="AR" >AR</form:option>
                          <form:option value="CR" >CR</form:option>
                          <form:option value="DE" >DE</form:option>
                          <form:option value="DC" >DC</form:option>
                          <form:option value="ID" >ID</form:option>
                          <form:option value="KS" >KS</form:option>
                          <form:option value="LA" >LA</form:option>
                          <form:option value="CA" >CA</form:option>
                          <form:option value="WA" >WA</form:option>
                          <form:option value="AZ" >AZ</form:option>
                       </form:select>
                      <form:errors path="location" class = "my-3" style="color: red;"/>
                 </div>
                 <button type="submit" class="btn btn-outline-warning align-self-center">Add</button>
                 </form:form>
        	</div>
        </div>
    </div>
            
</body>
</html>
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
<title>Edit Event</title>
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
                <h3>Edit Event</h3>
                <form:form action="/events/${myEvent.id}/edit" method="post" modelAttribute="myEvent">
                <input type="hidden" name="_method" value="put">
                <form:input type="hidden" path="host"  value="${user.id}"/>
                <form:input type="hidden" path="id"  value="${event.id}"/>
                    <div class="form-floating my-3">
                      <form:input path="name" class="form-control" name = "name" id="floatingInput" placeholder="name@example.com"/>
                      <form:label path="name" for="floatingInput">Name:</form:label>
                      <form:errors path="name" class = "my-3" style="color: red;"/>
                    </div>
                    <div class="form-floating my-3">
                      <form:input type="date" path="eventDate" class="form-control" name = "eventDate" id="floatingInput" placeholder="name@example.com"/>
                      <form:label path="eventDate" for="floatingInput">Event Date:</form:label>
                      <form:errors path="eventDate" class = "my-3" style="color: red;"/>
                    </div>
                    <div class="form-floating my-3">
                          <form:input path="location" class="form-control" name = "location" id="floatingInput" placeholder="name@example.com"/>
                          <form:label path="location" for="floatingInput">location</form:label>
                          <form:errors path="location" class = "my-3" style="color: red;"/>
                     </div>
                      <div class="form-floating my-3">
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
                      </div>
                    
                    <button type="submit" class="btn btn-outline-warning align-self-center">Edit</button>
                    </form:form>
            </div>
        </div>
    </div>
            
</body>
</html>
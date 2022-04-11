<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New</title>
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
    	<h1>Welcome!</h1>
    	<h5>Join our growing community</h5>
            <div class = "col-5 mt-5">
    			<h2>Register</h2>
                <form:form action="/guest/signin/register" method="post" modelAttribute="newUser">
                   <div class="form-floating my-3">
                      <form:input path="firstName" class="form-control" name = "firstName" id="floatingInput" placeholder="name@example.com"/>
                      <form:label path="firstName" for="floatingInput">First Name:</form:label>
                        <form:errors path="firstName" class = "my-3" style="color: red;"/>
                    </div>
                    <div class="form-floating my-3">
                      <form:input path="lastName" class="form-control" name = "lastName" id="floatingInput" placeholder="name@example.com"/>
                      <form:label path="lastName" for="floatingInput">Last Name:</form:label>
                        <form:errors path="lastName" class = "my-3" style="color: red;"/>
                    </div>                  
                    <div class="form-floating my-3">
                      <form:input type="email" path="email" class="form-control" name = "email" id="floatingInput" placeholder="name@example.com"/>
                      <form:label path="email" for="floatingInput">Email:</form:label>
                        <form:errors path="email" class = "my-3" style="color: red;"/>
                    </div>
                    <div class="form-floating my-3">
                      <form:input type="password" path="password" class="form-control" name = "password" id="floatingInput" placeholder="name@example.com"/>
                      <form:label path="password" for="floatingInput">Password:</form:label>
                        <form:errors path="password" class = "my-3" style="color: red;"/>
                    </div>
                    <div class="form-floating my-3">
                      <form:input type="password"  path="confirm" class="form-control" name = "confirm" id="floatingInput" placeholder="name@example.com"/>
                      <form:label path="confirm" for="floatingInput">Confirm Password:</form:label>
                        <form:errors path="confirm" class = "my-3" style="color: red;"/>
                    </div>
					<div class="form-floating my-3 col-3">
                      <form:select path="status" class="form-control" >
                          <form:option value="host" >Host</form:option>
                          <form:option value="guest" >Guest</form:option>
                       </form:select>
                    </div>
                    <button type="submit" class="btn btn-outline-warning align-self-center">Register</button>
                    </form:form>
    		</div>
    		 <div class = "col-5 mt-5">
    			<h2>Login</h2>
                <form:form action="/guest/signin/login" method="post" modelAttribute="newLogin">
                    <div class="form-floating my-3">
                      <form:input type="email" path="email" class="form-control" name = "email" id="floatingInput" placeholder="name@example.com"/>
                      <form:label path="email" for="floatingInput">Email:</form:label>
                        <form:errors path="email" class = "my-3" style="color: red;"/>
                    </div>
                    <div class="form-floating my-3">
                      <form:input type="password" path="password" class="form-control" name = "password" id="floatingInput" placeholder="name@example.com"/>
                      <form:label path="password" for="floatingInput">Password:</form:label>
                        <form:errors path="password" class = "my-3" style="color: red;"/>
                    </div>
                    <button type="submit" class="btn btn-outline-warning align-self-center">Log In</button>
                    </form:form>
    		</div>
    		</div>
    </div>
    		
</body>
</html>
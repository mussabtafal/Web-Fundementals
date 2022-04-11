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
                <h2><c:out value="${question.name}"></c:out></h2>                
            </div>
            <div class = "col-2 ">
                <a href="/questions">Back to dashboard</a>
            </div>
        </div>
        <div class = "row justify-content-around">
            <div class = "col-5 ">
            	<p>
                 <c:forEach var="tag" items="${question.questionTags}">
	                <button type="button" class="btn btn-outline-warning align-self-center"><c:out value="${tag.subject}"></c:out></button>  
	             </c:forEach>                  
            	</p>
            </div>
        </div>
        <div class = "row justify-content-between">
	       <div class = "col-4 ">
	               <table class="table border col-5  ">
	             <thead>
	               <tr>
                     <th scope="col">Answers</th>
	               </tr>
	             </thead>
	             <tbody>
	               <c:forEach var="answer" items="${question.questionAnswer}">
	               <tr>
	                   <td>
	                    	<c:out value="${answer.name}"></c:out> 
	                    </td>                 
	               </tr>
	               </c:forEach>
	             </tbody>
	           </table>
	       </div>
            <div class = "col-7 align-self-center m-5">
            	<h4>Add your Answer</h4>
                <form:form action="/questions/${question.id}" method="post" modelAttribute="answer">
                <form:input type="hidden" path="question"  value="${question.id}"/>
                    <div class="form-floating mb-4">
                      <form:textarea path="name" class="form-control" placeholder="Leave a comment here" id="floatingTextarea2" style="height: 100px"></form:textarea>
                      <form:label path="name" for="floatingTextarea2">Answer:</form:label>
                    <form:errors path="name" class = "my-3" style="color: red;"/>
                    </div>
                    <button type="submit" class="btn btn-outline-warning align-self-center">Add</button>
                </form:form>
            </div>
        </div>
    </div>      
</body>
</html>
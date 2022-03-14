<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<body>
	<h1>Here's Your Omikuji!</h1>
	<div class="card text-dark bg-info mb-3" style="max-width: 18rem;">
	  <div class="card-body">
    <p class="card-text">In <c:out value="${number}"/> years, You will live in <c:out value="${city}"/> with <c:out value="${name}"/>
    as your <br>roommate, <c:out value="${hobby}"/> for a living. The next time you see a <c:out value="${animal}"/>, you will have
     good luck. Also, <c:out value="${nice}"/></p>
		</div>
	</div>
	<a href="/omikuji">Go Back</a>
</body>
</html>
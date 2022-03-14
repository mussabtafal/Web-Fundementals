<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page Counter Info</title>
</head>
<body>
<h2>You have visited <a href="http://localhost:8080/">http://localhost:8080/</a> <c:out value="${counter}"/> times <br> Test another 
visit <a href="http://localhost:8080/">Test another visit ?</a></h2>

</body>
</html>
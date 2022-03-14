<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Customer Name: <c:out value="${fullname}"/></h1>
<h2>Item name: <c:out value="${item}"/></h2>
<h2>Price: $<c:out value="${itemprice}"/></h2>
<h2>Description: <c:out value="${desc}"/></h2>
<h2>vendor: <c:out value="${supplier}"/></h2>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Time Template</title>
<link rel="stylesheet" type="text/css" href="/css/Time.css">
<script type="text/javascript" src="js/Time.js"></script>

</head>

<body>
<%java.text.DateFormat df = new java.text.SimpleDateFormat("k:mm  a"); %>
	 <h1><%= df.format(new java.util.Date()) %></h1>
</body>
</html>
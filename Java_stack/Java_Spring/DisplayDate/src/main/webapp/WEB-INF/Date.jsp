<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Date Template</title>
<link rel="stylesheet" type="text/css" href="/css/Date.css">
<script type="text/javascript" src="js/Date.js"></script>
</head>
<body>
<%java.text.DateFormat df = new java.text.SimpleDateFormat("EEEE, 'the' d  'of' MMMM, YYYY"); %>
	 <h1><%= df.format(new java.util.Date())%></h1>
</body>
</html>
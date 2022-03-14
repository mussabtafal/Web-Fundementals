<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ninja Gold</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container border px-5 pt-5">
        <label for="Gold" class="ms-5 me-3" style="font-size: 20px;">Your Gold</label>
        <input type="text" id="Gold" name = "gold" value = "<c:out value="${gold}"/>" readonly>
        <form action="/reset">
        	<button type="submit" class="btn btn-danger mt-3 ms-5">Reset</button>
        </form>
        <div class="row mx-auto mt-5 justify-content-center">
            <div class="col-2 text-center border border-dark mx-4 px-3 py-5">
                <h1>Farm</h1>
                <p style="font-size: 12px;">(earns 10-20 golds)</p>
                <form method="post" action="/process">
                    <input type="hidden" name="gold" value="farm">
                    <button type="submit" class="btn btn-secondary mt-3">Find Gold!</button>
                </form>
            </div>
            <div class="col-2 text-center border border-dark mx-3 px-3 py-5">
                <h1>Cave</h1>
                <p style="font-size: 12px;">(earns 10-20 golds)</p>
                <form method="post" action="/process">
                    <input type="hidden" name="gold" value="cave">
                    <button type="submit" class="btn btn-secondary mt-3">Find Gold!</button>
                </form>
            </div>
            <div class="col-2 text-center border border-dark mx-3 px-3 py-5">
                <h1>House</h1>
                <p style="font-size: 12px;">(earns 10-20 golds)</p>
                <form method="post" action="/process">
                    <input type="hidden" name="gold" value="house">
                    <button type="submit" class="btn btn-secondary mt-3">Find Gold!</button>
                </form>
            </div>
            <div class="col-2 text-center border border-dark mx-3 px-2 py-5">
                <h1>Quest</h1>
                <p style="font-size: 11px;">(earns/takes 0-50 golds)</p>
                <form method="post" action="/process">
                    <input type="hidden" name="gold" value="quest">
                    <button type="submit" class="btn btn-secondary mt-3">Find Gold!</button>
                </form>
            </div>
            <div class="col-2 text-center border border-dark mx-3 px-2 py-5">
                <h1>Spa</h1>
                <p style="font-size: 11px;">(takes 5-20 golds)</p>
                <form method="post" action="/process">
                    <input type="hidden" name="gold" value="spa">
                    <button type="submit" class="btn btn-secondary mt-3">Find Gold!</button>
                </form>
            </div>
        </div>
        <div class="row mt-5 col-12 px-5 mb-5">
            <label for="activities" style="font-size: 20px;">Activities</label>
            <div class="col-12 border p-2 overflow-auto" style="height: 200px;">
            	<c:forEach var="goldLog" items="${arrLen}">
			        <c:out value="${goldLog}" escapeXml="false"></c:out>
			    </c:forEach>
            </div>
        </div>
    </div>
</body>
</html>
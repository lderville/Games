<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
	integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn"
	crossorigin="anonymous">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style>
li {
	list-style: none;
}
</style>

<meta charset="UTF-8">
<title>Home</title>
</head>
<body class="bg-dark">

	<%@include file="/header/header.jspf"%>
	<br><br>
<div class = "text-center">
	<img class ="rounded" src="logo/mots-melanges.png">
	
	<br><br>
	<c:forEach var="i" begin="0" end="${sessionScope.nombre_lettre}" step="1">
		<h1 class="text-warning d-inline mx-2">
			<c:out value="${sessionScope.mot_mel.charAt(i)}" />
		</h1>
	</c:forEach>

</div>
</body>
</html>
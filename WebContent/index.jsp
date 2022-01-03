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

	<br>
	<br>
	<br>
	<div class = "d-flex">
		<div class="card bg-dark mx-4" style="width: 18rem;">
			<img class="card-img-top" src="logo/potence.png" alt="Card image cap">
			<div class="card-body">
				<h5 class="card-title text-warning">Jeu Du Pendu</h5>
				<p class="card-text text-warning">jouer à la version classique
					du pendu</p>
				<a href="<c:url value = "pendu"/>" class="btn btn-outline-warning">Jouer</a>
			</div>
		</div>
		<div class="card bg-dark mx-1" style="width: 18rem;">
			<img class="card-img-top" src="logo/mots-melanges.png" alt="Card image cap">
			<div class="card-body">
			<br>
	<br>
	<br><br>
				<h5 class="card-title text-warning">Mot Mélangé</h5>
				<p class="card-text text-warning">jouer à la version classique
					du mot mélangé</p>
				<a href="<c:url value = "motMelange"/>" class="btn btn-outline-warning">Jouer</a>
			</div>
		</div>
	</div>


</body>
</html>
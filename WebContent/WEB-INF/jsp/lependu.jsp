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
<title>Le pendu</title>
</head>
<body class="bg-dark">

	<%@include file="/header/header.jspf"%>

<br><br><br>
<h1 class="text-center text-warning">LE PENDU</h1>
<br>
<div class="text-center">
<img class ="rounded" src="${sessionScope.urlimage}">
</div>
<h2 class="text-center text-warning">Le mot à trouver</h2>
<br>
<div class ="text-center">
<c:forEach var="i" begin="0" end="${sessionScope.nblettres}" step="1">
    <h1 class ="text-warning d-inline mx-1"><c:out value="${sessionScope.mot_a_trouver_vide.charAt(i)}"/></h1>
</c:forEach>
<br><br>
<br><br>

<h2 class="text-center text-warning">Cliquer sur la lettre de votre choix</h2>
<br><br>

<div class=" form-inline justify-content-center">  
<form action="<c:url value ="/pendu"/>" method="post">
    <input type="hidden" name="choixlettre" value="a" />
    <button class="btn btn-outline-warning" null>A</button>
</form>
<form action="<c:url value ="/pendu"/>" method="post">
    <input type="hidden" name="choixlettre" value="b" />
    <button class="btn btn-outline-warning">B</button>
</form>
<form action="<c:url value ="/pendu"/>" method="post">
    <input type="hidden" name="choixlettre" value="c" />
    <button class="btn btn-outline-warning">C</button>
</form>
<form action="<c:url value ="/pendu"/>" method="post">
    <input type="hidden" name="choixlettre" value="d" />
    <button class="btn btn-outline-warning">D</button>
</form>
<form action="<c:url value ="/pendu"/>" method="post">
    <input type="hidden" name="choixlettre" value="e" />
    <button class="btn btn-outline-warning">E</button>
</form>
<form action="<c:url value ="/pendu"/>" method="post">
    <input type="hidden" name="choixlettre" value="f" />
    <button class="btn btn-outline-warning">F</button>
</form>
<form action="<c:url value ="/pendu"/>" method="post">
    <input type="hidden" name="choixlettre" value="g" />
    <button class="btn btn-outline-warning">G</button>
</form>
<form action="<c:url value ="/pendu"/>" method="post">
    <input type="hidden" name="choixlettre" value="h" />
    <button class="btn btn-outline-warning">H</button>
</form>
<form action="<c:url value ="/pendu"/>" method="post">
    <input type="hidden" name="choixlettre" value="i" />
    <button class="btn btn-outline-warning">I</button>
</form>
<form action="<c:url value ="/pendu"/>" method="post">
    <input type="hidden" name="choixlettre" value="j" />
    <button class="btn btn-outline-warning">J</button>
</form>
<form action="<c:url value ="/pendu"/>" method="post">
    <input type="hidden" name="choixlettre" value="k" />
    <button class="btn btn-outline-warning">K</button>
</form>
<form action="<c:url value ="/pendu"/>" method="post">
    <input type="hidden" name="choixlettre" value="l" />
    <button class="btn btn-outline-warning">L</button>
</form>

<form action="<c:url value ="/pendu"/>" method="post">
    <input type="hidden" name="choixlettre" value="m" />
    <button class="btn btn-outline-warning">M</button>
</form>
</div> 
<div class=" form-inline justify-content-center"> 
<form action="<c:url value ="/pendu"/>" method="post">
    <input type="hidden" name="choixlettre" value="n" />
    <button class="btn btn-outline-warning">N</button>
</form>
<form action="<c:url value ="/pendu"/>" method="post">
    <input type="hidden" name="choixlettre" value="o" />
    <button class="btn btn-outline-warning">O</button>
</form>
<form action="<c:url value ="/pendu"/>" method="post">
    <input type="hidden" name="choixlettre" value="p" />
    <button class="btn btn-outline-warning">P</button>
</form>
<form action="<c:url value ="/pendu"/>" method="post">
    <input type="hidden" name="choixlettre" value="q" />
    <button class="btn btn-outline-warning">Q</button>
</form>
<form action="<c:url value ="/pendu"/>" method="post">
    <input type="hidden" name="choixlettre" value="r" />
    <button class="btn btn-outline-warning">R</button>
</form>
<form action="<c:url value ="/pendu"/>" method="post">
    <input type="hidden" name="choixlettre" value="s" />
    <button class="btn btn-outline-warning">S</button>
</form>
<form action="<c:url value ="/pendu"/>" method="post">
    <input type="hidden" name="choixlettre" value="t" />
    <button class="btn btn-outline-warning">T</button>
</form>
<form action="<c:url value ="/pendu"/>" method="post">
    <input type="hidden" name="choixlettre" value="u" />
    <button class="btn btn-outline-warning">U</button>
</form>
<form action="<c:url value ="/pendu"/>" method="post">
    <input type="hidden" name="choixlettre" value="v" />
    <button class="btn btn-outline-warning">V</button>
</form>
<form action="<c:url value ="/pendu"/>" method="post">
    <input type="hidden" name="choixlettre" value="w" />
    <button class="btn btn-outline-warning">W</button>
</form>
<form action="<c:url value ="/pendu"/>" method="post">
    <input type="hidden" name="choixlettre" value="x" />
    <button class="btn btn-outline-warning">X</button>
</form>
<form action="<c:url value ="/pendu"/>" method="post">
    <input type="hidden" name="choixlettre" value="y" />
    <button class="btn btn-outline-warning">Y</button>
</form>
<form action="<c:url value ="/pendu"/>" method="post">
    <input type="hidden" name="choixlettre" value="z" />
    <button class="btn btn-outline-warning">Z</button>
</form>

</div> 
</div>
</body>
</html>
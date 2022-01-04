<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="en">
<head>
<meta content="text/html" charset="UTF-8" name="viewport"
	content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
	integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn"
	crossorigin="anonymous">
<title>Connexion</title>

</head>

<body class="text-center bg-dark">
	<section class="container w-50 pt-5">
		<div>
			<a href="<c:url value = "/home"/>"><img class="mt-5 mb-4"
				src="logo/logo.png" alt="Logo enchères" /></a>
		</div>
		<h1 class="h5 mb-3 text-warning">Veuillez vous connecter</h1>
		<h3 class="h5 mb-3 text-danger Normal weight text.">${requestScope.wrongpassword}</h3>
		
		
	</section>

	<section class="container w-50">
		<div class="row justify-content-center">
			<form class="w-50 col-5" name="loginForm" method="post"
				action="<c:url value = "/login"/>">
				<div class="form-control-sm mb-2">
					<input name="userID" type="text" class="form-control"
						id="floatingInput" placeholder="Identifiant" required>
				</div>

				<div class="form-control-sm mb-3">
					<input name="password" type="password" class="form-control"
						id="floatingPassword" placeholder="Mot de passe" required>
				</div>

				<div class="checkbox mb-1">
					<label> <input type="checkbox" value="remember-me">
						<small class ="text-warning">Se souvenir de moi</small> <br> <a href="#"><small class="text-warning">Mot
								de passe oublié</small></a>
					</label>
				</div>

				<div>
					<button type="submit" class="btn btn-sm btn-warning w-100 mb-2">Connexion</button>
				</div>
			</form>
		</div>
	</section>

	<section class="container w-50">
		<div class="row justify-content-center">
			<div class="w-100 col-5">
				
					<a href="<c:url value = "/home"/>"><small class ="text-warning">Retour à la page
						d'accueil</small></a>
			</div>
		</div>
		<p class="mt-5 mb-3 text-muted">
			<small>&copy; 2021 - Jeux en ligne</small>
		</p>
	</section>
</body>
</html>
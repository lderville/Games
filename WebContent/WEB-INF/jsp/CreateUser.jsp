<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta content="text/html" charset="UTF-8" name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=yes">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
	integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn"
	crossorigin="anonymous">

<title>Inscription</title>

<style type="text/css">
.ast {
	color: #FF030F;
}

;
.asterix label.e-label-top::after {
	content: "*";
	color: red;
}
</style>

</head>

<body class="bg-dark">



	<ejs-autocomplete #ddlChallanType #purchaseType floatLabelType="Always"
		[fields]="localFields" [ngClass]="{ 'asterix' : enableAsterix }"
		placeholder=" Choose challan type 
" showPopupButton="true"
		[dataSource]="countries"> </ejs-autocomplete>

	<section class="container">
		<div class="row" style="text-align: center">
			<div class="col">
				<a href="<c:url value = "/home"/>"><img class="mt-5 mb-4"
					src="logo/logo.png" alt="Logo_encheres" /></a>
			</div>
		</div>
	</section>

	<section class="container">
		<div class="row text-center">
			<div class="col-md-2 col-lg-2 col-xl-4 col-4"></div>
			<div class="col-auto mb-0">
				<h1 class="text-warning h6">Inscrivez-vous pour profiter des
					nouveaux jeux !</h1>
				<p>
					<small class="text-warning">Les champs marqués d'une <font
						class="ast">*</font> sont obligatoires
					</small>
				</p>
				<h3 class="text-danger" >${requestScope.wrong}</h3>
			</div>
			<div class="col-md-2 col-lg-2 col-xl-4 col-4"></div>
		</div>
	</section>

	<section class="container">
		<div class="row">
			<div class="col-4"></div>
			<div class="col-xs-10 col-sm-8 col-md-8">
				<form action="<c:url value="CreateUser"/>" method="post">
					<div class="col-6 mb-0">
							<input value="${requestScope.inscription.pseudo}" style="resize: none" class="form-control form-control-sm mb-2" type="text" name="pseudo" required>
							<input value="${requestScope.inscription.prenom}" class="form-control form-control-sm" type="text" name="prenom" required>
							<input value="${requestScope.inscription.nom}" class="form-control form-control-sm mb-2" type="text" name="nom" required>
							<input value="${requestScope.inscription.email}" class="form-control form-control-sm" type="text" name="mail" required>
							<input value="${requestScope.inscription.telephone}" class="form-control form-control-sm" type="text" name="phone" maxlength=10 required>
						<p class="mt-0 mb-1">
							<small class="text-warning"><em>Format 0600000000</em></small>
						</p>
							<input value="${requestScope.inscription.rue}" class="form-control form-control-sm" type="text" name="rue" required>
							<input value="${requestScope.inscription.codePostal}" class="form-control form-control-sm" type="text" name="cp" maxlength=5 required> 
							<input value="${requestScope.inscription.ville}" class="form-control form-control-sm mb-2" type="text" name="ville" required> 
							<input placeholder="mot de passe*" class="form-control form-control-sm" type="password" name="password" required>
							<input placeholder="Confirmer le mot de passe*" class="form-control form-control-sm" type="password" name="PasswordConf" required>
							 <p class="mb-2">
							<small class="text-warning">Le mot de passe doit :<br>
								- Comporter entre 5 et 25 caractères<br> - Contenir une
								miniscule et une majuscule<br> - Contenir au moins un
								chiffre
							</small>
						</p>
						<button
							class="btn btn-sm btn-success mb-2 justify-content-center w-100"
							type="submit">Valider l'inscription</button>
					</div>
				</form>
			</div>
			<div class="col-4"></div>
		</div>
	</section>

	<section class="container">
		<div class="row">
			<div class="col col-4"></div>
			<div class="col col-4">
				<div
					class="col-xs-12 col-sm-12 col-md-12 col-lg-8 col-xl-8 col-8 mb-0">
					<a href="<c:url value="home" />"><button
							class="btn btn-sm btn-danger w-100">Annuler</button></a>
				</div>
			</div>
			<div class="col col-4"></div>
		</div>
	</section>

</body>
</html>
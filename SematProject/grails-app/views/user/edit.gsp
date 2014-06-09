<%@ page import="sematproject.User" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="barraUsuario">
		<title>Perfil</title>
	</head>
	<body>
		<g:form method="post">
			<g:hiddenField name="id" value="${userInstance?.id}" />
			<g:hiddenField name="version" value="${userInstance?.version}" />
			<ul id="editarPanel">
				<li><p id="letraGrandeEditar">Datos usuario</p></li>
				<li><g:textField id="campoTextoE" name="realname" required="" value="${userInstance?.realname}" placeholder="Nombre y apellido"/></li>
				<li><g:field id="campoTextoE" type="email" name="email" required="" value="${userInstance?.email}" placeholder="Correo eletrónico"/></li>
				<li><g:textField id="campoTextoE" name="name" required="" value="${userInstance?.name}" placeholder="Usuario"/></li>
				<li><g:field id="campoTextoE" type="password" name="password" maxlength="15" required="" value="${userInstance?.password}" placeholder="Contraseña"/></li>
				<li><g:if test="${flash.message}"><p id="errorIngresoR">Has introducido un nombre de usuario o correo electrónico que ya existe<br><br>Por favor intenta de nuevo.</p></g:if></li>
				<li><g:actionSubmit id="botonEditar" class="save" action="update" value="Actualizar"/></li>
			</ul>
		</g:form>
	</body>
</html>

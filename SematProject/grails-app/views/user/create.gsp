<%@ page import="sematproject.User" %>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet"href="${resource(dir: 'css', file: 'estilo.css')}" type="text/css" />
	</head>
	
	<body id="fondoRegistro">
	
		<g:form controller="user" action="save" method="post">
			<ul id="registroPanel">
				<li><p id="letraGrandeRegistro">Únete al Semat</p></li>
				<li><g:textField id="campoTextoR" name="realname" required="" value="${userInstance?.realname}" placeholder="Nombre y apellido"/></li>
				<li><g:field id="campoTextoR" type="email" name="email" required="" value="${userInstance?.email}" placeholder="Correo eletrónico"/></li>
				<li><g:textField id="campoTextoR" name="name" required="" value="${userInstance?.name}" placeholder="Usuario"/></li>
				<li><g:field id="campoTextoR" type="password" name="password" maxlength="15" required="" value="${userInstance?.password}" placeholder="Contraseña"/></li>
				<li><g:if test="${flash.message}"><p id="errorIngresoR">Has introducido un nombre de usuario o correo electrónico que ya existe<br><br>Por favor intenta de nuevo.</p></g:if></li>
				<li><g:submitButton id="botonRegistro" name="create" class="save" value="Registrar"/></li>
				<li><g:link controller="user" action="login"><img id="volverInicio" src="../images/Volver.png" title="Volver al pagina inicio" /></g:link></li>
			</ul>
		</g:form>

	</body>
</html>
<%@ page import="sematproject.User" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Restablecer contraseña</title>
		<link rel="stylesheet"href="${resource(dir: 'css', file: 'estilo.css')}" type="text/css" />	
	</head>
	
	<body id="fondoInicio">
	
	<g:form action="restore" method="post">
		<ul id="restablecer">
			<li><p id="letraGrande">Restablecer</p></li>
			<li><g:field id="campoTextoRestablecer" type="email" name="email" required="" value="${userInstance?.email}" placeholder="Correo eletrónico"/></li>
			<li><g:if test="${flash.message}"><p id="errorIngresoRestablecer">La dirección de correo electrónico ingresada no está registrada con nosotros.<br><br>Por favor, vuelve a intentarlo</p></g:if></li>
			<li><div id="botonCancelar"><g:link controller="user" action="login" >Cancelar</g:link></div></li>
			<li><g:actionSubmit id="botonRestablecer" value="Restablecer contraseña" action="hrestore"/></li>
		</ul>
	</g:form>
	</body>
</html>

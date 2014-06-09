<html>
<head>
	<title>Login Page</title>
	<link rel="stylesheet"href="${resource(dir: 'css', file: 'estilo.css')}" type="text/css" />
</head>

<body id="fondoInicio">
	<g:form controller="user" action="hlogin" method="post">
		<ul id="ingresoPanel">
			<li><p id="letraGrandeInicio">Semat</p></li>
			<li><g:textField id="campoTextoI" name="name" required="" value="${userInstance?.name}" placeholder="Usuario"/></li>
			<li><g:field id="campoTextoI" type="password" name="password" maxlength="15" required="" value="${userInstance?.password}" placeholder="Contraseña"/></li>
			<li><div id="restablecerPassword"><g:link controller="user" action="restore"><img src="../images/InterrogacionIcon.png" title="¿Olvidaste tu contraseña?" /></g:link></div></li>
			<li><g:if test="${flash.message}"><p id="errorIngreso">Has introducido un nombre<br>de usuario o una contraseña<br>incorrecta.</p></g:if></li>
			<li><g:actionSubmit id="botonIngreso" value="Iniciar sesión" action="hlogin"/></li>
			<li><div id="registrar"><g:link controller="user" action="create" >Regístrate</g:link></div></li>
		</ul>
	</g:form>
</body>
</html>
<%@ page import="sematproject.Session"%>
<!DOCTYPE html>
<html>

<head>
<title>Crear Proyecto</title>
<link rel="stylesheet"href="${resource(dir: 'css', file: 'estilo.css')}" type="text/css" />
</head>

<body id="fondo">
	<g:render template="/Common/panelUsuario" />
	
	<g:form action="save" >
		<ul id="creacionProyecto">
			<li><p id="letraGrande">Crear Proyecto</p></li>
			<li><g:textField id="campoTexto" name="name" required="" value="${sessionInstance?.name}" placeholder="Nombre del proyecto"/></li>
			<li><g:textArea id="campoArea" name="description" value="${sessionInstance?.description}" placeholder="Descripción"/></li>
			<%--<li><g:field id="campoTexto" type="email" name="email" required="" value="" placeholder="Correo eletrónico"/></li> --%>
			<li><g:submitButton id="botonCrear" name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" /></li>
		</ul>
	</g:form>

</body>
</html>

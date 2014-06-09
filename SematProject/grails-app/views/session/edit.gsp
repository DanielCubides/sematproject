<%@ page import="sematproject.Session" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="barraUsuario">
		<g:set var="entityName" value="${message(code: 'session.label', default: 'Session')}" />
		<title><g:message code="default.edit.label" args="[entityName]" /></title>
	</head>
	<body>
		<g:form method="post">
			<g:hiddenField name="id" value="${sessionInstance?.id}" />
			<g:hiddenField name="version" value="${sessionInstance?.version}" />
			<ul id="editarPanel">
				<li><p id="letraGrandeEditar">Datos proyecto</p></li>
				<li><g:textField id="campoTexto" name="name" required="" value="${sessionInstance?.name}" placeholder="Nombre del proyecto"/></li>
				<li><g:textArea id="campoArea" name="description" required="" value="${sessionInstance?.description}" placeholder="Descripción"/></li>
				<li><g:actionSubmit id="botonAcualizarProyecto" class="save" action="update" value="Actualizar"/></li>
			</ul>
		</g:form>
	</body>
</html>

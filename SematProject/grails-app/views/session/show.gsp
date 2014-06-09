
<%@ page import="sematproject.Session" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="barraUsuario">
		<title>Proyecto</title>
	</head>
	<body>
		<g:form>
			<ul id="proyectoDetalles">
				<li><p id="letraGrandeEditar">Datos proyecto</p></li>
				<li><g:textField id="campoTexto" disabled="disabled" name="name" required="" value="${sessionInstance?.name}" placeholder="Nombre del proyecto"/></li>
				<li><g:textArea id="campoArea" disabled="disabled" name="description" required="" value="${sessionInstance?.description}" placeholder="Descripción"/></li>
			</ul>
			<ul id="botonesProyecto">
				<li><div id="botonEditarProyecto"><g:link class="edit" action="edit" id="${sessionInstance?.id}">Editar</g:link></div></li>
				<li><g:actionSubmit id="botonEliminarProyecto" class="delete" action="delete" value="Eliminar"/></li>
			</ul>
			<%-- Carga usuarios 
			<g:if test="${sessionInstance?.rus}">
				<li class="fieldcontain">
					<span id="ussers-label" class="property-label"><g:message code="session.ussers.label" default="Ussers" /></span>
					
						<g:each in="${sessionInstance.rus.user}" var="u">
						<span class="property-value" aria-labelledby="ussers-label"><g:link controller="user" action="show" id="${u.id}">${u?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
			</g:if>   --%>
		</g:form>
	</body>
</html>

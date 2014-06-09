
<%@ page import="sematproject.User" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="barraUsuario">
		<g:set var="entityName" value="${message(code: 'user.label', default: 'User')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
	 	<%-- 
		<a href="#show-user" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-user" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list user">
			
				<g:if test="${userInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="user.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${userInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${userInstance?.password}">
				<li class="fieldcontain">
					<span id="password-label" class="property-label"><g:message code="user.password.label" default="Password" /></span>
					
						<span class="property-value" aria-labelledby="password-label"><g:fieldValue bean="${userInstance}" field="password"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${userInstance?.email}">
				<li class="fieldcontain">
					<span id="email-label" class="property-label"><g:message code="user.email.label" default="Email" /></span>
					
						<span class="property-value" aria-labelledby="email-label"><g:fieldValue bean="${userInstance}" field="email"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${userInstance?.rus}">
				<li class="fieldcontain">
					<span id="sesions-label" class="property-label"><g:message code="user.sesions.label" default="Sesions" /></span>
					
						<g:each in="${userInstance.rus.sesion}" var="s">
						<span class="property-value" aria-labelledby="sesions-label">	${s?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			
			<g:if test="${userInstance?.name}">
				<li class="fieldcontain">
					<g:fieldValue bean="${userInstance}" field="name"/>
					<g:fieldValue bean="${userInstance}" field="password"/>
					<g:fieldValue bean="${userInstance}" field="email"/></span>
					
				</li>
				</g:if> 
			
				<g:if test="${userInstance?.rus}">
				<li class="fieldcontain">
					<span id="sesions-label" class="property-label"><g:message code="user.sesions.label" default="Sesions" /></span>
					
						<g:each in="${userInstance.rus.sesion}" var="s">
						<span class="property-value" aria-labelledby="sesions-label"><g:link controller="session" action="show" id="${s.id}">${s?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			--%>
			
			
		<g:if test="${userInstance?.name}">
			<g:form>
				<g:hiddenField name="id" value="${userInstance?.id}" />
				<ul id="perfilPanel">
					<li><p id="letraGrandeEditar">Perfil</p></li>
					<li>Nombre: <g:fieldValue bean="${userInstance}" field="realname"/></li>
					<li>Correo electrónico: <g:fieldValue bean="${userInstance}" field="email"/></li>
					<li>Usuario: <g:fieldValue bean="${userInstance}" field="name"/></li>
					<li>Contraseña: <g:fieldValue bean="${userInstance}" field="password"/></li>
				</ul>
				<ul id="botonesPerfil">
					<li><div id="botonEditarPerfil"><g:link class="edit" action="edit" id="${userInstance?.id}">Editar</g:link></div></li>
					<li><g:actionSubmit id="botonEliminarPerfil" class="delete" action="delete" value="Eliminar"/></li>
				</ul>
			</g:form>
		</g:if>
			
	</body>
</html>

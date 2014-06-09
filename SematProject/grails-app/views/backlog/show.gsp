
<%@ page import="sematproject.Backlog" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'backlog.label', default: 'Backlog')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-backlog" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-backlog" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list backlog">
			
				<g:if test="${backlogInstance?.productOwner}">
				<li class="fieldcontain">
					<span id="productOwner-label" class="property-label"><g:message code="backlog.productOwner.label" default="Product Owner" /></span>
					
						<span class="property-value" aria-labelledby="productOwner-label"><g:fieldValue bean="${backlogInstance}" field="productOwner"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${backlogInstance?.startedDate}">
				<li class="fieldcontain">
					<span id="startedDate-label" class="property-label"><g:message code="backlog.startedDate.label" default="Started Date" /></span>
					
						<span class="property-value" aria-labelledby="startedDate-label"><g:formatDate date="${backlogInstance?.startedDate}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${backlogInstance?.springDate}">
				<li class="fieldcontain">
					<span id="springDate-label" class="property-label"><g:message code="backlog.springDate.label" default="Spring Date" /></span>
					
						<span class="property-value" aria-labelledby="springDate-label"><g:formatDate date="${backlogInstance?.springDate}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${backlogInstance?.hoursToSring}">
				<li class="fieldcontain">
					<span id="hoursToSring-label" class="property-label"><g:message code="backlog.hoursToSring.label" default="Hours To Sring" /></span>
					
						<span class="property-value" aria-labelledby="hoursToSring-label"><g:formatDate date="${backlogInstance?.hoursToSring}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${backlogInstance?.tasks}">
				<li class="fieldcontain">
					<span id="tasks-label" class="property-label"><g:message code="backlog.tasks.label" default="Tasks" /></span>
					
						<g:each in="${backlogInstance.tasks}" var="t">
						<span class="property-value" aria-labelledby="tasks-label"><g:link controller="task" action="show" id="${t.id}">${t?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${backlogInstance?.id}" />
					<g:link class="edit" action="edit" id="${backlogInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>

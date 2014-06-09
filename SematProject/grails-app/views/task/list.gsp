
<%@ page import="sematproject.Task" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'task.label', default: 'Task')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-task" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-task" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="name" title="${message(code: 'task.category.label', default: 'Name')}" />
					
						<g:sortableColumn property="category" title="${message(code: 'task.category.label', default: 'Category')}" />
					
						<g:sortableColumn property="description" title="${message(code: 'task.description.label', default: 'Description')}" />
					
						<g:sortableColumn property="finishDate" title="${message(code: 'task.finishDate.label', default: 'Finish Date')}" />
					
						<g:sortableColumn property="startedDate" title="${message(code: 'task.startedDate.label', default: 'Started Date')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${taskInstanceList}" status="i" var="taskInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${taskInstance.id}">${fieldValue(bean: taskInstance, field: "name")}</g:link></td>
					
						<td>${fieldValue(bean: taskInstance, field: "category")}</td>
					
						<td>${fieldValue(bean: taskInstance, field: "description")}</td>
					
						<td><g:formatDate date="${taskInstance.finishDate}" /></td>
					
						<td><g:formatDate date="${taskInstance.startedDate}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${taskInstanceTotal}" />
			</div>
		</div>
	</body>
</html>

<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<title>Tareas por hacer</title>
<meta name="layout" content="barraUsuario">
</head>
<body>
	<g:render template="/common/barraLateralBacklog" />
	<g:render template="/common/barraBacklogToDo" />

	<div id="pagBacklog">
	<g:set var="id" value="${ 0 }" />
		<g:form action="toDoing" method="post">
			<g:each in="${backlogInstance.tasks}" var="t">
				<div id="tareasToDoDoingDone">
					<g:if test="${t.state == 0}">
						<g:checkBox name="${t.name}" value="${false}" />
						<g:link controller="task" action="show" id="${t.id}" title="Ver detalles">${t.name}</g:link>
						<g:set var="id" value="${0}" />
						<g:set var="id" value="${t.id}" />
					</g:if>
				</div>
			</g:each>
			<g:submitButton id="botonRealizando" name="toDoing" value="Realizando" />
			<g:submitButton id="delete" name="delete" value="delete" />
		</g:form>
	</div>

	<ul>
		<li><g:link controller="task" action="create" id="${id}"><img id="agregarTareaIcono" title="Agregar una nueva tarea" /></g:link></li>
		</ul>
	
	
</body>
</html>
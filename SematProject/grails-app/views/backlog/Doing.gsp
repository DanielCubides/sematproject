<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<title>Tareas en proceso</title>
<meta name="layout" content="barraUsuario">
</head>
<body>
	<g:render template="/common/barraLateralBacklog" />
	<g:render template="/common/barraBacklogDoing" />

	<div id="pagBacklog">

		<g:form action="toDone" method="post">
			<g:each in="${backlogInstance.tasks}" var="t">
				<div id="tareasToDoDoingDone">
					<g:if test="${t.state == 1}">
						<g:checkBox name="${t.name}" value="${false}" />
						<g:link controller="task" action="show" id="${t.id}" title="Ver detalles">${t.name}</g:link>
					</g:if>
				</div>
			</g:each>
			<g:submitButton id="botonRealizando" name="toDoing" value="Realizado" />
		</g:form>
	</div>

	<ul>
		<li><g:link controller="task" action="create" id="${backlogInstance.id}"><img id="eliminarTareaIcono" title="Eliminar tarea(s)" /></g:link></li>
	</ul>
</body>
</html>
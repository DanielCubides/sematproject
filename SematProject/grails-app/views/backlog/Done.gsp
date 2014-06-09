<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<title>Tareas Finalizadas</title>
<meta name="layout" content="barraUsuario">
</head>
<body>
	<g:render template="/common/barraLateralBacklog" />
	<g:render template="/common/barraBacklogDone" />

	<div id="pagBacklog">
		<g:each in="${backlogInstance.tasks}" var="t">
			<div id="tareasToDoDoingDone">
				<g:if test="${t.state == 2}">
					<g:link controller="task" action="show" id="${t.id}" title="Ver detalles">${t.name}</g:link>
				</g:if>
			</div>
		</g:each>
	</div>
</body>
</html>
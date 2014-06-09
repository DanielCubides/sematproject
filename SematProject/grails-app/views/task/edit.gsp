<%@ page import="sematproject.Task" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="barraUsuario">
		<g:set var="entityName" value="${message(code: 'task.label', default: 'Task')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
	
	<g:if test="${taskInstance.state == 0}">
		<g:render template="/common/barraLateralBacklog" />
		<g:render template="/common/barraBacklogToDo" />
		<div id="pagBacklog">
			<g:form action="toDoing" method="post">
				<g:each in="${backlogInstance.tasks}" var="t">
					<div id="tareasToDoDoingDone">
						<g:if test="${t.state == 0}">
							<g:checkBox name="${t.name}" value="${false}" />
							${t.name}
						</g:if>
					</div>
				</g:each>
				<g:submitButton id="botonRealizando" name="toDoing" value="Realizando" />
			</g:form>
		</div>
		<ul>
			<li><g:link controller="task" action="create" id="${backlogInstance.id}"><img id="agregarTareaIcono" title="Agregar una nueva tarea" /></g:link></li>
			<li><g:link controller="task" action="create" id="${backlogInstance.id}"><img id="eliminarTareaIcono" title="Eliminar tarea(s)" /></g:link></li>
		</ul>
		<g:link class='fondoTransparente' controller="backlog" action="toDo" id="${backlogInstance.id}"></g:link>
	</g:if>
	
	<g:if test="${taskInstance.state == 1}">
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
		<g:link class='fondoTransparente' controller="backlog" action="Doing" id="${backlogInstance.id}"></g:link>
	</g:if>
	
	<g:if test="${taskInstance.state == 2}">
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
		<g:link class='fondoTransparente' controller="backlog" action="Done" id="${backlogInstance.id}"></g:link>
	</g:if>
	
	<g:form method="post" >
		<g:hiddenField name="id" value="${taskInstance?.id}" />
		<g:hiddenField name="version" value="${taskInstance?.version}" />
		<ul id="detallesTareaPanel">
			<li><p id="letraGrandeTareaMostrar">Detalles</p></li>
			<li>Nombre: <g:field id="campoTextoD1" name="name" type="text" value="${taskInstance.name}" required="" placeholder="Nombre"/></li>
			<li>Categoria: <g:field id="campoTextoD2" name="category" type="text" maxlength="2" value="${taskInstance.category}" required="" placeholder="Categoria"/></li>
			<li><div id="letraDescripcion">Descripcion:</div><li>
			<li><g:textArea id="campoTextoD3" name="description" type="text" value="${taskInstance?.description}" placeholder="Descripción"/></li>
			<li id="fechasTarea">Fecha iniciación: <g:formatDate date="${taskInstance?.startedDate}" /><li>
			<li id="fechasTarea">Fecha finalización: <g:datePicker name="finishDate" precision="day"  value="${taskInstance?.finishDate}"/><li>
			<li><g:actionSubmit id="botonActualizarTarea" class="save" action="update" value="Actualizar"/></li>
		</ul>
	</g:form>

	</body>
</html>
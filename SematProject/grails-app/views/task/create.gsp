<%@ page import="sematproject.Task" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="barraUsuario">
	</head>
	<body>		
		<g:render template="/common/barraLateralBacklog" />
		<g:render template="/common/barraBacklogToDo" />
		
		<div id="pagBacklog">
	
			<g:form action="toDoing" method="post">
				<g:each in="${backlogInstance.tasks}" var="t">
					<div>
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
		
		
		<%--------------------------- Carga el fondo trasparente ---------------------------%>
		<g:link class='fondoTransparente' controller="backlog" action="toDo" id="${backlogInstance.id}"></g:link>
		<%-----------------------------------------------------------------------------------%>
		
		<g:form action="save">
			<ul id="agregarTareaPanel">
				<li><p id="letraGrandeTareaCrear">Nueva tarea</p></li>
				<li><g:field id="campoTextoT" name="name" type="text" value="${taskInstance.name}" required="" placeholder="Nombre"/></li>
				<li><g:field id="campoTextoT" name="category" type="text" maxlength="2" value="${taskInstance.category}" required="" placeholder="Categoria"/></li>
				<li><g:textArea id="campoAreaT" name="description" type="text" value="${taskInstance?.description}" placeholder="Descripción"/></li>
				<li>Fecha finalización: <g:datePicker name="finishDate" precision="day"  value="${taskInstance?.finishDate}"/><li>
				<li><g:if test="${flash.message}"><p id="errorIngreso">Has introducido un nombre<br>de usuario o una contraseña<br>incorrecta.</p></g:if></li>
				<li><g:submitButton id="botonCrearTarea" name="create" class="save" value="Crear" /></li>
			</ul>
		</g:form>
	</body>
</html>

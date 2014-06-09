<ul id="barraBacklog">
	<li><g:link controller="backlog" action="toDo" id="${session.sesion.id}">To Do</g:link></li>
	<li class="activa">Doing</li>
	<li><g:link controller="backlog" action="Done" id="${session.sesion.id}">Done</g:link></li>
</ul>
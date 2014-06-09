<ul id="barraBacklog">
	<li class="activa">To Do</li>
	<li><g:link controller="backlog" action="Doing" id="${session.sesion.id}">Doing</g:link></li>
	<li><g:link controller="backlog" action="Done" id="${session.sesion.id}">Done</g:link></li>
</ul>
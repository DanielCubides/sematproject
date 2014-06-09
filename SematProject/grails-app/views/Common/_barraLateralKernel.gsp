<ul id="barraLateral">
	<li class="activa">kernel</li>
	<li><g:link controller="backlog" action="toDo" id="${session.sesion.id}">Backlog</g:link></li>
</ul>

<g:link controller="session" action="show" id="${session.sesion.id}"><p id="nombreProyecto">${session.sesion.name} - 21%</p></g:link>
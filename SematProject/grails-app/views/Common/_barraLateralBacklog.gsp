<ul id="barraLateral">
	<li><g:link controller="Kernel" action="show" id="${session.sesion.id}">Kernel</g:link></li>
	<li class="activa">Backlog</li>
</ul>

<g:link controller="session" action="show" id="${session.sesion.id}"><p id="nombreProyecto">${session.sesion.name} - 21%</p></g:link>
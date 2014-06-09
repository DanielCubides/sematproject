<ul id="panelSuperior">
	<li><div id="volverMenu"><g:link controller="user" action="hoome"><img id="logoSemat" title="Volver a la pagina principal" /></g:link></div></li>
	<li><div id="nombreCuenta"><g:link controller="user" action="show" id="${session.user.id}">${session.user.realname}</g:link></div></li>
	<li><div id="cerrarSesion"><g:link controller="user" action="login"><img id="logoCerrarSesion" title="Cerrar Sesion" /></g:link></div></li>
</ul>

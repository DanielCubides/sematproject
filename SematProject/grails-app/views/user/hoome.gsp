<!DOCTYPE html>
<html>

<head>
	<title>Semat - Registro de proyectos</title>
	<meta name="layout" content="barraUsuario">
</head>

<body>
	
	<ul>
		<li><p id="letraGrandeProyecto" class="proyectosIcono">Proyectos</p></li>
		<li><p id="letraGrandeCrearP">Crear proyecto</p></li>
		<li><p id="letraGrandeSolicitudes">Mis Solicitudes</p></li>
		<li><div id="menuProyectos"><g:link controller="session" action="list" ><img id="proyectosIcono" title="Ver mis proyectos" /></g:link></div></li>
		<li><div id="menuCrearProyecto"><g:link controller="session" action="create" ><img id="crearProyectoIcono" title="Crear un nuevo proyectos" /></g:link></div></li>
		<li><div id="menuSolicitudes"><g:link controller="session" action="list" ><img id="solicitudesIcono" title="Ver mis solicitudes" /></g:link></div></li>
	</ul>
</body>

</html>
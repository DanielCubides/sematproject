<%@ page import="sematproject.Session"%>

<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="barraUsuario" />
</head>

<body>
	<g:if test="${userInstance?.rus}">
		<div id="listaProyectos">
			<g:each in="${userInstance.rus.sesion}" var="s">
				<g:link controller="session" action="sessionhome" id="${s.id}">
					<div>
						${s.name}
					</div>
				</g:link>
			</g:each>
		</div>
	</g:if>
	<g:else>
		<p id="noProyecto">Aún no tienes ningun un proyecto.</p>
	</g:else>
</body>
</html>
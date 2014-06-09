<!DOCTYPE html>
<html>

	<head>
	<g:javascript library='jquery' />

<r:require module="core"/>
<!-- jQuery / jQuery UI -->
<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.min.js"></script>
	
		<link rel="stylesheet"href="${resource(dir: 'css', file: 'estilo.css')}" type="text/css" />
		<r:layoutResources />
	</head>
	
	<body id="fondo">
		<g:render template="/common/panelUsuario" />
		<g:layoutBody />			
	</body>
	
</html>

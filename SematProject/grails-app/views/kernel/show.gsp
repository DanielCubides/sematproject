
<%@ page import="sematproject.Kernel" %>
<!DOCTYPE html>
<html>
	<head>
	
	<g:javascript library='jquery' />

	<r:require module="core"/>
	<!-- jQuery / jQuery UI -->
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
	<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.min.js"></script>
	
		<meta name="layout" content="barraUsuario">
		<g:set var="entityName" value="${message(code: 'kernel.label', default: 'Kernel')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
		
	</head>		
	<r:layoutResources/>
	<body>
		<g:render template="/common/barraLateralKernel" />
		

		<div id="pagKernel">
			<g:render template="/cards/setOfCards"/>
		</div>
		
	</body>
</html>
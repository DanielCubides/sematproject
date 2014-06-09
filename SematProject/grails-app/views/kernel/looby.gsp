<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>




<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<meta name="layout" content="main"/>
<title>Insert title here</title>
</head>
<body>

  <div class="body">
  			<div id="derecha">
  			

  			
		<g:link controller="kernel" action="edit" id="${kernelInstance.id}">AQUI SE MODIFICA EL KERNEL</g:link>
		
			<div>
			<g:render template="/card/setOfCards"/>
			</div>

		
		
	</div>
  </div>
</body>
</html>
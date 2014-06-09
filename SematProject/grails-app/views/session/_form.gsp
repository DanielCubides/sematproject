<%@ page import="sematproject.Session" %>



<div class="fieldcontain ${hasErrors(bean: sessionInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="session.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${sessionInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: sessionInstance, field: 'description', 'error')} ">
	<label for="name">
		<g:message code="session.name.label" default="Description" />
		
	</label>
	<g:textField name="description" value="${sessionInstance?.description}"/>
</div>




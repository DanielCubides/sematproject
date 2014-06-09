<%@ page import="sematproject.Backlog" %>



<div class="fieldcontain ${hasErrors(bean: backlogInstance, field: 'productOwner', 'error')} ">
	<label for="productOwner">
		<g:message code="backlog.productOwner.label" default="Product Owner" />
		
	</label>
	<g:textField name="productOwner" value="${backlogInstance?.productOwner}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: backlogInstance, field: 'startedDate', 'error')} ">
	<label for="startedDate">
		<g:message code="backlog.startedDate.label" default="Started Date" />
		
	</label>
	<g:datePicker name="startedDate" precision="day"  value="${backlogInstance?.startedDate}" default="none" noSelection="['': '']" />
</div>

<div class="fieldcontain ${hasErrors(bean: backlogInstance, field: 'springDate', 'error')} ">
	<label for="springDate">
		<g:message code="backlog.springDate.label" default="Spring Date" />
		
	</label>
	<g:datePicker name="springDate" precision="day"  value="${backlogInstance?.springDate}" default="none" noSelection="['': '']" />
</div>

<div class="fieldcontain ${hasErrors(bean: backlogInstance, field: 'hoursToSring', 'error')} required">
	<label for="hoursToSring">
		<g:message code="backlog.hoursToSring.label" default="Hours To Sring" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="hoursToSring" precision="day"  value="${backlogInstance?.hoursToSring}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: backlogInstance, field: 'tasks', 'error')} ">
	<label for="tasks">
		<g:message code="backlog.tasks.label" default="Tasks" />
		
	</label>
	<g:select name="tasks" from="${sematproject.Task.list()}" multiple="multiple" optionKey="id" size="5" value="${backlogInstance?.tasks*.id}" class="many-to-many"/>
</div>


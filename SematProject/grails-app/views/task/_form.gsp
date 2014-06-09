<%@ page import="sematproject.Task" %>


<div class="fieldcontain ${hasErrors(bean: taskInstance, field: 'category', 'error')} required">
	<label for="name">
		<g:message code="task.category.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="name" type="text" value="${taskInstance.name}" required=""/>
</div>
<div class="fieldcontain ${hasErrors(bean: taskInstance, field: 'category', 'error')} required">
	<label for="category">
		<g:message code="task.category.label" default="Category" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="category" type="text" maxlength="2" value="${taskInstance.category}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: taskInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="task.description.label" default="Description" />
		
	</label>
	<g:textField name="description" value="${taskInstance?.description}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: taskInstance, field: 'finishDate', 'error')} required">
	<label for="finishDate">
		<g:message code="task.finishDate.label" default="Finish Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="finishDate" precision="day"  value="${taskInstance?.finishDate}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: taskInstance, field: 'startedDate', 'error')} required">
	<label for="startedDate">
		<g:message code="task.startedDate.label" default="Started Date" />
		<span> ${taskInstance?.startedDate} </span>
	</label>
	
</div>


<%@ page import="sematproject.Kernel" %>



<div class="fieldcontain ${hasErrors(bean: kernelInstance, field: 'progress', 'error')} required">
	<label for="progress">
		<g:message code="kernel.progress.label" default="Progress" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="progress" value="${fieldValue(bean: kernelInstance, field: 'progress')}" required=""/>
</div>


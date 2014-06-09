<div id="cardHeader">
	<h2>Forma de trabajo</h2>
</div>
<div id="b1">Con bases establecidad</div>
<div id="cardContent">
	<g:each in="${session.sesion.backlog.tasks}" var="t">
		<g:if test="${t.category == "R1" }">
			<label><input type="checkbox" name="checkbox1"
				value="${t.name}" tabindex="1" /> ${t.name}</label>
		</g:if>
		<br>
	</g:each>
</div>
<div id="b2">
	<p>1/6</p>
</div>


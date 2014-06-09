<div id="greenCardHeader">
	<h2>Forma de trabajo</h2>
</div>
<div id="g1">Con bases establecidas</div>
<div id="cardContent">
	<g:each in="${session.sesion.backlog.tasks}" var="t">
		<g:if test="${t.category == "O1" }">
			<label><input type="checkbox" name="checkbox1"
				value="${t.name}" tabindex="1" /> ${t.name}</label>
				<br>
		</g:if>

	</g:each>
</div>

<div id="g2">
	<p>1/6</p>
</div>
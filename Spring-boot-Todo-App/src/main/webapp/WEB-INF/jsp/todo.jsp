<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
	<div><label>Add todo description for <b>${userName}</b> here: </label></div>
	<br/>
	<form:form name="addTodoForm" method="post" modelAttribute="todo">
		<form:hidden path="id"/>
		<fieldset class="form-group">
			<form:label path="desc">Description: </form:label>
			<form:input path="desc" type="text" id="descId" class="form-control" required="required"/>
			<form:errors path="desc" cssClass="text-warning"/>
		</fieldset>
		<fieldset class="form-group">
			<form:label path="targetDate">Target Date: </form:label>
			<form:input path="targetDate" type="text" id="targetDateId" class="form-control" required="required"/>
			<form:errors path="targetDate" cssClass="text-warning"/>
		</fieldset>
		<button type="submit" name = "submitQryBtn" id="submitQryBtnId" class="btn btn-success">Add</button>
	</form:form>
</div>
<%@ include file="common/footer.jspf"%>	
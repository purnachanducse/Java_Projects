<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
	<div><label>Here are the list of todos for ${userName}:</label></div>
	<table class="table table-striped">
			<thead>
				<tr>
					<th>Description</th>
					<th>Target Date</th>
					<th>Is it Done?</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${todos}" var="todo">
					<tr>
						<td>${todo.desc}</td>
						<td><fmt:formatDate value="${todo.targetDate}" pattern="dd/MM/yyyy"/></td>
						<td></td>
						<td><a type="button" class="btn btn-success" href="/update-todo?id=${todo.id}">Update</a></td>
						<td><a type="button" class="btn btn-warning" href="/delete-todo?id=${todo.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
	</table>
	<br/>
	<div><a class="button" href="/todo">Add a Todo</a></div>
</div>
<%@ include file="common/footer.jspf" %>
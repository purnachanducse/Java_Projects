<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
<font color="red">${errorMessage}</font>
	<form method="post">
		User Name:<input type="text" name="userName" value=""/>
		Password:<input type="password" name="password" value=""/>
		<input type="submit" value="Submit Query"/>
	</form>
</div>
<%@ include file="common/footer.jspf"%>
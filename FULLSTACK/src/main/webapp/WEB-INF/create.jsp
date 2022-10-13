<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
    
<meta charset="UTF-8">
<title>Create book</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<%-- 	${user} --%>
	<div class="text-center">

		<h1 class="ms-3">Add a name!</h1>

		<form:form action="/babys" method="post" modelAttribute="baby">
			<p>
				<form:label path="newName">New Name:</form:label>
				<form:errors path="newName" />
				<form:input path="newName" />
			</p>

			<div>
				<form:select path="typicalGender">
						<form:option value="Male">male</form:option>
						<form:option value="Male">female</form:option>
						<form:option value="Male">neutral</form:option>
				</form:select>
			</div>




			<p>
				<form:label path="origin">Origin:</form:label>
				<form:errors path="origin" />
				<form:input path="origin" />
			</p>
			<p>
				<form:label path="meaning">Meaning:</form:label>
				<form:errors path="meaning" />
				<form:input path="meaning" />
			</p>

			<input type="submit" value="Submit" />
			<button>
				<a href="/success">cancel</a>
			</button>


			<form:input type="hidden" path="user" value="${user}" />
		</form:form>
	</div>

</body>
</html>
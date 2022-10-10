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
<title>New Ninja</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	   
	<h1>New Ninja</h1>
	${allNinjas}
	<div>
		<a href="/">back</a>
	</div>

	<div>
		<form:form action="/ninjas" method="post" modelAttribute="ninjas">

			<h3>First Name</h3>
			<form:errors path="first_name" />
			<form:input path="first_name" />


			<h3>Last Name</h3>
			<form:errors path="last_name" />
			<form:input path="last_name" />


			<h3>Age</h3>
			<form:errors path="age" />
			<form:input path="age" />

			<div>
				<form:select path="dojo">
					<c:forEach items="${allDojos }" var="dojo">
						<form:option value="${dojo.id }">
					${dojo.dojoName }
					</form:option>
					</c:forEach>
				</form:select>
			</div>


			<button>Create</button>




		</form:form>
	</div>

</body>
</html>
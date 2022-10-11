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
<title>Login and Register</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	   
	<div class="d-flex justify-content-evenly">
		<div class="mb-3">
			<h1>Register</h1>
			<form:form action="/register" method="post" modelAttribute="newUser">

				<label class="form-label">User name</label>
				<form:input path="userName" class="form-control" />
				<form:errors path="userName" />

				<label class="form-label">email</label>
				<form:input path="email" class="form-control" />
				<form:errors path="email" />


				<label for="exampleFormControlInput1" class="form-label">Password</label>
				<form:password path="password" class="form-control" />
				<form:errors path="password" />

				<label for="exampleFormControlInput1" class="form-label">Confirm
					Password</label>
				<form:password path="confirm" class="form-control" />
				<form:errors path="confirm" class="form-control" />


			<button>Submit</button>
			</form:form>

		</div>

		<div class="mb-3">
			<h1>Login</h1>
			<form:form action="/login" method="post" modelAttribute="newLogin">
				<label class="form-label">User name</label>
				<form:input path="email" class="form-control" />
				<form:errors path="email" />

				<label for="exampleFormControlInput1" class="form-label">Password</label>
				<form:password path="password" class="form-control" />
				<form:errors path="password" />
				<button>Submit</button>
			</form:form>


		</div>
	</div>

</body>
</html>
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
<title>Baby Names</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	   
	<%-- <h1 class="ms-5">Welcome, ${thisUser.userName}</h1> --%>
	<h1 class="ms-5">Baby Names</h1>

	<div class="d-flex justify-content-end p-3">
		<a href="/logout"><button>Logout</button></a>
	</div>


		<table class="table">
			<thead>
				<c:forEach items="${allBabys}" var="baby">
					<tbody>
						<tr>
							<td><a href="/babys/${baby.id}">${baby.newName}</a></td>
							<td>${baby.typicalGender}</td>
							<td>${baby.origin}</td>
							<td>${baby.meaning}</td>
						</tr>
					</tbody>
				</c:forEach>
		</table>










		<div class="text-center">
			<button>
				<a href="/create">new name</a>
			</button>
		</div>
</body>
</html>
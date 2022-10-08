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
<title>Travel Plans</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	   
	<h1>PLANS</h1>
	<a href="/create">Create</a>
	<p>${success}</p>
<%-- 	${alltheplans}
 --%>	<div>
		<table>
			<thead>
				<tr>
					<td>id</td>
					<td>amount</td>
					<td>description</td>
					<td>expense name</td>
					<td>vendor</td>
					<td>actions</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${alltheplans}" var="plan">
					<tr>
						<td>${plan.id}</td>
						<td>${plan.amount}</td>
						<td>${plan.description}</td>
						
						<td>
						<a href="/plans/${plan.id}">
						${plan.expenseName}</a>
						</td>
						<td>${plan.vendor}</td>
						<td><button>
								<a href="/edit/${plan.id}">edit</a>
							</button>
							
							<form action="/plans/${plan.id}" method="post">
    <input type="hidden" name="_method" value="delete">
    <input type="submit" value="Delete">
</form>
							
							</td>
					</tr>
				</c:forEach>


			</tbody>
		</table>
	</div>
</body>
</html>
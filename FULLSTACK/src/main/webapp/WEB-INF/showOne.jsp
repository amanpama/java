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
<title>One Baby</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<h1 class="ms-3">${thisBaby.newName}</h1>
	<p>(added by ${thisBaby.user.userName})</p>

	<p>Gender: ${thisBaby.typicalGender}</p>
	<p>Origin: ${thisBaby.origin}</p>
	<p>Origin: ${thisBaby.meaning}</p>

	
	 <c:if test="${user_id eq thisBaby.user.id}">
		
	<button>
		<a href="/edit/${thisBaby.id}">edit</a>
	</button>
		
	</c:if>




	


	<!--thisBaby comes from show one attribute in my controller for babys  -->



</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 class="text-center">Send an Omikuji!</h1>
<form action="/show" method="POST" >
<h5>Choose a number 5-25.</h5>
<select></select>
<h5>Enter the name of any city.</h5>
<input class="form-control" type="text" name="city">
<h5>Enter the name of any real person.</h5>
<input class="form-control" type="text" name="name">
<h5>Enter professional endeavor or hobby:</h5>
<input class="form-control" type="text" name="hobby">
<h5>Enter any type of living thing.</h5>
<input class="form-control" type="text" name="living">
<h5>Say something nice to someone.</h5>
<input class="form-control" type="text" name="nice">
<div class="col-auto">
    <button type="submit" name="buttton" class="btn btn-primary mb-3">Submit</button>
  </div>
</form>

</body>
</html>
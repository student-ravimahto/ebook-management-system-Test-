<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book: Edit Profile</title>
<%@include file="all_component/allCss.jsp"%>
</head>
<body Style="background-color: #f0f1f2;">
	<%@include file="all_component/navbar.jsp"%>

	<div class="container">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-body">

						<h5 class="text-center text-primary p-1">Edit Profile</h5>
						
						<c:if test="${not empty failedMsg }">
 <h5 class="text-danger text-center">${failedMsg}</h5>
<c:remove var="failedMsg" scope="session"/>
</c:if>

<c:if test="${not empty succMsg }">
 <h5 class="text-center text-success">${succMsg}</h5>
<c:remove var="succMsg" scope="session"/>
</c:if>
						

						<form action="update_profile" method="post">
						<input type="hidden"  value="${userobj.id }" name="id">
							<div class="form-group">
								<label for="exampleInputEmail1">Enter Full Name*</label> <input type="text"
									class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" required="required" name="fname" value="${userobj.name}">
								<small id="emailHelp" class="form-text text-muted"></small>
							</div>

							<div class="form-group">
								<label for="exampleInputEmail1">Email address*</label> <input
									type="email" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" required="required" name="email" value="${userobj.email}">
								<small id="emailHelp" class="form-text text-muted"></small>
							</div>

							<div class="form-group">
								<label for="exampleInputEmail1">Phone*</label> <input
									type="number" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" required="required" name="phno" value="${userobj.phNo}">
								<small id="emailHelp" class="form-text text-muted"></small>
							</div>

							<div class="form-group">
								<label for="exampleInputPassword1">Password*</label> <input
									type="password" class="form-control" id="exampleInputPassword1"
									required="required" name="password">
							</div>

							<div class="text-center p-2">
								<button type="submit" class="btn btn-primary btn-block btn-sm">Update</button>
							</div>
						</form>


					</div>
				</div>
			</div>
		</div>
	</div>


</body>
</html>
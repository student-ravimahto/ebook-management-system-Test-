<%@page import="com.entity.BookDtse" %>
<%@page import="com.DB.DBConnect" %>
<%@page import="com.DAO.BookDAOImpl" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin: Add Book</title>
<%@include file="allCss.jsp" %>

</head>
<body style="background-color: #f0f2f2;">
<%@include file="navbar.jsp" %>
<c:if test="${empty userobj}">
<c:redirect url="../login.jsp"/>
</c:if>
<div class="coantainer">
<div class="row">
<div class="col-md-4 offset-md-4">
<div class="card">
<div class="card-body">
<h4 class="text-center">Edit Books</h4>



<%   
int id = Integer.parseInt(request.getParameter("id"));

BookDAOImpl dao = new BookDAOImpl(DBConnect.getConn());
BookDtse b = dao.getBookById(id);

%>

<form action="../editbooks" method="post">
 <input type="hidden" name="id" value ="<%=b.getBookId() %>">
 
<div class ="form-group">
<label for="exampleInputEmail">Book Name*</label> <input
name = "bname" type="text" class="form-control"
id ="exampleInputEmail"  aria-describedby="emailHelp" value ="<%=b.getBookName() %>">

</div>

<div class ="form-group">
<label for="exampleInputEmail">Author Name*</label> <input
name = "author" type="text" class="form-control"
id ="exampleInputEmail"  aria-describedby="emailHelp" value ="<%=b.getAuthor() %>">

</div>

<div class ="form-group">
<label for="exampleInputEmail">Price*</label> <input
name = "price" type="number" class="form-control"
id ="exampleInputEmail"  value ="<%=b.getPrice() %>">

</div>


<div class ="form-group">
<label for="exampleInputEmail">Book Status*</label> <select
id ="exampleInputEmail"  name = "status"  class="form-control">
  <%  
  if("Active".equals(b.getStatus())){
%> 
 <option value="Active">Inactive</option>
<option value="Inactive">Active</option>
<% 

  }else{
	  %>
	  <option value="Inactive">Active</option>
	  <option value="Active">Inactive</option>
	 <% 
  }
  
  %>
</select>
</div>
<button type="submit"  class="btn btn-primary">Update</button>
</form>
</div>

</div>
</div>

</div>

</div>
<div style="margin-top: 130px;">
<%@include file="footer.jsp" %></div>
</body>
</html>
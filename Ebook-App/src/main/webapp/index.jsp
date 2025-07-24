<%@page import="com.DAO.UserDAOImpl"%>
<%@page import="com.entity.User"%>
<%@page import="com.entity.BookDtse" %>
<%@page import="java.util.List" %>
<%@page import="com.DB.DBConnect" %>
<%@page import="com.DAO.BookDAOImpl" %>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ZustBuy: Index</title>
<%@include file="all_component/allCss.jsp" %>
<style type="text/css">
.back-img{
background: url("img/b.jpg.jpg");
height: 50vh;
width: 100%;

background-repeat: no-repeat;
background-size: cover;
}
.crd-ho:hover{
background-color:#fcf7f7;
}
</style>
</head>
<body style="background: #f2f5f3;">

<%  

User u = (User) session.getAttribute("userobj");

%>

<%@include file="all_component/navbar.jsp" %>
<div class="container-fluid back-img"></div>
<%@ page import="java.sql.Connection" %>
<%@ page import="com.DB.DBConnect" %>  <!-- Update with your actual package name -->

<!-- start Recent Book -->

<div class="container" >
<h3 class="text-center">Recent Book</h3>
<div class="row">
<% 
BookDAOImpl dao2 = new BookDAOImpl(DBConnect.getConn());
List<BookDtse> list2 = dao2.getRecentBooks();
for(BookDtse b:list2){
%>
<div class="col-md-3">
<div class="card crd-ho">
<div class="card-body text-center">
<img alt="" src="Book/<%=b.getPhotoName() %>" 
style="width: 200px; height: 250px">
<p><%=b.getBookName() %></p>
<p><%=b.getAuthor() %></p>
<p>

<%
if(b.getBookCategory().equals("Old"))
{%>
Categories:<%=b.getBookCategory()%></p>
<div class="row"> 


<a href="view_book.jsp?bid=<%=b.getBookId() %>" class="btn btn-success btn-sm ml-5">View Details</a>
<a href="" class="btn btn-danger btn-sm ml-1"><%=b.getPrice()%> <i class="fa-solid fa-indian-rupee-sign"></i></a>
</div>
<%}else
{%>
 Categories:<%=b.getBookCategory()%></p>
<div class="row"> 

<%  
if(u==null){%>
	<a href="login.jsp" class="btn btn-danger btn-sm ml-1">Add Cart</a>
<%	
}else{
	%>
	<a href="cart?bid=<%=b.getBookId() %>&&uid=<%=u.getId() %>" class="btn btn-danger btn-sm ml-1">Add Cart</a>
<% 	
}
%>


<a href="view_book.jsp?bid=<%=b.getBookId() %>" 
class="btn btn-success btn-sm ml-0.9">View Details</a>
<a href="" class="btn btn-danger btn-sm ml-0.9"><%=b.getPrice()%><i class="fa-solid fa-indian-rupee-sign"></i></a>
</div>
<%}
%>



</div>
</div>
</div>
<% 
}
%>

</div>
<div class="text-center mt-1">
<a href="all_recent_book.jsp" class= "btn btn-danger btn-sm text-white">View All</a>
</div>
</div>

<!--  End Recent Book -->
<hr>
<!-- start New Book -->
<div class="container" >
<h3 class="text-center">New Book</h3>
<div class="row">

<% 
BookDAOImpl dao = new BookDAOImpl(DBConnect.getConn());
List<BookDtse> list = dao.getNewBook();
for(BookDtse b:list){
	%>
<div class="col-md-3">
<div class="card crd-ho">
<div class="card-body text-center">
<img alt="" src="Book/<%=b.getPhotoName() %>" 
style="width: 200px; height: 250px">
<p><%=b.getBookName() %></p>
<p><%=b.getAuthor() %></p>
<p>Categories:<%=b.getBookCategory() %></p>
<div class="row">

<%  
if(u==null){%>
	<a href="login.jsp" class="btn btn-danger btn-sm ml-1">Add Cart</a>
<%	
}else{
	%>
	<a href="cart?bid=<%=b.getBookId() %>&&uid=<%=u.getId() %>" class="btn btn-danger btn-sm ml-1">Add Cart</a>
<% 	
}
%>
 

<a href="view_book.jsp?bid=<%=b.getBookId() %>" class="btn btn-success btn-sm ml-1">View Details</a>
<a href="" class="btn btn-danger btn-sm ml-1"><%=b.getPrice()%>
<i class="fa-solid fa-indian-rupee-sign"></i></a>

</div>

</div>

</div>
</div>

<%
}
%>

</div>
<div class="text-center mt-1">
<a href="all_new_book.jsp" class= "btn btn-danger btn-sm text-white">View All</a>

</div>

</div>
<!--  End New Book -->
<hr>

<!-- start Old Book -->

<div class="container" >
<h3 class="text-center">Old Book</h3>
<div class="row">
<%  
BookDAOImpl dao3 = new BookDAOImpl(DBConnect.getConn());
List<BookDtse> list3 = dao3.getOldBooks();
for(BookDtse b:list3){
%>
<div class="col-md-3">
<div class="card crd-ho">
<div class="card-body text-center">
<img alt="" src="Book/<%=b.getPhotoName() %>" 
style="width: 200px; height: 250px">
<p><%=b.getBookName() %></p>
<p><%=b.getAuthor() %></p>
<p>Categories:<%=b.getBookCategory() %></p>

<div class="row"> 
  
<a href="view_book.jsp?bid=<%=b.getBookId() %>" class="btn btn-success btn-sm ml-5">View Details</a>
<a href="" class="btn btn-danger btn-sm ml-1"><%=b.getPrice()%>
<i class="fa-solid fa-indian-rupee-sign"></i></a>

</div>



</div>
</div>
</div>
<% 
}
%>


</div>
<div class="text-center mt-1">
<a href="all_old_book.jsp" class= "btn btn-danger btn-sm text-white">View All</a>

</div>

</div>
<!--  End Old Book -->
<%@include file="all_component/footer.jsp" %>

</body>
</html>
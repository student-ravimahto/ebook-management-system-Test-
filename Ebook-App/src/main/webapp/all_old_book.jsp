<%@page import="java.util.List"%>
<%@page import="com.entity.BookDtse"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="com.DAO.BookDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Old Book</title>
<%@include file="all_component/allCss.jsp" %>
</head>
<body>
<%@include file="all_component/navbar.jsp" %>
<style type="text/css">

.crd-ho:hover{
background-color:#fcf7f7;
}
</style>
<div class="container-fluid">
<div class="row p-3">

<% 
BookDAOImpl dao = new BookDAOImpl(DBConnect.getConn());
List<BookDtse> list = dao.getAllOldBook();
for(BookDtse b:list){
%>
<div class="col-md-3">
<div class="card crd-ho ">
<div class="card-body text-center">
<img alt="" src="Book/<%=b.getPhotoName() %>" 
style="width: 100px; height: 150px" class="img-thumblin">
<p><%=b.getBookName() %></p>
<p><%=b.getAuthor() %></p>
<p>

Categories:<%=b.getBookCategory()%></p>
<div class="row"> 


<a href="view_book.jsp?bid=<%=b.getBookId() %>"  class="btn btn-success btn-sm ml-5">View Details</a>
<a href="" class="btn btn-danger btn-sm ml-1"><%=b.getPrice()%> <i class="fa-solid fa-indian-rupee-sign"></i></a>
</div>
</div>
</div>
</div>

<% 
}
%>
</div>
</div>
</body>
</html>
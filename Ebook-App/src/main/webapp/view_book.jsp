<%@page import="com.entity.BookDtse"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="com.DAO.BookDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="all_component/allCss.jsp" %>
</head>
<body style="background-color:#f01f2;">
<%@include file="all_component/navbar.jsp" %>

<%  
int bid=Integer.parseInt(request.getParameter("bid"));
BookDAOImpl dao=new BookDAOImpl(DBConnect.getConn());
BookDtse b=dao.getBookById(bid);
%>

<div class="cantianer p-3">
<div class="row ">
<div class="col-md-6 text-center p-5 border bg-white">
<img src="Book/<%=b.getPhotoName() %>" style="width: 100px; height: 150px">
<h4 class="mt-3">Book Name: <span class="text-success"><%=b.getBookName() %></span> </h4>
<h4>Author Name: <span class="text-success"><%=b.getAuthor() %></span></h4>
<h4>Category: <span class="text-success"><%=b.getBookCategory() %></span></h4>
</div>

<div class="col-md-6 text-center p-5 border bg-white">
<h2><%=b.getBookName() %></h2>

<%  
if("Old".equals(b.getBookCategory()))
{%>
	<h5 class="text-primary">Contact To Seller</h5>
	<h5 class="text-primary">
	<i class="fa-regular fa-envelope"></i> 
	Email:<%=b.getEamil() %></h5>
<%}
%>

<div class="row">
<div class="col-md-4 text-danger text-center p-2">
<i class="fa-solid fa-money-bill-wave fa-2x"></i>
<p>Cash On Delivery</p>
</div>
<div class="col-md-4 text-danger text-center p-2">
<i class="fa-solid fa-rotate-left fa-2x"></i>
<p>Return Available</p>
</div>
<div class="col-md-4 text-danger text-center p-2">
<i class="fa-solid fa-truck fa-2x"></i>
<p>Free Shopping</p>
</div>
</div>

<%  
if("Old".equals(b.getBookCategory()))
{%>
<div class="text-center p-3">  
<a href="index.jsp"  class="btn btn-success"><i 
class="fa-solid fa-cart-shopping"></i> Continue Shopping</a>
<a href=""  class="btn btn-danger"><i
 class="fa-solid fa-indian-rupee-sign"></i> 200</a>
</div>
<%}else{%>
	
	<div class="text-center p-3">  
<a href=""  class="btn btn-primary"><i 
class="fa-solid fa-cart-shopping"></i> Add Card</a>
<a href=""  class="btn btn-danger"><i
 class="fa-solid fa-indian-rupee-sign"></i> 200</a>
</div>

<%}
%>



</div>
</div>
</div>

</body>
</html>
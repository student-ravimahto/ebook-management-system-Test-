<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="all_component/allCss.jsp"%>
</head>
<body Style="background-color: #f0f1f2;">
<%@include file="all_component/navbar.jsp"%>

	<div class="container">
		<div class="row p-3">
			<div class="col-md-6 offset-md-3">
			<div class="card">
			<div class="card-body">
			
			<h5 class="text-center text-success">Add Address</h5>
			
			<form>  
			<div class="form-row">
 <div class="form-group col-md-4">
      <label for="inputPassword4">Address</label>
      <input type="text" class="form-control" id="inputPassword4">
    </div>
    

    <div class="form-group col-md-6">
      <label for="inputEmail4">Landmark</label>
      <input type="text" class="form-control" id="inputEmail4" >
    </div>
    </div>
    
<div class="form-row">
<div class="form-group col-md-4">
      <label for="inputPassword4">City</label>
      <input type="text" class="form-control" id="inputPassword4">
    </div>
    
  
    <div class="form-group col-md-4">
      <label for="inputEmail4">State</label>
      <input type="email" class="form-control" id="inputEmail4" >
    </div>
    
    <div class="form-group col-md-4">
      <label for="inputPassword4">Pin Code</label>
      <input type="text" class="form-control" id="inputPassword4">
    </div>
  </div>
  <div class="text-center  mt-3">
<button class="btn btn-warning text-white">Add Address</button>
</div>
</div>
</div>
</form>
</div>
			</div>
			</div>

			

</body>
</html>
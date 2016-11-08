<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>

<c:set var="jobUrl" value="${pageContext.request.contextPath}/jobs"/>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 	<link rel="stylesheet" type="text/css" media="screen" href="<c:url value="/resources/css/sidebar.css" />" /> 
	<link rel="stylesheet" type="text/css" media="screen" href="<c:url value="/resources/css/bootstrap.min.css" />" />
	<title>Products</title>
</head>
<body>

	<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container-fluid">
	
	    <div class="navbar-header">
	      <a class="navbar-brand" href="#">Brand</a>
	    </div>
	
	    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	      <ul class="nav navbar-nav">
	        <li class="active"><a href="${jobUrl}/all">All Jobs</a></li>
	        <li><a href="${jobUrl}/add">Add Job</a></li>
	      </ul>
	    </div>
	
	</div>
	</nav>
	
	<section class="container">
		<form:form  modelAttribute="newJob" class="form-horizontal" method="POST">
			<fieldset>
				<legend>Add new product</legend>

				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="productId">Job Id</label>
					<div class="col-lg-10">
						<form:input id="productId" path="id" type="text" class="form:input-large"/>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="name">company Name</label>
					<div class="col-lg-10">
						<form:input id="company" path="company" type="text" class="form:input-large"/>
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-lg-2" for="unitPrice">Position</label>
					<div class="col-lg-10">
						<div class="form:input-prepend">
							<form:input id="position" path="position" type="text" class="form:input-large"/>
						</div>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="description">Description</label>
					<div class="col-lg-10">
						<form:textarea id="description" path="description" rows = "2"/>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="manufacturer">Location</label>
					<div class="col-lg-10">				
						 
					<form:select id="location" path="location" type="text" class="form:input-large" items="${LocationList}"/>
												 					  						
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="category">Category</label>
					<div class="col-lg-10">
					
					<form:select id="isPublic" path="isPublic" type="text" class="form:input-large" items="${isPublicMap}"/>
					
					<form:select id="type" path="type" type="text" class="form:input-large" items="${TypeList}"/>
												 						 
					</div>
				</div>

				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<input type="submit" id="btnAdd" class="btn btn-primary" value ="Add"/>
					</div>
				</div>
				
			</fieldset>
		</form:form>
	</section>
</body>
</html>

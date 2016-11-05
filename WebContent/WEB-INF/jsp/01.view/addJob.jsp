<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Products</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Jobs</h1>
				<p>Add job</p>
			</div>		
		</div>
	</section>
	<section class="container">
		<form:form  modelAttribute="newJob" class="form-horizontal" method="post">
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
					<label class="control-label col-lg-2" for="unitPrice">Location</label>
					<div class="col-lg-10">
						<div class="form:input-prepend">
							<form:input id="location" path="location" type="text" class="form:input-large"/>
						</div>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="description">Description</label>
					<div class="col-lg-10">
						<!-- html input area karsilik gelmektedir. -->
						<form:textarea id="description" path="description" rows = "2"/>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="manufacturer">Manufacturer</label>
					<div class="col-lg-10">				
						 				
						 <!-- HTML select option componentine karsilik gelmektedir. -->				
						
						<!-- hardcoded yaklasim -->
						<!-- 
						<form:select id="location" path="location" type="text" class="form:input-large">
							<form:option value="Apple">Apple</form:option>
							<form:option value="Google">Google</form:option>
							<form:option value="Samsung">Samsung</form:option>
						</form:select>
						 -->
						 
						 <!-- dinamik yaklasim model attribute reference data -->
						<!-- controller sinifimizdaki @ModelAttribute("manufacturerList") karsilik gelmektedir. -->
						 <form:select id="location" path="location" type="text" class="form:input-large" items="${LocationList}"/>
												 					  						
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="category">Category</label>
					<div class="col-lg-10">
					
					<!-- 
						<form:select id="isPublic" path="isPublic" type="text" class="form:input-large">
							<form:option value="Laptop">Laptop</form:option>
							<form:option value="Tablet">Tablet</form:option>
							<form:option value="Smart Phone">Smart Phone</form:option>
						</form:select>
					 -->	
						<form:select id="isPublic" path="isPublic" type="text" class="form:input-large" items="${categoryList}"/>
												 						 
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="condition">Condition</label>
					<div class="col-lg-10">
						<!-- html radio button componentine karsilik gelmektedir. -->					
						<!-- 
						<form:radiobutton path="isPublic" value="New" />New 
						<form:radiobutton path="isPublic" value="Old" />Old 
						<form:radiobutton path="isPublic" value="Refurbished" />Refurbished											
						  -->
						  
						 <form:radiobuttons path="isPublic" items="${conditionMap}"/>
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

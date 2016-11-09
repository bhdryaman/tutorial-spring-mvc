<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" %>

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
	      <a class="navbar-brand" href="#"><spring:message code="brand.name"/></a>
	    </div>
	
	    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	      <ul class="nav navbar-nav">
	        <li class="active"><a href="${jobUrl}/all"><spring:message code="jobs.all"/></a></li>
	        <li><a href="${jobUrl}/add"><spring:message code="jobs.add"/></a></li>
	      </ul>
	    </div>
	
	</div>
	</nav>
	
	<section class="container">
		<div class="row">
			<div class="col-md-5">
				<h3>${job.position}</h3>
				<p>${job.description}</p>
				<p>
					<strong>Job Code : </strong>${job.id}
				</p>
				<p>
					<strong>location</strong> : ${job.location}
				</p>
				<p>
					<strong>Position</strong> : ${job.position}
				</p>
				<p>
					<strong>Company</strong> : ${job.company}
				</p>
				<p>
					<a href="#" class="btn btn-warning btn-large"> <span
						class="glyphicon glyphicon-hand-right"></span> Apply Now
					</a> <a href="<spring:url value="/jobs/all" />" class="btn btn-default">
						<span class="glyphicon glyphicon-hand-left"></span> back
					</a>

				</p>

			</div>
		</div>
	</section>
</body>
</html>

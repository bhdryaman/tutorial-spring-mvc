<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Products</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Products</h1>
			</div>
		</div>
	</section>
	<section class="container">
		<div class="row">
			<div class="col-md-5">
				<h3>${job.position}</h3>
				<p>${job.description}</p>
				<p>
					<strong>Job Code : </strong><span class="label label-warning">${job.id}</span>
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
						class="glyphicon-shopping-cart glyphicon"></span> Apply Now
					</a> <a href="<spring:url value="/jobs/all" />" class="btn btn-default">
						<span class="glyphicon-hand-left glyphicon"></span> back
					</a>

				</p>

			</div>
		</div>
	</section>
</body>
</html>

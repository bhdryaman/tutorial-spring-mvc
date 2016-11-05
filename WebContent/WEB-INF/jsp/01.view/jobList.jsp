<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="jobUrl" value="${pageContext.request.contextPath}/jobs"/>
<c:set var="matrixUrl" value="${pageContext.request.contextPath}/jobs/filter"/>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 
<link rel="stylesheet" type="text/css" media="screen" href="<c:url value="/resources/css/sidebar.css" />" /> 
<link rel="stylesheet" type="text/css" media="screen" href="<c:url value="/resources/css/bootstrap.min.css" />" />
<script src="<c:url value="/resources/js/jquery-2.2.0.min.js" />"></script>
	
<title>Products</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h2>Jobs</h2>
				<h3>Available products</h3>
			</div>
		</div>
	</section>

    <div id="wrapper">

        <!-- Sidebar -->
        <div id="sidebar-wrapper">
            <ul class="sidebar-nav">
                <li class="sidebar-brand">                    
                        Type of working             
                </li>
                
                <li>	              
		            <label class="label-align">
		  				<input type="checkbox" name="type" value="full-time"><span>Full time</span>
		  			 </label>	             
	            </li>
                
                <li>	              
		            <label class="label-align">
		  				<input type="checkbox" name="type" value="part-time"><span>Part time</span>
		  			 </label>	             
	             </li>
                <li>
                	<label class="label-align">
                    	<input type="checkbox" name="type" value="other"><span>Other</span> 
                    </label> 	
                </li>
                
                <li class="sidebar-brand">                    
                        City                               
                </li>
                <li>
                	<label class="label-align">
                    	<input type="checkbox" name="location" value="istanbul"><span>İstanbul</span>
                    </label>
                </li>
                <li>
                	<label class="label-align">
                    	<input type="checkbox" name="location" value="ankara"><span>Ankara</span>
                    </label>
                </li>
                <li>
                	<label class="label-align">
                    	<input type="checkbox" name="location" value="izmir"><span>izmir</span>
                    </label>
                </li>
                <li>
                	<label class="label-align">
                    	<input type="checkbox" name="location" value="antalya"><span>Antalya</span>
                    </label>
                </li>                
                
				<a style="margin-left:20px" onclick="prepareMatrix()"  name="search" id="search"						
						class="btn btn-success" /></span> Search
				</a>
                
            </ul>
        </div>
	
	<script>
	function prepareMatrix(){

		var selectedTypes="";
		$('input:checkbox[name=type]').each(function() 
			{    
				if($(this).is(':checked'))
					selectedTypes=selectedTypes+$(this).val()+",";
			});
		
		
		
		var selectedLocations="";
		$('input:checkbox[name=location]').each(function() 
			{    
				if($(this).is(':checked'))
					selectedLocations=selectedLocations+$(this).val()+",";
			});
		
	
		var url= '${matrixUrl}/type='+selectedTypes+";location="+selectedLocations;
		$("#search").attr("href", url);

	}
	</script>
	
	<div id="page-content-wrapper">
	<section class="container">
	
		<div class="row">
		<div class="col-md-6">
			<ul class="nav nav-tabs">
				<li class="">
					<a href="${jobUrl}/all">All Products</a>
				</li>
				<li>
					<a href="${jobUrl}/full-time">Full-Time</a>
				</li>
				<li class="">
					<a href="${jobUrl}/part-time">Part-Time</a>
				</li>
				<li class="">
					<a href="${jobUrl}/other">Other</a>
				</li>
			</ul>
		</div>
	</div>
	
		<div class="row">
			<c:forEach items="${jobs}" var="job">
				<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
					<div class="thumbnail">
						<div class="caption">
							<h3>${job.position}</h3>
							<p>${job.description}</p>
							<p>${job.location}</p>
							<p>
								<a
									href=" <c:url value="/jobs/get?id=${job.id}" /> "
									class="btn btn-primary"> <span
									class="glyphicon-info-sign glyphicon" /></span> Details
								</a>
							</p>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
		</section>
		</div>
	</div>
</body>
</html>

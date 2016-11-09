<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<c:set var="jobUrl" value="${pageContext.request.contextPath}/jobs"/>
<c:set var="matrixUrl" value="${pageContext.request.contextPath}/jobs/filter"/>

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
	
	    <div class="collapse navbar-collapse">
	      <ul class="nav navbar-nav">
	        <li class="active"><a href="${jobUrl}/all"><spring:message code="jobs.all"/></a></li>
	        <li><a href="${jobUrl}/add"><spring:message code="jobs.add"/></a></li>
	      </ul>
	    </div>

		<ul class="nav navbar-nav navbar-right">
		  <li>
		  	<span>
		  		<a href="?language=en" >English</a>|
		  		<a href="?language=tr" >Türkce</a>
		  	</span>
		  </li>
		</ul>
   
	
	</div>
	</nav>

    <div id="wrapper">

        <div id="sidebar-wrapper" style="margin-top: 50px;">
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
                	<spring:message code="job.location"/>                   
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
                    	<input type="checkbox" name="location" value="izmir"><span>İzmir</span>
                    </label>
                </li>
                <li>
                	<label class="label-align">
                    	<input type="checkbox" name="location" value="antalya"><span>Antalya</span>
                    </label>
                </li>                
                
				<a style="margin-left:20px" onclick="prepareMatrix()"  name="search" id="search" class="btn btn-success" />
					<spring:message code="job.search"/>
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
	
		<div class="row" style="margin-top: 40px;" >
		<div class="col-md-6">
			<ul class="nav nav-tabs">
				<li class="">
					<a href="${jobUrl}/all"><spring:message code="job.type.all"/></a>
				</li>
				<li>
					<a href="${jobUrl}/full-time"><spring:message code="job.type.full_time"/></a>
				</li>
				<li class="">
					<a href="${jobUrl}/part-time"><spring:message code="job.type.part_time"/></a>
				</li>
				<li class="">
					<a href="${jobUrl}/other"><spring:message code="job.type.other"/></a>
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
								<a href=" <c:url value="/jobs/get?id=${job.id}" /> " class="btn btn-primary">
									<span class="glyphicon-info-sign glyphicon" /></span>
									<spring:message code="job.detail"/>
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
<script src="<c:url value="/resources/js/jquery-2.2.0.min.js" />"></script>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Project Manager</title>

	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
	<link rel="stylesheet" href="<spring:url value="/resources/css/home.css"/>" type="text/css"/>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

</head>
<body>

	<jsp:include page="../views/fragments/header.jsp"></jsp:include>
	
	<div class="container">
		<div class="row">
		
			<spring:url value="/project/add/" var="formUrl"></spring:url>
			
			<form:form method="post" action="${formUrl }" modelAttribute="project" cssClass="col-md-8 col-md-offset-2">
				<div class="form-group">
					<label for="project-name">Name</label>
					<form:input path="name" cssClass="form-control" id="project-name"/>
				</div>
				<form:errors path="name"/>
				<div class="form-group">
					<label for="project-type">Type</label>
					<form:select path="type" cssClass="selectpicker" items="${types}"></form:select>
				</div>
			
				<div class="form-group">
					<label for="sponsor-name">Sponsor Name</label>
					<form:input path="sponsor.name" cssClass="form-control" id="sponsor-name"/>
				</div>
				
				<div class="form-group">
					<label for="sponsor-phone">Sponsor Phone</label>
					<form:input path="sponsor.phone" cssClass="form-control" id="sponsor-phone"/>
				</div>
				
				<div class="form-group">
					<label for="sponsor-email">Sponsor Email</label>
					<form:input path="sponsor.email" cssClass="form-control" id="sponsor-email"/>
				</div>
				
				<div class="form-group">
					<label for="funds">Authorized Funds</label>
					<form:input id="funds" cssClass="form-control" path="authorizedFunds"/>
				</div>
			
				<div class="form-group">
					<label for="hours">Authorized Hours</label>
					<form:input id="hours" cssClass="form-control" path="authorizedHours"/>
					
				</div>
			
				<div class="form-group">
					<label for="project-name">Description</label>
					<form:textarea cssClass="form-control" path="description" rows="3"></form:textarea>
				</div>
				<form:errors path="description"/>
				<div class="form-group">
					<label for="poc1">Point of Contact 1</label>
					<form:input path="pointsOfContact[0]" cssClass="form-control" id="poc1"/>
				</div>
				
				<div class="form-group">
					<label for="poc2">Point of Contact 1</label>
					<form:input path="pointsOfContact[1]" cssClass="form-control" id="poc2"/>
				</div>
				
				<div class="form-group">
					<label for="poc3">Point of Contact 1</label>
					<form:input path="pointsOfContact[2]" cssClass="form-control" id="poc3"/>
				</div>
				
				<div class="form-group">
					<label for="special">Special</label>
					<form:checkbox id="special" path="special"/>
				</div>
				
				<button type="submit" class="btn btn-default">Submit</button>
	
			</form:form>
			
		</div>
	</div>
</body>
</html>

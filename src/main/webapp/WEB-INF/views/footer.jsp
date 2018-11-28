<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<!DOCTYPE html>

<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="css/style.css"/>
</head>
<body>
  
	<div id="footer-menu" class="footer-menu">
		
		<c:if test="${showChat}">
			<div id="form-human-message" class="form-human-message">
				<input id="input-human-message" class="input-human-message" placeholder="Digite aqui..."/>
			</div>
		</c:if>
		
		<div id="footer-sub-menu" class="footer-sub-menu">				
			© 2018 Developerworks | <a href="/how-i-work" class="link">How I work</a>				
		</div>
	</div>

</body>
</html>
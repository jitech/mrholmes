<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Mr.Holmes</title>
		
	<link href="css/style.css" rel="stylesheet">	
	<link href="https://fonts.googleapis.com/css?family=Roboto+Condensed" rel="stylesheet"/>
	
	<script src="js/script.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>	
	
</head>
<body class="body">
	
	<div id="header" class="header"> 	
		<center><jsp:include page="header.jsp" /></center>		
	</div>
		
	<div id="content" class="content"> 	
		
		<center>
		<c:choose>
			<c:when test="${page == 'chat'}">
        		<jsp:include page="chat.jsp" />
   			</c:when>
			<c:when test="${page == 'how-i-work'}">
        		<jsp:include page="how-i-work.jsp" />
   			</c:when>  
    		<c:otherwise>
        		<jsp:include page="not-found.jsp" />
    		</c:otherwise> 	
		</c:choose>
		</center>
		
	</div>	
		
	<div id="footer" class="footer"> 	
		<center><jsp:include page="footer.jsp" /></center>	
	</div>
	
</body>
</html>
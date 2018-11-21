<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
	
		<style>
		
			.div_robot_message{
				display: table; 
				float: left; 
				text-align: left; 
				background-color: #eee; 
				border-radius: 20px; 
				padding: 16px; 
				padding-bottom: 8px;
				max-width: 60%;
			}
			
			.div_human_message{
				display: table; 
				float: right; 
				text-align: left; 
				background-color: #5e60b4; 
				border-radius: 20px; 
				padding: 16px;
				padding-bottom: 8px;
				max-width: 60%;
				color: #FFF;
			}
			
			.link{
				color: #1d2129;
				text-decoration: none;
			}
		
		</style>
	
		<title>Mr.Holmes</title>
		
		<script>
		
			var line = '<div style="display: table; width: 100%; padding-top: 8px;"/>';
			var div_human_message = '<div class="div_human_message"> <div style="width: 100%; display: table"><MESSAGE></div> <div style="width: 100%; display: table; text-align: right; font-size: 8px; color: #F2F2F2"><TIME></div> </div>';
			var div_robot_message = '<div class="div_robot_message"> <div style="width: 100%; display: table"><MESSAGE></div> <div style="width: 100%; display: table; text-align: right; font-size: 8px; color: #848484"><TIME></div> </div>';		
			var div_robot_reading = '<div class="div_robot_message"> <img src="images/loading.svg" width="20px" style="margin-left: 7px; margin-right: 7px"> </div>';
					
			function sendMessage(){
				var date = new Date();
				var human_message = document.getElementById("human_message").value;			
				document.getElementById("message").innerHTML = document.getElementById("message").innerHTML + line + div_human_message.replace('<MESSAGE>', document.getElementById("human_message").value).replace('<TIME>', date.getHours() +':'+date.getMinutes());							
				document.getElementById("message").innerHTML = document.getElementById("message").innerHTML + line + div_robot_reading;
				document.getElementById("human_message").value = "";			
				searchEvaluations(human_message);
			};
		
			function sayWelcome(){		
				$.post("http://localhost:8090/mrholmes/talk", function (result) {				
					$.each(result, function(i, field){
						document.getElementById("message").innerHTML = document.getElementById("message").innerHTML + line + div_robot_message.replace('<MESSAGE>', field.text).replace('<TIME>', new Date(field.time).getHours() +':'+new Date(field.time).getMinutes());					
					});
				});
			};
			
			function searchEvaluations(what){
				$.post("http://localhost:8090/mrholmes/talk", {  topic : 'SAY_EVALUATION_SEARCH_RESULT', text : what }, function(result){
					$.each(result, function(i, field){
						if(document.getElementById("message").innerHTML.includes(div_robot_reading)){
							document.getElementById("message").innerHTML = document.getElementById("message").innerHTML.replace(div_robot_reading, div_robot_message).replace('<MESSAGE>', field.text).replace('<TIME>', new Date(field.time).getHours() +':'+new Date(field.time).getMinutes());					
						}else{
							document.getElementById("message").innerHTML = document.getElementById("message").innerHTML + line + div_robot_message.replace('<MESSAGE>', field.text).replace('<TIME>', new Date(field.time).getHours() +':'+new Date(field.time).getMinutes());
						}
					});
				});
			};
	
		</script>
</head>
<body onload="sayWelcome()" style="font-family: Helvetica Neue, Segoe UI, Helvetica, Arial, sans-serif; color: #1d2129; font-size: 16px; margin: 0px">
	
		<center>
			<div style="display: table; width: 40%; margin-top: 55px; margin-bottom: 0x">	
				<div style="display: table; width: 100%; margin-top: 0px; padding-top:5px; position: fixed; top: 0; background-color: #FFF">
					<a href="/"><img src="images/icon.png" width="45px" style="float: left; padding: 1px; border-radius: 100%"/></a>
				</div>
				<div id="message" style="margin-bottom: 150px"></div>			
				<div style="display: table; width: 40%; margin-top: 55px; position: fixed; bottom: 0; background-color: #FFF">		
					<input id="human_message" style="width: 80%; font-family: 'Raleway', sans-serif; padding: 10px; margin-top: 15px" placeholder="Digite aqui..."/>
					<button id="human_button" onclick="sendMessage()" style="width: 15%; padding: 11px; font-family: 'Roboto', sans-serif; margin-top: 5px; background-color: #5e60b4; border: 1px solid #5e60b4; color: #fff">ENVIAR</button>							
					<div style="width: 100%; display: table; margin-top: 50px; margin-bottom: 10px; font-size: 11px">				
						© 2018 Developerworks | <a href="/how-i-work" class="link">How I work</a>				
					</div>
				</div>			
			</div>			
		</center>
	
	</body>
</html>
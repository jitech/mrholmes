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
				max-width: 55%;
				font-size: 16px;
			}
			.link{
				color: #1d2129;
				text-decoration: none;
			}
		</style>
</head>
<body onload="sayWelcome()" style="font-family: Helvetica Neue, Segoe UI, Helvetica, Arial, sans-serif; color: #1d2129; font-size: 14px; margin: 0px">
	
		<center>
			<div style="display: table; width: 40%; margin-top: 55px; margin-bottom: 0x">	
				<div style="display: table; width: 100%; margin-top: 0px; padding-top:5px; position: fixed; top: 0; background-color: #FFF">
					<a href="/"><img src="images/icon.png" width="45px" style="float: left; padding: 1px; border-radius: 100%"/></a>
				</div>
							
				<div style="display: table; width: 100%; margin-bottom: 150px">
					<div id="title" style="width: 100%; display: table; text-align: left; font-weight: bold; letter-spacing: -3px; font-size: 24px; color: #1d2129">
						How I work
					</div>
					<div style="margin-top: 25px; width: 100%; display: table; text-align: left; font-size: 18px; color: #1d2129">						
						<div class="div_robot_message">&ldquo;Olá! Qual produto você quer comprar?&rdquo;</div>						
					</div>				
					<div style="margin-top: 25px; width: 100%; display: table; text-align: left; font-size: 18px; color: #1d2129;">					
						<div class="div_robot_message" style="float: right">
							&ldquo;Eu procuro na web as recomendações que o produto recebeu em várias lojas virtuais&rdquo;
						</div>						
					</div>
					<div style="margin-top: 25px; width: 100%; display: table; text-align: left; font-size: 18px; color: #1d2129;">					
						<div class="div_robot_message">&ldquo;Mostro pra você quantas pessoas recomendaram o produto&rdquo;</div>						
					</div>
					<div style="margin-top: 25px; width: 100%; display: table; text-align: left; font-size: 18px; color: #1d2129;">					
						<div class="div_robot_message" style="float: right">&ldquo;Agora é com você!&rdquo;</div>						
					</div>
				</div>
				
				<div style="display: table; width: 40%; margin-top: 55px; position: fixed; bottom: 0; background-color: #FFF">		
					<div style="width: 100%; display: table; margin-top: 50px; margin-bottom: 10px; font-size: 11px">				
						© 2018 Developerworks | <a href="/how-i-work" class="link">How I work</a>				
					</div>
				</div>			
			</div>			
		</center>
	
	</body>
</html>
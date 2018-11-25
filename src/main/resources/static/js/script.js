var line = '<div style="display: table; width: 100%; padding-top: 8px;"/>';
var div_human_message = '<div class="human-message"> <div style="width: 100%; display: table"><MESSAGE></div> <div style="width: 100%; display: table; text-align: right; font-size: 8px; color: #F2F2F2"><TIME></div> </div>';
var div_robot_message = '<div class="robot-message"> <div style="width: 100%; display: table"><MESSAGE></div> <div style="width: 100%; display: table; text-align: right; font-size: 8px; color: #848484"><TIME></div> </div>';		
var div_robot_reading = '<div class="robot-message"> <img src="images/loading.svg" width="20px" style="margin-left: 7px; margin-right: 7px"> </div>';
					
function sendMessage(){
	var human_message = document.getElementById("human-message").value;	
	var date = new Date();					
	document.getElementById("message").innerHTML = document.getElementById("message").innerHTML + line + div_human_message.replace('<MESSAGE>', document.getElementById("human-message").value).replace('<TIME>', date.getHours() +':'+date.getMinutes());							
	document.getElementById("message").innerHTML = document.getElementById("message").innerHTML + line + div_robot_reading;
	document.getElementById("human-message").value = "";			
	sayEvaluationProduct(human_message);		
};
		
function sayWelcome(){		
	$.post("/mrholmes/talk", function (result) {				
		$.each(result, function(i, field){
			document.getElementById("message").innerHTML = document.getElementById("message").innerHTML + line + div_robot_message.replace('<MESSAGE>', field.text).replace('<TIME>', new Date(field.time).getHours() +':'+new Date(field.time).getMinutes());					
		});
	});
};
			
function sayEvaluationProduct(what){
	$.post("/mrholmes/talk", {  topic : 'SAY_EVALUATION_PRODUCT', text : what }, function(result){
		$.each(result, function(i, field){
			if(document.getElementById("message").innerHTML.includes(div_robot_reading)){
				document.getElementById("message").innerHTML = document.getElementById("message").innerHTML.replace(div_robot_reading, div_robot_message).replace('<MESSAGE>', field.text).replace('<TIME>', new Date(field.time).getHours() +':'+new Date(field.time).getMinutes());					
			}else{
				document.getElementById("message").innerHTML = document.getElementById("message").innerHTML + line + div_robot_message.replace('<MESSAGE>', field.text).replace('<TIME>', new Date(field.time).getHours() +':'+new Date(field.time).getMinutes());
			}
		});
	});
};
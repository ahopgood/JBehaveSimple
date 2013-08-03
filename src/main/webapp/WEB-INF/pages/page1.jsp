<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
	<head>
		<title>Page One</title>
		<script type="text/javascript" src="../../../js/jquery-1.7.2.js"></script>
		<script type="text/javascript">
			window.onload = start;
			var rootContext = "../../..";
			function start() {
				var template 	= document.getElementById("rtti_table_body_template");
				var table 		= document.getElementById("rtti_table");
				var tableBody	= document.getElementById("rtti_table_body");
				
				var rttis		= createObjects();
				for (var i = 0; i < rttis.length; i++){
					var clone 		= template.cloneNode(true);
					tableBody.appendChild(fillInTableRow(clone, rttis[i]));
				}
			};
			
			function rttiInfo(route, status, legs) {
				this.route=route;
				this.status=status;
				this.legs=legs;
			};
			
			function leg(departure, arrival){
				this.departure=departure;
				this.arrival=arrival;
			};
			
			function fillInTableRow(template, rttiInfo) {
				//console.log(template);
				console.log("In the fillInTableRow with rttiInfo "+rttiInfo);
				var children 		= template.childNodes;
				console.log(children);
				console.log("The number of children is "+children.length);
				
				for (var i = 1; i < children.length; i++){
					if (children.item(i).nodeType==1){
						if (i==1){
							console.log("Test"+i+" "+children.item(i).id);
							children.item(i).innerHTML 		= rttiInfo.route;
						} else if (i==2) {
							children.item(i).innerHTML		= rttiInfo.status;
						} else {
							console.log("Legs "+rttiInfo.legs);
							var leg = rttiInfo.legs[i-3];
							//console.log(leg);
							//console.log("Test"+i);
							if (leg != undefined){
	 							children.item(i).innerHTML		= leg.departure + "," +leg.arrival;
							}
						}
					}

				}
				return template;
			};
			
			function createObjects(){
				var objects = new Array();
				objects[0] = new rttiInfo("MAN-EUS","LATE",new Array(new leg("0","+5")));
				console.log("rttiInfo object");
				console.log(objects[0]);
				return objects;
			};
			/*
			function ajaxGet(parameters,url){
				var request = new XMLHttpRequest();
				request.open("GET",url+"?"+parameters,true);
				request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
				request.send();
				request.onreadystatechange = function() {
					if (request.readyState == 4 && request.status == 200) {
						//do something on request success
						console.log("Success");
					} else if (request.readyState == 2){
						//do some error handling
						console.log("Failure :"+request.statusText);
						console.log(request);
					}
				}
			};*/
			
			function buttonClick() {
				console.log("Testing");
				
				$.ajax({ 	type: "GET",
							url: rootContext+"/test/testers/json", 
							dataType: "text", 
							contentType: "application/json", 
							success: function(text) { 
								console.log("Success "+text); 
								var json		= jQuery.parseJSON(text);
								var template 	= document.getElementById("rtti_table_body_template");
								var tableBody	= document.getElementById("rtti_table_body");
								var clone 		= template.cloneNode(true);
								console.log("Have created a clone node");
								tableBody.appendChild(fillInTableRow(clone, json[0]));
								console.log(json);
								console.log("status "+json[0].status);
								console.log("route "+json[0].route);
								console.log("legs "+json[0].legs);
								console.log("Tried to append child");
							}, 
							error: function(xhr) { 
								console.log("Failure",xhr); 
							}
						});
					return false;
			};
		</script>
	</head>
	<body>
		<form action="uploadNewFile">
			<h1>Upload a new file</h1>
			<input type="file" name="NewFile"/>
			<input type="submit" name="UploadFile" value="Upload File"/>
		</form>
		<div>
			<form action="POST">
				<h1>Select a file</h1>
				<select>
					<option>bob</option>
				</select>
				<input type="submit" name="LoadFile" value="Load File" />
			</form>
		</div>
		<table id="rtti_table">
			<thead>
				<tr>
					<th>Route</th><th>Status</th><th>Leg 1</th><th>Leg 2</th><th>Leg 3</th><th>Leg 4</th><th>Leg 5</th><th>Leg 6</th>
				</tr>
			</thead>
			<tbody id="rtti_table_body">
			</tbody>
		</table>
		<div>
			<table>
				<tbody>
					<tr id="rtti_table_body_template">
						<td id="route"></td><td id="status"></td><td id="leg1"></td><td id="leg2"></td><td id="leg3"></td><td id="leg4"></td><td id="leg5"></td><td id="leg6"></td>
					</tr>	
				</tbody>
			</table>
		</div>
		<div>
			<input id="testget" type="button" value="GET" onclick="buttonClick()"/>
		</div>
	</body>
</html>
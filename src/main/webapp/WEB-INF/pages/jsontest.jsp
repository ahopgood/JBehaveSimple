<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
	<head>
		<title>Sample Web Application</title>
		<script type="text/javascript" src="../../../js/jquery-1.7.2.js"></script>
		<script type="text/javascript">
			$(document).ready(function() {
				$("form.readJsonForm").submit(function() {
					var form = $(this);
					var button = form.children(":first");
					console.log("In the readJsonForm method");
					//var data = form.hasClass("invalid") ?
					//var data = "{ 'route':'route1', 'status':'ontime', '' },{ \"foo\": \"bar\", \"fruit\": \"apple\" }";
					$.ajax({ 	type: "GET", 
								url: form.attr("action"), 
								data: data, 
								contentType: "application/json", 
								dataType: "text", 
								success: 
									function(text) { 
										console.log(text); 
									}, 
								error: function(xhr) { 
										console.log(xhr.responseText); 
									}
							});
					return false;
				});//end readjsonform
				
				$("#readForm").submit(function() {
					var form = $(this);
					var button = form.children(":first");
					$.ajax({ 	type: "POST", 
								url: form.attr("action"), 
								data: "foo=bar&fruit=apple", 
								contentType: "application/x-www-form-urlencoded", 
								dataType: "text", 
								success: function(text) { 
									console.log("Success");
								}, 
								error: function(xhr) { 
									console.log("Failure", xhr);
								}
							});
					return false;
				});
				
				$("#writeForm").click(function() {
					var link = $(this);
					$.ajax({ 	url: this.href, 
								dataType: "text", 
								beforeSend: function(req) { 
									req.setRequestHeader("Accept", "application/x-www-form-urlencoded"); 
								}, 
								success: function(form) { 
									console.log("Success");
								}, 
								error: function(xhr) { 
									console.log("Failure"); 
								}
							});					
					return false;
				});
				
				$("form.textForm").submit(function(event) {
					var form = $(this);
					var button = form.children(":first");
					$.ajax({ type: "POST", url: form.attr("action"), data: "foo", contentType: "text/plain", dataType: "text", success: function(text) { console.log("Success "+text); }, error: function(xhr) { console.log("Failure"); }});
					return false;
				});
				
				$("a.textLink").click(function(){
					var link = $(this);
					$.ajax({ url: link.attr("href"), dataType: "text", success: function(text) { console.log("Success "+text); }, error: function(xhr) { console.log("Failure"); }});
					return false;
				});
				
				$("a.jsonLink").click(function(){
					var link = $(this);
					$.ajax({ 	url: link.attr("href"), 
								dataType: "text", 
								contentType: "application/json", 
								success: function(text) { 
									console.log("Success "+text); 
								}, 
								error: function(xhr) { 
									console.log("Failure",xhr); 
								}
							});
					return false;
				});
				
				$("form.jsonForm").submit(function(event) {
					var form = $(this);
					var button = form.children(":first");
					$.ajax({ 	type: "POST", 
								url: form.attr("action"), 
								data: "foo", 
								contentType: "text/plain", 
								dataType: "text", 
								success: function(text) { 
									console.log("Success "+text); 
								}, 
								error: function(xhr) { 
									console.log("Failure",xhr); 
								}
							});
					return false;
				});
			});
		</script>
	</head>
	<body>
		<h1>This is a sample web page</h1>
		<div>
			<form id="readString" class="textForm" action="<c:url value="/test/testers/writestring" />" method="post">
				<input id="readStringSubmit" type="submit" value="Read a String" />
			</form>

			<a id="writeString" class="textLink" href="<c:url value="/test/testers/writestring" />">Write a String</a>
			</br>
			<a id="jsonString" class="jsonLink" href="<c:url value="/test/testers/json" />">Read json</a>
			</br>
			
			<form id="readJsonString" class="jsonForm" action="<c:url value="/test/testers/json" />" method="post">
				<input id="readStringSubmit" type="submit" value="Write json" />
			</form> 
			 
			<form id="readString" class="textForm" action="<c:url value="/messageconverters/string" />" method="post">
				<input id="readStringSubmit" type="submit" value="Read a String" />
			</form>			 
			<a id="writeForm" href="<c:url value="/messageconverters/form" />">Write Form Data</a>
			
			<form id="postJson" class="readJsonForm" action="<c:url value="/test/testers/json" />" method="post">
				<input id="jsonPostSubmit" type="submit" value="Post JSON" />	
			</form>
			
			<form id="readJson" class="readJsonForm" action="<c:url value="/test/testers/jsonget" />" method="get">
				<input id="readJsonSubmit" type="submit" value="Read JSON" />
			</form>
			<a id="writeJson" class="writeJsonLink" href="<c:url value="/messageconverters/json" />">Write JSON</a>
  		</div>
	</body>
</html>
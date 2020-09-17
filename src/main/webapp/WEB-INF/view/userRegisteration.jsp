<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 



<html>
<head>
<script src="./js/app.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
$(document).ready(function(event){
	$("#countryId").change(function(){
		
		$("#stateId").find('option').remove();
		$("#cityId").find('option').remove();
		var countryId=$("#countryId").val();
		$.ajax({
			url:"/state?id="+countryId,
			success:function(result){
				 $('<option>').val('').text("-Select-").appendTo("#stateId");
				$.each(result,function(key,value){
				$('<option>').val(key).text(value).appendTo("#stateId");
				})
			}
		})
	});
	$("#stateId").change(function(){
		
		$("#cityId").find('option').remove();
		var stateId=$("#stateId").val();
		$.ajax({
			url:"/city?id="+stateId,
			success:function(result){
				$('<option>').val('').text("-Select-").appendTo("#cityId");
				$.each(result,function(key,value){
				$('<option>').val(key).text(value).appendTo("#cityId");
				})
			}
		})
	});
	
	$("#email").blur(function(){
		var email = $("#email").val();
		$.ajax({
			url:"/emailCheck?email="+email,
			success:function(response){
				console.log({response});
				if(response){
					$("#emailvalidate").text("email already exist");
					$("#emailvalidate").css("color","red");
				}else{
					$("#emailvalidate").text('');
					$("#emailvalidate").css("color","");
				}
			}
		})
	})
	});
</script>
</head>
<body>
<p>${msg}</p>
<h1>User Registraction Form</h1>
<form:form  modelAttribute="user" action="/saveUser">
First Name:
<form:input path="firstName" value=""/>
<br/><br/>
Last Name:
<form:input path="lastName" value=""/>
<br/><br/>
Email:
<form:input path="email" value=""/>
<span id="emailvalidate"></span>
<br/><br/>

Phone number:
<form:input path="phno" value=""/>
<br/><br/>
Country:
<form:select path="countryId">
<form:option value="">-Select-</form:option>
<form:options items="${countryMap}"></form:options>

</form:select>
<br/><br/>
State:
<form:select path="stateId">
<form:option value="">-Select-</form:option>
</form:select>
<br/><br/>
city:
<form:select path="cityId">
<form:option value="">-Select-</form:option>
</form:select>
<br/><br/>
<input type="submit" value="save" />
<input type="button" value="reset" />

</form:form>
</body>

</html>
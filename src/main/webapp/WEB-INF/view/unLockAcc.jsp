<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 



<html>
<head>
<script src="./js/app.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

</head>
<body>
<form:form  action="unlockAccount" modelAttribute="unlockAcc">
Email:<form:input path="email" readonly="true"/>
  temp pwd:<form:input path="tempPwd" /><br><br>
  New Password: <form:input path="newPwd" /><br><br>
  confirm password:  <form:input path="confirmPwd" /><br><br>

<input type="submit" value="save"/>
</form:form>
</body>



</html>
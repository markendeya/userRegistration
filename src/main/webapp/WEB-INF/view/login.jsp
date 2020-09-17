<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<h3>Enter your credintials</h3>

<form:form action="/validateLogin" modelAttribute="login" >
UserName: <form:input path="userName" ></form:input>
password: <form:input path="password"></form:input>

<input type="submit" value="login" />
</form:form>
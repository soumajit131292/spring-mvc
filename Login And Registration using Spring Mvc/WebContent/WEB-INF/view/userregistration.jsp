<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<style>
.errors{color:red}
</style>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form action="registerProcess" modelAttribute="userDetails">
  FirstName :
  <form:input path="firstname" />
  <form:errors path="firstname" cssClass="errors"/><br/><br/>
   LastName:
   <form:input path="lastname" />
   
   <br/>
		<p />
   Password:
  <form:password path="password" required="true"/>
  <form:errors path="password" cssClass="errors"/><br/><br/>
    MobileNumber:
  <form:input path="mobileNumber" />
  <form:errors path="mobileNumber" cssClass="errors"/><br/>
  
  EmailId:
  <form:input path="emailId" required="true"/><br/>
  Gender:
         Male<form:radiobutton path="gender" value="Male" checked="checked"/>
         Female: <form:radiobutton path="gender" value="Female" />
		<p /><br/>
		Country:
     <form:select path="country">
			<form:option value="India"></form:option>
			<form:option value="New Zealand"></form:option>
			<form:option value="Australia"></form:option>
		</form:select><br/>
		<input type="submit" value="submit">
	
	</form:form>
</body>
</html>
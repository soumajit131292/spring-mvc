<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form action="registerProcess" modelAttribute="userDetails">
  FirstName :
  <form:input path="firstname" /><br/>
   LastName:
   <form:input path="lastname" /><br/>
		<p />
   Password:
  <form:password path="password" /><br/>
    MobileNumber:
  <form:input path="mobileNumber" /><br/>
  EmailId:
  <form:input path="emailId" /><br/>
  Gender:
         Male<form:radiobutton path="gender" value="Male" />
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
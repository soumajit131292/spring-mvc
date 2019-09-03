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

	<form:form action="emailSendingProcess" modelAttribute="forgetPasswordDetails">
	
 EmailId:
  <input type="text" name="emailid" placeholder="Email" />
  
		<input type="submit" value="Enter">
		<br />

	</form:form>
</body>
</html>
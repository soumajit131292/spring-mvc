<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Forgot Password</title>
</head>
<body>
<form:form action="loginProcess" modelAttribute="loginDetails">
 
  Email-Id :
  <form:input path="firstname" />
   <p />
   Password:
  <form:password path="password" />
  
  <input type="submit" value="Log in"><br/>
  <br/>
  <a href="forget">Forget password</a><br/>
 <br/>click here for <a href="userregistration">Registration</a>
  
  
  </form:form>
</body>
</html>
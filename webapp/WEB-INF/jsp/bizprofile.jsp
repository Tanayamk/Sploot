<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">



<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>

<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body style='
          
          background-image: url(https://images.pexels.com/photos/7788657/pexels-photo-7788657.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940);
          background-color: rgba(255,255,255,0.6);
          background-blend-mode: lighten;
          -webkit-background-size: cover;
  -moz-background-size: cover;
  -o-background-size: cover;
  background-size: cover;
  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
             padding-left:25px;
             padding-top: 25px;
             '>

	<c:set var="x" value="0"></c:set>
	

	<header>
            <h1 style="
                font-weight: 300;
                font-size: 40px;
                letter-spacing: 10px;
                color: var(--dark);">
			Sploot Business
		</h1>
             You are logged in as a Partner Owner</br>
             User id :<c:out value="${currentuser.getEmail() }"></c:out></br>         
            <a align="right" href="home.htm">Home</a>|<a align="right" href="logout.htm">Logout</a></br>
  	 <div align="center">
        <form:form action="registerbiz.htm" modelAttribute="biz" method="post">
            <table border="0">
                <tr>
                    <td colspan="2" align="center"><h2>Biz Registration Form</h2></td>
</tr>
                <tr>
                    <td>Biz Name:</td>
                    <td><form:input path="bizname" /></td>
                </tr>
 <tr>
                    <td>About Biz:</td>
                    <td><form:input path="aboutbiz" /></td>
                </tr>
		<tr>
                    <td>Biz Owner's Email:</td>
                    <td><form:input  disabled="true" path="owneremail" value="${currentuser.getEmail() }" /></td>
                </tr>
                <tr>
                    <td>City:</td>
                    <td><form:input path="city" /></td>
                </tr>
                <tr>
                    <td>Upload Photograph1:</td>
                    <td><form:input path="profilephoto1" /></td>
                </tr>
                <tr>
                    <td>Upload Photograph2:</td>
                    <td><form:input path="profilephoto2" /></td>
                </tr>
                <tr>
                    <td>Biz Business type:</td>
                    <td><form:select path="btype">  
        <form:option value="GR" label="Grooming"/>  
        <form:option value="DC" label="Day Care"/>  
        <form:option value="VT" label="Veterinary"/>  
        </form:select>  </td>
                </tr>

		<tr>
                    <td></td>
                    <td><form:hidden path="rating" /></td>
                </tr>
		
                <tr>
    
                    <td colspan="2" align="center"><input type="submit" value="Register Biz" /></td>
                </tr>
            </table>
        </form:form>
    </div>


	
	<footer>
		<div class="footer"> 
	      
	    </div>
	</footer>
	
</body>
</html>

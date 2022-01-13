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
			Sploot Reviews
		</h1>
             <a align="right" href="home.htm">Home</a></br>
             User id :<c:out value="${currentuser.getEmail() }"></c:out></br>         
            <a align="right" href="logout.htm">Logout</a></br>

  	 <div align="center">
        <form:form action="savereviewform.htm" modelAttribute="appointment"  method="post">
            <table border="0">
                <tr>
                    <td colspan="2" align="center"><h2>Submit Review on Appointment</h2></td>
                </tr>
                <tr>
                    <td>Service Type:</td>
                <td><c:if test="${appointment.atype.equals('GR') }">Grooming</c:if><c:if test="${appointment.atype.equals('DC') }">Day Care</c:if><c:if test="${appointment.atype.equals('VT') }">Veterinary</c:if> </td>
                </tr>
                <tr>
                    <td>Service Provider:</td>
                    <td><c:out value="${appointment.bizemail}"/></td>
                </tr>
                <tr>
                    <td>Name:</td>
                    <td><c:out value="${appointment.bizname}"/></td>
                </tr>
		<tr>
                    <td>City:</td>
                    <td><c:out value="${appointment.city}"/></td>
                </tr>

                <tr>
                    <td>Closing Status:</td>
                    <td><c:out value="${appointment.closingstatus}"/></td>
                </tr>
                <tr>
                    <td>Your Review:</td>
                    <td><form:input path="custreviews" /></td>
                </tr>
		
		
                <tr>
    
                    <td colspan="2" align="center"><input type="submit" value="Save Changes" /></td>
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

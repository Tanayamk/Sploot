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
			Sploot Appointments
		</h1>
            You are logged in as a Pet Owner</br>
             User id :<c:out value="${currentuser.getEmail() }"></c:out></br>         
            <a align="right" href="home.htm">Home</a>|<a align="right" href="logout.htm">Logout</a></br>

  	 <div align="center">
        <form:form action="saveregisterappointment.htm" modelAttribute="appointment" method="post">
            <table border="0">
                <tr>
                        <td colspan="2" align="center"><h2>Appointment Registration Form</h2></td>
</tr>
            <tr>
                    <td>Type Of Appointment:</td>
                    <td><c:if test="${appointment.atype.equals('GR') }">Grooming</c:if><c:if test="${appointment.atype.equals('DC') }">Day Care</c:if><c:if test="${appointment.atype.equals('VT') }">Veterinary</c:if><form:hidden  path="atype" /></td>
                </tr>    
            <tr>
                    <td>Pet Name:</td>
                    <td><form:select path="petname">
  <c:forEach items="${petlist}" var="pt">
    <form:option value="${pt.petname}">${pt.petname}</form:option>
  </c:forEach>
</form:select> 
</td>
                </tr>
		<tr>
                    <td>Pet Owner's Email:</td>
                    <td><c:out value="${appointment.getCustemail() }"/><form:hidden  path="custemail" /></td>
                </tr>

                <tr>
                    <td>Sploot Email:</td>
                    <td><c:out value="${appointment.bizemail }"/><form:hidden path="bizemail"  /></td>
                </tr>
                <tr>
                    <td>Sploot Name:</td>
                    <td><c:out value="${appointment.bizname }"/><form:hidden path="bizname" /></td>
                </tr>
		<tr>
                    <td>Sploot City:</td>
                    <td><c:out value="${appointment.city }"/><form:hidden path="city" /></td>
                </tr>
		<tr>
                    <td>Appointment Request Filled On Date</td>
                    <td><c:out value="${appointment.reqdate }"/><form:hidden path="reqdate" /></td>
                </tr>
                <tr>
                    <td></td>
                    <td><form:hidden path="appointdate" /></td>
                </tr>
                <tr>
                    <td></td>
                    <td><form:hidden path="closingdate" /></td>
                </tr>

                <tr>
                    <td></td>
                    <td><form:hidden path="closingstatus"/></td>
                </tr>
                <tr>
                    <td></td>
                    <td><form:hidden path="custreviews" /></td>
                </tr>
                <tr>
    
                    <td colspan="2" align="center"><input type="submit" value="Make Appointment"/></td>
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


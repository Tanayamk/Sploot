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
            You are logged in as a Partner Owner</br>
             User id :<c:out value="${currentuser.getEmail() }"></c:out></br>         
            <a align="right" href="home.htm">Home</a>|<a align="right" href="logout.htm">Logout</a></br>

  	 <div align="center">
       
            <table border="0">
                <tr>
                        <td colspan="2" align="center"><h2>Appointment with Pet Details </h2></td>
               </tr>
               <tr>
                    <td>Appointment Id:</td>
                    <td><c:out value="${appointmentselected.appointid }"/></td>
                </tr>               
                <tr>
                    <td>Type Of Appointment:</td>
                    <td><c:if test="${appointmentselected.atype.equals('GR') }">Grooming</c:if><c:if test="${appointmentselected.atype.equals('DC') }">Day Care</c:if><c:if test="${appointmentselected.atype.equals('VT') }">Veterinary</c:if></td>
                </tr>    
                <tr>
                    <td>Pet Name: </td>
                    <td><c:out value="${appointmentselected.petname}"/></td>
                </tr>
                <tr>
                    <td>Pet Breed : </td>
                     <td><c:out value="${appointmentpet.breed}"/></td>
                    
                </tr>
                <tr>
                    <td>Pet Description: </td>
                    <td><c:out value="${appointmentpet.aboutpet}"/></td>
                </tr>
                <tr>
                    <td>Pet Medical: </td>
                    <td><c:out value="${appointmentpet.medicalstatus}"/></td>
                </tr>
                 <tr>
                    <td>Services Availed for Pet: </td>
                    <td><c:out value="${appointmentpet.servicesavailed}"/></td>
                </tr>
		<tr>
                    <td>Pet Owner's Email:</td>
                    <td><c:out value="${appointmentselected.custemail }"/></td>
                </tr>

                
                
                
                <tr><td>
            <form action="processandcloseappointment.htm" method="get">
       <input type="hidden" name="id" value=<c:out value="${appointmentselected.appointid }"/>>
       <input type="submit" value="Process"/></form></td>
            <td>
            <form action="viewappointmentsforbp.htm" method="get">
                <input type="submit" value="Back"/></form></td>
       
                </tr>
            </table>
        
    </div>


	
	<footer>
		<div class="footer"> 
	      
	    </div>
	</footer>
	
</body>
</html>


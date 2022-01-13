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
			Sploot Customer Reviews on Appointments
		</h1>
            You are logged in as a Partner Owner</br>
             User id :<c:out value="${currentuser.getEmail() }"></c:out></br>         
            <a align="right" href="home.htm">Home</a>|<a align="right" href="logout.htm">Logout</a></br>

  	 <div align="center">
<h1>Your List Of Appointment Reviews</h1>  
<table border="2" width="70%" cellpadding="2">  
<tr><th>Appointment Id</th><th>Pet Name</th><th>Service </th><th>Provider Business Name</th><th>Customer Email</th><th>City</th><th>Reviews</th></tr>  
   <c:forEach var="mylist" items="${appointmentslistforreviews}"> 
    
   <tr>  
   <td>${mylist.appointid}</td>  
   <td>${mylist.petname}</td>  
   <td><c:if test="${mylist.atype.equals('GR') }">Grooming</c:if><c:if test="${mylist.atype.equals('DC') }">Day Care</c:if><c:if test="${mylist.atype.equals('VT') }">Veterinary</c:if></td>  
   <td>${mylist.bizname}</td> 
   <td>${mylist.custemail}</td>
   <td>${mylist.city}</td> 
   <td>${mylist.custreviews}</td>   
   </tr>  
   
   </c:forEach>  
   </table>  
   <br/>  
   
    </div>


	
	<footer>
		<div class="footer"> 
	      
	    </div>
	</footer>
	
</body>
</html>

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
<body>

	<c:set var="x" value="0"></c:set>
	

	<header>
            <h1>
			Sploot Appointments
		</h1>
            You are logged in as a Partner Owner</br>
             User id :<c:out value="${currentuser.getEmail() }"></c:out></br>         
            <a align="right" href="home.htm">Home</a>|<a align="right" href="logout.htm">Logout</a></br>

  	 <div align="center">
<h1>Your Appointment List for Closure</h1>  
<table border="2" width="70%" cellpadding="2">  
<tr><th>Service Request</th><th>Pet Name</th><th>Owner Email</th><th>City</th><th>Existing Closure Review</th><th>View/Submit Closure Status</th></tr>  
   <c:forEach var="mylist" items="${appointmentslist}">  
        
   <tr>  
   <td>${mylist.appointid}</td>   
   <td><c:if test="${mylist.atype.equals('GR') }">Grooming</c:if><c:if test="${mylist.atype.equals('DC') }">Day Care</c:if><c:if test="${mylist.atype.equals('VT') }">Veterinary</c:if> </td>   
   <td>${mylist.petname}</td>
   <td>${mylist.custemail}</td>  
   <td>${mylist.city}</td> 
   <td>${mylist.closingstatus}</td> 
   
   <td>
   <form action="submitbpclosurereview.htm" method="get">
      Closure Review Comments :<input type="text" name="review">
      <input type="hidden" name="id" value="${mylist.appointid}">
       <input type="submit" value="Submit review">
    </form>
   </td>
   
   </tr>  
   </c:forEach>  
   </table>  
   <br/>  
   
    </div>


	
	<footer>
		<div class="footer"> 
	      //footer
	    </div>
	</footer>
	
</body>
</html>

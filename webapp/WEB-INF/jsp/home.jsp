<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
			Sploot Home
		</h1>
            You are logged in as a <c:if test="${currentuser.getUtype().equals('po') }"> Pet Owner</c:if> <c:if test="${currentuser.getUtype().equals('bp') }"> Partner Owner</c:if></br>
        User id :<c:out value="${currentuser.getEmail() }"></c:out> </br>
            <a align="right" href="logout.htm">Logout</a><br>	</br>
            
	</header>
	
	
 	<div class="container">
 		<div class="row">
 				<div class="col-md-4">
 					    <c:if test="${currentuser.getUtype().equals('po') }"> Pet Care Services for Pet Owners </br> 
						   
					      <div class="list-group">
                                                  <ul>
                                                      
						    
                                                  
                                                 
                                                  <li><a href="viewpetprofiles.htm" class="list-group-item">View Your Pet Profiles</a></li>                                                
                                                     <li><a href="appointmentsprofile.htm" class="list-group-item">Book Appointments</a></li>
                                                     <li><a href="viewappointmentsprofiles.htm" class="list-group-item">Booked Appointments</a></li>
						  <li><a href="viewclosedappointmentsprofiles.htm" class="list-group-item">Write Reviews</a></li>
						  
                                                  </ul>
                                              </div>
                                            </c:if>
                                                  
                                            <c:if test="${currentuser.getUtype().equals('bp') }"> Business Opportunities for Partner</br>
                                            <div class="list-group">
                                                  <ul>
                                                      
						    
                                                   
                                                 
                                                  <li><a href="viewbizprofiles.htm" class="list-group-item">View Business Partner Profiles</a></li>
                                                  <li><a href="viewappointmentsforbp.htm" class="list-group-item">View Appointments</a></li>
                                                  <li><a href="viewcustreviwsforbp.htm" class="list-group-item">Customer Reviews on Appointments</a></li>
						  
                                                  </ul>
                                              </div></c:if></br>
						
 				</div>

 				<div class="col-md-8"><!-- right -->
 					<h2 style="text-align: center;"></h2><br>
 					
										
 					
 					
 				</div>
 			</div>
 		</div>
 	
	
	
	<footer>		
	</footer>
	
</body>
</html>

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
			Sploot Pets
		</h1>
            You are logged in as a Pet Owner</br>
             User id :<c:out value="${currentuser.getEmail() }"></c:out></br>         
            <a align="right" href="home.htm">Home</a>|<a align="right" href="logout.htm">Logout</a></br>
  	 <div align="center">
<h1>Your Pet List</h1>  
<table border="2" width="70%" cellpadding="2">  
<tr><th>Pet Id</th><th>Pet Name</th><th>Pet Type</th><th>City</th><th>Edit</th><th>Delete</th></tr>  
   <c:forEach var="mypet" items="${petlist}">   
   <tr>  
   <td>${mypet.petid}</td>  
   <td>${mypet.petname}</td>  
   <td>${mypet.aboutpet}</td>  
   <td>${mypet.breed}</td>  
   <td>${mypet.medicalstatus}</td>  
   <td>${mypet.servicesavailed}</td>  
   
   <td><a href="editpet.htm?id=${mypet.petid}">Edit</a></td>  
   <td><a href="deletepet.htm?id=${mypet.petid}">Delete</a></td>  
   </tr>  
   </c:forEach>  
   </table>  
   <br/>  
   <a href="petprofile.htm" class="list-group-item">Create Pet Profile</a>
    </div>


	
	<footer>
		<div class="footer"> 
	      
	    </div>
	</footer>
	
</body>
</html>

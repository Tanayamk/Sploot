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
            <a align="right" href="home.htm">Home</a></br>
             User id :<c:out value="${currentuser.getEmail() }"></c:out></br>         
            <a align="right" href="logout.htm">Logout</a></br>

  	 <div align="center">
        <form:form action="savepeteditform.htm" modelAttribute="pet"  method="post">
            <table border="0">
                <tr>
                    <td colspan="2" align="center"><h2>Edit Pet Profile</h2></td>
                </tr>
                <tr>
                    <td>Pet Id:</td>
                    <td><c:out value="${pet.getPetid()}"/><form:hidden path="petid" /></td>
                </tr>
                <tr>
                    <td>Pet Name:</td>
                    <td><c:out value="${pet.getPetname()}"/><form:hidden path="petname" /></td>
                </tr>
                <tr>
                    <td>About Pet:</td>
                    <td><c:out value="${pet.aboutpet}"/><form:hidden path="aboutpet" /></td>
                </tr>
		<tr>
                    <td>Pet Owner's Email:</td>
                    <td><c:out value="${pet.getOwneremail()}"/><form:hidden path="owneremail" /></td>
                </tr>

                <tr>
                    <td>Pet Breed:</td>
                    <td><c:out value="${pet.getBreed()}"/><form:hidden path="breed"/></td>
                </tr>
                <tr>
                    <td>Medical Status:</td>
                    <td><form:input path="medicalstatus" /></td>
                </tr>
		<tr>
                    <td>Services Availed Till Date:</td>
                    <td><form:input path="servicesavailed" /></td>
                </tr>
		<tr>
                    <td>Upload Photograph1:</td>
                    <td><form:input path="photo1" /></td>
                </tr>
                <tr>
                    <td>Upload Photograph2:</td>
                    <td><form:input path="photo2" /></td>
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

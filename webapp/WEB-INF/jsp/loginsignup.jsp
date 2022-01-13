<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <style>  
        .error {color:red}  
    </style>  
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
        
        <header>
            <h1 style="
                font-weight: 300;
                font-size: 40px;
                letter-spacing: 10px;
                color: var(--dark);">
			Sploot Login Form
		</h1>
           
            
	</header>
       <div class="wrapper">
      
        <div style="margin: auto;
                    width: 50%;
                    padding: 25px 25px 25px 25px;
                    border: 3px solid gray;
                    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;" class="form-inner">
            <div class="title login"></div></br>
            <c:if test="${not empty errorMessge}"><div style="color:red; font-weight: bold; margin: 30px 0px;">${errorMessge}</div></c:if>
            <form:form action="login.htm" modelAttribute="user" method="post">
            Login as:   </br>
            Pet Owner <form:radiobutton checked="checked" path="utype" value="po"/>  
            Business Partner <form:radiobutton path="utype" value="bp"/></br>      
            Email Address: <form:input type="email" path="email" /><br/>
            
            Password: <form:input type="password" path="pass" /><br/>
            
            </br>  

           
            <input type="submit" value="LOGIN USER" />
            </form:form>
        </br></br></br></br>
        <div class="signup-link">Not a member? Sign up now</div></br>
           
            <form:form action="signup.htm" modelAttribute="user" method="post"> 
            Sign up as:   </br>
            Pet Owner <form:radiobutton checked="checked" path="utype" value="po"/>  
            Business Partner <form:radiobutton path="utype" value="bp"/></br> 
            
            Email Address: <form:input type="email" path="email" size="30" /><br/>
           
            
            Password: <form:input type="password" path="pass" /><br/>
           
            
            City: <form:input path="city" /><br/>
           
            
            <input type="submit" value="SAVE USER" />
        </form:form>
  
        </div>
      </div>
    </div>
</body>
</html>
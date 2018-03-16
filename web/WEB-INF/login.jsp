<%-- 
    Document   : index
    Created on : Oct 29, 2017, 11:38:20 AM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="assets/css/override.css" rel="stylesheet" />
        <link rel="stylesheet" href="<c:url value='styles/style.css'/>" />
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <title>Login</title>
        <style>
            body {
                background-color: white;
            }

            #loginbox {
                margin-top: 5px;
            }

            #loginbox > div:first-child {        
                padding-bottom: 10px;    
            }

            .iconmelon {
                display: block;
                margin: auto;
            }

            #form > div {
                margin-bottom: 25px;
            }

            #form > div:last-child {
                margin-top: 10px;
                margin-bottom: 10px;
            }

            .panel {    
                background-color: ffffff;
            }

            .panel-body {
                padding-top: 30px;
                background-color: rgba(2555,255,255,.3);
            }
            .iconmelon,
            .im {
                position: relative;
                width: 150px;
                height: 150px;
                display: block;
                fill: #525151;
            }

            .iconmelon:after,
            .im:after {
                content: '';
                position: absolute;
                top: 0;
                left: 0;
                width: 100%;
                height: 100%;
            }
        </style>

    </head>
    <body>
            
            <image src ="assets/img/logoLogin.png" class="logoLogin">
 
        <div class="container">    

            <div id="loginbox" class="mainbox col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3"> 


                <div class="panel panel-default" >
                       

                    <div class="panel-body" >

                        <form action="login" name="form" id="form" class="form-horizontal" method="POST">

                            <div class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                <input id="empId" type="text" class="form-control" name="empId" value="${empId}" placeholder="Employee ID" required="required">                                        
                            </div>

                            <div class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                                <input id="password" type="password" class="form-control" name="password" value="${password}" placeholder="Password" required="required">
                            </div>                                                                  

                            <div class="form-group">
                                <!-- Button -->
                                <div class="col-sm-12 controls">
                                    <button type="submit" class="btn btn-primary pull-right"><i class="glyphicon glyphicon-log-in"></i> Log in</button>                          
                                </div><br><br>

                                <div class="col-sm-12 controls">
                                    <a href="reset" class="pull-right need-help">Forgot my password</a><span class="clearfix"></span>
                                    ${errorMsg}
                                    ${message}
                                </div>

                            </div>

                        </form>     

                    </div>                     
                </div>  
            </div>
        </div>
    </body>
</html>
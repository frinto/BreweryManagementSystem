<%-- 
    Document   : reset
    Created on : Nov 28, 2017, 9:34:51 AM
    Author     : 727525
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reset Password</title>
    </head>
    <body>
        <h1>Reset Password</h1>
        Please enter your email address to reset your password.<br>
        <form action="reset" method="post">
            Email Address: <input type="text" name="email"><br>
            <input type="hidden" name="action" value="email">
            <input type="submit" value="Reset">
        </form>
        <br>${message}
    </body>
</html>

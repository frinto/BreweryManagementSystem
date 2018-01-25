<%-- 
    Document   : resetNewPassword
    Created on : Nov 29, 2017, 1:53:22 PM
    Author     : 727525
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Enter New Password</title>
    </head>
    <body>
        <h1>Enter New Password</h1>
        <form action="reset" method="post">
            New Password: <input type="text" name="password"><br>
            <input type="hidden" name="action" value="reset">
            <input type="hidden" name="uuid" value=${uuid}>
            <input type="submit" value="reset">
        </form>
    </body>
</html>

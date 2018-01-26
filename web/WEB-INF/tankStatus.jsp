<%-- 
    Document   : tankStatus
    Created on : Jan 26, 2018, 1:35:05 PM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tank Status</title>
    </head>
    <body>
        <h1>Tank Status</h1>
        <h2>SV Tanks</h2>
        <table>
            <tr>
                <th>SV ID</th>
                <th>Volume</th>
                <th>Status</th>
            </tr>
            <c:forEach var="sv" items="${svs}">
                <tr>
                    <td>${sv.svId}</td>
                    <td>${sv.volume}</td>
                    <td>${sv.status}</td>
                </tr>
            </c:forEach>
        </table>
        <h2>FV Tanks</h2>
        <table>
            <tr>
                <th>FV ID</th>
                <th>Volume</th>
                <th>Status</th>
            </tr>
            <c:forEach var="fv" items="${fvs}">
                <tr>
                    <td>${fv.fvId}</td>
                    <td>${fv.volume}</td>
                    <td>${fv.status}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>

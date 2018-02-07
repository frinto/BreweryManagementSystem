
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <title>BMS</title> 
        <c:import url="/WEB-INF/includes/sidebar.html"/>
    <h1>Production</h1>
    <table>
        <tr>
            <th>Date</th>
            <th>ProductionType</th>
            <th>Quantity</th>
            <th>SVNumber</th>
            <th>EmployeeID</th>
        </tr>
        <c:forEach var="production" items="${prod}">
            <tr>
                <td>${production.date}</td>
                <td>${production.productionType}</td>
                <td>${production.quantity}</td>
                <td>${production.svNum}</td>
                <td>${production.employeeId}</td>
            </tr>
        </c:forEach>
        <td>
            <form action="production?action=submit" method="POST">
                <button type="submit">Submit</button>
            </form>
        </td>
    </table>
    </body>
    <c:import url="includes/footer.html"/>
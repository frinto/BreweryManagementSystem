
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <title>BMS</title> 
        <c:import url="/WEB-INF/includes/sidebar.html"/>
    <h1>Production</h1>
    <c:choose>
        <c:when test="${action == 'add'}">
            <form action="production?action=newProduction" method="POST">
                <table>
                <tr>
                    <th>Date</th>
                    <th>ProductionType</th>
                    <th>Quantity</th>
                    <th>SVNumber</th>
                    <th>EmployeeID</th>
                </tr>
                <tr>
                    <td>
                        <input type="date" name="date">
                    </td>
                    <td>
                        <input type="text" name="productionType">
                    </td>
                    <td>
                        <input type="text" name="quantity">
                    </td>
                    <td>
                        <input type="text" name="svNumber">
                    </td>
                    <td>
                        <input type="text" name="employeeId">
                    </td>
                </tr>
                </table>
                <button type="submit">Submit</button>
            </form>
        </c:when>
        <c:otherwise>
            <form action="production?action=add" method="POST">
                <button type="submit">Add Production</button>
            </form>
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
            </table>
        </c:otherwise>
    </c:choose>
</body>
<c:import url="includes/footer.html"/>
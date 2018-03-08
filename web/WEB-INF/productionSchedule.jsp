<%-- 
    Document   : productionSchedule
    Created on : Mar 8, 2018, 2:02:30 PM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Production Schedule</title>
    </head>
    <body>
        <form action="productionSchedule?action=submit" method="post" class="productionScheduleSubmitButton">
            <table class="table">
                <thead class="thead-dark">
                    <tr>
                        <th>Date</th>
                        <th>Brew</th>
                    </tr>
                </thead>
<!--                <c:forEach var="productName" items="${finishedProducts}">
                    <tr>
                        <td>${productName.productName}</td>
                        <td>${productName.qty}</td>
                        <td>
                            <input type="number" name="${productName.productName}" value="${productName.qty}">
                        </td>
                    </tr>
                </c:forEach>-->
            </table>

            <button type="submit" class="btn btn-success">Update Inventory</button>
        </form>
    </body>
</html>

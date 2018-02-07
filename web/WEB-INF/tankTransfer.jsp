
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <title>BMS</title> 
        <c:import url="/WEB-INF/includes/sidebar.html"/>
        
        <h1>FV to SV Tank Transfer</h1>
        
        <div>
            <form action="tankTransfer?action=add" method="POST">
                <button type="submit">Add a Transfer</button>
            </form>
        </div>
        
        <div>
            <table>
                <tr>
                    <th>Date</th>
                    <th>Brand</th>
                    <th>FV</th>
                    <th>SV</th>
                    <th>Volume</th>
                    <th>Correction</th>
                </tr>
                <c:forEach var="transfer" items="${transfers}">
                    <tr>
                        <td>${transfer.date}</td>
                        <td>brand</td>
                        <td>${transfer.fromFv}</td>
                        <td>${transfer.toSv}</td>
                        <td>${transfer.volume}</td>
                        <td>correction</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        ${message}
    </body>
    <c:import url="includes/footer.html"/>

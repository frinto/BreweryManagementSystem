<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <title>BMS</title>
        <c:import url="includes/sidebar.jsp"/>
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
        ${message}

            </div>
        </div>
    </body>
    <c:import url="includes/footer.html"/>
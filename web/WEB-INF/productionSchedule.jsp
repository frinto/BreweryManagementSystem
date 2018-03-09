<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                    <tr><th>Date</th>
                        <th>brew</th>
                        <th>fv</th>
                        <th>yst</th>
                        <th>transfer</th>
                        <th>fuge</th>
                        <th>clean</th>
                        <th>keg</th>
                        <th>bottle</th>
                        <th>can</th>
                    </tr>
                </thead>


                <tr>
                    <td>Monday</td>
                    <c:forEach var="var" items="${productionSchedules}">
                        <c:if test="${var.getDayOfWeek() =='monday'}">
                            <td>
                                ${var.brew}
                            </td>
                            <td>
                                ${var.fv}
                            </td>
                            <td>
                                ${var.yst}
                            </td>
                            <td>
                                ${var.transfer}
                            </td>
                            <td>
                                ${var.fuge}
                            </td>
                            <td>
                                ${var.clean}
                            </td>
                            <td>
                                ${var.keg}
                            </td>
                            <td>
                                ${var.bottle}
                            </td>
                            <td>
                                ${var.can}
                            </td>
                        </c:if>
                    </c:forEach>
                </tr>
                <tr>
                    <td>Tuesday</td>
                    <c:forEach var="var" items="${productionSchedules}">
                        <c:if test="${var.getDayOfWeek() =='tuesday'}">
                            <td>
                                ${var.brew}
                            </td>
                            <td>
                                ${var.fv}
                            </td>
                            <td>
                                ${var.yst}
                            </td>
                            <td>
                                ${var.transfer}
                            </td>
                            <td>
                                ${var.fuge}
                            </td>
                            <td>
                                ${var.clean}
                            </td>
                            <td>
                                ${var.keg}
                            </td>
                            <td>
                                ${var.bottle}
                            </td>
                            <td>
                                ${var.can}
                            </td>
                        </c:if>
                    </c:forEach>
                </tr>
                <tr>
                    <td>Wednesday</td>
                    <c:forEach var="var" items="${productionSchedules}">
                        <c:if test="${var.getDayOfWeek() =='wednesday'}">
                            <td>
                                ${var.brew}
                            </td>
                            <td>
                                ${var.fv}
                            </td>
                            <td>
                                ${var.yst}
                            </td>
                            <td>
                                ${var.transfer}
                            </td>
                            <td>
                                ${var.fuge}
                            </td>
                            <td>
                                ${var.clean}
                            </td>
                            <td>
                                ${var.keg}
                            </td>
                            <td>
                                ${var.bottle}
                            </td>
                            <td>
                                ${var.can}
                            </td>
                        </c:if>
                    </c:forEach>
                </tr>
                <tr>
                    <td>Thursday</td>
                    <c:forEach var="var" items="${productionSchedules}">
                        <c:if test="${var.getDayOfWeek() =='thursday'}">
                            <td>
                                ${var.brew}
                            </td>
                            <td>
                                ${var.fv}
                            </td>
                            <td>
                                ${var.yst}
                            </td>
                            <td>
                                ${var.transfer}
                            </td>
                            <td>
                                ${var.fuge}
                            </td>
                            <td>
                                ${var.clean}
                            </td>
                            <td>
                                ${var.keg}
                            </td>
                            <td>
                                ${var.bottle}
                            </td>
                            <td>
                                ${var.can}
                            </td>
                        </c:if>
                    </c:forEach>
                </tr>
                <tr>
                    <td>Friday</td>
                    <c:forEach var="var" items="${productionSchedules}">
                        <c:if test="${var.getDayOfWeek() =='friday'}">
                            <td>
                                ${var.brew}
                            </td>
                            <td>
                                ${var.fv}
                            </td>
                            <td>
                                ${var.yst}
                            </td>
                            <td>
                                ${var.transfer}
                            </td>
                            <td>
                                ${var.fuge}
                            </td>
                            <td>
                                ${var.clean}
                            </td>
                            <td>
                                ${var.keg}
                            </td>
                            <td>
                                ${var.bottle}
                            </td>
                            <td>
                                ${var.can}
                            </td>
                        </c:if>
                    </c:forEach>
                </tr>



            </table>

            <button type="submit" class="btn btn-success">submit</button>
        </form>
    </body>
</html>

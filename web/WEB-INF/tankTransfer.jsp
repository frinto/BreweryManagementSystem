
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <title>BMS</title> 
        <c:import url="/WEB-INF/includes/sidebar.html"/>
    
        <!-- start main panel and top header text-->    
    <div class="main-panel">
                <!-- Navbar -->
                <nav class="navbar navbar-expand-lg " color-on-scroll="500">
                    <div class=" container-fluid  ">
                        <a class="navbar-brand" href="#pablo">FV to SV Tank Transfer</a>
                        <button href="" class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" aria-controls="navigation-index" aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-bar burger-lines"></span>
                            <span class="navbar-toggler-bar burger-lines"></span>
                            <span class="navbar-toggler-bar burger-lines"></span>
                        </button>
                    </div>
                </nav>
                
    <!-- start page functionality -->
    <div>
        <form action="tankTransfer?action=add" method="POST">
            <button type="submit">Add a Transfer</button>
        </form>
    </div>

    <div>
        <table class="table">
            <thead class="thead-dark">
                <tr>
                    <th>Date</th>
                    <th>Brand</th>
                    <th>FV</th>
                    <th>SV</th>
                    <th>Volume</th>
                    <th>Correction</th>
                </tr>
            </thead>
            </tbody>
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
    </table>
</div>

${message}
</div>
</div>
</body>
<c:import url="includes/footer.html"/>

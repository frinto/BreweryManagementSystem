
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <title>BMS</title> 
        <link rel="apple-touch-icon" sizes="76x76" href="../assets/img/apple-icon.png">
        <link rel="icon" type="image/png" href="../assets/img/favicon.ico">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' />

        <!--     Fonts and icons     -->
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700,200" rel="stylesheet" />
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" />

        <!-- CSS Files -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link href="assets/css/bootstrap.css" rel="stylesheet" />
        <link href="assets/css/light-bootstrap-dashboard.css?v=2.0.1" rel="stylesheet" />
        <link href="assets/css/override.css" rel="stylesheet" />
    </head>

    <body>
        <div class="wrapper">

            <!--Nav bar----------------------------------------------------------------------------->
            <div class="sidebar" data-image="../assets/img/sidebar-5.jpg">
                <div class="sidebar-wrapper">
                    <div class="logo">
                        <image src ="assets/img/logo.png">
                    </div>
                    <ul class="nav">
                        <li>
                            <a class="nav-link" href="tankFarm">
                                <i class ="navIcon" icon="assets/img/farm.png"></i>
                                <img src="assets/img/farm.png" class="" alt="Norway">
                                <p style ="padding-left:5px">Tank Farm</p>
                            </a>
                        </li>
                        <li class="nav-item active">
                            <a class="nav-link" href="production">
                                <img src="assets/img/barrel.png" class="" alt="Norway">
                                <p style ="padding-left:5px">Production</p>
                            </a>
                        </li>
                        <li>
                            <a class="nav-link" href="brew">
                                <img src="assets/img/brew.png" class="" alt="Norway">
                                <p style ="padding-left:5px">Brew</p>
                            </a>
                        </li>
                        <li>
                            <a class="nav-link" href="finishedInventory">
                                <img src="assets/img/finished.png" class="" alt="Norway">
                                <p>Finished Inventory</p>
                            </a>
                        </li>
                        <li>
                            <a class="nav-link" href="rawInventory">
                                <img src="assets/img/raw.png" class="" alt="Norway">
                                <p>Raw Inventory</p>
                            </a>
                        </li>
                        <li>
                            <a class="nav-link" href="recipe">
                                <img src="assets/img/recipe.png" class="" alt="Norway">
                                <p>Recipes</p>
                            </a>
                        </li>
                        <li>
                            <a class="nav-link" href="delivery">
                                <img src="assets/img/delivery.png" class="" alt="Norway">
                                <p>Delivery</p>
                            </a>
                        </li>
                        <li>
                            <a class="nav-link" href="reports">
                                <img src="assets/img/report.png" class="" alt="Norway">
                                <p>Reports</p>
                            </a>
                        </li>
                        <li>
                            <a class="nav-link" href="productionSchedule">
                                <img src="assets/img/report.png" class="" alt="Norway">
                                <p>Production Schedule</p>
                            </a>
                        </li>
                        <c:if test="${currentEmployee.roleId == 1}">
                            <li>
                                <a class="nav-link" href="manageEmployee">
                                    <img src="assets/img/report.png" class="" alt="Norway">
                                    <p>Manage Employees</p>
                                </a>
                            </li>
                        </c:if>
                    </ul>
                </div>
            </div>
            <div class="main-panel">
                <!-- Navbar -->
                <nav class="navbar navbar-expand-lg " color-on-scroll="500">
                    <div class=" container-fluid  ">
                        <a class="navbar-brand">Production</a>
                        <div class="btn-group">
                            <button type="button" class="btn btn-secondary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                ${employee.firstName} ${employee.lastName}
                            </button>
                            <div class="dropdown-menu dropdown-menu-right">
                                <button class="dropdown-item" type="button" onclick="window.location.href = 'login?logout'">Logout</button>
                            </div>
                        </div>
                        <button href="" class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" aria-controls="navigation-index" aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-bar burger-lines"></span>
                            <span class="navbar-toggler-bar burger-lines"></span>
                            <span class="navbar-toggler-bar burger-lines"></span>
                        </button>
                    </div>
                </nav>

                <!--End nav bar-------------------------------------------------------------------------->
                <ul class="nav nav-tabs" id="myTab" role="tablist">
                    <li class="nav-item">
                        <a class="nav-link active" id="home-tab" data-toggle="tab" href="#production" role="tab" aria-controls="home" aria-selected="true">Production</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" id="profile-tab" data-toggle="tab" href="#newProduction" role="tab" aria-controls="profile" aria-selected="false">New Production Type</a>
                    </li>
                </ul>
                <div class="tab-content" id="myTabContent">
                    <!-- brew materials tab-->  
                    <div class="tab-pane fade show active" id="production" role="tabpanel" aria-labelledby="home-tab">

                        <c:choose>
                            <c:when test="${action == 'add'}">
                                <form action="production?action=nextProduction" method="POST">
                                    <table class="table">
                                        <thead class="thead-dark">
                                        <th>ProductionType</th>
                                        <th>Quantity</th>
                                        <th>SVNumber</th>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td>
                                                    <select name="productionType" required="true">
                                                        <c:forEach var="finishedProduct" items="${finishedProd}">
                                                            <option value="${finishedProduct.productName}">${finishedProduct.productName}</option>
                                                        </c:forEach>
                                                    </select>
                                                </td>
                                                <td>
                                                    <input type="number" name="quantity" required="true">
                                                </td>
                                                <td>
                                                    <select name="svNumber" required="true">
                                                        <c:forEach var="storageVessel" items="${sv}">
                                                            <option value="${storageVessel.svId}">${storageVessel.svId}</option>
                                                        </c:forEach>
                                                    </select>
                                                </td>
                                            </tr>
                                        </tbody>
                                    </table>
                                    <button type="submit" class="btn btn-success">Next</button>
                                </form>
                            </c:when>
                            <c:when test="${action == 'nextProduction'}">
                                <form action="production?action=submitProduction" method="POST">
                                    <table class="table">
                                        <thead class="thead-dark">
                                        <th>ProductionType</th>
                                        <th>Quantity</th>
                                        <th>SVNumber</th>
                                        <th>Expected Sv Volume</th>
                                        <th>Finished Sv Volume</th>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td>
                                                    <input type="hidden" name="productionType" value="${productionType}">
                                                    ${productionType}
                                                </td>
                                                <td>
                                                    <input type="hidden" name="quantity" value="${quantity}">
                                                    ${quantity}
                                                </td>
                                                <td>
                                                    <input type="hidden" name="svNumber" value="${svNumber}">
                                                    ${svNumber}
                                                </td>
                                                <td>
                                                    <input type="hidden" name="expectedSvVolume" value="${expectedSvVolume}">
                                                    ${expectedSvVolume}
                                                </td>
                                                <td>
                                                    <input type="number" name="finishedSvVolume" required="true">
                                                </td>
                                            </tr>
                                        </tbody>
                                    </table>
                                    <button type="submit" class="btn btn-success">Submit</button>
                                </form>
                            </c:when>
                            <c:otherwise>
                                <div class="text-center">
                                    <form class ="" action="production" method="GET">
                                        <h4>View Productions by Date:</h4>
                                        <input type="date" name="productionDate" id="datePicker">
                                        <button type="submit" class="btn btn-outline-primary">Select Date</button>
                                    </form>
                                    <form action="production?action=add" method="POST">
                                        <button type="submit" class="btn btn-success productionButton">Add Production</button>
                                    </form>
                                </div>

                                <table class="table">
                                    <thead class="thead-dark">
                                    <th>Date</th>
                                    <th>ProductionType</th>
                                    <th>Quantity</th>
                                    <th>SVNumber</th>
                                    <th>Employee</th>
                                    <th>Finished Sv Volume</th>
                                    <th>Gain/Loss +-</th>
                                    <th></th>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="production" items="${prod}">
                                            <c:if test="${productionDate.equals(production.date)}">
                                                <tr>
                                                    <td><fmt:formatDate value="${production.date}" pattern="MMM-dd-yyy" /></td>
                                                    <td>${production.productionType}</td>
                                                    <td>${production.quantity}</td>
                                                    <td>${production.svNum}</td>
                                                    <td>
                                                        <c:forEach var="employee" items="${employees}">
                                                            <c:if test="${employee.empId.equals(production.employeeId)}">
                                                                ${employee.firstName} ${employee.lastName}
                                                            </c:if>   
                                                        </c:forEach>  
                                                    </td>
                                                    <td>${production.finishedSvVolume}</td>
                                                    <td>${production.gainLoss}</td>
                                            <form action="production?action=delete" method="POST">
                                                <input type="hidden" name="delete" value="${production.prodId}">
                                                <td><button type="submit">Delete</td>
                                            </form>     
                                            </tr>
                                        </c:if>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </c:otherwise>
                        </c:choose>
                    </div>
                    <!--This is in a new tab for production -->

                    <div class="tab-pane fade" id="newProduction" role="tabpanel" aria-labelledby="newProduction-tab">

                        <!--This is a form to create a new production type-->
                        <form action="production?action=newProductionType" id="newProductionTypeForm" method="POST">
                            <table border="1" class="table" id="newTypeTable">
                                <thead>
                                    <tr class="thead-dark">
                                        <th> </th>
                                        <th> </th>
                                    </tr>
                                </thead>
                                <tr>
                                    <th>
                                        Production Name
                                    </th>
                                    <th>
                                        <input style="width:100%" type="text" autofocus="on" name="name" id="name" value="${newProduction}" placeholder="Product name">
                                    </th>
                                </tr>
                                <tr>
                                    <td>
                                        <select name="usage" id="usage">
                                            <option value="none">
                                                NONE
                                            </option>
                                            <c:forEach var="productionMaterialUsage" items="${productionMaterialUsages}">
                                                <option value="${productionMaterialUsage.name}">
                                                    ${productionMaterialUsage.name}
                                                </option>
                                            </c:forEach>
                                        </select>
                                    </td>
                                    <td>
                                        <input style="width:100%" type="number" min="0"  name="qty" id="qty" value="${qty}" placeholder="quantity">
                                    </td>
                                </tr>
                            </table>
                            <table>
                                <input type="button" onclick="addARow()" value="Add a Row">
                                <input type="button" onclick="removeARow()" value="Remove a Row">
                                <input type="submit" value="submit">
                            </table>
                        </form>
                    </div>
                </div>
                <!---------------------------------------------Success Modal-------------------------------------------------->
                <c:if test="${success!=null}">

                    <div id="myModal" class="modal fade">

                        <div class="modal-dialog modal-confirm">
                            <div class="modal-content">
                                <div class="modal-header">

                                    <div style="font-size:5em;">
                                        <i class="far fa-check-circle"></i>
                                    </div>

                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                </div>
                                <div class="modal-body text-center">
                                    <h4>Great!</h4>	
                                    <p>Production submitted successfully.</p>
                                    <input type ="button" class="btn btn-success"data-dismiss="modal" value="OK"></button>
                                </div>
                            </div>
                        </div>
                    </div>

                </c:if>

                <!-------------------------------------------------End Success Modal------------------------------------------->

                <c:if test="${errorMessage!=null}">

                    <div id="myModal" class="modal fade">

                        <div class="modal-dialog modal-confirm">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <!--                                <div class="icon-box">
                                                                        <i class="far fa-check-circle"></i>
                                                                    </div>-->
                                    <div style="font-size:5em; color:red">
                                        <i class="fas fa-times-circle"></i>
                                    </div>

                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                </div>
                                <div class="modal-body text-center">

                                    <h4>Uh oh!</h4>	
                                    <p>${errorMessage}</p>
                                    <input type ="button" class="btn btn-success" data-dismiss="modal" value="OK"></button>

                                </div>
                            </div>
                        </div>
                    </div>

                </c:if>
                </body>
                <!--   Core JS Files   -->
                <script src="assets/js/core/jquery.3.2.1.min.js" type="text/javascript"></script>
                <script src="assets/js/core/popper.min.js" type="text/javascript"></script>
                <script src="assets/js/core/bootstrap.min.js" type="text/javascript"></script>
                <!--  Plugin for Switches, full documentation here: http://www.jque.re/plugins/version3/bootstrap.switch/ -->
                <script src="assets/js/plugins/bootstrap-switch.js"></script>
                <!--  Google Maps Plugin    -->
                <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY_HERE"></script>
                <!--  Chartist Plugin  -->
                <script src="assets/js/plugins/chartist.min.js"></script>
                <!--  Notifications Plugin    -->
                <script src="assets/js/plugins/bootstrap-notify.js"></script>
                <!-- Control Center for Light Bootstrap Dashboard: scripts for the example pages etc -->
                <script src="assets/js/light-bootstrap-dashboard.js?v=2.0.1" type="text/javascript"></script>
                <!-- Light Bootstrap Dashboard DEMO methods, don't include it in your project! -->
                <script src="assets/js/production.js"></script>
                <!--                                                function addARow()
                                                                {
                                                                    //grab the location that we are going to add the input box to
                                                                    var form = document.getElementById("newProductionTypeForm");
                                                                    var table = form.getElementsByTagName("table") [0];
                
                                                                    //generate the elements we are adding
                                                                    var tr = document.createElement("tr");
                
                                                                    //generate our select box
                                                                    var td1 = document.createElement("td");
                                                                    //this will be used in for our quantity box
                                                                    var td2 = document.createElement("td");
                                                                    var usage = document.getElementById("usage");
                                                                    var duplicateO = usage.cloneNode(true);
                                                                    var duplicate = duplicateO;
                                                                    //usage.setAttribute("value","NONE");
                
                                                                    //add to our tr
                                                                    td1.appendChild(duplicate);
                                                                    tr.appendChild(td1);
                
                                                                    //generate our quantity box this uses the previously created td2
                                                                    var qty = document.createElement("input");
                                                                    qty.setAttribute("type", "number");
                                                                    qty.setAttribute("min", "0");
                                                                    //                                        qty.setAttribute("value", "0");
                                                                    qty.setAttribute("name", "qty");
                                                                    qty.setAttribute("id", "qty");
                                                                    qty.setAttribute("placeholder", "quantity");
                                                                    qty.setAttribute("style", "width:100%");
                
                                                                    //add to our tr
                                                                    td2.appendChild(qty);
                                                                    tr.appendChild(td2);
                                                                    //add to page
                                                                    table.appendChild(tr);
                                                                }
                -->
                </html>


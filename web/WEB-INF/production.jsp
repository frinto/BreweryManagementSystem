
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

            <div class="sidebar" data-image="../assets/img/sidebar-5.jpg" data-color="red">

                <div class="sidebar-wrapper">
                    <div class="logo">

                        <image src ="assets/img/logo.jpg">

                    </div>
                    <ul class="nav">
                        <li>
                            <a class="nav-link" href="tankFarm">
                                <img src="assets/img/tank.png" class="tankfarmIcon" alt="Norway">
                                <p style ="padding-left:5px">Tank Farm</p>
                            </a>
                        </li>
                        <li class="nav-item active">
                            <a class="nav-link" href="production">
                                <img src="assets/img/barrel.png" class="barrelIcon" alt="Norway">
                                <p style ="padding-left:5px">Production</p>
                            </a>
                        </li>
                        <li>
                            <a class="nav-link" href="brew">
                                <i class="nc-icon nc-notes"></i>
                                <p>Brew</p>
                            </a>
                        </li>
                        <li>
                            <a class="nav-link" href="finishedInventory">
                                <i class="nc-icon nc-paper-2"></i>
                                <p>Finished Inventory</p>
                            </a>
                        </li>
                        <li>
                            <a class="nav-link" href="rawInventory">
                                <i class="nc-icon nc-atom"></i>
                                <p>Raw Inventory</p>
                            </a>
                        </li>
                        <li>
                            <a class="nav-link" href="production">
                                <i class="nc-icon nc-pin-3"></i>
                                <p>Recipes</p>
                            </a>
                        </li>
                        <li>
                            <a class="nav-link" href="delivery">
                                <i class="nc-icon nc-bell-55"></i>
                                <p>Delivery</p>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="main-panel">
                <!-- Navbar -->
                <nav class="navbar navbar-expand-lg " color-on-scroll="500">
                    <div class=" container-fluid  ">
                        <a class="navbar-brand" href="#pablo"> Production </a>
                        <li><a href="login?logout">Log Out</a></li>
                        <button href="" class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" aria-controls="navigation-index" aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-bar burger-lines"></span>
                            <span class="navbar-toggler-bar burger-lines"></span>
                            <span class="navbar-toggler-bar burger-lines"></span>
                        </button>
                    </div>
                </nav>

                <!--End nav bar-------------------------------------------------------------------------->

                <h1>Production</h1>
                <c:choose>
                    <c:when test="${action == 'add'}">
                        <form action="production?action=finalProduction" method="POST">
                            <table class="table">
                                <thead class="thead-dark">
                                <th>ProductionType</th>
                                <th>Quantity</th>
                                <th>SVNumber</th>
                                <!--                                <th>Starting Sv Volume</th>
                                                                <th>Finished Sv Volume</th>-->
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>
                                            <select name="productionType">
                                                <c:forEach var="finishedProduct" items="${finishedProd}">
                                                    <option value="${finishedProduct.productName}">${finishedProduct.productName}</option>
                                                </c:forEach>
                                            </select>
                                        </td>
                                        <td>
                                            <input type="number" name="quantity">
                                        </td>
                                        <td>
                                            <select name="svNumber">
                                                <c:forEach var="storageVessel" items="${sv}">
                                                    <option value="${storageVessel.svId}">${storageVessel.svId}</option>
                                                </c:forEach>
                                            </select>
                                    </tr>
                                </tbody>
                            </table>
                            <button type="submit" class="btn btn-success">Next</button>
                        </form>
                    </c:when>
                    <c:when test="${action == 'finalProduction'}">
                        <form action="production?action=newProduction" method="POST">
                            <table class="table">
                                <thead class="thead-dark">
                                <th>ProductionType</th>
                                <th>Quantity</th>
                                <th>SVNumber</th>
                                <th>Starting Sv Volume</th>
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
                                            ${svVolume}
                                        </td>
                                        <td>
                                            <input type="number" name="finishedSvVolume">
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                            <button type="submit" class="btn btn-success">Submit</button>
                        </form>
                    </c:when>
                    <c:otherwise>
                        <form class ="datepicker" action="production" method="GET">
                            <h4>View Productions by Date:</h4>
                            <input type="date" name="productionDate" id="datePicker">
                            <button type="submit" class="btn btn-outline-primary">Select Date</button>
                        </form>
                        <form action="production?action=add" method="POST" class="productionButton">
                            <button type="submit" class="btn btn-success">Add Production</button>
                        </form>
                        <p class="productionMessage">${message}</p>
                        <form action="production?action=update" method="POST" class="productionButton">
                            <table class="table">
                                <thead class="thead-dark">
                                <th>Date</th>
                                <th>ProductionType</th>
                                <th>Quantity</th>
                                <th>SVNumber</th>
                                <th>EmployeeID</th>
                                <th>Finished Sv Volume</th>
                                <th>Gain/Loss +-</th>
                                </thead>
                                <tbody>
                                    <c:forEach var="production" items="${prod}">
                                            <tr>
                                                <td><fmt:formatDate value="${production.date}" pattern="MMM-dd-yyy" /></td>
                                                <td>${production.productionType}</td>
                                                <td>${production.quantity}</td>
                                                <td>${production.svNum}</td>
                                                <td>${production.employeeId}</td>                                           
                                                <td>${finishSvVol}</td>
                                                <td>${gainLoss}</td>
                                            </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                            <button type="submit" class="btn btn-success">Update</button>
                        </form>
                    </c:otherwise>
                </c:choose>
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
                <script type="text/javascript">
                    $(document).ready(function () {
                        // Javascript method's body can be found in assets/js/demos.js

                    });
                </script>

                </html>


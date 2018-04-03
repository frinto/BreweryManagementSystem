
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
                        <li>
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
                        <li class="nav-item active">
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
                        <a class="navbar-brand"></a>
                        <div class="btn-group">
                            <button type="button" class="btn btn-secondary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Matthew
                            </button>
                            <div class="dropdown-menu dropdown-menu-right">
                                <button class="dropdown-item" type="button" onclick="window.location.href='login?logout'">Logout</button>
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


                <!--                <p class="copyright text-center">
                                    ©
                                    <script>
                                        document.write(new Date().getFullYear())
                                    </script>
                                    <a href="http://www.creative-tim.com">Creative Tim</a>, made with love for a better web
                                </p>-->

                <div class = "brews">

                    <form class ="datepicker" action="delivery" method="GET">
                        <h4>View Deliveries by Date:</h4>
                        <input type="date" name="deliveryDate" id="datePicker" value="${dateToday}">
                        <button type="submit" class="btn btn-outline-primary">Select Date</button>
                    </form>
                    <div class="text-center">
                        <button type="button" class="btn btn-success" data-toggle="modal" data-target="#myModal">Add A Delivery</button>
                    </div>

                    <!-- Modal -->
                    <div id="myModal" class="modal fade" role="dialog">
                        <div class="modal-dialog" style="max-width:1000px">
                            <!-- Modal content-->
                            <div class="modal-content" style="position:fixed; width:100%">
                                <div class="modal-header" >
                                    <h4 class="modal-title" style="text-align:center;width:100%">Add A Delivery</h4>
                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                </div>
                                <div class="modal-body" style="height: 500px">
                                    <form action="delivery?action=add" method="POST">
                                        <table>
                                            <tr>
                                                <th style="width:25%">
                                                    <h4>Company Name</h4></th>
                                                <th style="width:25%">
                                                    <select style="height:100%; width: 100%" name="companyName">
                                                        <c:forEach var="account" items="${accounts}">
                                                            <option  value="${account.companyName}">${account.companyName}</option>
                                                        </c:forEach>
                                                    </select>
                                                </th>
                                                <!--</tr>-->
                                                <!--<tr>-->
                                                <th style="width:25%"><h4>Date</h4></th>
                                                <th style="width:25%"><input type="date" name="date" id="date" value="${dateToday}"></th>
                                            </tr>
                                        </table>
                                        <table class="table">
                                            <thead class="thead-dark">
                                                <tr>
                                                    <th>Item Name</th>
                                                    <th>Quantity</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach var="finishedProduct" items="${finishedProducts}">
                                                    <tr>

                                                        <td><input style="width:100%" name="productName" readonly type="hidden" value="${finishedProduct.productName}">${finishedProduct.productName}</td>
                                                        <td><input style="width:100%" min="0" type="number" name="qty" id="qty" value="${qty}" width="99%"></td>

                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                        <table><th><td><input name="submit" type="submit"</td></th></table>
                                    </form>
                                </div>
                                <div class="modal-footer">
                                </div>
                            </div>

                        </div>
                    </div>

                    <!--This is a list of all the delivery objects in the future they will become a hrefs with links to the delivery page specific to that delivery-->
                    <table class="table">
                        <thead class="thead-dark">
                            <tr>
                                <th scope="col">Company Name</th>
                                <th scope="col">Date</th>
                                <th scope="col">Employee ID</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="delivery" items="${deliverys}">
                                <c:if test="${deliveryDate.equals(delivery.date)}">
                                    <tr>
                                        <td> <a href="viewDelivery?deliveryId=${delivery.deliveryId}" style="text-decoration: underline;"> ${delivery.companyName} </a></td>
                                        <td> <a href="viewDelivery?deliveryId=${delivery.deliveryId}" style="text-decoration: underline;"> <fmt:formatDate value="${delivery.date}" pattern="MMM-dd-yyy" /></a></td>
                                        <td> <a href="viewDelivery?deliveryId=${delivery.deliveryId}" style="text-decoration: underline;"> ${delivery.empId}</a></td>
                                    </tr>
                                </c:if>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
    <c:import url="includes/footer.html"/>
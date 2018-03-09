
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                        <image src ="assets/img/logo4.png">

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
                        <li class="nav-item active">
                            <a class="nav-link" href="productionSchedule">
                                <img src="assets/img/report.png" class="" alt="Norway">
                                <p>Production Schedule</p>
                            </a>
                        </li>
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


                <h1>Production Schedule</h1>
                <form action="productionSchedule?action=update" id="pForm" method="post" class="finishedInventoryUpdateButton">
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
                                        <textarea rows="4" cols="10" name="brewMon" form="pForm">${var.brew}</textarea>
                                    </td>
                                    <td>
                                        <textarea rows="4" cols="10" name="fvMon" form="pForm">${var.fv}</textarea>
                                    </td>
                                    <td>
                                        <textarea rows="4" cols="10" name="ystMon" form="pForm">${var.yst}</textarea>
                                    </td>
                                    <td>
                                        <textarea rows="4" cols="10" name="transferMon" form="pForm">${var.transfer}</textarea>
                                    </td>
                                    <td>
                                        <textarea rows="4" cols="10" name="fugeMon" form="pForm">${var.fuge}</textarea>
                                    </td>
                                    <td>
                                        <textarea rows="4" cols="10" name="cleanMon" form="pForm">${var.clean}</textarea>
                                    </td>
                                    <td>
                                        <textarea rows="4" cols="10" name="kegMon" form="pForm">${var.keg}</textarea>
                                    </td>
                                    <td>
                                        <textarea rows="4" cols="10" name="bottleMon" form="pForm">${var.bottle}</textarea>
                                    </td>
                                    <td>
                                        <textarea rows="4" cols="10" name="canMon" form="pForm">${var.can}</textarea>
                                    </td>
                                </c:if>
                            </c:forEach>
                        </tr>
                        <tr>
                            <td>Tuesday</td>
                            <c:forEach var="var" items="${productionSchedules}">
                                <c:if test="${var.getDayOfWeek() =='tuesday'}">
                                    <td>
                                        <textarea rows="4" cols="10" name="brewTues" form="pForm">${var.brew}</textarea>
                                    </td>
                                    <td>
                                        <textarea rows="4" cols="10" name="fvTues" form="pForm">${var.fv}</textarea>
                                    </td>
                                    <td>
                                        <textarea rows="4" cols="10" name="ystTues" form="pForm">${var.yst}</textarea>
                                    </td>
                                    <td>
                                        <textarea rows="4" cols="10" name="transferTues" form="pForm">${var.transfer}</textarea>
                                    </td>
                                    <td>
                                        <textarea rows="4" cols="10" name="fugeTues" form="pForm">${var.fuge}</textarea>
                                    </td>
                                    <td>
                                        <textarea rows="4" cols="10" name="cleanTues" form="pForm">${var.clean}</textarea>
                                    </td>
                                    <td>
                                        <textarea rows="4" cols="10" name="kegTues" form="pForm">${var.keg}</textarea>
                                    </td>
                                    <td>
                                        <textarea rows="4" cols="10" name="bottleTues" form="pForm">${var.bottle}</textarea>
                                    </td>
                                    <td>
                                        <textarea rows="4" cols="10" name="canTues" form="pForm">${var.can}</textarea>
                                    </td>
                                </c:if>
                            </c:forEach>
                        </tr>
                        <tr>
                            <td>Wednesday</td>
                            <c:forEach var="var" items="${productionSchedules}">
                                <c:if test="${var.getDayOfWeek() =='wednesday'}">
                                    <td>
                                        <textarea rows="4" cols="10" name="brewWed" form="pForm">${var.brew}</textarea>
                                    </td>
                                    <td>
                                        <textarea rows="4" cols="10" name="fvWed" form="pForm">${var.fv}</textarea>
                                    </td>
                                    <td>
                                        <textarea rows="4" cols="10" name="ystWed" form="pForm">${var.yst}</textarea>
                                    </td>
                                    <td>
                                        <textarea rows="4" cols="10" name="transferWed" form="pForm">${var.transfer}</textarea>
                                    </td>
                                    <td>
                                        <textarea rows="4" cols="10" name="fugeWed" form="pForm">${var.fuge}</textarea>
                                    </td>
                                    <td>
                                        <textarea rows="4" cols="10" name="cleanWed" form="pForm">${var.clean}</textarea>
                                    </td>
                                    <td>
                                        <textarea rows="4" cols="10" name="kegWed" form="pForm">${var.keg}</textarea>
                                    </td>
                                    <td>
                                        <textarea rows="4" cols="10" name="bottleWed" form="pForm">${var.bottle}</textarea>
                                    </td>
                                    <td>
                                        <textarea rows="4" cols="10" name="canWed" form="pForm">${var.can}</textarea>
                                    </td>
                                </c:if>
                            </c:forEach>
                        </tr>
                        <tr>
                            <td>Thursday</td>
                            <c:forEach var="var" items="${productionSchedules}">
                                <c:if test="${var.getDayOfWeek() =='thursday'}">
                                    <td>
                                        <textarea rows="4" cols="10" name="brewThurs" form="pForm">${var.brew}</textarea>
                                    </td>
                                    <td>
                                        <textarea rows="4" cols="10" name="fvThurs" form="pForm">${var.fv}</textarea>
                                    </td>
                                    <td>
                                        <textarea rows="4" cols="10" name="ystThurs" form="pForm">${var.yst}</textarea>
                                    </td>
                                    <td>
                                        <textarea rows="4" cols="10" name="transferThurs" form="pForm">${var.transfer}</textarea>
                                    </td>
                                    <td>
                                        <textarea rows="4" cols="10" name="fugeThurs" form="pForm">${var.fuge}</textarea>
                                    </td>
                                    <td>
                                        <textarea rows="4" cols="10" name="cleanThurs" form="pForm">${var.clean}</textarea>
                                    </td>
                                    <td>
                                        <textarea rows="4" cols="10" name="kegThurs" form="pForm">${var.keg}</textarea>
                                    </td>
                                    <td>
                                        <textarea rows="4" cols="10" name="bottleThurs" form="pForm">${var.bottle}</textarea>
                                    </td>
                                    <td>
                                        <textarea rows="4" cols="10" name="canThurs" form="pForm">${var.can}</textarea>
                                    </td>
                                </c:if>
                            </c:forEach>
                        </tr>
                        <tr>
                            <td>Friday</td>
                            <c:forEach var="var" items="${productionSchedules}">
                                <c:if test="${var.getDayOfWeek() =='friday'}">
                                    <td>
                                        <textarea rows="4" cols="10" name="brewFri" form="pForm">${var.brew}</textarea>
                                    </td>
                                    <td>
                                        <textarea rows="4" cols="10" name="fvFri" form="pForm">${var.fv}</textarea>
                                    </td>
                                    <td>
                                        <textarea rows="4" cols="10" name="ystFri" form="pForm">${var.yst}</textarea>
                                    </td>
                                    <td>
                                        <textarea rows="4" cols="10" name="transferFri" form="pForm">${var.transfer}</textarea>
                                    </td>
                                    <td>
                                        <textarea rows="4" cols="10" name="fugeFri" form="pForm">${var.fuge}</textarea>
                                    </td>
                                    <td>
                                        <textarea rows="4" cols="10" name="cleanFri" form="pForm">${var.clean}</textarea>
                                    </td>
                                    <td>
                                        <textarea rows="4" cols="10" name="kegFri" form="pForm">${var.keg}</textarea>
                                    </td>
                                    <td>
                                        <textarea rows="4" cols="10" name="bottleFri" form="pForm">${var.bottle}</textarea>
                                    </td>
                                    <td>
                                        <textarea rows="4" cols="10" name="canFri" form="pForm">${var.can}</textarea>
                                    </td>
                                </c:if>
                            </c:forEach>
                        </tr>
                    </table>
                    <button type="submit" class="btn btn-success">update</button>
                </form>
                <form form action="productionSchedule?action=clear" id="pForm" method="post" class="finishedInventoryUpdateButton">
                    <button type="submit" class="btn btn-success">clear</button>
                </form>
            </div>
        </div>
    </body>
    <c:import url="includes/footer.html"/>

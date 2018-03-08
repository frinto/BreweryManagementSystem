
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
                        <li class="nav-item active">
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

                <h1>Raw Goods Inventory</h1>

                <!--These are the tabs from the bootstrap documentation-->

                <ul class="nav nav-tabs" id="myTab" role="tablist">
                    <li class="nav-item">
                        <a class="nav-link active" id="home-tab" data-toggle="tab" href="#home" role="tab" aria-controls="home" aria-selected="true">BrewMaterials</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" id="profile-tab" data-toggle="tab" href="#profile" role="tab" aria-controls="profile" aria-selected="false">ProductionMaterials</a>
                    </li>
                </ul>


                <div class="tab-content" id="myTabContent">
                    <!-- brew materials tab-->  
                    <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                        <h3>Brew Materials</h3>
                        <c:if test="${role == 1}">
                        <form action="rawInventory?action=addBrewMaterials" method="post" class="rawInventoryUpdateButton">
                            <table class="table">
                                <thead class="thead-dark">
                                    <tr>
                                        <th>Name</th>
                                        <th>Quantity</th>
                                        <th>Units</th>
                                        <th>Type</th>
                                    </tr>
                                </thead>

                                <tr>
                                    <td><input type="text" name="addName" placeholder="name"></td>
                                    <td><input type="number" name="addQty" placeholder="quantity"></td>
                                    <td><input type="text" name="addUnits" placeholder="units"></td>
                                    <td><input type="text" name="addType" placeholder="type"></td>
                                </tr>

                            </table>

                            <button type="submit" class="btn btn-success">Add</button>
                        </form>
                        </c:if>

                        <form action="rawInventory?action=updateBrewMaterials" method="post" class="rawInventoryUpdateButton">
                            <table class="table">
                                <thead class="thead-dark">
                                    <tr>
                                        <th>Name</th>
                                        <th>Quantity</th>
                                        <th>Units</th>
                                        <th>Type</th>
                                        <c:if test="${role == 1}">
                                        <th>New Quantity</th>
                                        </c:if>
                                    </tr>
                                </thead>
                                <c:forEach var="brewList" items="${brewMaterials}">
                                    <tr>
                                        <td>${brewList.name}</td>
                                        <td>${brewList.qty}</td>
                                        <td>${brewList.units}</td>
                                        <td>${brewList.type}</td>
                                        <c:if test="${role == 1}">
                                        <td>
                                            <input type="number" name="${brewList.name}" value="${brewList.qty}">
                                        </td>
                                        </c:if>
                                    </tr>
                                </c:forEach>
                            </table>
                            <c:if test="${role == 1}">
                            <button type="submit" class="btn btn-success">Update Inventory</button>
                            </c:if>
                        </form>

                    </div>
                    <!--end brew materials tab-->

                    <!--production materials tab-->
                    <div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab">
                        <h3>Production Materials</h3>
                        <c:if test="${role == 1}">
                        <form action="rawInventory?action=addProductionMaterials" method="post" class="rawInventoryUpdateButton">
                            <table class="table">
                                <thead class="thead-dark">
                                    <tr>
                                        <th>Name</th>
                                        <th>Quantity</th>
                                    </tr>
                                </thead>

                                <tr>
                                    <td><input type="text" name="addName" placeholder="name"></td>
                                    <td><input type="number" name="addQty" placeholder="quantity"></td>
                                </tr>
                            </table>

                            <button type="submit" class="btn btn-success">Add</button>
                        </form>
                        </c:if>
                        <form action="rawInventory?action=updateProductionMaterials" method="post" class="rawInventoryUpdateButton">
                            <table class="table">
                                <thead class="thead-dark">
                                    <tr>
                                        <th>Name</th>
                                        <th>Quantity</th>
                                        <c:if test="${role == 1}">
                                        <th>New Quantity</th>
                                        </c:if>
                                    </tr>
                                </thead>
                                <c:forEach var="prodList" items="${productionMaterials}">
                                    <tr>
                                        <td>${prodList.name}</td>
                                        <td>${prodList.qty}</td>
                                        <c:if test="${role == 1}">
                                        <td>
                                            <input type="number" name="${prodList.name}" value="${prodList.qty}">
                                        </td>
                                        </c:if>
                                    </tr>
                                </c:forEach>
                            </table>
                            <c:if test="${role == 1}">
                            <button type="submit" class="btn btn-success">Update Inventory</button>
                            </c:if>
                        </form>
                    </div>
                    <!--end production materials tab-->
                </div>
            </div>
        </div>
    </body>
    <c:import url="includes/footer.html"/>

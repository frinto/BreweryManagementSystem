
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <title>BMS</title>
        <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' />
        <!--     Fonts and icons     -->
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700,200" rel="stylesheet" />
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" />
        <!-- CSS Files -->
        <link href="assets/css/bootstrap.min.css" rel="stylesheet" />
        <link href="assets/css/light-bootstrap-dashboard.css?v=2.0.1" rel="stylesheet" />
        <!-- CSS Just for demo purpose, don't include it in your project -->
        <link href="assets/css/demo.css" rel="stylesheet" />
        <link href="assets/css/override.css" rel="stylesheet" />
    </head>

    <body>
        <div class="wrapper">

            <div class="sidebar" data-image="../assets/img/sidebar-5.jpg" data-color="red">

                <!--
            Tip 1: You can change the color of the sidebar using: data-color="purple | blue | green | orange | red"
    
            Tip 2: you can also add an image using data-image tag
                -->
                <div class="sidebar-wrapper">
                    <div class="logo">
                        <a href="http://www.creative-tim.com" class="simple-text">
                            Brewery Management System
                        </a>
                    </div>
                    <ul class="nav">
                        <li class="nav-item active">
                            <a class="nav-link" href="tankStatus">
                                <img src="assets/img/tank.png" class="tankfarmIcon" alt="Norway">
                                <p style ="padding-left:5px">Tank Farm</p>
                            </a>
                        </li>
                        <li>
                            <a class="nav-link" href="./user.html">
                                <img src="assets/img/barrel.png" class="barrelIcon" alt="Norway">
                                <p style ="padding-left:5px">Production</p>
                            </a>
                        </li>
                        <li>
                            <a class="nav-link" href="./table.html">
                                <i class="nc-icon nc-notes"></i>
                                <p>Brew</p>
                            </a>
                        </li>
                        <li>
                            <a class="nav-link" href="./typography.html">
                                <i class="nc-icon nc-paper-2"></i>
                                <p>Finished Inventory</p>
                            </a>
                        </li>
                        <li>
                            <a class="nav-link" href="./icons.html">
                                <i class="nc-icon nc-atom"></i>
                                <p>Raw Goods Inventory</p>
                            </a>
                        </li>
                        <li>
                            <a class="nav-link" href="./maps.html">
                                <i class="nc-icon nc-pin-3"></i>
                                <p>Recipes</p>
                            </a>
                        </li>
                        <li>
                            <a class="nav-link" href="./notifications.html">
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
                        <a class="navbar-brand" href="#pablo"> Tank Farm </a>
                        <button href="" class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" aria-controls="navigation-index" aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-bar burger-lines"></span>
                            <span class="navbar-toggler-bar burger-lines"></span>
                            <span class="navbar-toggler-bar burger-lines"></span>
                        </button>
                    </div>
                </nav>
                <!-- End Navbar -->

                <!--                <p class="copyright text-center">
                                    ©
                                    <script>
                                        document.write(new Date().getFullYear())
                                    </script>
                                    <a href="http://www.creative-tim.com">Creative Tim</a>, made with love for a better web
                                </p>-->
                
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

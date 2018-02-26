
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
                        <li >
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
                        <li class="nav-item active">
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
                        <a class="navbar-brand" href="#pablo"> Finished Inventory </a>
                        <li><a href="login?logout">Log Out</a></li>
                        <button href="" class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" aria-controls="navigation-index" aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-bar burger-lines"></span>
                            <span class="navbar-toggler-bar burger-lines"></span>
                            <span class="navbar-toggler-bar burger-lines"></span>
                        </button>
                    </div>
                </nav>

                <!--End nav bar-------------------------------------------------------------------------->


                <h1>Finished Inventory</h1>
                
                <form action="finishedInventory?action=add" method="post" class="finishedInventoryUpdateButton">
                    
                    <table class="table">
                        <thead class="thead-dark">
                            <tr>
                                <th>Product Name</th>
                                <th>Quantity</th>
                            </tr>
                        </thead>
                        
                        
                        <tr>
                            <td><input type="text" name="addProductName" placeholder="product name"></td>
                            <td><input type="number" name="addQty" placeholder="quantity"></td>
                        </tr>
                        
                    </table>
                    
                    <button type="submit" class="btn btn-success">Add</button>
                </form>


                <form action="finishedInventory?action=update" method="post" class="finishedInventoryUpdateButton">
                    <table class="table">
                        <thead class="thead-dark">
                            <tr>
                                <th>Product Name</th>
                                <th>Quantity</th>
                                <th>Update</th>
                            </tr>
                        </thead>
                        </tbody>
                        <c:forEach var="productName" items="${finishedProducts}">
                            <tr>
                                <td>${productName.productName}</td>
                                <td>${productName.qty}</td>
                                <td>
                                    <input type="number" name="${productName.productName}" value="${productName.qty}">
                                </td>
                            </tr>
                        </c:forEach>
                    </table>

                    <button type="submit" class="btn btn-success">Update Inventory</button>
                </form>
            </div>
        </div>
    </body>
    <c:import url="includes/footer.html"/>



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

    <body onbeforeunload="">

        <div class="wrapper">

            <!--Nav bar----------------------------------------------------------------------------->
            <div class="sidebar" data-image="../assets/img/sidebar-5.jpg" data-color="red">
                <div class="sidebar-wrapper">
                    <div class="logo">
                        <image src ="assets/img/logo.jpg">
                    </div>
                    <ul class="nav">
                        <li>
                            <a class="nav-link" href="tankStatus">
                                <img src="assets/img/tank.png" class="tankfarmIcon" alt="Norway">
                                <p style ="padding-left:5px">Tank Farm</p>
                            </a>
                        </li>
                        <li>
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
                        <li class="nav-item active">
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
                        <a class="navbar-brand" href="#pablo"> Recipes </a>
                        <li><a href="login?logout">Log Out</a></li>
                        <button href="" class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" aria-controls="navigation-index" aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-bar burger-lines"></span>
                            <span class="navbar-toggler-bar burger-lines"></span>
                            <span class="navbar-toggler-bar burger-lines"></span>
                        </button>
                    </div>
                </nav>

                <!--End nav bar-------------------------------------------------------------------------->
                <div class = "brews">


                    <c:if test="${newRecipe==null}">
                        <table class="table">
                            <thead class="thead-dark">
                                <tr>
                                    <th scope="col">Recipe</th>
                                    <th scope="col">Last Modified</th>
                                    <th scope="col">Edit</th>
                                </tr>
                            </thead>
                            <tbody>


                                <c:forEach var="recipe" items="${recipeList}">

                                    <tr>
                                        <td>${recipe.recipeName}</td>
                                        <td><fmt:formatDate value="${recipe.dateModified}" pattern="MMM-dd-yyy" /></td>
                                    </tr>

                                </c:forEach>
                            </tbody>
                        </table>

                        <form action="recipe" method ="GET" class ="brewButton">
                            <button type="submit" class="btn btn-success" name="newRecipe">Add a Recipe</button>
                        </form>

                    </c:if>

                    <h1 class="leftSpacingh1">Add Recipe:</h1>

                    <table class="table">
                        <thead class="thead-dark">
                            <tr>
                                <th scope="col">Recipe Attribute</th>
                                <th scope="col">Value</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <th scope="row">Brand Name:</th>
                                <td><input type="text" name="recipeName" id="recipeName" required></td>
                            </tr>
                            
                            
                        </tbody>

                    </table>    


                </div>





            </div>
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
    <script src="assets/js/brew.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            // Javascript method's body can be found in assets/js/demos.js
        });
    </script>

</html>


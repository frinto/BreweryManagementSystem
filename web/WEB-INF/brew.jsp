
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
                        <li class="nav-item active">
                            <a class="nav-link" href="brew">
                                <i class="nc-icon nc-notes"></i>
                                <p>Brew</p>
                            </a>
                        </li>
                        <li>
                            <a class="nav-link" href="finishedinventory">
                                <i class="nc-icon nc-paper-2"></i>
                                <p>Finished Inventory</p>
                            </a>
                        </li>
                        <li>
                            <a class="nav-link" href="rawinventory">
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
                        <a class="navbar-brand" href="#pablo"> Brew </a>
                        <button href="" class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" aria-controls="navigation-index" aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-bar burger-lines"></span>
                            <span class="navbar-toggler-bar burger-lines"></span>
                            <span class="navbar-toggler-bar burger-lines"></span>
                        </button>
                    </div>
                </nav>

                <!--End nav bar-------------------------------------------------------------------------->


                <!--------------------------------------Brew Selector------------------------------------------->


                <c:if test="${recipe==null}">

                    <c:if test="${newBrew != null}">


                        <div class ="selectBrew">
                            <h3>Select Brew:</h3>

                            <form action ="brew" method ="GET">
                                <select name="recipeList" class="custom-select">
                                    <c:forEach items="${recipes}" var="recipe">

                                        <option value="${recipe.recipeName}" selected ="selected">
                                            ${recipe.recipeName} 
                                        </option>

                                    </c:forEach>
                                </select>
                                <br>
                                <br>
                                <button type="submit" class="btn btn-primary btn-lg">Start Brew!</button>
                            </form>
                            <br>
                            <br>

                        </div>



                    </c:if>

                    <!-------------------------------------- End Brew Selector------------------------------------------->





                    <!--------------------------------------Start  New Brew------------------------------------------->




                    <div class = "brews">
                        <form class ="datepicker">
                            View Brews by Date:
                            <input type="date" name="bdaytime">
                        </form>


                        <table class="table">
                            <thead class="thead-dark">
                                <tr>
                                    <th scope="col">Brew #</th>
                                    <th scope="col">Brand</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <th scope="row">1</th>
                                    <td>Blonde</td>
                                </tr>
                                <tr>
                                    <th scope="row">2</th>
                                    <td>Blacksmith</td>
                                </tr>
                            </tbody>
                        </table>
                        <form action="brew" method ="GET" class ="brewButton">
                            <button type="submit" class="btn btn-success" name="newBrew">Add a Brew</button>
                        </form>

                    </div>

                </c:if>

                <!----------------------------------------------BrewSheetForm-------------------------------------------->


                <c:if test="${recipe!=null}">

                    <h1 class="leftSpacingh1">Now Brewing: ${recipe.recipeName}</h1>


                    <!---------------------------------------------------Tabs------------------------------------------>

                    <!--These are the tabs from the bootstrap documentation-->

                    <ul class="nav nav-tabs" id="myTab" role="tablist">
                        <li class="nav-item">
                            <a class="nav-link active" id="home-tab" data-toggle="tab" href="#home" role="tab" aria-controls="home" aria-selected="true">Ingredients</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" id="profile-tab" data-toggle="tab" href="#profile" role="tab" aria-controls="profile" aria-selected="false">BrewSheet</a>
                        </li>

                    </ul>


                    <div class="tab-content" id="myTabContent">
                        <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">


                            <!------------------------------------------------------------Ingredients------------------------------------------------------>


                            <h4 class="leftSpacingh4">Hops:</h4>

                            <table class="table table-sm">
                                <thead>
                                    <tr>
                                        <th scope="col">Ingredient</th>
                                        <th scope="col">Type</th>
                                        <th scope="col">Amount</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <th scope="row">First Hop Addition</th>
                                        <td>${recipe.firstHop}</td>
                                        <td>${recipe.firstHopAmt} kg</td>
                                    </tr>
                                    <tr>
                                        <th scope="row">Second Hop Addition</th>
                                        <td>${recipe.secondHop}</td>
                                        <td>${recipe.secondHopAmt} kg</td>
                                    </tr>
                                    <tr>
                                        <th scope="row">Third Hop Addition</th>
                                        <td>${recipe.thirdHop}</td>
                                        <td colspan="2">${recipe.thirdHopAmt} kg</td>

                                    </tr>
                                </tbody>
                            </table>

                            <h4 class="leftSpacingh4">Malt:</h4>     

                            <table class="table table-sm">
                                <thead>
                                    <tr>
                                        <th scope="col">Ingredient</th>
                                        <th scope="col">Type</th>
                                        <th scope="col">Amount</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <th scope="row">Base Malt</th>
                                        <td>${recipe.baseMalt}</td>
                                        <td>${recipe.baseMaltAmt} kg</td>
                                    </tr>
                                    <tr>
                                        <th scope="row">Second Malt</th>
                                        <td>${recipe.secondMalt}</td>
                                        <td>${recipe.secondMaltAmt} kg</td>
                                    </tr>
                                    <c:if test="${recipe.thirdMaltAmt!=0}">
                                        <tr>
                                            <th scope="row">Third Malt</th>
                                            <td>${recipe.thirdMalt}</td>
                                            <td colspan="2">${recipe.thirdMaltAmt} kg</td>

                                        </tr>
                                    </c:if>
                                    <c:if test="${recipe.fourthMaltAmt!=0}">
                                        <tr>
                                            <th scope="row">Third Malt</th>
                                            <td>${recipe.fourthMalt}</td>
                                            <td colspan="2">${recipe.fourthMaltAmt} kg</td>

                                        </tr>
                                    </c:if>
                                </tbody>
                            </table>

                        </div>

                        <!-------------------------------------------------------Brew Sheet----------------------------------------------------------->

                        <div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab">


                            This is where the brewsheet goes

                        </div>

                    </div>
                </c:if>


                <!--------------------------------------End Start New Brew------------------------------------------->



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


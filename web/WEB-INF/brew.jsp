

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
                        <li class="nav-item active">
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
                            <input type="date" name="brewDate">
                        </form>
                        <table class="table">
                            <thead class="thead-dark">
                                <tr>
                                    <th scope="col">Brew #</th>
                                    <th scope="col">Date</th>
                                    <th scope="col">Brand</th>
                                </tr>
                            </thead>
                            <tbody>
                                
                                    <c:forEach var="brew" items="${brews}">
                                    <tr>
                                        <td>${brew.brewId}</td>
                                        <td>${brew.date}</td>
                                        <td>${brew.recipeName}</td>
                                    </tr>
                                </c:forEach>
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
                    <div class="cancelButton">
                        <form action ="brew" method ="GET">
                        <button type="submit" class="btn btn-danger" name="cancelBrew">Cancel Brew</button>
                        </form>
                    </div>


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


                            <h4 class="leftSpacingh4">Hop Bill:</h4>

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

                            <h4 class="leftSpacingh4">Malt Bill:</h4>     

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
                            </table>

                            <h4 class="leftSpacingh4">Mash Chemistry</h4>     

                            <table class="table table-sm">
                                <thead>
                                    <tr>
                                        <th scope="col">Ingredient</th>

                                        <th scope="col">Amount</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <th scope="row">Gypsum</th>
                                        <td>${recipe.gypsumAmt} gm</td>

                                    </tr>
                                    <tr>
                                        <th scope="row">Calcium Chloride</th>
                                        <td>${recipe.calciumChlorideAmt} mg</td>

                                    </tr>

                                    <tr>
                                        <th scope="row">Phosphoric Acid</th>
                                        <td>${recipe.phosphAcidAmt} mL</td>

                                    </tr>


                                </tbody>
                            </table>

                        </div>

                        <!-------------------------------------------------------Brew Sheet----------------------------------------------------------->
                        <div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab">
                            <form action="brew" method ="POST">
                                <h3 class ="brewSteps">Mash Tun</h3>
                                <table class="table">
                                    <thead class="thead-dark">
                                        <tr>
                                            <th scope="col">Action</th>
                                            <th scope="col">Unit</th>
                                            <th scope="col">Target</th>
                                            <th scope="col">Actual</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <th scope="row">Mash-In Temperature</th>
                                            <td>oC</td>
                                            <td colspan="4">${recipe.mashInTemp}</td>

                                        </tr>
                                        <tr>
                                            <th scope="row">Mash-In Time</th>
                                            <td>Minutes</td>
                                            <td>${recipe.mashInTime}</td>
                                            <td><input type="number" name="mashInTime" id="mashInTime" onkeyup="UpdateInfo()" min="0" max="500" required></td>
                                        </tr>
                                        <tr>
                                            <th scope="row">Mash-In Water</th>
                                            <td>Litres</td>
                                            <td>${recipe.mashWaterVolume}</td>
                                            
                                        </tr>
                                        <tr>
                                            <th scope="row">Rest Time</th>
                                            <td>Minutes</td>
                                            <td>${recipe.restTime}</td>
                                            <td><input type="number" name="restTime" id="restTime" onkeyup="UpdateInfo()" min="0" max="500" required></td>
                                        </tr>
                                        <tr>
                                            <th colspan="4" style ="text-align:center">****DO STARCH TEST****</th>

                                        </tr>
                                        <tr>
                                            <th scope="row">Raise To Temperature</th>
                                            <td>oC</td>
                                            <td colspan="4">${recipe.raiseToTemp}</td>

                                        </tr>
                                        <tr>
                                            <th scope="row">In Time</th>
                                            <td>Minutes</td>
                                            <td>${recipe.inTime}</td>
                                            <td><input type="number" name="inTime" id="inTime" min="0" max="500" required></td>
                                        </tr>
                                        <tr>
                                            <th scope="row">Total Mash Time</th>
                                            <td>Minutes</td>
                                            <td>${recipe.totalMashTime}</td>
                                            <td><input type="number" name="totalMashTime" id="totalMashTime" min="0" max="500" readonly></td>
                                        </tr>

                                    </tbody>

                                </table>
                                <h3 class ="brewSteps">Lauter Tun</h3>

                                <table class="table">
                                    <thead class="thead-dark">
                                        <tr>
                                            <th scope="col">Action</th>
                                            <th scope="col">Unit</th>
                                            <th scope="col">Target</th>
                                            <th scope="col">Actual</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <th scope="row">Underlet</th>
                                            <td>Litres</td>
                                            <td>${recipe.underletLitres}</td>
                                            <td><input type="number" name="underletTime" min="0" max="500" required></td>
                                            

                                        </tr>
                                        <tr>
                                            <th scope="row">Rest</th>
                                            <td>Minutes</td>
                                            <td>${recipe.rest}</td>
                                            <td><input type="number" name="lauterRest" min="0" max="500" required></td>
                                        </tr>
                                        <tr>
                                            <th scope="row">Vorlauf</th>
                                            <td>Minutes</td>
                                            <td>${recipe.vorlaufTime}</td>
                                            <td><input type="number" name="vorlaufTime" min="0" max="500" required></td>
                                        </tr>
                                        <tr>
                                            <th scope="row">First Wort Gravity</th>
                                            <td>oP</td>
                                            <td>${recipe.firstWortGrav}</td>
                                            <td><input type="number" name="firstWortGrav" min="0" max="500" required></td>
                                        </tr>
                                        <tr>
                                            <th scope="row">Run-Off</th>
                                            <td>Minutes</td>
                                            <td>${recipe.runOffTime}</td>
                                            <td><input type="number" name="runOffTime" min="0" max="500" required></td>
                                        </tr>
                                        <tr>
                                            <th scope="row">Sparge Volume</th>
                                            <td>Hectolitres</td>
                                            <td>${recipe.spargVol}</td>

                                        </tr>

                                        <tr>
                                            <th scope="row">Sparge Temperature</th>
                                            <td>oC</td>
                                            <td>${recipe.spargTemp}</td>

                                        </tr>

                                        <tr>
                                            <th scope="row">Last Runnings Gravity</th>
                                            <td>oP</td>
                                            <td>${recipe.lastRunningsGrav}</td>
                                            <td><input type="number" name="lastRunnings" min="0" max="500" required></td>
                                        </tr>

                                        <tr>
                                            <th scope="row">Kettle Full Volume</th>
                                            <td>Hectolitres</td>
                                            <td>${recipe.kettleFullVol}</td>
                                            <td><input type="number" name="kettleFullVol" min="0" max="500" required></td>
                                        </tr>


                                    </tbody>

                                </table>

                                <h3 class ="brewSteps">Brew Kettle</h3>

                                <table class="table">
                                    <thead class="thead-dark">
                                        <tr>
                                            <th scope="col">Action</th>
                                            <th scope="col">Unit</th>
                                            <th scope="col">Target</th>
                                            <th scope="col">Actual</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <th scope="row">Kettle Full Gravity</th>
                                            <td>oP</td>
                                            <td>${recipe.kettleFullGrav}</td>
                                            <td><input type="number" name="kettleFullGrav" min="0" max="500" required></td>
                                        </tr>
                                        <tr>
                                            <th scope="row">Boil</th>
                                            <td>Minutes</td>
                                            <td>${recipe.boilTime}</td>

                                        </tr>


                                        <tr>
                                            <th scope="row">Add First Hop at Kettle Full</th>
                                            <td>kg</td>
                                            <td>${recipe.firstHop}</td>
                                            <td>${recipe.firstHopAmt}</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">Add Second Hop:30 Min Left</th>
                                            <td>kg</td>
                                            <td>${recipe.secondHop}</td>
                                            <td>${recipe.secondHopAmt}</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">Add Third Hop: 5 Min Left</th>
                                            <td>kg</td>
                                            <td>${recipe.thirdHop}</td>
                                            <td>${recipe.thirdHopAmt}</td>
                                        </tr>

                                        <tr>
                                            <th scope="row">Kettle Strikeout Volume</th>
                                            <td>Hectolitres</td>
                                            <td>${recipe.strikeOutVol}</td>
                                            <td><input type="number" name="strikeOutVol" min="0" max="500" required></td>
                                        </tr>
                                        <tr>
                                            <th scope="row">Kettle Strikeout Gravity</th>
                                            <td>oP</td>
                                            <td>${recipe.strikeOutGrav}</td>
                                            <td><input type="number" name="strikeOutGrav" min="0" max="500" required></td>
                                        </tr>
                                        <tr>
                                            <th scope="row">Whirlpool Time</th>
                                            <td>Minutes</td>
                                            <td>${recipe.whirlPoolTime}</td>

                                        </tr>
                                        <tr>
                                            <th scope="row">Oxygen Rate</th>
                                            <td>Litres Per Minute</td>
                                            <td>${recipe.oxygenRate}</td>

                                        </tr>


                                    </tbody>

                                </table>
                                <h3 class ="brewSteps">Fermenting Vessel and Final Volume</h3>
                                <br>
                                <div class="fvSelect">
                                    <table class="table">
                                        <tr>
                                            <td>
                                <label for="custom-select">Please Select Destination Fermenter:</label>
                                            </td>
                                            <td>
                                <select name="fvList" class="custom-select">
                                    <c:forEach items="${fvs}" var="fv">
                                        <option value="${fv.fvId}" selected ="selected">
                                            ${fv.fvId} 
                                        </option>
                                    </c:forEach>
                                </select>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                
                                <label>Final volume for fermenter(hectolitres):</label>
                                            </td>
                                            <td>
                                <input type="number" name="finalVolume" min="0" max="10000" required></td>
                                        </tr>
                                    </table>
                                </div>
                                
                                <br>
                                <br>
                                <br>
                                <br>






                                <div class="brewSubmit">
                                    <button type="submit" class="btn btn-success" name="newBrew" style="text-align: center">SUBMIT BREW</button>
                                </div>
                            </form>
                            <br>
                            <br>
                            <br>


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


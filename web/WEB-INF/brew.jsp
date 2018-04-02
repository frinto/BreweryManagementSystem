

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
        <link href="assets/css/successmodal.css" rel="stylesheet" />
    </head>

    <body onbeforeunload="">

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
                        <li class="nav-item active">
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
                        <a class="navbar-brand">Brew</a>
                        <div class="btn-group">
                            <button type="button" class="btn btn-secondary dropdown-toggle" style="margin-right: 50px" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
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


                <!--------------------------------------Brew Selector------------------------------------------->
                <c:if test ="${viewBrew==null}">
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
                                    ${errorMessage}
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

                            <!-----------------------------------------------Success Modal---------------------------->



                            <!-----------------------------------------------End Success Modal---------------------------->

                            <form class ="datepicker" action="brew" method="GET">
                                <h4>View Brews by Date:</h4>
                                <input type="date" name="brewDate" id="datePicker">
                                <button type="submit" class="btn btn-outline-primary">Select Date</button>
                            </form>

                            <table class="table">
                                <thead class="thead-dark">
                                    <tr>
                                        <th scope="col">Brew #</th>
                                        <th scope="col">Date</th>
                                        <th scope="col">Brand</th>
                                        <th scope="col"></th>
                                    </tr>
                                </thead>
                                <tbody>


                                    <c:forEach var="brew" items="${brews}">
                                        <c:if test="${brewDate.equals(brew.date)}">
                                            <tr>
                                                <td>${brew.brewId}</td>

                                                <td><fmt:formatDate value="${brew.date}" pattern="MMM-dd-yyy" /></td>
                                                <td>${brew.recipeName}</td>
                                                <td>
                                                    <form action="brew" METHOD ="POST">
                                                        <input type="submit" value="View" name="viewBrew">
                                                        <input type="hidden" name="selectedBrew" value="${brew.brewId}">
                                                    </form>
                                                </td>
                                            </tr>
                                        </c:if>
                                    </c:forEach>
                                </tbody>
                            </table>

                            <form action="brew" method ="GET" class ="brewButton">
                                <button type="submit" class="btn btn-success" name="newBrew">Add a Brew</button>
                            </form>
                        </div>
                    </c:if>
                </c:if>   
                <c:if test="${viewBrew!=null}">
                    <h1 class="leftSpacingh1">Now Viewing: ${viewBrew.recipeName} | Brew Number : ${viewBrew.brewId}</h1>
                    <form action ="brew" method ="GET">
                        <button type="submit" class="btn btn-danger" name="cancelBrew">Back</button>
                    </form>
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
                                <td colspan="4">${viewRecipe.mashInTemp}</td>

                            </tr>
                            <tr>
                                <th scope="row">Mash-In Time</th>
                                <td>Minutes</td>
                                <td>${viewRecipe.mashInTime}</td>
                                <td>${viewBrew.mashInTime}</td>
                            </tr>
                            <tr>
                                <th scope="row">Mash-In Water</th>
                                <td>Litres</td>
                                <td>${viewRecipe.mashWaterVolume}</td>

                            </tr>
                            <tr>
                                <th scope="row">Rest Time</th>
                                <td>Minutes</td>
                                <td>${viewRecipe.restTime}</td>
                                <td>${viewBrew.restTime}</td>
                            </tr>
                            <tr>
                                <th colspan="4" style ="text-align:center">****DO STARCH TEST****</th>

                            </tr>
                            <tr>
                                <th scope="row">Raise To Temperature</th>
                                <td>oC</td>
                                <td colspan="4">${viewRecipe.raiseToTemp}</td>

                            </tr>
                            <tr>
                                <th scope="row">In Time</th>
                                <td>Minutes</td>
                                <td>${viewRecipe.inTime}</td>
                                <td>${viewBrew.inTime}</td>
                            </tr>
                            <tr>
                                <th scope="row">Total Mash Time</th>
                                <td>Minutes</td>
                                <td>${viewRecipe.totalMashTime}</td>
                                <td>${viewBrew.totalMashTime}</td>
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
                                <td>${viewRecipe.underletLitres}</td>
                                <td>${viewBrew.underletTime}</td>


                            </tr>
                            <tr>
                                <th scope="row">Rest</th>
                                <td>Minutes</td>
                                <td>${viewRecipe.rest}</td>
                                <td>${viewBrew.lauterRestTime}</td>
                            </tr>
                            <tr>
                                <th scope="row">Vorlauf</th>
                                <td>Minutes</td>
                                <td>${viewRecipe.vorlaufTime}</td>
                                <td>${viewBrew.vorlaufTime}</td>
                            </tr>
                            <tr>
                                <th scope="row">First Wort Gravity</th>
                                <td>oP</td>
                                <td>${viewRecipe.firstWortGrav}</td>
                                <td>${viewBrew.firstWortGravity}</td>
                            </tr>
                            <tr>
                                <th scope="row">Run-Off</th>
                                <td>Minutes</td>
                                <td>${viewRecipe.runOffTime}</td>
                                <td>${viewBrew.runOffTime}</td>
                            </tr>
                            <tr>
                                <th scope="row">Sparge Volume</th>
                                <td>Hectolitres</td>
                                <td>${viewRecipe.spargVol}</td>

                            </tr>

                            <tr>
                                <th scope="row">Sparge Temperature</th>
                                <td>oC</td>
                                <td>${viewRecipe.spargTemp}</td>

                            </tr>

                            <tr>
                                <th scope="row">Last Runnings Gravity</th>
                                <td>oP</td>
                                <td>${viewRecipe.lastRunningsGrav}</td>
                                <td>${viewBrew.lastRunningsGravity}</td>
                            </tr>

                            <tr>
                                <th scope="row">Kettle Full Volume</th>
                                <td>Hectolitres</td>
                                <td>${viewRecipe.kettleFullVol}</td>
                                <td>${viewBrew.kettleFullVol}</td>
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
                                <td>${viewRecipe.kettleFullGrav}</td>
                                <td>${viewBrew.kettleFullGravity}</td>
                            </tr>
                            <tr>
                                <th scope="row">Boil</th>
                                <td>Minutes</td>
                                <td>${viewRecipe.boilTime}</td>

                            </tr>


                            <tr>
                                <th scope="row">Add First Hop at Kettle Full</th>
                                <td>kg</td>
                                <td>${viewRecipe.firstHop}</td>
                                <td>${viewRecipe.firstHopAmt}</td>
                            </tr>
                            <tr>
                                <th scope="row">Add Second Hop:30 Min Left</th>
                                <td>kg</td>
                                <td>${viewRecipe.secondHop}</td>
                                <td>${viewRecipe.secondHopAmt}</td>
                            </tr>
                            <tr>
                                <th scope="row">Add Third Hop: 5 Min Left</th>
                                <td>kg</td>
                                <td>${viewRecipe.thirdHop}</td>
                                <td>${viewRecipe.thirdHopAmt}</td>
                            </tr>

                            <tr>
                                <th scope="row">Kettle Strikeout Volume</th>
                                <td>Hectolitres</td>
                                <td>${viewRecipe.strikeOutVol}</td>
                                <td>${viewBrew.kettleStrikeOutVol}</td>
                            </tr>
                            <tr>
                                <th scope="row">Kettle Strikeout Gravity</th>
                                <td>oP</td>
                                <td>${viewRecipe.strikeOutGrav}</td>
                                <td>${viewBrew.kettleStrikeOutGravity}</td>
                            </tr>
                            <tr>
                                <th scope="row">Whirlpool Time</th>
                                <td>Minutes</td>
                                <td>${viewRecipe.whirlPoolTime}</td>

                            </tr>
                            <tr>
                                <th scope="row">Oxygen Rate</th>
                                <td>Litres Per Minute</td>
                                <td>${viewRecipe.oxygenRate}</td>

                            </tr>


                        </tbody>

                    </table>
                    <h3 class ="brewSteps">Fermenting Vessel and Final Volume</h3>
                    <br>
                    <div class="fvSelect">
                        <table class="table">
                            <tr>
                                <td>
                                    <label for="custom-select">Destination Fermenter:</label>
                                </td>
                                <td>
                                    ${viewBrew.fvId}</td>


                            </tr>
                            <tr>
                                <td>

                                    <label>Final volume for fermenter(hectolitres):</label>
                                </td>
                                <td>
                                    ${viewBrew.allInVolume}</td>
                            </tr>
                        </table>
                    </div>
                    <form action ="brew" method ="GET">
                        <button type="submit" class="btn btn-danger" name="deleteBrew">Delete Brew</button>
                    </form>
                    <br>
                    <br>
                    <br>
                </c:if>
                <c:if test="${viewBrew!=null}">
                    <h1 class="leftSpacingh1">Now Viewing: ${viewBrew.recipeName} | Brew Number : ${viewBrew.brewId}</h1>
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
                                <td colspan="4">${viewRecipe.mashInTemp}</td>

                            </tr>
                            <tr>
                                <th scope="row">Mash-In Time</th>
                                <td>Minutes</td>
                                <td>${viewRecipe.mashInTime}</td>
                                <td>${viewBrew.mashInTime}</td>
                            </tr>
                            <tr>
                                <th scope="row">Mash-In Water</th>
                                <td>Litres</td>
                                <td>${viewRecipe.mashWaterVolume}</td>

                            </tr>
                            <tr>
                                <th scope="row">Rest Time</th>
                                <td>Minutes</td>
                                <td>${viewRecipe.restTime}</td>
                                <td>${viewBrew.restTime}</td>
                            </tr>
                            <tr>
                                <th colspan="4" style ="text-align:center">****DO STARCH TEST****</th>

                            </tr>
                            <tr>
                                <th scope="row">Raise To Temperature</th>
                                <td>oC</td>
                                <td colspan="4">${viewRecipe.raiseToTemp}</td>

                            </tr>
                            <tr>
                                <th scope="row">In Time</th>
                                <td>Minutes</td>
                                <td>${viewRecipe.inTime}</td>
                                <td>${viewBrew.inTime}</td>
                            </tr>
                            <tr>
                                <th scope="row">Total Mash Time</th>
                                <td>Minutes</td>
                                <td>${viewRecipe.totalMashTime}</td>
                                <td>${viewBrew.totalMashTime}</td>
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
                                <td>${viewRecipe.underletLitres}</td>
                                <td>${viewBrew.underletTime}</td>


                            </tr>
                            <tr>
                                <th scope="row">Rest</th>
                                <td>Minutes</td>
                                <td>${viewRecipe.rest}</td>
                                <td>${viewBrew.lauterRestTime}</td>
                            </tr>
                            <tr>
                                <th scope="row">Vorlauf</th>
                                <td>Minutes</td>
                                <td>${viewRecipe.vorlaufTime}</td>
                                <td>${viewBrew.vorlaufTime}</td>
                            </tr>
                            <tr>
                                <th scope="row">First Wort Gravity</th>
                                <td>oP</td>
                                <td>${viewRecipe.firstWortGrav}</td>
                                <td>${viewBrew.firstWortGravity}</td>
                            </tr>
                            <tr>
                                <th scope="row">Run-Off</th>
                                <td>Minutes</td>
                                <td>${viewRecipe.runOffTime}</td>
                                <td>${viewBrew.runOffTime}</td>
                            </tr>
                            <tr>
                                <th scope="row">Sparge Volume</th>
                                <td>Hectolitres</td>
                                <td>${viewRecipe.spargVol}</td>

                            </tr>

                            <tr>
                                <th scope="row">Sparge Temperature</th>
                                <td>oC</td>
                                <td>${viewRecipe.spargTemp}</td>

                            </tr>

                            <tr>
                                <th scope="row">Last Runnings Gravity</th>
                                <td>oP</td>
                                <td>${viewRecipe.lastRunningsGrav}</td>
                                <td>${viewBrew.lastRunningsGravity}</td>
                            </tr>

                            <tr>
                                <th scope="row">Kettle Full Volume</th>
                                <td>Hectolitres</td>
                                <td>${viewRecipe.kettleFullVol}</td>
                                <td>${viewBrew.kettleFullVol}</td>
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
                                <td>${viewRecipe.kettleFullGrav}</td>
                                <td>${viewBrew.kettleFullGravity}</td>
                            </tr>
                            <tr>
                                <th scope="row">Boil</th>
                                <td>Minutes</td>
                                <td>${viewRecipe.boilTime}</td>

                            </tr>


                            <tr>
                                <th scope="row">Add First Hop at Kettle Full</th>
                                <td>kg</td>
                                <td>${viewRecipe.firstHop}</td>
                                <td>${viewRecipe.firstHopAmt}</td>
                            </tr>
                            <tr>
                                <th scope="row">Add Second Hop:30 Min Left</th>
                                <td>kg</td>
                                <td>${viewRecipe.secondHop}</td>
                                <td>${viewRecipe.secondHopAmt}</td>
                            </tr>
                            <tr>
                                <th scope="row">Add Third Hop: 5 Min Left</th>
                                <td>kg</td>
                                <td>${viewRecipe.thirdHop}</td>
                                <td>${viewRecipe.thirdHopAmt}</td>
                            </tr>

                            <tr>
                                <th scope="row">Kettle Strikeout Volume</th>
                                <td>Hectolitres</td>
                                <td>${viewRecipe.strikeOutVol}</td>
                                <td>${viewBrew.kettleStrikeOutVol}</td>
                            </tr>
                            <tr>
                                <th scope="row">Kettle Strikeout Gravity</th>
                                <td>oP</td>
                                <td>${viewRecipe.strikeOutGrav}</td>
                                <td>${viewBrew.kettleStrikeOutGravity}</td>
                            </tr>
                            <tr>
                                <th scope="row">Whirlpool Time</th>
                                <td>Minutes</td>
                                <td>${viewRecipe.whirlPoolTime}</td>

                            </tr>
                            <tr>
                                <th scope="row">Oxygen Rate</th>
                                <td>Litres Per Minute</td>
                                <td>${viewRecipe.oxygenRate}</td>

                            </tr>


                        </tbody>

                    </table>
                    <h3 class ="brewSteps">Fermenting Vessel and Final Volume</h3>
                    <br>
                    <div class="fvSelect">
                        <table class="table">
                            <tr>
                                <td>
                                    <label for="custom-select">Destination Fermenter:</label>
                                </td>
                                <td>
                                    ${viewBrew.fvId}</td>


                            </tr>
                            <tr>
                                <td>

                                    <label>Final volume for fermenter(hectolitres):</label>
                                </td>
                                <td>
                                    ${viewBrew.allInVolume}</td>
                            </tr>
                        </table>
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
                            <a class="nav-link active" id="home-tab" data-toggle="tab" href="#home" role="tab" aria-controls="home" aria-selected="true">BrewSheet</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" id="profile-tab" data-toggle="tab" href="#profile" role="tab" aria-controls="profile" aria-selected="false">Ingredients</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" id="fermenter-tab" data-toggle="tab" href="#fermenter" role="tab" aria-controls="fermenter" aria-selected="false">Fermenter Status</a>
                        </li>

                    </ul>



                    <div class="tab-content" id="myTabContent">
                        <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
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
                                            <td><input type="number" value="${mashInTime}" name="mashInTime" id="mashInTime" onfocusout="UpdateInfo()" min="0" max="500" required></td>
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
                                            <td><input type="number" value="${restTime}" name="restTime" id="restTime" onfocusout="UpdateInfo()" min="0" max="500" required></td>
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
                                            <td><input type="number" value="${inTime}" name="inTime" id="inTime" min="0" max="500" required></td>
                                        </tr>
                                        <tr>
                                            <th scope="row">Total Mash Time</th>
                                            <td>Minutes</td>
                                            <td>${recipe.totalMashTime}</td>
                                            <td><input type="number" value="${totalMashTime}" name="totalMashTime" id="totalMashTime" min="0" max="500" readonly></td>
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
                                            <td><input type="number" value="${underletTime}" name="underletTime" min="0" max="500" required></td>


                                        </tr>
                                        <tr>
                                            <th scope="row">Rest</th>
                                            <td>Minutes</td>
                                            <td>${recipe.rest}</td>
                                            <td><input type="number" value="${lauterTime}" name="lauterRest" min="0" max="500" required></td>
                                        </tr>
                                        <tr>
                                            <th scope="row">Vorlauf</th>
                                            <td>Minutes</td>
                                            <td>${recipe.vorlaufTime}</td>
                                            <td><input type="number" value="${vorlaufTime}" name="vorlaufTime" min="0" max="500" required></td>
                                        </tr>
                                        <tr>
                                            <th scope="row">First Wort Gravity</th>
                                            <td>oP</td>
                                            <td>${recipe.firstWortGrav}</td>
                                            <td><input type="number" value="${firstWortGrav}" name="firstWortGrav" min="0" max="500" required></td>
                                        </tr>
                                        <tr>
                                            <th scope="row">Run-Off</th>
                                            <td>Minutes</td>
                                            <td>${recipe.runOffTime}</td>
                                            <td><input type="number" value="${runOffTime}" name="runOffTime" min="0" max="500" required></td>
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
                                            <td><input type="number" value="${lastRunnings}" name="lastRunnings" min="0" max="500" required></td>
                                        </tr>

                                        <tr>
                                            <th scope="row">Kettle Full Volume</th>
                                            <td>Hectolitres</td>
                                            <td>${recipe.kettleFullVol}</td>
                                            <td><input type="number" value="${kettleFullVol}" name="kettleFullVol" min="0" max="500" required></td>
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
                                            <td><input type="number" value="${kettleFullGrav}" name="kettleFullGrav" min="0" max="500" required></td>
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
                                            <td><input type="number" value="${strikeOutVol}" name="strikeOutVol" min="0" max="500" required></td>
                                        </tr>
                                        <tr>
                                            <th scope="row">Kettle Strikeout Gravity</th>
                                            <td>oP</td>
                                            <td>${recipe.strikeOutGrav}</td>
                                            <td><input type="number" value="${strikeOutGrav}" name="strikeOutGrav" min="0" max="500" required></td>
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
                                                        <option value="${fv.fvId}" selected ="selected" required>
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


                        <!-------------------------------------------------------Brew Sheet----------------------------------------------------------->
                        <div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab">


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
                        <div class="tab-pane fade" id="fermenter" role="tabpanel" aria-labelledby="fermenter-tab">

                            <table class="table table-sm">
                                <thead class="thead-dark">
                                    <tr>
                                        <th scope="col">SV ID</th>
                                        <th scope="col">Volume</th>
                                        <th scope="col"> Capacity</th>
                                        <th scope="col">Brew 1</th>
                                        <th scope="col">Brew 2</th>
                                        <th scope="col">Brew 3</th>
                                        <th scope="col">Brand</th>
                                        <th scope="col">Status</th>
                                    </tr>
                                </thead>

                                <c:forEach var="fv" items="${fvs}">
                                    <tr>
                                        <td>${fv.fvId}</td>
                                        <td>${fv.volume}</td>
                                        <td>${fv.capacity}</td>
                                        <td>${fv.brew1}</td>
                                        <td>${fv.brew2}</td>
                                        <td>${fv.brew3}</td>
                                        <td>${fv.brand}</td>
                                        <td>${fv.status}</td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </div>


                    </c:if>
                    <!--------------------------------------End Start New Brew------------------------------------------->
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
                                <p>Brew submitted successfully.</p>
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

            <c:if test="${deleteBrew!=null}">

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

                                <h4>Attention!</h4>	
                                <p>Are you sure you want to delete this brew</p>
                                <form action="brew" METHOD="POST">
                                    <input type ="submit" class="btn btn-success" value="OK" name="ok">
                                    <input type ="submit" class="btn btn-success" name="cancel" value="cancel">
                                </form>
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
    <script src="assets/js/brew.js"></script>
    <script type="text/javascript">
                                    $(document).ready(function () {
                                        // Javascript method's body can be found in assets/js/demos.js
                                    });
    </script>
    <script defer src="https://use.fontawesome.com/releases/v5.0.7/js/all.js"></script>



</html>


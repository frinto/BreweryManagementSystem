

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
            <div class="sidebar" data-image="../assets/img/sidebar-5.jpg">
                <div class="sidebar-wrapper">
                    <div class="logo">
                        <image src ="assets/img/logo.png">

                    </div>
                    <hr>
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
                        <li class="nav-item active">
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
                                <img src="assets/img/schedule.png" class="" alt="Norway">
                                <p>Schedule</p>
                            </a>
                        </li>

                        <c:if test="${currentEmployee.roleId == 1}">
                            <li>
                                <a class="nav-link" href="manageEmployee">
                                    <img src="assets/img/employee.png" class="" alt="Norway">
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
                        <a class="navbar-brand">Recipes</a>
                        <div class="btn-group"  style="margin-right: 50px">
                            <button type="button" class="btn btn-secondary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
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
                <div class = "brews">




                    <c:if test="${newRecipe==null&& viewRecipe==null}">
                        <c:if test="${role == 1}">
                        <form action="recipe" method ="GET" class ="recipeButton">
                            <button type="submit" class="btn btn-success" name="newRecipe">Add a Recipe</button>
                        </form>
                        </c:if>
                        <table class="table">
                            <thead class="thead-dark">
                                <tr>
                                    <th scope="col">Recipe</th>
                                    <th scope="col">Date Created</th>
                                    <th scope="col"></th>
                                </tr>
                            </thead>
                            <tbody>


                                <c:forEach var="recipe" items="${recipeList}">

                                    <tr>
                                        <td>${recipe.recipeName}</td>
                                        <td><fmt:formatDate value="${recipe.dateModified}" pattern="MMM-dd-yyy" /></td>
                                        <td><form action="recipe" METHOD ="POST">
                                                <input type="submit" value="View" name="viewRecipe">
                                                <input type="hidden" name="selectedRecipe" value="${recipe.recipeName}">
                                            </form>
                                    </tr>

                                </c:forEach>
                            </tbody>
                        </table>

                    </c:if>
                    <c:if test="${newRecipe!=null}">
                        <h1 class="leftSpacingh1">Add Recipe:</h1>
                        <div class="cancelButton">
                            <form action ="recipe" method ="GET">
                                <button type="submit" class="btn btn-danger" name="cancelRecipe">Cancel Recipe</button>
                            </form>
                        </div>
                        <form action="recipe" method ="POST">


                            <table class="table">
                                <form action="recipe" method ="POST">
                                    <tbody>
                                        <tr>
                                            <th scope="row">Brand Name:</th>
                                            <td><input type="text" name="recipeName" id="recipeName" required></td>
                                        </tr>


                                    </tbody>

                            </table>

                            <h3 class ="brewSteps">Raw Materials</h3>

                            <table class="table">

                                <thead class="thead-dark">
                                    <tr>
                                        <th scope="col">Recipe Attribute</th>
                                        <th scope="col">Units</th>
                                        <th scope="col">Material Name</th>
                                        <th scope="col">Material Amount</th>
                                    </tr>
                                </thead>

                                <tr>
                                    <th scope="row">Base Malt</th>
                                    <td>kg</td>
                                    <td><select name="baseMaltList" class="custom-select" required>
                                            <option value="">--None--</option>
                                            <c:forEach items="${maltList}" var="malt">
                                                <option value="${malt.name}">
                                                    ${malt.name} 
                                                </option>
                                            </c:forEach>
                                        </select>
                                    </td>
                                    <td><input type="number" value="${baseMaltAmt}" required id="basemalt" name="baseMaltAmt" min="0" max="500"></td>
                                </tr>

                                <tr>
                                    <th scope="row">Second Malt</th>
                                    <td>kg</td>
                                    <td><select name="secondMaltList" class="custom-select">
                                            <option value="">--None--</option>
                                            <c:forEach items="${maltList}" var="malt">
                                                <option value="${malt.name}">
                                                    ${malt.name} 
                                                </option>
                                            </c:forEach>
                                        </select>
                                    </td>
                                    <td><input type="number" id="secondmalt" value="${secondMaltAmt}" name="secondMaltAmt" min="0" max="500"></td>
                                </tr>

                                <tr>
                                    <th scope="row">Third Malt</th>
                                    <td>kg</td>
                                    <td><select name="thirdMaltList" class="custom-select">
                                            <option value="">--None--</option>
                                            <c:forEach items="${maltList}" var="malt">
                                                <option value="${malt.name}">
                                                    ${malt.name} 
                                                </option>
                                            </c:forEach>
                                        </select>
                                    </td>
                                    <td><input type="number" id="thirdmalt" value="${thirdMaltAmt}" name="thirdMaltAmt" min="0" max="500"></td>
                                </tr>

                                <tr>
                                    <th scope="row">Fourth Malt</th>
                                    <td>kg</td>
                                    <td><select name="fourthMaltList" class="custom-select">
                                            <option value="">--None--</option>
                                            <c:forEach items="${maltList}" var="malt">
                                                <option value="${malt.name}">
                                                    ${malt.name} 
                                                </option>
                                            </c:forEach>
                                        </select>
                                    </td>
                                    <td><input type="number" value="${fourthMaltAmt}" id="fourthmalt" name="fourthMaltAmt" min="0" max="500"></td>
                                </tr>

                                <th colspan="4" style ="text-align:center">****HOPS****</th>


                                <tr>
                                    <th scope="row">First Hop</th>
                                    <td>kg</td>
                                    <td><select name="firstHopList" class="custom-select">
                                            <option value="">--None--</option>
                                            <c:forEach items="${hopList}" var="hop">
                                                <option value="${hop.name}">
                                                    ${hop.name} 
                                                </option>
                                            </c:forEach>
                                        </select>
                                    </td>
                                    <td><input type="number" value="${firstHopAmt}" id="firsthop" name="firstHopAmt" min="0" max="500"></td>
                                </tr>
                                <tr>
                                    <th scope="row">Second Hop</th>
                                    <td>kg</td>
                                    <td><select name="secondhopList" class="custom-select">
                                            <option value="">--None--</option>
                                            <c:forEach items="${hopList}" var="hop">
                                                <option value="${hop.name}">
                                                    ${hop.name} 
                                                </option>
                                            </c:forEach>
                                        </select>
                                    </td>
                                    <td><input type="number" value="${secondHopAmt}" id="secondhop" name="secondHopAmt" min="0" max="500"></td>

                                </tr>
                                <tr>
                                    <th scope="row">Third Hop</th>
                                    <td>kg</td>
                                    <td><select name="thirdHopList" class="custom-select">
                                            <option value="">--None--</option>
                                            <c:forEach items="${hopList}" var="hop">

                                                <option value="${hop.name}">
                                                    ${hop.name} 
                                                </option>
                                            </c:forEach>
                                        </select>
                                    </td>
                                    <td><input type="number" value="${thirdHopAmt}" id="thirdhop" name="thirdHopAmt" min="0" max="500"></td>
                                </tr>

                                </tbody>

                            </table>

                            <h3 class ="brewSteps">Mash Chemistry</h3>

                            <table class="table">

                                <thead class="thead-dark">
                                    <tr>
                                        <th scope="col">Name</th>
                                        <th scope="col">Units</th>
                                        <th scope="col">Amount</th>
                                    </tr>
                                </thead>

                                <tr>
                                    <th scope="row">Sodium Chloride Amount</th>
                                    <td>mg</td>
                                    <td><input type="number" value="${sodiumChlorideAmt}" id="sodium" name="sodiumChlorideAmt" id="sodiumChlorideAmt" min="0" max="500"></td>


                                </tr>


                                <tr>
                                    <th scope="row">Gypsum Amount</th>
                                    <td>mg</td>
                                    <td><input type="number" value="${gypsumAmt}" id="gypsum" name="gypsumAmt" id="gypsumAmt" min="0" max="500"></td>


                                </tr>

                                <tr>
                                    <th scope="row">Calcium Chloride Amount</th>
                                    <td>mg</td>
                                    <td><input type="number" value="${calciumChlorideAmt}" id="calcium" name="calciumChlorideAmt" id="calciumChlorideAmt" min="0" max="500"></td>


                                </tr>

                                <tr>
                                    <th scope="row">Phosphoric Acid Amount</th>
                                    <td>ml</td>
                                    <td><input type="number" value="${phosphAcidAmt}" id="phosphoric" name="phosphAcidAmt" id="phosphAcidAmt" min="0" max="500" ></td>


                                </tr>


                            </table>


                            <h3 class ="brewSteps">Mash Tun</h3>
                            <table class="table">
                                <thead class="thead-dark">
                                    <tr>
                                        <th scope="col">Recipe Attribute</th>
                                        <th scope="col">Units</th>
                                        <th scope="col">Value</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <th scope="row">Mash-In Temperature</th>
                                        <td>oC</td>
                                        <td><input type="number" value="${mashInTemp}" name="mashInTemp" id="mashInTemp" onfocusout="UpdateInfo()" min="0" max="500" required></td>



                                    </tr>
                                    <tr>
                                        <th scope="row">Mash-In Time</th>
                                        <td>Minutes</td>
                                        <td><input type="number" value="${mashInTime}" name="mashInTime" id="mashInTime" onfocusout="UpdateInfo()" min="0" max="500" required></td>
                                    </tr>
                                    <tr>
                                        <th scope="row">Mash-In Water</th>
                                        <td>Litres</td>
                                        <td><input type="number" value="${mashWaterVolume}" name="mashWaterVolume" id="mashWaterVolume" onfocusout="UpdateInfo()" min="0" max="500" required></td>


                                    </tr>
                                    <tr>
                                        <th scope="row">Rest Time</th>
                                        <td>Minutes</td>

                                        <td><input type="number" value="${restTime}" name="restTime" id="restTime" onfocusout="UpdateInfo()" min="0" max="500" required></td>
                                    </tr>
                                    <tr>


                                    </tr>
                                    <tr>
                                        <th scope="row">Raise To Temperature</th>
                                        <td>oC</td>
                                        <td><input type="number" value="${raiseToTemp}" name="raiseToTemp" id="raiseToTemp" onfocusout="UpdateInfo()" min="0" max="500" required></td>


                                    </tr>
                                    <tr>
                                        <th scope="row">In Time</th>
                                        <td>Minutes</td>
                                        <td><input type="number" value="${inTime}" name="inTime" id="inTime" min="0" max="500" required></td>
                                    </tr>
                                    <tr>
                                        <th scope="row">Total Mash Time</th>
                                        <td>Minutes</td>
                                        <td><input type="number" value="${totalMashTime}" name="totalMashTime" id="totalMashTime" min="0" max="500" readonly></td>
                                    </tr>

                                </tbody>

                            </table>
                            <h3 class ="brewSteps">Lauter Tun/Kettle</h3>

                            <table class="table">
                                <thead class="thead-dark">
                                    <tr>
                                        <th scope="col">Recipe Attribute</th>
                                        <th scope="col">Units</th>
                                        <th scope="col">Value</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <th scope="row">Underlet</th>
                                        <td>Litres</td>
                                        <td><input type="number" value="${underletLitres}" name="underletLitres" min="0" max="500" required></td>


                                    </tr>
                                    <tr>
                                        <th scope="row">Rest</th>
                                        <td>Minutes</td>
                                        <td><input type="number" value="${lauterTime}" name="lauterRest" min="0" max="500" required></td>
                                    </tr>
                                    <tr>
                                        <th scope="row">Vorlauf</th>
                                        <td>Minutes</td>
                                        <td><input type="number" value="${vorlaufTime}" name="vorlaufTime" min="0" max="500" required></td>
                                    </tr>
                                    <tr>
                                        <th scope="row">First Wort Gravity</th>
                                        <td>oP</td>
                                        <td><input type="number" value="${firstWortGrav}" name="firstWortGrav" min="0" max="500" required></td>
                                    </tr>
                                    <tr>
                                        <th scope="row">Run-Off</th>
                                        <td>Minutes</td>
                                        <td><input type="number" value="${runOffTime}" name="runOffTime" min="0" max="500" required></td>
                                    </tr>
                                    <tr>
                                        <th scope="row">Sparge Volume</th>
                                        <td>Hectolitres</td>
                                        <td><input type="number" value="${spargVol}" name="spargVol" min="0" max="500" required></td>


                                    </tr>

                                    <tr>
                                        <th scope="row">Sparge Temperature</th>
                                        <td>oC</td>
                                        <td><input type="number" value="${spargTemp}" name="spargTemp" min="0" max="500" required></td>


                                    </tr>

                                    <tr>
                                        <th scope="row">Last Runnings Gravity</th>
                                        <td>oP</td>
                                        <td><input type="number" value="${lastRunnings}" name="lastRunnings" min="0" max="500" required></td>
                                    </tr>

                                    <tr>
                                        <th scope="row">Kettle Full Volume</th>
                                        <td>Hectolitres</td>
                                        <td><input type="number" value="${kettleFullVol}" name="kettleFullVol" min="0" max="500" required></td>
                                    </tr>

                                    <tr>
                                        <th scope="row">Kettle Full Gravity</th>
                                        <td>oP</td>
                                        <td><input type="number" value="${kettleFullGrav}" name="kettleFullGrav" min="0" max="500" required></td>
                                    </tr>
                                    <tr>
                                        <th scope="row">Boil Time</th>
                                        <td>Minutes</td>
                                        <td><input type="number" value="${boilTime}" name="boilTime" min="0" max="500" required></td>
                                    </tr>

                                <th scope="row">Kettle Strikeout Volume</th>
                                <td>Hectolitres</td>
                                <td><input type="number" value="${strikeOutVol}" name="strikeOutVol" min="0" max="500" required></td>
                                </tr>
                                <tr>
                                    <th scope="row">Kettle Strikeout Gravity</th>
                                    <td>oP</td>
                                    <td><input type="number" value="${strikeOutGrav}" name="strikeOutGrav" min="0" max="500" required></td>
                                </tr>
                                <tr>
                                    <th scope="row">Whirlpool Time</th>
                                    <td>Minutes</td>
                                    <td><input type="number" value="${whirlPoolTime}" name="whirlPoolTime" min="0" max="500" required></td>

                                </tr>

                                <tr>
                                    <th scope="row">Cool-in Temp</th>
                                    <td>oC</td>
                                    <td><input type="number" value="${coolInTemp}" name="coolInTemp" min="0" max="500" required></td>

                                </tr>
                                <tr>
                                    <th scope="row">Oxygen Rate</th>
                                    <td>Litres Per Minute</td>
                                    <td><input type="number" value="${oxygenRate}" name="oxygenRate" min="0" max="500" required></td>

                                </tr>


                                </tbody>
                            </table>
                            <br>
                            <br>

                            <div class="brewSubmit">
                                <button type="submit" class="btn btn-success" name="newRecipe" style="text-align: center">Add Recipe</button>
                            </div>
                        </form>
                    </c:if>
                    <c:if test="${viewRecipe!=null}">
                        <h1 class="leftSpacingh1">Viewing Recipe : ${viewRecipe.recipeName}</h1>
                        <div class="cancelButton">
                            <form action ="recipe" method ="GET">
                                <button type="submit" class="btn btn-danger" name="cancelRecipe">Back</button>
                            </form>
                        </div>


                        <h3 class ="brewSteps">Raw Materials</h3>

                        <table class="table">

                            <thead class="thead-dark">
                                <tr>
                                    <th scope="col">Recipe Attribute</th>
                                    <th scope="col">Units</th>
                                    <th scope="col">Material Name</th>
                                    <th scope="col">Material Amount</th>
                                </tr>
                            </thead>

                            <tr>
                                <th scope="row">Base Malt</th>
                                <td>kg</td>
                                <td>
                                    ${viewRecipe.baseMalt}
                                </td>
                                <td>${viewRecipe.baseMaltAmt}</td>
                            </tr>

                            <tr>
                                <th scope="row">Second Malt</th>
                                <td>kg</td>
                                <td>
                                    ${viewRecipe.secondMalt}
                                </td>
                                <td>${viewRecipe.secondMaltAmt}</td>
                            </tr>

                            <tr>
                                <th scope="row">Third Malt</th>
                                <td>kg</td>
                                <td>
                                    ${viewRecipe.thirdMalt}
                                </td>
                                <td>${viewRecipe.thirdMaltAmt}</td>
                            </tr>

                            <tr>
                                <th scope="row">Fourth Malt</th>
                                <td>kg</td>
                                <td>
                                    ${viewRecipe.fourthMalt}
                                </td>
                                <td>${viewRecipe.fourthMaltAmt}</td>
                            </tr>

                            <th colspan="4" style ="text-align:center">****HOPS****</th>


                            <tr>
                                <th scope="row">First Hop</th>
                                <td>kg</td>
                                <td>
                                    ${viewRecipe.firstHop}
                                </td>
                                <td>${viewRecipe.firstHopAmt}</td>
                            </tr>
                            <tr>
                                <th scope="row">Second Hop</th>
                                <td>kg</td>
                                <td>
                                    ${viewRecipe.secondHop}
                                </td>
                                <td>${viewRecipe.secondHopAmt}</td>

                            </tr>
                            <tr>
                                <th scope="row">Third Hop</th>
                                <td>kg</td>
                                <td>
                                    ${viewRecipe.thirdHop}
                                </td>
                                <td>${viewRecipe.thirdHopAmt}</td>
                            </tr>

                            </tbody>

                        </table>

                        <h3 class ="brewSteps">Mash Chemistry</h3>

                        <table class="table">

                            <thead class="thead-dark">
                                <tr>
                                    <th scope="col">Name</th>
                                    <th scope="col">Units</th>
                                    <th scope="col">Amount</th>
                                </tr>
                            </thead>

                            <tr>
                                <th scope="row">Sodium Chloride Amount</th>
                                <td>mg</td>
                                <td>${viewRecipe.sodiumChlorideAmt}</td>


                            </tr>


                            <tr>
                                <th scope="row">Gypsum Amount</th>
                                <td>mg</td>
                                <td>${viewRecipe.gypsumAmt}</td>


                            </tr>

                            <tr>
                                <th scope="row">Calcium Chloride Amount</th>
                                <td>mg</td>
                                <td>${viewRecipe.calciumChlorideAmt}</td>


                            </tr>

                            <tr>
                                <th scope="row">Phosphoric Acid Amount</th>
                                <td>ml</td>
                                <td>${viewRecipe.phosphAcidAmt}</td>


                            </tr>


                        </table>


                        <h3 class ="brewSteps">Mash Tun</h3>
                        <table class="table">
                            <thead class="thead-dark">
                                <tr>
                                    <th scope="col">Recipe Attribute</th>
                                    <th scope="col">Units</th>
                                    <th scope="col">Value</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <th scope="row">Mash-In Temperature</th>
                                    <td>oC</td>
                                    <td>${viewRecipe.mashInTemp}</td>



                                </tr>
                                <tr>
                                    <th scope="row">Mash-In Time</th>
                                    <td>Minutes</td>
                                    <td>${viewRecipe.mashInTime}</td>
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
                                </tr>
                                <tr>


                                </tr>
                                <tr>
                                    <th scope="row">Raise To Temperature</th>
                                    <td>oC</td>
                                    <td>${viewRecipe.raiseToTemp}</td>


                                </tr>
                                <tr>
                                    <th scope="row">In Time</th>
                                    <td>Minutes</td>
                                    <td>${viewRecipe.inTime}</td>
                                </tr>
                                <tr>
                                    <th scope="row">Total Mash Time</th>
                                    <td>Minutes</td>
                                    <td>${viewRecipe.totalMashTime}</td>
                                </tr>

                            </tbody>

                        </table>
                        <h3 class ="brewSteps">Lauter Tun/Kettle</h3>

                        <table class="table">
                            <thead class="thead-dark">
                                <tr>
                                    <th scope="col">Recipe Attribute</th>
                                    <th scope="col">Units</th>
                                    <th scope="col">Value</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <th scope="row">Underlet</th>
                                    <td>Litres</td>
                                    <td>${viewRecipe.underletLitres}</td>


                                </tr>
                                <tr>
                                    <th scope="row">Rest</th>
                                    <td>Minutes</td>
                                    <td>${viewRecipe.rest}</td>
                                </tr>
                                <tr>
                                    <th scope="row">Vorlauf</th>
                                    <td>Minutes</td>
                                    <td>${viewRecipe.vorlaufTime}</td>
                                </tr>
                                <tr>
                                    <th scope="row">First Wort Gravity</th>
                                    <td>oP</td>
                                    <td>${viewRecipe.firstWortGrav}</td>
                                </tr>
                                <tr>
                                    <th scope="row">Run-Off</th>
                                    <td>Minutes</td>
                                    <td>${viewRecipe.runOffTime}</td>
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
                                </tr>

                                <tr>
                                    <th scope="row">Kettle Full Volume</th>
                                    <td>Hectolitres</td>
                                    <td>${viewRecipe.kettleFullVol}</td>
                                </tr>

                                <tr>
                                    <th scope="row">Kettle Full Gravity</th>
                                    <td>oP</td>
                                    <td>${viewRecipe.kettleFullGrav}</td>
                                </tr>
                                <tr>
                                    <th scope="row">Boil Time</th>
                                    <td>Minutes</td>
                                    <td>${viewRecipe.boilTime}</td>
                                </tr>

                            <th scope="row">Kettle Strikeout Volume</th>
                            <td>Hectolitres</td>
                            <td>${viewRecipe.strikeOutVol}</td>
                            </tr>
                            <tr>
                                <th scope="row">Kettle Strikeout Gravity</th>
                                <td>oP</td>
                                <td>${viewRecipe.strikeOutGrav}</td>
                            </tr>
                            <tr>
                                <th scope="row">Whirlpool Time</th>
                                <td>Minutes</td>
                                <td>${viewRecipe.whirlPoolTime}</td>

                            </tr>

                            <tr>
                                <th scope="row">Cool-in Temp</th>
                                <td>oC</td>
                                <td>${viewRecipe.coolInTemp}</td>

                            </tr>
                            <tr>
                                <th scope="row">Oxygen Rate</th>
                                <td>Litres Per Minute</td>
                                <td>${viewRecipe.oxygenRate}</td>

                            </tr>


                            </tbody>
                        </table>
                    </c:if>





                </div>
                <br>
                <br>
                <br>






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
    <script src="assets/js/recipe.js"></script>
    <script type="text/javascript">
                                    $(document).ready(function () {
                                        // Javascript method's body can be found in assets/js/demos.js
                                    });
    </script>

</html>


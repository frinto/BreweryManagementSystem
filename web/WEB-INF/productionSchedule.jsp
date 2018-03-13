
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
                            <tr>
                                <th>Date</th>
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
                        <div id="sample">
                            <script type="text/javascript" src="http://js.nicedit.com/nicEdit-latest.js"></script> <script type="text/javascript">
                                    //<![CDATA[
                                    bkLib.onDomLoaded(function () {
                                        var myNicEditor = new nicEditor();
                                        myNicEditor.setPanel('myNicPanel');
                                        myNicEditor.addInstance('myInstance1');
                                        myNicEditor.addInstance('myInstance2');
                                        myNicEditor.addInstance('myInstance3');
                                        myNicEditor.addInstance('myInstance4');
                                        myNicEditor.addInstance('myInstance5');
                                        myNicEditor.addInstance('myInstance6');
                                        myNicEditor.addInstance('myInstance7');
                                        myNicEditor.addInstance('myInstance8');
                                        myNicEditor.addInstance('myInstance9');
                                        myNicEditor.addInstance('myInstance10');
                                        myNicEditor.addInstance('myInstance11');
                                        myNicEditor.addInstance('myInstance12');
                                        myNicEditor.addInstance('myInstance13');
                                        myNicEditor.addInstance('myInstance14');
                                        myNicEditor.addInstance('myInstance15');
                                        myNicEditor.addInstance('myInstance16');
                                        myNicEditor.addInstance('myInstance17');
                                        myNicEditor.addInstance('myInstance18');
                                        myNicEditor.addInstance('myInstance19');
                                        myNicEditor.addInstance('myInstance20');
                                        myNicEditor.addInstance('myInstance21');
                                        myNicEditor.addInstance('myInstance22');
                                        myNicEditor.addInstance('myInstance23');
                                        myNicEditor.addInstance('myInstance24');
                                        myNicEditor.addInstance('myInstance25');
                                        myNicEditor.addInstance('myInstance26');
                                        myNicEditor.addInstance('myInstance27');
                                        myNicEditor.addInstance('myInstance28');
                                        myNicEditor.addInstance('myInstance29');
                                        myNicEditor.addInstance('myInstance30');
                                        myNicEditor.addInstance('myInstance31');
                                        myNicEditor.addInstance('myInstance32');
                                        myNicEditor.addInstance('myInstance33');
                                        myNicEditor.addInstance('myInstance34');
                                        myNicEditor.addInstance('myInstance35');
                                        myNicEditor.addInstance('myInstance36');
                                        myNicEditor.addInstance('myInstance37');
                                        myNicEditor.addInstance('myInstance38');
                                        myNicEditor.addInstance('myInstance39');
                                        myNicEditor.addInstance('myInstance40');
                                        myNicEditor.addInstance('myInstance41');
                                        myNicEditor.addInstance('myInstance42');
                                        myNicEditor.addInstance('myInstance43');
                                        myNicEditor.addInstance('myInstance44');
                                        myNicEditor.addInstance('myInstance45');
                                    });
                                    //]]>
                            </script>
                            <div id="myNicPanel" style="width: 100%;"></div>
                            <tr>
                                <td>Monday</td>
                                <c:forEach var="var" items="${productionSchedules}">
                                    <c:if test="${var.getDayOfWeek() =='monday'}">
                                        <td>
                                            <textarea rows="4" cols="10" id="myInstance1" name="brewMon" form="pForm">${var.brew}</textarea>
                                        </td>
                                        <td>
                                            <textarea rows="4" cols="10" id="myInstance2" name="fvMon" form="pForm">${var.fv}</textarea>
                                        </td>
                                        <td>
                                            <textarea rows="4" cols="10" id="myInstance3" name="ystMon" form="pForm">${var.yst}</textarea>
                                        </td>
                                        <td>
                                            <textarea rows="4" cols="10" id ="myInstance4" name="transferMon" form="pForm">${var.transfer}</textarea>
                                        </td>
                                        <td>
                                            <textarea rows="4" cols="10" id="myInstance5" name="fugeMon" form="pForm">${var.fuge}</textarea>
                                        </td>
                                        <td>
                                            <textarea rows="4" cols="10" id="myInstance6" name="cleanMon" form="pForm">${var.clean}</textarea>
                                        </td>
                                        <td>
                                            <textarea rows="4" cols="10" id="myInstance7" name="kegMon" form="pForm">${var.keg}</textarea>
                                        </td>
                                        <td>
                                            <textarea rows="4" cols="10" id="myInstance8" name="bottleMon" form="pForm">${var.bottle}</textarea>
                                        </td>
                                        <td>
                                            <textarea rows="4" cols="10" id="myInstance9"name="canMon" form="pForm">${var.can}</textarea>
                                        </td>
                                    </c:if>
                                </c:forEach>
                            </tr>
                            <tr>
                                <td>Tuesday</td>
                                <c:forEach var="var" items="${productionSchedules}">
                                    <c:if test="${var.getDayOfWeek() =='tuesday'}">
                                        <td>
                                            <textarea rows="4" cols="10" id="myInstance10" name="brewTues" form="pForm">${var.brew}</textarea>
                                        </td>
                                        <td>
                                            <textarea rows="4" cols="10" id="myInstance11" name="fvTues" form="pForm">${var.fv}</textarea>
                                        </td>
                                        <td>
                                            <textarea rows="4" cols="10" id="myInstance12" name="ystTues" form="pForm">${var.yst}</textarea>
                                        </td>
                                        <td>
                                            <textarea rows="4" cols="10" id="myInstance13" name="transferTues" form="pForm">${var.transfer}</textarea>
                                        </td>
                                        <td>
                                            <textarea rows="4" cols="10" id="myInstance14" name="fugeTues" form="pForm">${var.fuge}</textarea>
                                        </td>
                                        <td>
                                            <textarea rows="4" cols="10" id="myInstance15" name="cleanTues" form="pForm">${var.clean}</textarea>
                                        </td>
                                        <td>
                                            <textarea rows="4" cols="10" id="myInstance16" name="kegTues" form="pForm">${var.keg}</textarea>
                                        </td>
                                        <td>
                                            <textarea rows="4" cols="10" id="myInstance17" name="bottleTues" form="pForm">${var.bottle}</textarea>
                                        </td>
                                        <td>
                                            <textarea rows="4" cols="10" id="myInstance18" name="canTues" form="pForm">${var.can}</textarea>
                                        </td>
                                    </c:if>
                                </c:forEach>
                            </tr>
                            <tr>
                                <td>Wednesday</td>
                                <c:forEach var="var" items="${productionSchedules}">
                                    <c:if test="${var.getDayOfWeek() =='wednesday'}">
                                        <td>
                                            <textarea rows="4" cols="10" id="myInstance19" name="brewWed" form="pForm">${var.brew}</textarea>
                                        </td>
                                        <td>
                                            <textarea rows="4" cols="10" id="myInstance20" name="fvWed" form="pForm">${var.fv}</textarea>
                                        </td>
                                        <td>
                                            <textarea rows="4" cols="10" id="myInstance21" name="ystWed" form="pForm">${var.yst}</textarea>
                                        </td>
                                        <td>
                                            <textarea rows="4" cols="10" id="myInstance22" name="transferWed" form="pForm">${var.transfer}</textarea>
                                        </td>
                                        <td>
                                            <textarea rows="4" cols="10" id="myInstance23" name="fugeWed" form="pForm">${var.fuge}</textarea>
                                        </td>
                                        <td>
                                            <textarea rows="4" cols="10" id="myInstance24" name="cleanWed" form="pForm">${var.clean}</textarea>
                                        </td>
                                        <td>
                                            <textarea rows="4" cols="10" id="myInstance25" name="kegWed" form="pForm">${var.keg}</textarea>
                                        </td>
                                        <td>
                                            <textarea rows="4" cols="10" id="myInstance26" name="bottleWed" form="pForm">${var.bottle}</textarea>
                                        </td>
                                        <td>
                                            <textarea rows="4" cols="10" id="myInstance27" name="canWed" form="pForm">${var.can}</textarea>
                                        </td>
                                    </c:if>
                                </c:forEach>
                            </tr>
                            <tr>
                                <td>Thursday</td>
                                <c:forEach var="var" items="${productionSchedules}">
                                    <c:if test="${var.getDayOfWeek() =='thursday'}">
                                        <td>
                                            <textarea rows="4" cols="10" id="myInstance28" name="brewThurs" form="pForm">${var.brew}</textarea>
                                        </td>
                                        <td>
                                            <textarea rows="4" cols="10" id="myInstance29" name="fvThurs" form="pForm">${var.fv}</textarea>
                                        </td>
                                        <td>
                                            <textarea rows="4" cols="10" id="myInstance30" name="ystThurs" form="pForm">${var.yst}</textarea>
                                        </td>
                                        <td>
                                            <textarea rows="4" cols="10" id="myInstance31" name="transferThurs" form="pForm">${var.transfer}</textarea>
                                        </td>
                                        <td>
                                            <textarea rows="4" cols="10" id="myInstance32" name="fugeThurs" form="pForm">${var.fuge}</textarea>
                                        </td>
                                        <td>
                                            <textarea rows="4" cols="10" id="myInstance33" name="cleanThurs" form="pForm">${var.clean}</textarea>
                                        </td>
                                        <td>
                                            <textarea rows="4" cols="10" id="myInstance34" name="kegThurs" form="pForm">${var.keg}</textarea>
                                        </td>
                                        <td>
                                            <textarea rows="4" cols="10" id="myInstance35" name="bottleThurs" form="pForm">${var.bottle}</textarea>
                                        </td>
                                        <td>
                                            <textarea rows="4" cols="10" id="myInstance36" name="canThurs" form="pForm">${var.can}</textarea>
                                        </td>
                                    </c:if>
                                </c:forEach>
                            </tr>
                            <tr>
                                <td>Friday</td>
                                <c:forEach var="var" items="${productionSchedules}">
                                    <c:if test="${var.getDayOfWeek() =='friday'}">
                                        <td>
                                            <textarea rows="4" cols="10" id="myInstance37" name="brewFri" form="pForm">${var.brew}</textarea>
                                        </td>
                                        <td>
                                            <textarea rows="4" cols="10" id="myInstance38" name="fvFri" form="pForm">${var.fv}</textarea>
                                        </td>
                                        <td>
                                            <textarea rows="4" cols="10" id="myInstance39" name="ystFri" form="pForm">${var.yst}</textarea>
                                        </td>
                                        <td>
                                            <textarea rows="4" cols="10" id="myInstance40" name="transferFri" form="pForm">${var.transfer}</textarea>
                                        </td>
                                        <td>
                                            <textarea rows="4" cols="10" id="myInstance41" name="fugeFri" form="pForm">${var.fuge}</textarea>
                                        </td>
                                        <td>
                                            <textarea rows="4" cols="10" id="myInstance42" name="cleanFri" form="pForm">${var.clean}</textarea>
                                        </td>
                                        <td>
                                            <textarea rows="4" cols="10" id="myInstance43" name="kegFri" form="pForm">${var.keg}</textarea>
                                        </td>
                                        <td>
                                            <textarea rows="4" cols="10" id="myInstance44" name="bottleFri" form="pForm">${var.bottle}</textarea>
                                        </td>
                                        <td>
                                            <textarea rows="4" cols="10" id="myInstance45" name="canFri" form="pForm">${var.can}</textarea>
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

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        
        <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
        <script type="text/javascript">
            // Load the Visualization API and the corechart package.
      google.charts.load('current', {'packages':['corechart']});

      // Set a callback to run when the Google Visualization API is loaded.
      google.charts.setOnLoadCallback(drawChart);

      // Callback that creates and populates a data table,
      // instantiates the chart, passes in the data and
      // draws it.
      function drawChart() {
        
        //------------------ ALL CHARTS LISTED BELOW --------------------------------------------------------
        
        //------------------ Production of Finished Inventory CHART -----------------------------------------
        // Create the data table.
        var productionData = new google.visualization.DataTable();
        productionData.addColumn('string', 'Type');
        productionData.addColumn('number', 'Quantity');
        
        <c:forEach var="production" items="${prodItemListWeek}">
            productionData.addRows([
                ['${production.productionType}', ${production.quantity}]
            ]);
        </c:forEach>
        
        // Set chart options
        var productionOptions = {
                       'width':800,
                       'height':500};
        
        var chartProduction = new google.visualization.ColumnChart(document.getElementById('chart_production'));
        chartProduction.draw(productionData,productionOptions);
        
        $(document).ready(function(){
            //On change of option, display different data
            $(".production-option").change(function() {
                
                var text = this.options[this.selectedIndex].text;
                if (text == "Weekly") {
                    
                    var productionData = new google.visualization.DataTable();
                    productionData.addColumn('string', 'Type');
                    productionData.addColumn('number', 'Quantity');

                    <c:forEach var="production" items="${prodItemListWeek}">
                        productionData.addRows([
                            ['${production.productionType}', ${production.quantity}]
                        ]);
                    </c:forEach>

                    // Set chart options
                    var productionOptions = {
                                   'width':800,
                                   'height':500};

                    var chartProduction = new google.visualization.ColumnChart(document.getElementById('chart_production'));
                    chartProduction.draw(productionData,productionOptions);
                    
                } else if (text == "Monthly") {
                    
                    var productionData = new google.visualization.DataTable();
                    productionData.addColumn('string', 'Type');
                    productionData.addColumn('number', 'Quantity');

                    <c:forEach var="production" items="${prodItemListMonth}">
                        productionData.addRows([
                            ['${production.productionType}', ${production.quantity}]
                        ]);
                    </c:forEach>

                    // Set chart options
                    var productionOptions = {
                                   'width':800,
                                   'height':500};

                    var chartProduction = new google.visualization.ColumnChart(document.getElementById('chart_production'));
                    chartProduction.draw(productionData,productionOptions);
                    
                } else if (text == "Yearly") {
                    
                    var productionData = new google.visualization.DataTable();
                    productionData.addColumn('string', 'Type');
                    productionData.addColumn('number', 'Quantity');

                    <c:forEach var="production" items="${prodItemListYear}">
                        productionData.addRows([
                            ['${production.productionType}', ${production.quantity}]
                        ]);
                    </c:forEach>

                    // Set chart options
                    var productionOptions = {
                                   'width':800,
                                   'height':500};

                    var chartProduction = new google.visualization.ColumnChart(document.getElementById('chart_production'));
                    chartProduction.draw(productionData,productionOptions);
                    
                } else if (text == "All Time") {
                    
                    var productionData = new google.visualization.DataTable();
                    productionData.addColumn('string', 'Type');
                    productionData.addColumn('number', 'Quantity');

                    <c:forEach var="production" items="${prodItemListAllTime}">
                        productionData.addRows([
                            ['${production.productionType}', ${production.quantity}]
                        ]);
                    </c:forEach>

                    // Set chart options
                    var productionOptions = {
                                   'width':800,
                                   'height':500};

                    var chartProduction = new google.visualization.ColumnChart(document.getElementById('chart_production'));
                    chartProduction.draw(productionData,productionOptions);
                }
            });
        });
        
        //------------------- END Production of Finished Inventory CHART ----------------------------------------
        
        
        //--------------------- Total Volume by Brand CHART -----------------------------------------
        // Create the data table.
        var brewVolumeData = new google.visualization.DataTable();
        brewVolumeData.addColumn('string', 'Type');
        brewVolumeData.addColumn('number', 'Volume');
        
        <c:forEach var="brewMap" items="${brewVolumeMapWeek}">
            brewVolumeData.addRows([
                ['${brewMap.key}', ${brewMap.value}]
            ]);
        </c:forEach>
        
        // Set chart options
        var brewVolumeOptions = {
                       'width':800,
                       'height':500};
        var chartBrewVolume = new google.visualization.ColumnChart(document.getElementById('chart_brewVolume'));
        chartBrewVolume.draw(brewVolumeData,brewVolumeOptions);
        
        $(document).ready(function(){
            //On change of option, display different data
            $(".brewVolume-option").change(function() {
                
                var text = this.options[this.selectedIndex].text;
                if (text == "Weekly") {
                    
                    var brewVolumeData = new google.visualization.DataTable();
                    brewVolumeData.addColumn('string', 'Type');
                    brewVolumeData.addColumn('number', 'Volume');

                    <c:forEach var="brewMap" items="${brewVolumeMapWeek}">
                        brewVolumeData.addRows([
                            ['${brewMap.key}', ${brewMap.value}]
                        ]);
                    </c:forEach>

                    // Set chart options
                    var brewVolumeOptions = {
                                   'width':800,
                                   'height':500};
                    var chartBrewVolume = new google.visualization.ColumnChart(document.getElementById('chart_brewVolume'));
                    chartBrewVolume.draw(brewVolumeData,brewVolumeOptions);
                    
                } else if (text == "Monthly") {
                    
                    var brewVolumeData = new google.visualization.DataTable();
                    brewVolumeData.addColumn('string', 'Type');
                    brewVolumeData.addColumn('number', 'Volume');

                    <c:forEach var="brewMap" items="${brewVolumeMapMonth}">
                        brewVolumeData.addRows([
                            ['${brewMap.key}', ${brewMap.value}]
                        ]);
                    </c:forEach>

                    // Set chart options
                    var brewVolumeOptions = {
                                   'width':800,
                                   'height':500};
                    var chartBrewVolume = new google.visualization.ColumnChart(document.getElementById('chart_brewVolume'));
                    chartBrewVolume.draw(brewVolumeData,brewVolumeOptions);
                    
                } else if (text == "Yearly") {
                    
                    var brewVolumeData = new google.visualization.DataTable();
                    brewVolumeData.addColumn('string', 'Type');
                    brewVolumeData.addColumn('number', 'Volume');

                    <c:forEach var="brewMap" items="${brewVolumeMapYear}">
                        brewVolumeData.addRows([
                            ['${brewMap.key}', ${brewMap.value}]
                        ]);
                    </c:forEach>

                    // Set chart options
                    var brewVolumeOptions = {
                                   'width':800,
                                   'height':500};
                    var chartBrewVolume = new google.visualization.ColumnChart(document.getElementById('chart_brewVolume'));
                    chartBrewVolume.draw(brewVolumeData,brewVolumeOptions);
                    
                } else if (text == "All Time") {
                    
                    var brewVolumeData = new google.visualization.DataTable();
                    brewVolumeData.addColumn('string', 'Type');
                    brewVolumeData.addColumn('number', 'Volume (hL)');

                    <c:forEach var="brewMap" items="${brewVolumeMapAllTime}">
                        brewVolumeData.addRows([
                            ['${brewMap.key}', ${brewMap.value}]
                        ]);
                    </c:forEach>

                    // Set chart options
                    var brewVolumeOptions = {
                                   'width':800,
                                   'height':500};
                    var chartBrewVolume = new google.visualization.ColumnChart(document.getElementById('chart_brewVolume'));
                    chartBrewVolume.draw(brewVolumeData,brewVolumeOptions);
                }
            });
        });
        
        //------------------- END Total Volumes by Brand CHART ------------------------------------------------------
        
        
        //--------------------- Loss During Brewing CHART -----------------------------------------
        // Create the data table.
        var brewLossVolumeData = new google.visualization.DataTable();
        brewLossVolumeData.addColumn('string', 'Type');
        brewLossVolumeData.addColumn('number', 'Volume (L)');
        
        <c:forEach var="brewLossMap" items="${brewLossVolumeMapWeek}">
            brewLossVolumeData.addRows([
                ['${brewLossMap.key}', ${brewLossMap.value}]
            ]);
        </c:forEach>
        
        // Set chart options
        var brewLossVolumeOptions = {
                       'width':800,
                       'height':500};
        var chartBrewLossVolume = new google.visualization.ColumnChart(document.getElementById('chart_brewLossVolume'));
        chartBrewLossVolume.draw(brewLossVolumeData,brewLossVolumeOptions);
        
        $(document).ready(function(){
            //On change of option, display different data
            $(".brewLossVolume-option").change(function() {
                
                var text = this.options[this.selectedIndex].text;
                if (text == "Weekly") {
                    
                    var brewLossVolumeData = new google.visualization.DataTable();
                    brewLossVolumeData.addColumn('string', 'Type');
                    brewLossVolumeData.addColumn('number', 'Volume (L)');

                    <c:forEach var="brewLossMap" items="${brewLossVolumeMapWeek}">
                        brewLossVolumeData.addRows([
                            ['${brewLossMap.key}', ${brewLossMap.value}]
                        ]);
                    </c:forEach>

                    // Set chart options
                    var brewLossVolumeOptions = {
                                   'width':800,
                                   'height':500};
                    var chartBrewLossVolume = new google.visualization.ColumnChart(document.getElementById('chart_brewLossVolume'));
                    chartBrewLossVolume.draw(brewLossVolumeData,brewLossVolumeOptions);
                    
                } else if (text == "Monthly") {
                    
                    var brewLossVolumeData = new google.visualization.DataTable();
                    brewLossVolumeData.addColumn('string', 'Type');
                    brewLossVolumeData.addColumn('number', 'Volume (L)');

                    <c:forEach var="brewLossMap" items="${brewLossVolumeMapMonth}">
                        brewLossVolumeData.addRows([
                            ['${brewLossMap.key}', ${brewLossMap.value}]
                        ]);
                    </c:forEach>

                    // Set chart options
                    var brewLossVolumeOptions = {
                                   'width':800,
                                   'height':500};
                    var chartBrewLossVolume = new google.visualization.ColumnChart(document.getElementById('chart_brewLossVolume'));
                    chartBrewLossVolume.draw(brewLossVolumeData,brewLossVolumeOptions);
                    
                } else if (text == "Yearly") {
                    
                    var brewLossVolumeData = new google.visualization.DataTable();
                    brewLossVolumeData.addColumn('string', 'Type');
                    brewLossVolumeData.addColumn('number', 'Volume (L)');

                    <c:forEach var="brewLossMap" items="${brewLossVolumeMapYear}">
                        brewLossVolumeData.addRows([
                            ['${brewLossMap.key}', ${brewLossMap.value}]
                        ]);
                    </c:forEach>

                    // Set chart options
                    var brewLossVolumeOptions = {
                                   'width':800,
                                   'height':500};
                    var chartBrewLossVolume = new google.visualization.ColumnChart(document.getElementById('chart_brewLossVolume'));
                    chartBrewLossVolume.draw(brewLossVolumeData,brewLossVolumeOptions);
                } else if (text == "All Time") {
                    
                    var brewLossVolumeData = new google.visualization.DataTable();
                    brewLossVolumeData.addColumn('string', 'Type');
                    brewLossVolumeData.addColumn('number', 'Volume (L)');

                    <c:forEach var="brewLossMap" items="${brewLossVolumeMapAllTime}">
                        brewLossVolumeData.addRows([
                            ['${brewLossMap.key}', ${brewLossMap.value}]
                        ]);
                    </c:forEach>

                    // Set chart options
                    var brewLossVolumeOptions = {
                                   'width':800,
                                   'height':500};
                    var chartBrewLossVolume = new google.visualization.ColumnChart(document.getElementById('chart_brewLossVolume'));
                    chartBrewLossVolume.draw(brewLossVolumeData,brewLossVolumeOptions);
                }
            });
        });
        // -------------------- END Loss During Brewing CHART --------------------------------------------------- 
        
                
//        //------------------- Finished Inventory CHART --------------------------------------------------------
//        
//        var titleFinishedInventory = '${reportDataFinishedInventory}';
//        
//        // Create the data table.
//        var dataFinishedInventory = new google.visualization.DataTable();
//        dataFinishedInventory.addColumn('string', 'Topping');
//        dataFinishedInventory.addColumn('number', 'Slices');
//        
//        <c:forEach var="productName" items="${finishedProducts}">
//            dataFinishedInventory.addRows([
//                ['${productName.productName}', ${productName.qty}]
//            ]);
//        </c:forEach>
//        
//
//        // Set chart options
//        var optionsFinishedInventory = {'title':titleFinishedInventory,
//                       'width':400,
//                       'height':400};
//
//        // Instantiate and draw our chart, passing in some options.
//        var chartFinishedInventory = new google.visualization.PieChart(document.getElementById('chart_finishedInventory'));
//        chartFinishedInventory.draw(dataFinishedInventory, optionsFinishedInventory);
//        
//        //----------------- END Finished Inventory CHART ------------------------------------------------------------------
//
//        
//        
//        
//        
//        //----------------START PROD MAT CHART----------------------------------------------------------------------
//        
//        var titleProductionMaterials = '${reportDataProductionMaterials}';
//        
//        // Create the data table.
//        var dataProductionMaterials = new google.visualization.DataTable();
//        dataProductionMaterials.addColumn('string', 'Topping');
//        dataProductionMaterials.addColumn('number', 'Slices');
//        
//        <c:forEach var="prodMatList" items="${productionMaterials}">
//            dataProductionMaterials.addRows([
//                ['${prodMatList.name}', ${prodMatList.qty}]
//            ]);
//        </c:forEach>
//        
//
//        // Set chart options
//        var optionsProductionMaterials = {'title':titleProductionMaterials,
//                       'width':600,
//                       'height':600};
//
//        // Instantiate and draw our chart, passing in some options.
//        var chartProdMat = new google.visualization.PieChart(document.getElementById('chart_productionMaterials'));
//        chartProdMat.draw(dataProductionMaterials, optionsProductionMaterials);
//        
//        //-----------------END PROD MAT CHART------------------------------------------------------------------
//        
//        
//        //---------------------Start brew materials-----------------------------------------------------------------------
//        
//        var titleBrewMaterials = '${reportDataBrewMaterials}';
//        
//        // Create the data table.
//        var dataBrewMaterials = new google.visualization.DataTable();
//        dataBrewMaterials.addColumn('string', 'Topping');
//        dataBrewMaterials.addColumn('number', 'Slices');
//        
//        <c:forEach var="brewList" items="${brewMaterials}">
//            dataBrewMaterials.addRows([
//                ['${brewList.name}', ${brewList.qty}]
//            ]);
//        </c:forEach>
//        
//
//        // Set chart options
//        var optionsBrewMaterials = {'title':titleBrewMaterials,
//                       'width':600,
//                       'height':600};
//
//        // Instantiate and draw our chart, passing in some options.
//        var chartBrewMat = new google.visualization.PieChart(document.getElementById('chart_brewMaterials'));
//        chartBrewMat.draw(dataBrewMaterials, optionsBrewMaterials);
//        
//        //-----------------------END BREW MATERIALS-------------------------------------------------------------------
        
      }
        </script>
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
                        <li class="nav-item">
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
                        <li class="nav-item">
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
                        <li class="nav-item active">
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
                        <a class="navbar-brand">Reports</a>
                        <div class="btn-group" style="margin-right: 50px">
                            <button type="button" class="btn btn-secondary dropdown-toggle"  data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                ${currentEmployee.firstName} ${currentEmployee.lastName}
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
          
          <!--- Displaying the Charts along with their Titles and Customizable options ------>     
                
          <div class='row' align='center'>
            <div class='col-3'></div>  
            <div class='col-4'>
                <h4>Production of Finished Inventory</h4>
            </div>
            <div class='col-2'>
              <div class="form-row" style='padding-top: 10%'>
                <select class="form-control production-option" >
                  <option>Weekly</option>
                  <option>Monthly</option>
                  <option>Yearly</option>
                  <option>All Time</option>
                </select>
              </div>
            </div>
            <div class='col-3'></div>  
          </div>
          
          <div id="chart_production" align="center"></div>
          
          <hr>
          <div class='row' align='center'>
            <div class='col-3'></div>  
            <div class='col-4'>
                <h4>Total Volumes Brewed per Brand</h4>
            </div>
            <div class='col-2'>
                <div class="form-group" style='padding-top: 18%'>
                    <select class="form-control brewVolume-option">
                      <option>Weekly</option>
                      <option>Monthly</option>
                      <option>Yearly</option>
                      <option>All Time</option>
                    </select>
                  </div>
            </div>
            <div class='col-3'></div>  
          </div>
          
          <div id="chart_brewVolume" align="center"></div>
          
          <hr>
          <div class='row' align='center'>
            <div class='col-3'></div>  
            <div class='col-4'>
                <h4>Volume of Gains/Losses (+/-) from FV to SV</h4>
            </div>
            <div class='col-2'>
                <div class="form-group" style='padding-top: 18%'>
                    <select class="form-control brewLossVolume-option">
                      <option>Weekly</option>
                      <option>Monthly</option>
                      <option>Yearly</option>
                      <option>All Time</option>
                    </select>
                  </div>
            </div>
            <div class='col-3'></div>  
          </div>
          
          <div id="chart_brewLossVolume" align="center"></div>
            
<!--          <div id="chart_finishedInventory" align="center"></div>
          
          <div id="chart_productionMaterials" align="center"></div>
          
          <div id="chart_brewMaterials" align="center"></div>-->

                
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
    <!-- Light Bootstrap Dashboard DEMO methods, don't include it in your project! -->
    <script src="assets/js/demo.js"></script>
    
<!--        <script>
        document.getElementById("chart_production_option").addEventListener("change", function() {
            var menu = document.getElementById("chart_production_option");
            var text = menu.options[menu.selectedIndex].text;
            if (text == "Monthly") {
                alert(text);
            }
        });
        </script>-->
</html>

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
      // instantiates the pie chart, passes in the data and
      // draws it.
      function drawChart() {
        
        var reportData = '${reportData}';
        
        // Create the data table.
        var data = new google.visualization.DataTable();
        data.addColumn('string', 'Topping');
        data.addColumn('number', 'Slices');
        data.addRows([
          ['Mushrooms', 3],
          ['Onions', 1],
          ['Olives', 1],
          ['Zucchini', 1],
          ['Pepperoni', 2]
        ]);

        // Set chart options
        var options = {'title':reportData,
                       'width':400,
                       'height':300};

        // Instantiate and draw our chart, passing in some options.
        var chart = new google.visualization.PieChart(document.getElementById('chart_div'));
        chart.draw(data, options);
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
                    </ul>
                </div>
            </div>
            <div class="main-panel">
                <!-- Navbar -->
                <nav class="navbar navbar-expand-lg " color-on-scroll="500">
                    <div class=" container-fluid  ">
                        <a class="navbar-brand">Reports</a>
                        <div class="btn-group">
                            <button type="button" class="btn btn-secondary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Matthew
                            </button>
                            <div class="dropdown-menu dropdown-menu-right">
                                <button class="dropdown-item" type="button">Logout</button>
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
        
          <div id="chart_div"></div>
                
                
                
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
</html>
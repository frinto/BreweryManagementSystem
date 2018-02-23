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
            
            <!-- start sidebar -->
            <div class="sidebar" data-image="../assets/img/sidebar-5.jpg" data-color="red">

                <!--
            Tip 1: You can change the color of the sidebar using: data-color="purple | blue | green | orange | red"
    
            Tip 2: you can also add an image using data-image tag
                -->
                <div class="sidebar-wrapper">
                    <div class="logo">
                        <image src ="assets/img/logo.jpg">
                    </div>
                    <ul class="nav">
                        <li class="nav-item active">
                            <a class="nav-link" href="tankFarm">
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
                                <p>Raw Goods Inventory</p>
                            </a>
                        </li>
                        <li>
                            <a class="nav-link" href="recipe">
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
            
            <!-- start main page -->
            <div class="main-panel">
                <!-- Navbar -->
                <nav class="navbar navbar-expand-lg " color-on-scroll="500">
                    <div class=" container-fluid  ">
                        <a class="navbar-brand"> Tank Farm </a>
                        <button href="" class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" aria-controls="navigation-index" aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-bar burger-lines"></span>
                            <span class="navbar-toggler-bar burger-lines"></span>
                            <span class="navbar-toggler-bar burger-lines"></span>
                        </button>
                    </div>
                </nav>
                <!-- End Navbar -->
        
        <!-- List of Tabs -->
        <ul class="nav nav-tabs" id="myTab" role="tablist">
            <li class="nav-item">
                <a class="nav-link active" id="home-tab" data-toggle="tab" href="#tankStatus" role="tab" aria-controls="tankStatus" aria-selected="true">Tank Status</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" id="profile-tab" data-toggle="tab" href="#transferLog" role="tab" aria-controls="transferLog" aria-selected="false">Transfer Log</a>
            </li>
        </ul>
        
        <!-- Tank Tab Content -->
        <div class="tab-content" id="myTabContent">
          <div class="tab-pane fade show active" id="tankStatus" role="tabpanel" aria-labelledby="tankStatus-tab">
              ${message}
              <div class="row">
                <div class="col text-center">
                  <h2>SV Tanks</h2>
                </div>
                <div class="col text-right">
                    <form>
                    <button type="button" class="btn btn-success" data-toggle="modal" data-target="#myModalTank" style="margin-top:5%;margin-right:3%">Add A New Tank</button>
                    </form>
                </div>
              </div>
                <table class="table" style="margin-top: 0%">
                    <thead class="thead-dark">
                        <tr>
                            <th>SV ID</th>
                            <th>Volume</th>
                            <th>Capacity</th>
                            <th>Brew 1</th>
                            <th>Brew 2</th>
                            <th>Brew 3</th>
                            <th>Brand</th>
                            <th>Status</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="sv" items="${svs}">
                            <tr>
                                <td>${sv.svId}</td>
                                <td>${sv.volume}</td>
                                <td>${sv.capacity}</td>
                                <td>${sv.brew1}</td>
                                <td>${sv.brew2}</td>
                                <td>${sv.brew3}</td>
                                <td>${sv.brand}</td>
                                <td>${sv.status}</td>
                                <td>
                                    <form action="tankFarm?action=editSv" method="POST">
                                        <button type="submit">Edit</button>
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
              <div class="row">
                  <div class="col text-center">
                      <h2>FV Tanks</h2>
                  </div>
                  <div class="col">
                  </div>
              </div>
              <table class="table" style="margin-top: 0%">
                    <thead class="thead-dark">
                        <tr>
                            <th>FV ID</th>
                            <th>Volume</th>
                            <th>Capacity</th>
                            <th>Brew 1</th>
                            <th>Brew 2</th>
                            <th>Brew 3</th>
                            <th>Brand</th>
                            <th>Status</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
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
                                <td>
                                    <form action="tankFarm?action=editFv" method="POST">
                                        <button type="submit">Edit</button>
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
              <!-- Add A Tank Modal -->
              <div id="myModalTank" class="modal fade" role="dialog">
                    <div class="modal-dialog" style="max-width:1000px">

                    <!-- Modal content-->
                    <div class="modal-content" style="width:100%">
                      <div class="modal-header" >
                        <h4 class="modal-title" style="text-align:center;width:100%">Add A New Tank</h4>
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                      </div>
                      <div class="modal-body">
                        <!-- Table for user input -->
                        <form action="tankFarm?action=addTank" method="POST">
                            <table class="table">
                                <thead class="thead-dark">
                                    <tr>
                                        <th>Tank Type</th>
                                        <th>Capacity</th>
                                    </tr>
                                </thead>
                              <tbody>
                                  <tr>
                                      <td>
                                          <div class="radio-inline">
                                              <label style="padding-right:2rem"><input type="radio" name="tankType" checked>SV</label>
                                            <label><input type="radio" name="tankType">FV</label>
                                          </div>
                                      </td>
                                      <td><input type="number" name="capacity" required/></td>
                                  </tr>
                                <tr>${tankMessage}</tr>
                              </tbody>
                            </table>
                            <button type="submit" class="btn btn-success">Submit</button>
                        </form>
                      </div> <!-- end Modal Body -->
                      <div class="modal-footer">
                      </div>
                    </div>
                  </div>
                </div>
          </div>
          
          <!-- Transfer Tab -->
          <div class="tab-pane fade" id="transferLog" role="tabpanel" aria-labelledby="transferLog-tab">
                
              <!-- 'Add A Transfer' button -->

                <!-- Trigger the modal with a button -->
                <div class="text-center">
                  <button type="button" class="btn btn-success" data-toggle="modal" data-target="#myModalTransfer" style="margin-top:2%">Add A New Transfer</button>
                </div>

                <!-- User Feedback Message -->
                ${message}

                <!-- Modal -->
                <div id="myModalTransfer" class="modal fade" role="dialog">
                    <div class="modal-dialog" style="max-width:1000px">

                    <!-- Modal content-->
                    <div class="modal-content" style="width:100%">
                      <div class="modal-header" >
                        <h4 class="modal-title" style="text-align:center;width:100%">Add A New Transfer</h4>
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                      </div>
                      <div class="modal-body">
                        <!-- Table for user input -->
                        <form action="tankFarm?action=addTransfer" method="POST">
                            <table class="table">
                              <thead class="thead-dark">
                                <tr>
                                    <th>Date</th>
                                    <th>From FV</th>
                                    <th>To SV</th>
                                    <th>Volume (L)</th>
                                    <th>Emptying FV? <a class="helpInfo" style="font-size:10px" href="#" data-toggle="tooltip" title="If the FV is being emptied, then the system well calculate any loss for this brew.">Help</a></th>
                                </tr>
                              </thead>
                              <tbody>
                                <tr>
                                    <td><input type="date" name="date" value="${dateToday}"/></td>
                                    <td><input type="number" name="fromFV" value="${inputFV}" required/></td>
                                    <td><input type="number" name="toSV" value="${inputSV}" required/></td>
                                    <td><input type="number" name="volume" value="${inputVolume}" required/></td>
                                    <td><input type="checkbox" name="isEmpty" ${checkedIsEmpty}/></td>
                                </tr>
                                <tr>${capacityMessage}</tr>
                              </tbody>
                            </table>
                            <button type="submit" class="btn btn-success">Submit</button>
                        </form>
                      </div> <!-- end Modal Body -->
                      <div class="modal-footer">
                      </div>
                    </div>
                  </div>
                </div>

                <!-- main page table for displaying transfers -->
                <table class="table" style="margin-top: 2%">
                    <thead class="thead-dark">
                        <tr>
                            <th>Date</th>
                            <th>Brand</th>
                            <th>FV</th>
                            <th>SV</th>
                            <th>Volume</th>
                            <th>Correction</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="transfer" items="${transfers}">
                        <tr>
                            <td>${transfer.date}</td>
                            <td>${transfer.brand}</td>
                            <td>${transfer.fromFv}</td>
                            <td>${transfer.toSv}</td>
                            <td>${transfer.volume}</td>
                            <td>${transfer.correction}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
          </div>
        </div>
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
    
    <!-- script to open modal if requested from back-end based on loadAddTransfer being set-->
    <c:if test="${loadAddTransfer != null}">
        <script type="text/javascript">
            $(window).on('load',function(){
                $('#myModal').modal('show');
            });
        </script>
    </c:if>
</html>

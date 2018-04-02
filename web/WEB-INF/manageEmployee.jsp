<%-- 
    Document   : users
    Created on : Nov 1, 2017, 2:02:39 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
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
    <body>
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
                    <a class="navbar-brand">Manage Employee</a>
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


            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <h4>Employee List</h4>
                        <div class="table-responsive">
                            <table id="mytable" class="table table-bordred table-striped">
                                <thead>
                                <th>empId</th>
                                <th>firstName</th>
                                <th>lastName</th>
                                <th>password</th>
                                <th>email</th>
                                <th>roleId</th>
                                <th>isActive</th>
                                <th>resetPasswordUUID</th>
                                <th></th>
                                </thead>
                                <c:forEach var="item" items="${users}">
                                    <tbody>
                                        <tr>
                                            <td><c:out value="${item.empId}"/></td>
                                            <td><c:out value="${item.firstName}"/></td>
                                            <td><c:out value="${item.lastName}"/></td>
                                            <td><c:out value="${item.password}"/></td>
                                            <td><c:out value="${item.email}"/></td>
                                            <td><c:out value="${item.roleId}"/></td>
                                            <td><c:out value="${item.isActive}"/></td>
                                            <td><c:out value="${item.resetPasswordUUID}"/></td>
                                            <td>
                                                <form action="manageEmployee" method="get">
                                                    <input type="submit" value="Edit"><span class="glyphicon glyphicon-pencil"></span>
                                                    <input type="hidden" name="action" value="viewEdit">
                                                    <input type="hidden" name="selectedUser" value="${item.empId}">
                                                </form>
                                            </td>
                                        </tr>  
                                    </tbody>
                                </c:forEach>
                            </table>
                        </div>
                    </div>
                </div>

                <form action="manageEmployee" method="get">
                    <input type="submit" value="Add"><span class="glyphicon glyphicon-pencil"></span>
                    <input type="hidden" name="action" value="viewAdd">
                    <input type="hidden" name="selectedUserAdd" value="value">
                </form>



                <c:if test="${selectedUserAdd != null}">
                    <div class="row">
                        <div class="col-md-4">
                            <form action="manageEmployee" method="post" class="form-horizontal" role="form">
                                <fieldset>

                                    <!-- Form Name -->
                                    <legend>Add User</legend>

                                    <!-- Text input-->
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label" for="textinput">First name</label>
                                        <div class="col-sm-10">
                                            <input type="text" name="firstName"  class="form-control">
                                        </div>
                                    </div>

                                    <!-- Text input-->
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label" for="textinput">Last Name</label>
                                        <div class="col-sm-10">
                                            <input type="text" name="lastName"  class="form-control">
                                        </div>
                                    </div>

                                    <!-- Text input-->
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label" for="textinput">password</label>
                                        <div class="col-sm-4">
                                            <input type="password" name="password"  class=form-control>
                                        </div>

                                        <label class="col-sm-2 control-label" for="textinput">email</label>
                                        <div class="col-sm-4">
                                            <input type="text" name="email"  class=form-control>
                                        </div>
                                    </div>

                                    <!-- Text input-->
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label" for="textinput">Role ID</label>
                                        <div class="col-sm-4">
                                            <input type="number" name="roleId"   class=form-control>
                                        </div>

                                        <label class="col-sm-2 control-label" for="textinput">isActive</label>
                                        <div class="col-sm-4">
                                            <input type="number" name="isActive"  class=form-control>
                                        </div>
                                    </div>

                                    <!-- Text input-->
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label" for="textinput">reset Password UUID</label>
                                        <div class="col-sm-10">
                                            <input type="number" name="resetPasswordUUID" class=form-control>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="col-sm-offset-2 col-sm-10">
                                            <div class="pull-right">
                                                <input type="hidden" name="action" value="add">
                                                <input type="submit" value="Add User"  class="btn btn-primary">
                                            </div>
                                        </div>
                                    </div>

                                </fieldset>
                            </form>
                        </div><!-- /.col-lg-12 -->
                    </c:if>
                    <c:if test="${selectedUser != null}">
                        <div class="col-md-4">
                            <form action="manageEmployee" method="post" class="form-horizontal" role="form">
                                <fieldset>

                                    <!-- Form Name -->
                                    <legend>Edit User</legend>

                                    <!-- Text input-->
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label" for="textinput">empId</label>
                                        <div class="col-sm-10">
                                            <input type="text" name="empId" value="${selectedUser.empId}" readonly class="form-control">
                                        </div>
                                    </div>

                                    <!-- Text input-->
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label" for="textinput">First name</label>
                                        <div class="col-sm-10">
                                            <input type="text" name="firstName" value="${selectedUser.firstName}" class="form-control">
                                        </div>
                                    </div>

                                    <!-- Text input-->
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label" for="textinput">Last Name</label>
                                        <div class="col-sm-10">
                                            <input type="text" name="lastName" value="${selectedUser.lastName}" class="form-control">
                                        </div>
                                    </div>

                                    <!-- Text input-->
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label" for="textinput">password</label>
                                        <div class="col-sm-4">
                                            <input type="password" name="password" value="${selectedUser.password}" class=form-control>
                                        </div>

                                        <label class="col-sm-2 control-label" for="textinput">email</label>
                                        <div class="col-sm-4">
                                            <input type="text" name="email" value="${selectedUser.email}" class=form-control>
                                        </div>
                                    </div>

                                    <!-- Text input-->
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label" for="textinput">Role ID</label>
                                        <div class="col-sm-4">
                                            <input type="number" name="roleId"  value="${selectedUser.roleId}" class=form-control>
                                        </div>

                                        <label class="col-sm-2 control-label" for="textinput">isActive</label>
                                        <div class="col-sm-4">
                                            <input type="number" name="isActive" value="${selectedUser.isActive}" class=form-control>
                                        </div>
                                    </div>

                                    <!-- Text input-->
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label" for="textinput">reset Password UUID</label>
                                        <div class="col-sm-10">
                                            <input type="number" name="resetPasswordUUID" value="${selectedUser.resetPasswordUUID}" class=form-control>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="col-sm-offset-2 col-sm-10">
                                            <div class="pull-right">
                                                <input type="hidden" name="action" value="edit">
                                                <input type="submit" value="Save" class="btn btn-primary">
                                            </div>
                                        </div>
                                    </div>

                                </fieldset>
                            </form>
                        </div><!-- /.col-lg-12 -->
                    </c:if>
                </div><!-- /.row -->
            </div><br>
        </div><br>
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

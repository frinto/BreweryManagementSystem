
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <title>BMS</title> 
        <c:import url="/WEB-INF/includes/sidebar.html"/>
        <!-- start main panel and top header text-->    
    <div class="main-panel">
                <!-- Navbar -->
                <nav class="navbar navbar-expand-lg " color-on-scroll="500">
                    <div class=" container-fluid  ">
                        <a class="navbar-brand">FV to SV Tank Transfer</a>
                        <button href="" class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" aria-controls="navigation-index" aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-bar burger-lines"></span>
                            <span class="navbar-toggler-bar burger-lines"></span>
                            <span class="navbar-toggler-bar burger-lines"></span>
                        </button>
                    </div>
                </nav>
                
    <!-- start page functionality -->
    
    
    

    <div>
        <!-- 'Add A Transfer' button -->
        
        <!-- Trigger the modal with a button -->
        <div class="text-center">
          <button type="button" class="btn btn-success" data-toggle="modal" data-target="#myModal">Add A Transfer</button>
          ${message}
          ${capacityMessage}
        </div>

        <!-- Modal -->
        <div id="myModal" class="modal fade" role="dialog">
            <div class="modal-dialog" style="max-width:1000px">

            <!-- Modal content-->
            <div class="modal-content" style="width:100%">
                <div class="modal-header" >
                  <h4 class="modal-title" style="text-align:center;width:100%">Add A Transfer</h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
              </div>
              <div class="modal-body">
                <form action="tankTransfer?action=add" method="POST">
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
              </div>
              <div class="modal-footer">
              </div>
            </div>

          </div>
        </div>
        
<!--        <div class="row">
            <div class="col-12">
                <form action="tankTransfer?action=add" method="POST">
                    <button type="submit">Add a Transfer</button>
                </form>
            </div>
        </div>-->
        
        <!-- start the table -->
        <table class="table">
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
${message}
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
    <!-- script to open modal if requested from back-end -->
    <c:if test="${loadAddTransfer != null}">
        <script type="text/javascript">
        $(window).on('load',function(){
            $('#myModal').modal('show');
        });
        </script>
    </c:if>
</html>

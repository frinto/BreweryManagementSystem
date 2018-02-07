<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <title>BMS</title> 
        <c:import url="/WEB-INF/includes/sidebar.html"/>


    <h1>Finished Inventory</h1>

    <div>
        <table class="table">
            <thead class="thead-dark">
                <tr>
                    <th>Product Name</th>
                    <th>Quantity</th>
                </tr>
            </thead>
            </tbody>
            <c:forEach var="productName" items="${finishedProducts}">
                <tr>
                    <td>${productName.productName}</td>
                    <td>${productName.qty}</td>
                </tr>
            </c:forEach>
        </table>
    </table>
</div>

${message}
</div>
</div>
</body>
<c:import url="includes/footer.html"/>
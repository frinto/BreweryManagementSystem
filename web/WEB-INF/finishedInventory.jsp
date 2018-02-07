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
                    <th>Update</th>
                </tr>
            </thead>
            </tbody>
            <form action="finishedInventory?action=update" method="post">
                <c:forEach var="productName" items="${finishedProducts}" varStatus="status">
                    <tr>
                        <td>${productName.productName}</td>
                        <td>${productName.qty}</td>
                        <td>
                            <input type="number" id="${status.index}" value="${updatedCount}">
                        </td>
                    </tr>
                </c:forEach>
        </table>
        <input type="submit" value="Update">
        </form>



    </div>
</div>
</div>
</body>
<c:import url="includes/footer.html"/>
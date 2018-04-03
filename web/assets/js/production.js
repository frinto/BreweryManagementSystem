$(document).ready(function () {
    document.getElementById('datePicker').valueAsDate = new Date();
});

$(window).on('load', function () {
    $('#myModal').modal('show');
});

function addARow() {
    //grab the location that we are going to add the input box to
    var form = document.getElementById("newProductionTypeForm");
    var table = form.getElementsByTagName("table") [0];

    //generate the elements we are adding
    var tr = document.createElement("tr");

    //generate our select box
    var td1 = document.createElement("td");
    //this will be used in for our quantity box
    var td2 = document.createElement("td");
    var usage = document.getElementById("usage");
    var duplicateO = usage.cloneNode(true);
    var duplicate = duplicateO;
    //usage.setAttribute("value","NONE");

    //add to our tr
    td1.appendChild(duplicate);
    tr.appendChild(td1);

    //generate our quantity box this uses the previously created td2
    var qty = document.createElement("input");
    qty.setAttribute("type", "number");
    qty.setAttribute("min", "0");
    //                                        qty.setAttribute("value", "0");
    qty.setAttribute("name", "qty");
    qty.setAttribute("id", "qty");
    qty.setAttribute("placeholder", "quantity");
    qty.setAttribute("style", "width:100%");

    //add to our tr
    td2.appendChild(qty);
    tr.appendChild(td2);
    //add to page
    table.appendChild(tr);
}
function removeARow() {
    var form = document.getElementById("newTypeTable");
    if (form.lastChild === form.getElementsByTagName("tbody") [0]) {
        
    }
    else{
        form.removeChild(form.lastChild);
    }
//    form.removeChild(form.lastChild);
}
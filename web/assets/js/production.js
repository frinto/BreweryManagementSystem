$(document).ready(function () {
    document.getElementById('datePicker').valueAsDate = new Date();
});

$(window).on('load', function () {
    $('#myModal').modal('show');
});
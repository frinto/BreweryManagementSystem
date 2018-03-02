
   
   $(function() {
  $("#inTime").change(function() {
    var a =($("#inTime").val());
    var b = ($("#mashInTime").val());
    var c = ($("#restTime").val());
    a = parseFloat(a);
    
    if(b==="")
    {
        b=0;
    }
    else
        b = parseFloat(b);
    
    if(c==="")
    {
        c=0;
    }
    else
        c = parseFloat(c);
    
    var d = a+b+c;
    $('#totalMashTime').val(d);


  });
});

    $(function() {
  $("#mashInTime").change(function() {
    var a =($("#mashInTime").val());
    var b = ($("#inTime").val());
    var c = ($("#restTime").val());
    a = parseFloat(a);
    
    if(b==="")
    {
        b=0;
    }
    else
        b = parseFloat(b);
    
    if(c==="")
    {
        c=0;
    }
    else
        c = parseFloat(c);
    
    var d = a+b+c;
    $('#totalMashTime').val(d);


  });
});

   $(function() {
  $("#restTime").change(function() {
    var a =($("#restTime").val());
    var b = ($("#inTime").val());
    var c = ($("#mashInTime").val());
    a = parseFloat(a);
    
    if(b==="")
    {
        b=0;
    }
    else
        b = parseFloat(b);
    
    if(c==="")
    {
        c=0;
    }
    else
        c = parseFloat(c);
    
    var d = a+b+c;
    $('#totalMashTime').val(d);


  });
});

$(document).ready( function() {
document.getElementById('datePicker').valueAsDate = new Date();
});

  $(window).on('load',function(){
        $('#myModal').modal('show');
    });
    

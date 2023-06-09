function validationName (name){
    const regexp = /^[a-zA-ZæøåÆØÅ. \-]{2,20}$/;
    if(!regexp.test(name)){
        $("#failName").html("Bad validation")
        return false;
    }
    else
        $("#failName").html("")
        return true;
}

function validationEmail (email){
    const regexp = /^[a-zA-Z.@ 0-9\-]{2,20}$/;
    if(!regexp.test(email)){
        $("#failEmail").html("Bad validation")
        return false;
    }
    else
        $("#failEmail").html("")
    return true;

}

function validationPhone (phone){
    const regexp = /^[0-9]{3,8}$/;
    if(!regexp.test(phone)){
        $("#failPhone").html("Bad validation")
        return false;
    }
    else
        $("#failPhone").html("")
    return true;

}

function validationTable (table){
    const regexp = /^[0-50]{1,2}$/;
    if(!regexp.test(table)){
        $("#failTable").html("Bad validation")
        return false;
    }
    else
        $("#failTable").html("")
    return true;

}

function validationItems (item){
    const regexp = /^[0-9,]{0,8}$/;
    if(!regexp.test(item)){
        $("#failItem").html("Bad validation")
        return false;
    }
    else
        $("#failItem").html("")
    return true;

}

function display(id, message, timeout){
    $("#" + id).html(message).fadeIn();
    setTimeout(function() {
        $("#" + id).fadeOut();
    }, timeout);
}

function saveReservation(){
    // navn = $("#navn").val();
    // mobil = $("#phone").val();
    // email = $("#email").val();
    // bord = $("#bord").val();
    // vare = $("#vare").val();

    nameOk = validationName($('#name').val());
    phoneOk = validationPhone($('#phone').val());
    emailOk = validationEmail($('#email').val());
    tableOk = validationTable($('#table').val());
    itemOk = validationItems($('#items').val());

    if(nameOk && phoneOk && emailOk && tableOk && itemOk){
        let reservation = {
            name: $('#name').val(),
            phone: $('#phone').val(),
            email: $('#email').val(),
            table: $('#table').val(),
            item: $('#items').val()
        };

       // $.ajax({
         //   url: "/lagre",
         //   method: "POST",
         //   data: bestilling,
         //   success: function (){
         //       $("#melding").html("Bestilling er sendt")
         //   }
       // })
        $.get("/check", {phone: $("#phone").val(), email: $("#email").val() } , function (data){
            if (data.phoneExists && data.emailExists) {
                display("message", "Phone number and email are already in use", 3000);
            } else if (data.phoneExists) {
                display("message", "Phone number is already in use", 3000);
            } else if (data.emailExists) {
                display("message", "Email is already in use", 3000);
            } else
                $.post("/save",reservation, function (){
                    display("message", "Reservation is sent", 3000);
                    console.log(reservation)
                }) .fail(function (jqXHR){
                    const json = $.parseJSON(jqXHR.responseText);
                    $('#message').html("Internal Server Error, Try again later")
                    console.log(json.message)
                });
        })


    }
    else
        display("message","Something went wrong", 3000);
    console.log(nameOk, phoneOk, emailOk, tableOk,itemOk);

}
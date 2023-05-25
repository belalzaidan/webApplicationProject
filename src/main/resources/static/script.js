function valideringNavn (navn){
    const regexp = /^[a-zA-ZæøåÆØÅ. \-]{2,20}$/;
    if(!regexp.test(navn)){
        $("#feilnavn").html("يا خرا شنو هذا")
        return false;
    }
    else
        $("#feilnavn").html("")
        return true;
}

function valideringEpost (epost){
    const regexp = /^[a-zA-Z.@ 0-9\-]{2,20}$/;
    if(!regexp.test(epost)){
        $("#feilepost").html("يا خرا شنو هذا")
        return false;
    }
    else
        $("#feilepost").html("")
    return true;

}

function valideringTelefon (telefon){
    const regexp = /^[0-9]{3,8}$/;
    if(!regexp.test(telefon)){
        $("#feitelefon").html("يا خرا شنو هذا")
        return false;
    }
    else
        $("#feiltelefon").html("")
    return true;

}

function valideringBord (bord){
    const regexp = /^[0-50]{1,2}$/;
    if(!regexp.test(bord)){
        $("#feilbord").html("يا خرا شنو هذا")
        return false;
    }
    else
        $("#feilbord").html("")
    return true;

}

function valideringVare (vare){
    const regexp = /^[0-9]{0,8}$/;
    if(!regexp.test(vare)){
        $("#feilvare").html("يا خرا شنو هذا")
        return false;
    }
    else
        $("#feilvare").html("")
    return true;

}

function lagreBestilling(){
    // navn = $("#navn").val();
    // mobil = $("#phone").val();
    // email = $("#email").val();
    // bord = $("#bord").val();
    // vare = $("#vare").val();

    navnOk = valideringNavn($('#navn').val());
    telefonOk = valideringTelefon($('#phone').val());
    epostOk = valideringEpost($('#email').val());
    bordOk = valideringBord($('#bord').val());
    vareOk = valideringVare($('#vare').val());

    if(navnOk && telefonOk && epostOk && bordOk && vareOk){
        let bestilling = {
            navn: $('#navn').val(),
            telefon: $('#phone').val(),
            epost: $('#email').val(),
            bord: $('#bord').val(),
            vare: $('#vare').val()
        };

       // $.ajax({
         //   url: "/lagre",
         //   method: "POST",
         //   data: bestilling,
         //   success: function (){
         //       $("#melding").html("Bestilling er sendt")
         //   }
       // })
        $.get("/sjekk/" + $("#phone").val(), function (data){
            if(!data){
                $("#melding").html("Telefonnummeret er allerede i bruk")
            }
            else
                $.post("/lagre",bestilling, function (){
                    $("#melding").html("Bestilling er sendt")
                    console.log(bestilling)
                }) .fail(function (jqXHR){
                        const json = $.parseJSON(jqXHR.responseText);
                        $('#melding').html("Internal Server Error, Try again later")
                    console.log(json.message)
                });
        })


    }
    else
        $("#melding").html("something went wrong")
    console.log(navnOk, telefonOk, epostOk, bordOk,vareOk);

}
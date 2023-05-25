function validering(input){
    const regexp = /^a-zA-ZæøåÆØÅ#%&@0-9 \-$/;
    if(!regexp.test){
        $('#melding').html("bad validation")
        return false
    } else
        $('#melding').html('')
        return true
}


function login(){
    brukernavnOK = validering($('#username').val());
    passwordOK = validering($('#password').val());

    if (brukernavnOK && passwordOK){

    }
}
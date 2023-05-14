//oppgave1

$(()=>{ //ready function
    console.log("ready!")



    $("#register").click(
        () =>  {
            //lager object av pakken
            let pakken = {
                fornavn : $("#fornavn").val(),
                etternavn : document.getElementById("etternavn"),
                adresse : $("#adresse").val(),
                Postnr : $("#postnr").val(),
                telefonnr : $("#telefonnr").val(),
                epost : $("#epost").val(),
                volum  : $("#volum").val(),
                vekt : $("#vekt").val()
            }
            if(vailderPakkeFE(pakken)){ //validering
                lagre(pakken) //kaller på lagre funksjonen
            }
        })

})
//1 a)
function lagre(pakke){
    $.get("/lagre", pakke, (data) => { //sender request til server
        print(data)
    })
}
function vailderPakkeFE(pakke){
    //javascript rexexp
    const regexpfnavn = /^[a-zæøåA-ZÆØÅ]{2,50}$
    const regexpenavn = /^[a-zæøåA-ZÆØÅ]{2,50}$
    const regexppostnr = /^[0-9]{4}$

    if (regexpenavn.test(pakke.etternavn), regexpfnavn.test(pakke.fornavn), regexppostnr.test(pakke.Postnr)){
        return true; //alt riktig,return true

    } else {
        //validering for hver enkel
        if (!regexpenavn.test(pakke.etternavn)) {
            alert("Feil i  etternavnet")
            return false
        }
        if (!regexpfnavn.test(pakke.fornavn)) {
            alert("feil i fornavn")
            return false
        }
        if (!regexppostnr.test(pakke.Postnr) && sjekkPostnr(pakke)) {
            alert("feil i postnr")
            return false
        }
    }

}
function lagre(pakke){
    //lagrer pakken med get
    $.get("/lagre", pakke, pakke.telefonnr , function (data) {
        print(data)
    })
}

function sjekkPostnr(pakke){
    //sjekkker bostnummer, skal returnere bool
    $.get("/sjekkPostnr", pakken.Postnr, function (data) {
return data
    })
}


$.ajax(
    {
        url: "http://localhost:8080/slett",
        type :"DELETE",
        sucess :  (data) =>{
            //her skjer det ting når det er suksess
        },
        error: (error) => {
            //nå skjer det noe galt her (hjelp)
        }
    }
)
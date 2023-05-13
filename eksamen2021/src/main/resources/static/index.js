//oppgave1

$(()=>{
    console.log("ready!")



    $("#register").click(
        () =>  {
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
            lagre(pakken)})
})
//1 a)
function lagre(pakke){
    $.get("/lagre", pakke, (data) => {
        print(data)
    })
}
function lagre(pakke){
    $.get("/lagre", pakke, pakke.telefonnr , function (data) {
        print(data)
    })
}
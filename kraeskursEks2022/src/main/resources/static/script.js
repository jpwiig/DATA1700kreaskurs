
//ready function
$(() => {
    let bestilling = {
        name : $("name").val(),
        phone : $("phone").val(),
        email : $("mail").val(),
        table : $("table").val(),
        goods : $("goods").val()
    }
    if (err(bestilling)){
        bestill(bestilling)
    }

})
function bestill (obj){
    if (err(obj)) {
        $.post("/bestill", obj, () => {
            console.log("ok")
        }).fail( const json = $.parseJSON(jqXHR.responseText), (json) => {
            alert(json)
        }
    )
    }
}

function err (obj){
    const regexpName =  /^[a-zæøåA-ZÆØÅ]{0,255}$/;
    const regexpphone = /^[0-9]{8}$/;
    const regexpmail = /^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/; //yoinka fra nettet
    const table = /^[0-9]{0,3}$/

    if (regexpName.test(obj.name) && regexpphone.test(obj.phone) && regexpmail.test(obj.email) && table.test(obj.table)) {
        return true
    } else {
        if (!regexpName.test(obj.name)) $("namerr").html("Please write a name with only letters").style("red")
        if (!regexpphone.test(obj.phone)) $("phoneerr").html("Please write a phone number").style("red")
        if (!regexpmail.test(obj.email)) $("mailerr").html("write a propper email with: mail@provider.domaine").style("red")
        if (!table.test(obj.table)) $("tableerr").html("please write a number between 0 and 999").style("red")
        return false;
    }
}
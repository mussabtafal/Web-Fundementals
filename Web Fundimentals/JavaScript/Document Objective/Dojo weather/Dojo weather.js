function hide(e) {
    e.parentElement.remove();
}

var tday1  = document.querySelector("#td1")
var tnight1 = document.querySelector("#tn1")
var tday2 = document.querySelector("#td2")
var tnight2 = document.querySelector("#tn2")
var tday3 = document.querySelector("#td3")
var tnight3 = document.querySelector("#tn3")
var tday4 = document.querySelector("#td4")
var tnight4 = document.querySelector("#tn4")

// function tempC_F() {
    
//     tday1.innerHTML = "75";
//     tnight1.innerHTML = "65";
//     tday2.innerHTML = "80";
//     tnight2.innerHTML = "66";
//     tday3.innerHTML = "69";
//     tnight3.innerHTML = "61";
//     tday4.innerHTML = "78";
//     tnight4.innerHTML = "70";
// }



function tempC_F() {
    var selection = document.getElementById("selection").value
    console.log("****")
    // console.log(tday1, tnight1)
    console.log(selection)
    if (selection == "C") {
        console.log("C is wokring fine")
        tday1.innerHTML = "24&#176";
        tnight1.innerHTML = "18&#176";
        tday2.innerHTML = "27&#176";
        tnight2.innerHTML = "19&#176";
        tday3.innerHTML = "21&#176";
        tnight3.innerHTML = "16&#176";
        tday4.innerHTML = "26&#176";
        tnight4.innerHTML = "21&#176";
    } 

    else if (selection == "F") {
        console.log("F is wokring fine")
        tday1.innerHTML = "75&#176";
        tnight1.innerHTML = "65&#176";
        tday2.innerHTML = "80&#176";
        tnight2.innerHTML = "66&#176";
        tday3.innerHTML = "69&#176";
        tnight3.innerHTML = "61&#176";
        tday4.innerHTML = "78&#176";
        tnight4.innerHTML = "70&#176";
    }
}

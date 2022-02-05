var footer = document.querySelector("footer")
function hide(e) {
    footer.remove();
}

// var tday1  = document.querySelector("#td1")
// var tnight1 = document.querySelector("#tn1")
// var tday2 = document.querySelector("#td2")
// var tnight2 = document.querySelector("#tn2")
// var tday3 = document.querySelector("#td3")
// var tnight3 = document.querySelector("#tn3")
// var tday4 = document.querySelector("#td4")
// var tnight4 = document.querySelector("#tn4")

// function tempC_F (element) {
//     var selection = document.getElementById("selection").value
//     if ( selection == "F"){
//         console.log("F is wokring fine")
//         var td1 = parseInt(tday1.innerHTML)
//         tday1.innerHTML = Math.round(td1* 1.8 + 32);
//         console.log (td1)

//         var tn1 = parseInt(tnight1.innerHTML)
//         tnight1.innerHTML = Math.round(tn1* 1.8 + 32);
//         console.log (tn1)

//         var td2 = parseInt(tday2.innerHTML)
//         tday2.innerHTML = Math.round(td2* 1.8 + 32);
//         console.log (td2)

//         var tn2 = parseInt(tnight2.innerHTML)
//         tnight2.innerHTML = Math.round(tn2* 1.8 + 32);
//         console.log (tn2)

//         var td3 = parseInt(tday3.innerHTML)
//         tday3.innerHTML = Math.round(td3* 1.8 + 32);
//         console.log (td3)

//         var tn3 = parseInt(tnight3.innerHTML)
//         tnight3.innerHTML = Math.round(tn3* 1.8 + 32);
//         console.log (tn3)

//         var td4 = parseInt(tday4.innerHTML)
//         tday4.innerHTML = Math.round(td4* 1.8 + 32);
//         console.log (td4)

//         var tn4 = parseInt(tnight4.innerHTML)
//         tnight4.innerHTML = Math.round(tn4* 1.8 + 32);
//         console.log (tn4)
//     }

//     else if ( selection == "C") {
//         console.log("F is wokring fine")
//         var td1 = parseInt(tday1.innerHTML)
//         tday1.innerHTML = Math.round((td1 -32)/1.8);
//         console.log (td1)

//         var tn1 = parseInt(tnight1.innerHTML)
//         tnight1.innerHTML = Math.round((tn1 -32)/1.8);
//         console.log (tn1)

//         var td2 = parseInt(tday2.innerHTML)
//         tday2.innerHTML = Math.round((td2 -32)/1.8);
//         console.log (td2)

//         var tn2 = parseInt(tnight2.innerHTML)
//         tnight2.innerHTML = Math.round((tn2 -32)/1.8);
//         console.log (tn2)

//         var td3 = parseInt(tday3.innerHTML)
//         tday3.innerHTML = Math.round((td3 -32)/1.8);
//         console.log (td3)

//         var tn3 = parseInt(tnight3.innerHTML)
//         tnight3.innerHTML = Math.round((tn3 -32)/1.8);
//         console.log (tn3)

//         var td4 = parseInt(tday4.innerHTML)
//         tday4.innerHTML = Math.round((td4 -32)/1.8);
//         console.log (td4)

//         var tn4 = parseInt(tnight4.innerHTML)
//         tnight4.innerHTML = Math.round((tn4 -32)/1.8);
//         console.log (tn4)
//     }
// }


function tempC_F(element){
    for(var i = 1; i < 9; i++){
        var t = document.querySelector("#t"+i);
        console.log(t);
        if(selection == "F"){
            t.innerText= Math.round((parseInt(t.innerText))*9/5+32);
        }
        else{
            t.innerText= Math.round((parseInt(t.innerText)-32)*5/9);
        }
    }
    }


var addition1 = document.querySelector(".scores .score1 .pscore_ninja")
var addition2 = document.querySelector(".scores .score2 .pscore_pirates")

function add1(e) {
    addition1.innerHTML++
}

function add2(e) {
    addition2.innerHTML++
}

function hide(e) {
    e.parentElement.remove();
}

function message() {
    alert("The Ninjas Have Won !")  
}

setTimeout(message, 13000);

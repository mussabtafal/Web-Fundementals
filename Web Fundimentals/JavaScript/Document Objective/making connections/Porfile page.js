//Function 1 remove request on click
function removeRequest(e) {
    e.parentElement.parentElement.remove();
}

//Function 2 Change the name on click
var name = document.querySelector(".usercard H1")
function changeName(e) {
    name.innerHTML = "Oday Qasrawi"
}
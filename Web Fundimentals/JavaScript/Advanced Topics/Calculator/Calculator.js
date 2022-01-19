
var display = document.getElementById("display");
var num1 = "";
var num2 = "";
var op = "";

console.log(display.innerHTML);
function press(num) {
    num1 += num;
    display.innerHTML = num1;
}

function setOP(key) {
    op = key;
    num2 = num1;
    num1 = "";
}

function clr() {
    num1 = "";
    num2 = "";
    op = "";
    display.innerHTML = "0";
}

function calculate() {
    var a = parseInt(num2);
    var b = parseInt(num1);
    var res = 0;
    switch (op) {
        case "+":
            res = a + b;
            break;
        case "-":
            res = a - b;
            break;
        case "*":
            res = a * b;
            break;
        case "/":
            res = a / b;
            break;
    }

    num1 = res;
    op = "";
    display.innerHTML = res;
}
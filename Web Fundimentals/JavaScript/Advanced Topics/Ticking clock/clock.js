function getSecondsSinceStartOfDay() {
    return new Date().getSeconds() +
        new Date().getMinutes() * 60 +
        new Date().getHours() * 3600;
}

function Sangle {
    var s = new Date().getSeconds() * 6
}

function Mangle {
    var m = new Date().getMinutes() * 6
}

function Hangle {
    var h = new Date().getHours() * 6
}
new Date().getSeconds() * 6
var minutesDeg = new Date().getMinutes() * 6
var hoursDeg = new Date().getHours() * 30

setInterval(function() {
        var time = getSecondsSinceStartOfDay();
        console.log(time);

        // your code here
        // document.getElementById("#minutes").style.transform = "rotate(minutes)";
        // document.getElementById("#hours").style.transform = "rotate(hours)";
    },
    1000);
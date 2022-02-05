var reversedarr = [];

function reverseString(str) {
    var array = str.split(",");
    for (var i = array.length - 1; i >= 0; i--) {
        reversedarr.push(array[i]);
    }
    var reversed = reversedarr.join();
    console.log(array)
    console.log(reversed)
    return reversed;
}
console.log(reverseString('creature'));

// function reverseString(str) {
//     var newString = "";
//     for (var i = str.length - 1; i >= 0; i--) {
//         newString += str[i];
//     }
//     return newString;
// }
// console.log(reverseString('creature'));
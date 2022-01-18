// **************Array 1***************************
var food = "";
var counter = 0

function alwaysHungry(arr) {
    // your code here 
    for (var i = 0; i < arr.length; i++){
        if (arr[i] == "food") {
            foods += "yummy ";
            counter++
        }
    }
    console.log(foods)
    if (counter == 0) {
        console.log("I'm hungry");
    }
}

    
alwaysHungry([3.14, "food", "pie", true, "food"]);
// this should console log "yummy", "yummy"
alwaysHungry([4, 1, 5, 7, 2]);
// this should console log "I'm hungry"

// **************Array 2***************************
function highPass(arr, cutoff) {
    var filteredArr = [];
    // your code here
    for ( var i = 0; i < arr.length; i++){
        if (arr[i] > cutoff) {
            filteredArr.push(arr[i]);
        }
    }
    return filteredArr;
}
var result = highPass([6, 8, 3, 10, -2, 5, 9], 5);
console.log(result); // we expect back [6, 8, 10, 9]

// **************Array 3***************************

function betterThanAverage(arr) {
    var sum = 0;
    // calculate the average
    var count = 0
    // count how many values are greated than the average
    for (var i = 0; i < arr.length; i++){
        sum = sum + arr[i];
    }
    average = sum/arr.length;
    for(i = 0; i < arr.length; i++) {
        if(arr[i]>average){
            count++
        }
    }
    return count;
}
var result = betterThanAverage([6, 8, 3, 10, -2, 5, 9]);
console.log(result); // we expect back 4

// **************Array 4***************************

function reverse(arr) {
    // your code here
    var temp = [];
    for (var i = arr.length-1; i >= 0; i--){
        temp.push(arr[i])
    }
    arr = temp;
    return arr;
}
   
var result = reverse(["a", "b", "c", "d", "e"]);
console.log(result); // we expect back ["e", "d", "c", "b", "a"]

// **************Array 5***************************

function fibonacciArray(n) {
    // the [0, 1] are the starting values of the array to calculate the rest from
    var fibArr = [0, 1];
    var sum = 0
    // your code here
    for ( var i = 2; i < n; i++) {
    sum = fibArr[i-1] + fibArr[i-2]
    fibArr[i] = sum;
    }
    return fibArr;
}
   
var result = fibonacciArray(40);
console.log(result); // we expect back [0, 1, 1, 2, 3, 5, 8, 13, 21, 34]


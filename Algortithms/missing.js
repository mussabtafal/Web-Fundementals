
    var sum = 0;
    var sum1 = 0;
    var arr = [5,6,7,8,9,11,12,13];  

    function missingNumber (arr) {
        sum1 = (arr.length + 1)* (arr.length + 2)/2;
        for ( var i = 0; i < arr.length; i++) {
                sum = sum + arr[i];
    }
    missing = sum1 - sum;
    
    console.log(sum)
    console.log(sum1)
    console.log(missing)
    return missing;
}
missingNumber(arr);

var array = [ 1,2,3,4,5]

    function addarray(array, value) {
    var template = [value];
    for(var i=0; i<array.length;i++) {
        template[i+1] = array[i];
    }
    console.log(template);
    }
    
    addarray(array,8);




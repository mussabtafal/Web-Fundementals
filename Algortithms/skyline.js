



function skyline(heights) {
var visible = [];
var heighest = heights[0];
    if(heights[0] > 0){
        visible.push(heighest);
    }

    for ( i = 1; i < heights.length; i++){  
        if (heights[i] > heighest){
            heighest = heights[i];
            visible.push(heighest)
        }
    }  
    return visible;
}
    console.log(skyline([-1,5,3,2,1,8]));

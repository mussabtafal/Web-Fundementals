
var minutecounter = 0
var hourcounter = 0
for (var i = 0; i =< 20260; i+=60) {

    minutecounter +=1

    if ( minutecounter % 60 == 0) {
        hountercounter +=1
        minutercounter = 0
    }
    
}
var newstring = "";

function removeSpaces(string) {

    for (var i = 0; i < string.length; i++) {
        if (string[i] != (" ") && string[i] != (",") && string[i] != (".")) {
            newstring += string[i];
        }
    }
    return newstring;

}
console.log(removeSpaces("play that, Funky Music. "));
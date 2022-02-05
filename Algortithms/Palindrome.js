var revarray = []

function Palindrome(str) {
    for (var i = 0; i < (str.length) / 2; i++) {
        if (str[i] != str[str.length - 1 - i]) {
            return ('no')
        }
    }
    return ('yes')
}

Palindrome("geeks")
Palindrome("malayalam")
var array = [];

function balanced(string) {
    for (var i = 0; i < string.length; i++) {
        if (string[i] == "(") {
            array.push('(');
        } else if (string[i] == ")") {
            array.pop('(');
        }
    }
    if (array.length == 0) {
        return true;
    } else {
        return false;
    }
}

console.log(balanced("y(3(p)p(3)r)s"))
console.log(balanced("n(0(p)3"))
console.log(balanced("n(0(p)3"))



// let stack = [];

// function Balanced(expr) {
//     for (var i = 0; i < expr.length; i++) {
//         var x = expr[i];

//         if (x == '(' || x == '[' || x == '{') {
//             stack.push(x);
//             continue;
//         }

//         if (stack.length == 0)
//             return false;
//     }

// }
// // // Traversing the Expression
// // for (let i = 0; i < expr.length; i++) {
// //     let x = expr[i];

// //     if (x == '(' || x == '[' || x == '{') {

// //         // Push the element in the stack
// //         stack.push(x);
// //         continue;
// //     }

// //     // If current character is not opening
// //     // bracket, then it must be closing. 
// //     // So stack cannot be empty at this point.
// //     if (stack.length == 0)
// //         return false;

// //     let check;
// //     switch (x) {
// //         case ')':
// //             check = stack.pop();
// //             if (check == '{' || check == '[')
// //                 return false;
// //             break;

// //         case '}':
// //             check = stack.pop();
// //             if (check == '(' || check == '[')
// //                 return false;
// //             break;

// //         case ']':
// //             check = stack.pop();
// //             if (check == '(' || check == '{')
// //                 return false;
// //             break;
// //     }
// // }

// // // Check Empty Stack
// // return (stack.length == 0);
// // }

// // // Driver code
// // var expr = "([{}])";

// // // Function call
// // if (areBracketsBalanced(expr))
// //     document.write("Balanced ");
// // else
// //     document.write("Not Balanced ");
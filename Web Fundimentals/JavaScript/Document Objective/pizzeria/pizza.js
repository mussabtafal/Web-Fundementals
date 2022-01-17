// Function
function pizzaOven(crustType, sauceType, cheeses, toppings) {
    var pizza = {};
    pizza.crust = crustType;
    pizza.sauce = sauceType;
    pizza.cheeses = cheeses;
    pizza.toppings = toppings;
    return pizza;
}
    
// Pizza 1
var pizza1 = pizzaOven("deep dish", "traditional", ["mozzarella"], ["pepperoni", "sausage"]);

function pizzaOven(crustType, sauceType, cheeses, toppings) {
    var pizza = {};
    pizza.crust = crustType;
    pizza.sauce = sauceType;
    pizza.cheeses = cheeses;
    pizza.toppings = toppings;
    return pizza;
}
console.log(pizza1);

// pizza 2
var pizza2 = pizzaOven("hand tossed", "marinara", ["mozzarella", "feta"], ["mushrooms", "olives", "onions"]) 
console.log(pizza2);
    

// pizza 3
var pizza3 = pizzaOven("Stuffed Crust", "ranch sauce", ["margaritta", "Cheddar"], ["mushrooms", "Bell Pepper", "onions"]) 
console.log(pizza3);

// pizza 4
var pizza4 = pizzaOven("San Francisco crust", "Barbeque sauce", ["mozzarella", "Blue cheese"], ["BBQ Chicken", "Black Olives"]) 
console.log(pizza4);

// pizza 5 - random pizza
var crustType = ["San Francisco crust","Stuffed Crust","hand tossed","deep dish"];
var sauceType = ["Barbeque sauce", "marinara", "ranch sauce", "Barbeque sauce","Honey mustard sauce"];
var cheeses = ["mozzarella", "feta", "Blue cheese", "Cheddar", "margaritta"];
var toppings = ["BBQ Chicken", "Black Olives", "mushrooms", "olives", "onions"];

function pizzaOven(crustType, sauceType, cheeses, toppings) {
    var pizza = {};
    pizza.crustType = crustType[Math.floor(Math.random() *3) ];
    pizza.sauceType = sauceType[Math.floor(Math.random() *4) ];
    pizza.cheeses = cheeses[Math.floor(Math.random() *4) ];
    pizza.toppings = [toppings[Math.floor(Math.random() *4)], toppings[Math.floor(Math.random() *4)], toppings[Math.floor(Math.random() *4)]];
    return pizza;
}
    
var Pizza = pizzaOven(crustType, sauceType, cheeses, toppings);
console.log(Pizza);

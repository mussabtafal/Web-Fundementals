
class Ninja {
    constructor(name, health) {
        this.name = name;
        this.health = health;
        this.speed = 3;
        this.strength = 3;
    }

    sayName() {
        console.log(`The ninja's name is ${this.name}`);
    }

    showStats() {
        console.log(`The ninja's name is ${this.name} and has a speed of ${this.speed} and has a Strength of ${this.strength} and the ninja's health is ${this.health}`);
    }

    drinkSake() {
        this.health += 10;
    }
}

class Sensei extends Ninja {
    constructor(name){
        super(name, 200);    
        this.speed = 10;
        this.strength = 10;
        this.wisdom = 10;
    }
    speakWisdom() {
        this.drinkSake();
        console.log("What one programmer can do in one month, two programmers can do in two months.")
    }
}

const superSensei = new Sensei("Master Splinter");
superSensei.speakWisdom()
superSensei.showStats();

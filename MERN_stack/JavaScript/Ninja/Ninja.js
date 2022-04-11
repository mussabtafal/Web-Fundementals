
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

const ninja1 = new Ninja("Hyabusa", 100);
ninja1.sayName();
ninja1.drinkSake();
ninja1.showStats();

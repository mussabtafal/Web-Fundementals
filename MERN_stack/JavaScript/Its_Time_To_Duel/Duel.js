class Card {
    constructor(name,cost) {
        this.name = name;
        this.cost = cost;
    }
}

class Unit extends Card{
    constructor(name, cost, power, resilence) {
        super(name, cost);
        this.power = power;
        this.resilence = resilence;
        this.text = `Power: ${this.power} \nResilence: ${this.resilence}`
    }

    attack(target) {
        if( target instanceof Unit ) {
            target.resilence -= this.power;
        } else {
            throw new Error( "Target must be a unit!" );
        }
    }
}

class Effect extends Card{
    constructor(name, cost, stat, magnitude) {
        super(name, cost)
        this.stat = stat;
        this.magnitude = magnitude;
        let mod = "";
        if (magnitude > 0) {
            mod = "Raise";
        } else {
            mod = "Lower";
        }
        this.text = `${mod} the target's ${this.stat} by ${this.magnitude}`;
    }

    play(target) {
        if( target instanceof Unit ) {
            if (this.stat == "Resilience") {
                target.resilence += this.magnitude;
            }else if (this.stat == "Power"){
                target.power += this.magnitude;
            } else {
                console.log("This is not an Option idiot !");
            }
        } else {
            throw new Error( "Target must be a unit!" );
        }
    }
}

const redNinja = new Unit("Red Belt Ninja", 3, 3, 4);
const hardAlg = new Effect ("Hard Algorithm", 2, "Resilience", 3);
hardAlg.play(redNinja);
console.log(redNinja);
const blackNinja = new Unit("Black Belt Ninja", 4, 5, 4);
const unhandledProm = new Effect ("Unhandeled Promise Rejection", 1, "Resilience", -2);
unhandledProm.play(redNinja);
console.log(redNinja);
const pairProg = new Effect ("Pair Programming", 3, "Power", 2);
pairProg.play(redNinja);
console.log(redNinja);
redNinja.attack(blackNinja);
console.log(blackNinja);




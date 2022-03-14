package com.codingdojo.projectzoo;

public class GiantBat extends Mammal{
	
	public GiantBat (int energyLevel) {
	    this.energyLevel = energyLevel;
	}
	
	public Integer fly() {
		System.out.println("Bat Swoosh Swish Swoosh Swish !!");
		energyLevel -= 50;
		return energyLevel;
	}
	
	public Integer eatHumans() {
		System.out.println("num num num num !");
		energyLevel += 25;
		return energyLevel;
	}
	
	public Integer attackTown() {
		System.out.println("Sizzle Sizzle Sizzle Swish Swoosh Crack");
		energyLevel -= 100;
		return energyLevel;
	}
}

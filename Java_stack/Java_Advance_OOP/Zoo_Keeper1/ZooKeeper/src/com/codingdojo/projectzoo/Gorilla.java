package com.codingdojo.projectzoo;

public class Gorilla extends Mammal{
	
	public Integer throwSomething() {
		System.out.println("Carefull!! The Gorilla has thrown something !");
		energyLevel -= 5;
		return energyLevel;
	}
	
	public Integer eatBananas() {
		System.out.println("The Gorilla is very Happy !");
		energyLevel += 10;
		return energyLevel;
	}
	
	public Integer climb() {
		System.out.println("Care, The Gorilla is Climbing a Tree !");
		energyLevel -= 10;
		return energyLevel;
	}
}

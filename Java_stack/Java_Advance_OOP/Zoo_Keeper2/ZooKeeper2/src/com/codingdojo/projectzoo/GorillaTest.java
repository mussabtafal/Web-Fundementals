package com.codingdojo.projectzoo;
public class GorillaTest {

	public static void main(String[] args) {
		Gorilla gorilla1 = new Gorilla(100);
		
		gorilla1.throwSomething();
		gorilla1.throwSomething();
		gorilla1.throwSomething();
		gorilla1.displayEnergy();
		
		gorilla1.eatBananas();
		gorilla1.eatBananas();
		gorilla1.displayEnergy();
		
		gorilla1.climb();
		gorilla1.displayEnergy();

	}

}

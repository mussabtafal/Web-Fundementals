package com.codingdojo.projectzoo;

public class BatTest {

	public static void main(String[] args) {
		
		GiantBat GiantBat1 = new GiantBat(300);
		
		GiantBat1.attackTown();
		GiantBat1.attackTown();
		GiantBat1.attackTown();
		GiantBat1.displayEnergy();
		
		GiantBat1.eatHumans();
		GiantBat1.eatHumans();
		GiantBat1.displayEnergy();
		
		GiantBat1.fly();
		GiantBat1.fly();
		GiantBat1.displayEnergy();
		
	}

}

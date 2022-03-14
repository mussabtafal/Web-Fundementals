package com.codingdojo.calculator;

public class CalTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		calculator op1 = new calculator();
		op1.setFirstNum(10);
		op1.setSecondNum(20);
		op1.setOperator("+");
		op1.performOperation();
		op1.getResults();
		
		calculator op2 = new calculator();
		op2.setFirstNum(15.2);
		op2.setSecondNum(17.4);
		op2.setOperator("-");
		op2.performOperation();
		op2.getResults();
	}

}

package com.codingdojo.calculator;

public class calculator {
	private double firstNum;
	private double secondNum;
	private String Operator;
	private double Result;
	
	public calculator(){
	    }
    public calculator(Double firstNum, Double secondNum, String Operator){
        this.firstNum = firstNum;
        this.secondNum = secondNum;
        this.Operator = Operator;
    }
    
    public Double performOperation() {
    	if (this.Operator == "+") {
    		this.Result = this.firstNum + this.secondNum;
    	}
    	else if (this.Operator == "-") {
    		this.Result = this.firstNum - this.secondNum;
    	}	
    	return this.Result;
    }
    
    public void getResults() {
    	System.out.println(this.Result);
    }

    public Double getFirstNum() {
    	return firstNum;
    }
    public void setFirstNum(double firstNum) {
    	this.firstNum = firstNum;
    }
	public Double getSecondNum() {
		return secondNum;
	}
	public void setSecondNum(double secondNum) {
		this.secondNum = secondNum;
	}
	public String getOperator() {
		return Operator;
	}
	public void setOperator(String operator) {
		Operator = operator;
	}
	public Double getResult() {
		return Result;
	}
	public void setResult(Double result) {
		Result = result;
	}

}

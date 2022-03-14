package comd.codingdojo.calculator2;

import java.util.ArrayList;

public class calculator {
	ArrayList<Double> nums = new ArrayList<Double>();
	ArrayList<String> operations = new ArrayList<String>();
	
	public calculator(){
	    }
	
    public calculator(double num){
        nums.add(num);
    }
    
    public calculator(String operator){
        operations.add(operator);
    }
}

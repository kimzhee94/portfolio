package calculator;

import java.util.*;

public class NumberVO {

	private String firstNum;
	private String secondNum;
	private String operator;
	private String inputValue;
	
	public void setFirstNum(int value) {
		firstNum = Integer.toString(value);
	}
	
	public String getFirstNum() {
		return firstNum;
	}
	
	public void setSecondNum(int value) {
		secondNum = Integer.toString(value);
	}
	
	public String getSecondNum() {
		return secondNum;
	}
	
	public void setInputValue(String value) {
		inputValue = value;
	}
	
	public String getInputValue() {
		return inputValue;
	}

	public void setOperator(String value) {
		operator = value;
	}
	
	public String getOperator() {
		return operator;
	}
	
}

package calculator;

import java.util.*;

public class Calculator {

	private String firstNum;
	private String secondNum;
	private String operator;
	private String[] operatorArr = {"+", "-", "*", "/"};
	
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
	
	public String chechOperator(String inputValue) {
		String msg = "";
		List<String> operatorList = Arrays.asList(operatorArr);
		
		if(operatorList.indexOf(inputValue) < 0) {
			return "※ 사칙 연산자만 입력하세요!(+, -, *, /)";
		}
		
		operator = inputValue;
		return msg;
	}
	
	public String operate() {
		int first = Integer.parseInt(firstNum);
		int second = Integer.parseInt(secondNum);
		int result;
		String resultMsg = "";
		
		if("+".equals(operator)) {
			result = first + second;
		} else if("-".equals(operator)) {
			result = first - second;
		} else if("*".equals(operator)) {
			result = first * second;
		} else {
			result = first / second;
		}
		
		resultMsg = firstNum + operator + secondNum + "=" + result;
		firstNum = Integer.toString(result);
		
		return resultMsg;
	}
	
	public void reset() {
		firstNum = null;
		secondNum = null;
	}

}

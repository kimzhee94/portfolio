package calculator;

import java.util.*;

public class Calculator {

	private String[] operatorArr = {"+", "-", "*", "/"};
	
	public String chechOperator(String inputValue) {
		String msg = "";
		List<String> operatorList = Arrays.asList(operatorArr);
		
		if(operatorList.indexOf(inputValue) < 0) {
			msg = "※ 사칙 연산자만 입력하세요!(+, -, *, /)";
		}
		
		return msg;
	}
	
	public Map<String, Object> operate(NumberVO numberVO, Storage storage) {
		Map<String, Object> resultMap = new HashMap<>();
		int first = Integer.parseInt(numberVO.getFirstNum());
		int second = Integer.parseInt(numberVO.getSecondNum());
		String operator = numberVO.getOperator();
		
		int result;
		
		if("+".equals(operator)) {
			result = first + second;
		} else if("-".equals(operator)) {
			result = first - second;
		} else if("*".equals(operator)) {
			result = first * second;
		} else {
			result = first / second;
		}
		
		storage.putSavedList(result);
		numberVO.setFirstNum(result);
		
		resultMap.put("storage", storage);
		resultMap.put("numberVO", numberVO);
		
		return resultMap;
	}
	
}

package calculator;

import java.util.*;

public class MyScanner {

	Scanner sc = new Scanner(System.in);
	
	NumberVO inputValue(NumberVO numberVO) {
		String inputValue = sc.nextLine();
		
		numberVO.setInputValue(inputValue);
		
		return numberVO;
	}
	
	void close() {
		sc.close();
	}
}

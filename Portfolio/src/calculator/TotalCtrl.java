package calculator;

import java.util.*;

public class TotalCtrl {
	NumberVO numberVO = new NumberVO(); // getter, setter
	
	Calculator calc = new Calculator(); // 처리부
	
	Storage storage = new Storage(); // 저장부
	
	MyScanner scanner = new MyScanner(); // 입력부 -- set
	
	Printer printer = new Printer(); // 출력부
	
	public void start() {
		
		outer : do {
			printer.toString("종료를 원하시면 'ESC'를 입력하세요.", true);
			
			if(storage.getLastResult() != null) {
				printer.toString(null, true);
				printer.toString("▶ 지난 연산 결과 값 : " + storage.getLastResult(), true);
			}
			
			else {
				do {
					printer.toString("▶ 첫번째 수를 입력하세요. : ", false);
					try {
						numberVO = scanner.inputValue(numberVO);
						
						if("ESC".equals(numberVO.getInputValue())) {
							break outer;
						} else if("AC".equals(numberVO.getInputValue())) {
							numberVO = new NumberVO();
							continue outer;
						} else {
							numberVO.setFirstNum(Integer.parseInt(numberVO.getInputValue()));
							break;
						}
					} catch (NumberFormatException e) {
						printer.toString("※ 숫자만 입력하세요!", true);
						continue;
					}
				} while (true);
				
				numberVO.setInputValue(null); // 초기화
			}
			
			do {
				printer.toString(null, true);
				printer.toString("▶ 연산자를 입력하세요.(+, -, *, /) : ", false);
				
				numberVO = scanner.inputValue(numberVO);
				
				if("ESC".equals(numberVO.getInputValue())) {
					break outer;
				} else if("AC".equals(numberVO.getInputValue())) {
					numberVO = new NumberVO();
					continue outer;
				} else {
					String message = calc.chechOperator(numberVO.getInputValue());
					if("".equals(message)) {
						numberVO.setOperator(numberVO.getInputValue());
						break;
					} else {
						printer.toString(message, true);
					}
				}
			} while (true);
			
			numberVO.setInputValue(null); // 초기화
			
			do {
				printer.toString(null, true);
				printer.toString("▶ 두번째 수를 입력하세요. : ", false);
				
				try {
					numberVO = scanner.inputValue(numberVO);
					
					if("ESC".equals(numberVO.getInputValue())) {
						break outer;
					} else if("AC".equals(numberVO.getInputValue())) {
						numberVO = new NumberVO();
						continue outer;
					} else {
						numberVO.setSecondNum(Integer.parseInt(numberVO.getInputValue()));
						break;
					}
				} catch (NumberFormatException e) {
					printer.toString("※ 숫자만 입력하세요!", true);
					continue;
				}
			} while (true);
			
			numberVO.setInputValue(null); // 초기화
			
			Map<String, Object> resultMap = calc.operate(numberVO, storage);
			
			numberVO = (NumberVO)resultMap.get("numberVO");
			storage = (Storage)resultMap.get("storage");
			
			printer.toString("☞ 결과 : " + storage.getLastResult(), true);
		} while (true);
	
		scanner.close();
	}


}

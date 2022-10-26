package calculator;

import java.util.*;

public class TotalCtrl {
	
	public void start(Scanner sc) {
		System.out.println("======= 자바 계산기 =======");
		
		Calculator calc = new Calculator();
		String inputValue = "";
		
		outer : do {
			System.out.println("종료를 원하시면 'ESC'를 입력하세요.");
			
			if(calc.getFirstNum() != null) {
				System.out.println("초기화를 원하시면 'AC'를 입력하세요.");
				System.out.print("▶ 지난 연산 결과 값 : ");
				System.out.println(calc.getFirstNum());
			}
			else {
				do {
					try {
						System.out.print("▶ 첫번째 수를 입력하세요. : ");
						inputValue = sc.nextLine();
						
						if("ESC".equals(inputValue)) {
							break outer;
						} else if("AC".equals(inputValue)) {
							calc.reset();
							continue outer;
						} else {
							calc.setFirstNum(Integer.parseInt(inputValue));
							break;
						}
						
					} catch (NumberFormatException e) {
						System.out.println("※ 숫자만 입력하세요!");
						continue;
					}
				} while (true);
			}
			
			do {
				System.out.println("초기화를 원하시면 'AC'를 입력하세요.");
				System.out.print("▶ 연산자를 입력하세요.(+, -, *, /) : ");
				inputValue = sc.nextLine();
				
				if("ESC".equals(inputValue)) {
					break outer;
				} else if("AC".equals(inputValue)) {
					calc.reset();
					continue outer;
				} else {
					String msg = calc.chechOperator(inputValue);
					
					if("".equals(msg)) {
						break;
					}
					else {
						System.out.println(msg);
					}
				}
			} while (true);
			
			do {
				try {
					System.out.println("초기화를 원하시면 'AC'를 입력하세요.");
					System.out.print("▶ 두번째 수를 입력하세요. : ");
					inputValue = sc.nextLine();
					
					if("ESC".equals(inputValue)) {
						break outer;
					} else if("AC".equals(inputValue)) {
						calc.reset();
						continue outer;
					} else {
						calc.setSecondNum(Integer.parseInt(inputValue));
						break;
					}
				} catch (NumberFormatException e) {
					System.out.println("※ 숫자만 입력하세요!");
					continue;
				}
			} while (true);
			
			System.out.print("☞ 결과 : ");
			System.out.println(calc.operate());
			System.out.println();
			
		} while (true);
		
	}


}

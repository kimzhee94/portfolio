package calculator;

public class Printer {

	void toString(String message, boolean nextLine) {
		if(message == null) {
			message = "초기화를 원하시면 'AC'를 입력하세요.";
		}
		
		if(nextLine) {
			System.out.println(message);
		} else {
			System.out.print(message);
		}
	}

}

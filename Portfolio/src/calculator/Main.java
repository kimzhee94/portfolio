package calculator;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		TotalCtrl ctrl = new TotalCtrl();
		
		Scanner sc = new Scanner(System.in);
		
		ctrl.start(sc);
		
		sc.close();

	}

}

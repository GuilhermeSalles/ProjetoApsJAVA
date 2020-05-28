package TelaPrincipal;

import java.util.Scanner;

public class MainTeste {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = null;
		for(int i = 0; i <= 10; i++) {
			System.out.println("Digite algo: ");
			a = sc.next();
			System.out.println(a);
			System.out.println("cls");

		}
		
		
		sc.close();
	}
}

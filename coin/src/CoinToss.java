import java.util.Scanner;

public class CoinToss {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		while (true) {
			int num1 = (int)(Math.random() * 2);

			System.out.print("Mynt eller krone? ");
			String strin = input.nextLine();

			if ( strin.toLowerCase().equals("mynt")) {
				if (num1 == 0) {
					System.out.println("Correct!");
				} else {
					System.out.println("InCorrect!");
				}
			} else if ( strin.toLowerCase().equals("krone")) {
				if (num1 == 1) {
					System.out.println("Correct!");
				} else {
					System.out.println("InCorrect!");
				}
			} else if ( strin.toLowerCase().equals("quit")) {
				break;
			} else {
				System.out.println("Du skrev noe feil, prøv igjen!");
			}
		}
		input.close();
	}
}

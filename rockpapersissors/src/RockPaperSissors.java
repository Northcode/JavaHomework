import java.util.Scanner;
import java.util.HashMap;

class RockPaperSissors {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		final int ROCK = 0;
		final int PAPER = 1;
		final int SCISSOR = 2;
		final int QUIT = 3;
		HashMap<Character,Integer> choices = new HashMap<Character,Integer>();
		choices.put('r',ROCK);
		choices.put('p',PAPER);
		choices.put('s',SCISSOR);
		choices.put('q',QUIT);

		final String G_DRAW = "Game ended in draw";
		final String G_WIN = "You won!";
		final String G_LOOSE = "You lost :(";

		int score = 0;
		int winningstreak = 0;
		
		while(true) {

			System.out.print("Select rock(r),paper(p),scissor(s) or type q to quit: ");
			
			int computer = (int) (Math.random() * 3);
			char c = input.next().charAt(0);

			if(!choices.containsKey(c)) {
				System.out.println("Invalid input!");
				continue;
			}

			int selection = choices.get(c);

			System.out.println("Selection: " + selection);
			
			if (selection == QUIT) {
				break;
			}

			if (selection == computer) {
				System.out.println(G_DRAW);
			} else if (selection == ROCK && computer == SCISSOR) {
				System.out.println(G_WIN);
				score++;
				winningstreak++;
			} else if (selection == computer + 1) {
				System.out.println(G_WIN);
				score++;
				winningstreak++;
			} else {
				System.out.println(G_LOOSE);
				score--;
				winningstreak = 0;
			}
			System.out.println("Your current score is: " + score);
			System.out.println("Current winning streak: " + winningstreak);
		}
		input.close();
	}
}

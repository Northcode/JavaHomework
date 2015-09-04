import java.util.ArrayList;
import java.util.Scanner;

public class Average {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		ArrayList<Float> numbers = new ArrayList<Float>();

		String str = input.nextLine();

		for (String n : str.split(" ")) {
			try {
				float f = Float.parseFloat(n);
				numbers.add(f);
			} catch (Exception ex) {
				System.out.println(n + " er ikke et flyttall!");
			}
		}

		float sum = 0f;
		for (Float f : numbers) {
			sum += f;
		}

		float avg = sum / numbers.size();

		System.out.println("Average: " + avg);
		
		input.close();
	}
}

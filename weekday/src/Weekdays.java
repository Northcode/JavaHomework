import java.util.Scanner;
import java.util.HashMap;
import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.Locale;

class Weekdays {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Enter date in dd.mm.yyyy format: ");
		String date = input.nextLine();

		String[] dateParts = date.split("\\.");
		
		int day = Integer.parseInt(dateParts[0]);
		int month = Integer.parseInt(dateParts[1]);
		int year = Integer.parseInt(dateParts[2]);

		int weekday = ZellerCongruence(day,month,year);
		// DayOfWeek is 1 indexed, but Zeller is 0 indexed remeber to add 1
		String weekdayStr = DayOfWeek.of(weekday + 1).getDisplayName(TextStyle.FULL, new Locale("no")); // Maybe get locale from os in future?

		System.out.println("Day of the week: " + weekdayStr);
		
		input.close();
	}

	public static int ZellerCongruence(int q, int m, int y) {
		if (m < 3) {
			m = 12 + m;
			y = y - 1;
		}
		int j = y/100;
		int k = y % 100;
		int h = (q + (26*(m + 1))/10 + k + k/4 + j/4 + 5*j) % 7;
		// h starts on a saturday, move it to start on monday
		if (h < 2)
			h = 5 + h;
		else
			h -= 2;
		return h;
	}
}

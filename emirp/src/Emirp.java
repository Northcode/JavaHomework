import java.util.Scanner;

public class Emirp {

    public static void main(String[] args) {
	//Scanner input = new Scanner(System.in);

	int emirpCount = 0;
	for (int i = 0; emirpCount < 100; i++) {
	    if(isEmirp(i)) {
		emirpCount++;
		System.out.print(i + "\t");
		if(emirpCount % 10 == 0) {
		    System.out.print("\n");
		}
	    }
	}
    }

    public static boolean isEmirp(int num) {
	if(isPalindrome(num)) return false;
	return isPrime(num) && isPrime(reversal(num));
    }

    public static boolean isPrime(int num) {
	if (num >= 0 && num < 4) return true;
	if (num % 2 == 0) return false;
	for (int i = 3; i < num; i += 2) {
	    if (num % i == 0)
		return false;
	}
	return true;
    }

    public static int reversal(int number) {
	int reversed = 0;
	
	while (number != 0) {
	    reversed = reversed * 10 + number % 10;
	    number = number / 10;
	}

	return reversed;
    }
    
    public static boolean isPalindrome(int number) {
	return number == reversal(number);
    }
}
    

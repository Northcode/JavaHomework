import java.util.Scanner;

public class CreditCardNumber {

    public enum CARDPREFIX {
	VISA(4), MASTERCARD(5), AMERICANEXPRESS(34), DISCOVERCARD(6);
	private final int value;
	private CARDPREFIX(int value) {
	    this.value = value;
	}
    }

    public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	
	System.out.print("Enter card number: ");
	long cardnumber = input.nextLong();

	if (isValid(cardnumber)) {
	    System.out.println("Card number is valid");
	} else {
	    System.out.println("Card number is invalid!");
	}
    }

    /** Return true if the card number is valid */
    public static boolean isValid(long number) {
	double evendoubles = sumOfDoubleEvenPlace(number);
	double oddsum = sumOfOddPlace(number);
	System.out.println(evendoubles + ", " + oddsum + ", " + ( evendoubles + oddsum ));
	return (evendoubles + oddsum) % 10 == 0;
	
    }
    
    /** Get the result from Step 2 */
    public static int sumOfDoubleEvenPlace(long number) {
	int sum = 0;
	for(int i = 0; i < getSize(number); i += 2) {
	    sum += getDigit(getIndex(number,i)*2);
	}
	return sum;
    }

    /** Return this number if it is a single digit, otherwise,
     * return the sum of the two digits */
    public static int getDigit(int number) {
	if (number >= 0 && number < 10) {
	    return number;	   
	} else {
	    int sum = 0;
	    while (number > 0) {
		sum += number % 10;
		number = number / 10;
	    }
	    return sum;
	}
    }

    /** Return sum of odd-place digits in number */
    public static int sumOfOddPlace(long number) {
	int sum = 0;
	for(int i = 1; i < getSize(number); i += 2) {
	    sum += getIndex(number,i);
	}
	return sum;
    }

    /** Return true if the digit d is a prefix for number */
    public static boolean prefixMatched(long number, int d) {
	System.out.println("n: " + number);
	System.out.println("p: " + getPrefix(number,getSize(d)));
	System.out.println("d: " + d);
	return getPrefix(number,getSize(d)) == d;
    }

    /** Return the number of digits in d */
    public static int getSize(long d) {
	return (int)Math.ceil(Math.log10(d));
    }

    /** Return the first k number of digits from number. If the
     * number of digits in number is less than k, return number. */
    public static long getPrefix(long number, int k) {
	if(k > getSize(number)) return number;
	return (long)Math.floor(number / Math.pow(10,getSize(number) - k));
    }

    public static int getIndex(long number, int index) {
	return (int)((number / Math.pow(10,getSize(number) - 1 - index)) % 10);
    }
}
    

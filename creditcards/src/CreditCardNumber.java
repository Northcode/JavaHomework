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

	// System.out.print("Select card type:\n1.Visa\n2.Master Card\n3.American Express\n4.Discover Card\nSelect: ");

	// int num = input.nextInt();

	// final String card_error_message = "Card number does not match card type";

	// if (num == 1) {
	//     if (!prefixMatched(cardnumber,CARDPREFIX.VISA.value)) {
	// 	System.out.println(card_error_message);
	//     }
	// } else if (num == 2) {
	//     if (!prefixMatched(cardnumber,CARDPREFIX.MASTERCARD.value)) {
	// 	System.out.println(card_error_message);
	//     }
	// } else if (num == 3) {
	//     if (!prefixMatched(cardnumber,CARDPREFIX.AMERICANEXPRESS.value)) {
	// 	System.out.println(card_error_message);
	//     }
	// } else if (num == 4) {
	//     if (!prefixMatched(cardnumber,CARDPREFIX.DISCOVERCARD.value)) {
	// 	System.out.println(card_error_message);
	//     }
	// }
	/*
	System.out.println("getDigit: " + getDigit(1) + ", " + getDigit(5) + ", " + getDigit(12) + ", " + getDigit(32));
	System.out.println("getIndex: " + getIndex(3451,0) + "," + getIndex(3451,1) + "," + getIndex(3451,2) + "," + getIndex(3451,3));
	System.out.println("getSize:" + getSize(5) + "," + getSize(421) + "," + getSize(123456789));
	System.out.println("getPrefix: " + getPrefix(1234567,3));
	System.out.println("isPrefix: " + prefixMatched(123456789,123) + "," + prefixMatched(3125,3) + "," + prefixMatched(5421,123));
	System.out.println("SumOddPlace: " + sumOfOddPlace(123456789) + "," + sumOfOddPlace(11111111L));
	System.out.println("SumEvenDouble: " + sumOfDoubleEvenPlace(123456789) + "," + sumOfDoubleEvenPlace(11111111L));
	*/
    }

    /** Return true if the card number is valid */
    public static boolean isValid(long number) {
	double evendoubles = sumOfDoubleEvenPlace(number);
	double oddsum = sumOfOddPlace(number);
	System.out.println(evendoubles + oddsum);
	return (evendoubles + oddsum) % 10 == 0;
	
    }
    
    /** Get the result from Step 2 */
    public static int sumOfDoubleEvenPlace(long number) {
	int sum = 0;
	for(int i = 0; i < getSize(number); i += 2) {
	    sum += getIndex(number,i)*2;
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
    

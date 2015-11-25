package no.northcode.java.homework.VowelCount;

import java.util.Scanner;

public class VowelCount {

    public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	System.out.print("Enter a string: ");
	String text = input.nextLine();
	int vowelCount = 0;
	int consonantCount = 0;
	for (char c : text.toCharArray()) {
	    if (Character.isLetter(c)) {
		String C = (""+c).toUpperCase();
		if ("AEIOU".contains(C)) {
		    vowelCount++;
		} else {
		    consonantCount++;
		}
	    }
	}
	System.out.println(String.format("Vowels: %d\nConsonants: %d",vowelCount,consonantCount));
    }
	
}
    

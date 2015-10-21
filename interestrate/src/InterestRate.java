import java.util.Scanner;

public class InterestRate {

    public static void main(String[] args) {
	Scanner input = new Scanner(System.in);

	
	
    }

    public static double futureInvestmentValue(double investmentAmount, double monthlyInterestRate, int years) {
	return investmentAmount * Math.pow(1 + monthlyInterestRate,years*12);
    }
    
}
    

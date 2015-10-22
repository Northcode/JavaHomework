import java.util.Scanner;

public class InterestRate {

    public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	 
	System.out.print("Enter amount invested: ");
	double investedAmount = input.nextDouble();
	System.out.print("Annual interest rate: ");
	double annualInterestRate = input.nextDouble();

	double monthlyInterestRate = annualInterestRate / 1200;
	
	System.out.println("\nYear\tFuture Value");

	for(int i = 0; i < 30; i++) {
	    
	    double investmentValue = futureInvestmentValue(investedAmount, monthlyInterestRate, i);
	    System.out.println(i + "\t" + String.format("%.2f",investmentValue));
	}

	
    }

    public static double futureInvestmentValue(double investmentAmount, double monthlyInterestRate, int years) {
	return investmentAmount * Math.pow(1 + monthlyInterestRate,years*12);
    }
    
}
    

package no.northcode.java.homework.ATM;

import java.util.Scanner;
import java.util.Date;

public class ATM {
    
    public static void main(String[] args) {
	// Account account = new Account();
	// account .setBalance(100);
	// System.out.println("Id: " + account.getId());
	// System.out.println("Balance: " +  account.getBalance());
	// System.out.println("Monthly interest rate: " + account.getMonthlyInterestRate());
	
	// System.out.println("Balance: " + account.getBalance());
	// account.deposit(20);
	// System.out.println("Balance: " + account.getBalance());
	// account.withdraw(20);
	// System.out.println("Balance: " + account.getBalance());

	Scanner input = new Scanner(System.in);

	Account[] accounts = new Account[10];

	for (int i = 0; i < 10; i++) {
	    accounts[i] = new Account(i,100.0);
	}

	while (true) {
	    System.out.print("Enter an id (0-" + accounts.length + "): ");
	    int id = input.nextInt() - 1;

	    if (id < 0 || id > 9) {
		System.out.println("Invalid user id");
		continue;
	    }

	    boolean running = true;

	    while (running) {
	    
		System.out.print("\nMain menu\n1: check balance\n2: withdraw\n3: deposit\n4: exit\nEnter a choice: ");
		int choice = input.nextInt();
		
		switch (choice) {
		case 1:
		    System.out.println("Balance: " + accounts[id].getBalance());
		    break;
		case 2:
		    System.out.print("Enter amount to withdraw: ");
		    double withdrawAmount = input.nextDouble();
		    accounts[id].withdraw(withdrawAmount);
		    break;
		case 3:
		    System.out.print("Enter amount to deposit: ");
		    double depositAmount = input.nextDouble();
		    accounts[id].deposit(depositAmount);
		    break;
		case 4:
		    running = false;
		}
	    }
		
	}
    }
}


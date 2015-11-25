package no.northcode.java.homework.CompareCosts;

import java.util.Scanner;
import java.util.ArrayList;

class CompareCosts {

	public static class Package {
		public float weight;
		public float price;

		public Package(float Weight, float Price) {
			weight = Weight;
			price = Price;
		}

		public float pricePerWeight() {
			return price/weight;
		}
	}
	   
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.println("Enter weights and price/kg for packages to compare\nend with quit");

		ArrayList<Package> packages = new ArrayList<Package>();

		String line;

	        while(true) {
			System.out.print("Package " + (packages.size() + 1) + ": ");
			line = input.nextLine().trim();
			if (line.equals("quit")) {
				break;
			}
			String[] lineParts = line.split(" ");
			if (lineParts.length != 2) {
				System.out.println("Package details must be in format: 'weight price'! Please try again or type 'quit' to quit");
				continue;
			}
			try {			    
			float weight = Float.parseFloat(lineParts[0]);
			float price = Float.parseFloat(lineParts[1]);
			Package newPackage = new CompareCosts.Package(weight,price);
			packages.add(newPackage);
			} catch (Exception ex) {
				System.out.println("Error occured while converting weight or price to package, " + ex.toString());
				continue;
			}
		}

		if (packages.size() == 0) {
			System.out.println("You entered no packages!");
			return;
		}

		Package cheapest = null;
		
		for (Package p : packages) {
			if (cheapest == null) {
				cheapest = p;
			} else if (p.pricePerWeight() < cheapest.pricePerWeight()) {
				cheapest = p;
			}
		}

		System.out.println("Cheapest package is: Package " + (packages.indexOf(cheapest) + 1) + ", with weight: " + cheapest.weight + ", price: " + cheapest.price + ", price/weight: " + cheapest.pricePerWeight());
	}
}

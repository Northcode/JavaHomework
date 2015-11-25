package no.northcode.java.homework.EksamensOppgaver;

import java.util.Scanner;
import java.util.Date;
import java.util.ArrayList;

public class EksamensOppgaver {
    
    public static class Salg {
	public int selger;
	public int produkt;
	public int antall;

	public Salg(int Selger, int Produkt, int Antall) {
	    this.selger = Selger;
	    this.produkt = Produkt;
	    this.antall = Antall;
	}
    }
    
    public static void main(String[] args) {
	Scanner input = new Scanner(System.in);

	ArrayList<Salg> salgsTabell = new ArrayList<Salg>();
	double[] prisTabell = {200,1600,2300,5000};

	while (true) {
	    System.out.print("Selger nr: ");
	    int selger = input.nextInt();
	    if (selger == -1) { break; }
	    
	    System.out.print("Produkt nr: ");	    
	    int produkt = input.nextInt();

	    System.out.print("Antall: ");	    
	    int antall = input.nextInt();

	    boolean exist = false;

	    for (int i = 0; i < salgsTabell.size(); i++) {
		if (salgsTabell.get(i).selger == selger && salgsTabell.get(i).produkt == produkt) {
		    salgsTabell.set(i, new Salg(
						salgsTabell.get(i).selger,
						salgsTabell.get(i).produkt,
						salgsTabell.get(i).antall + antall
						));
		    exist = true;
		    break;
		}
	    }
	    
	    if(!exist) {
		salgsTabell.add(new Salg(selger,produkt,antall));
	    }
	}

	System.out.println("\n--------\nSelger\tProdukt\tAntall");
	for (Salg s : salgsTabell) {
	    System.out.println(s.selger + "\t" + s.produkt + "\t" + s.antall);
	}

	int[] selgerSum = new int[5];
	for (Salg s : salgsTabell) {
	    selgerSum[s.selger - 1] += prisTabell[s.produkt] * s.antall;
	}
	System.out.println("\n--------\n");
	for (int i = 0; i < selgerSum.length; i++) {
	    System.out.println("Selger nr: " + (i + 1) + " kr " + selgerSum[i]);
	}
    }
    
    static double beregnAvgift(int antallTimer) {
	int dogn = antallTimer / 24;
	int time = antallTimer % 24;

	int pris = dogn * 180;

	int n = time - 2;

	if (time >= 0) 
	    pris += 40;
	
	if (n >= 0) {
	    if (time <= 16) {
		pris += 10 * n;
	    } else {
		pris += 140;
	    }
	}

	return pris;
    }
}


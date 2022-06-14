package de.dummewaehler;

public class Main {

	public static void main(String[] args) {


		Partei cdu = new Partei("CDU", 500, 600);
		cdu.printStatistik();		
		
		Partei sbgf = new Partei("SPU, B90/Gruene, FDP",600, 300);
		sbgf.printStatistik();


	}

}

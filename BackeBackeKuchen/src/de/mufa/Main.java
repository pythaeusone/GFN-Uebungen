package de.mufa;

public class Main {

	public static void main(String[] args) {
		Kuchen Erdbeere = new Kuchen("Erdbeere",500,250,8,150);
		Kuchen Schoko = new Kuchen("Schoko",1000,500,5,400);
		
		Erdbeere.showObjectVar();
		System.out.println();
		Schoko.showObjectVar();
		Erdbeere.backen();
		Schoko.backen();
		Erdbeere.essen(4);
		Schoko.essen(3);
		System.out.println();
		Erdbeere.showObjectVar();
		Erdbeere.showGraphic();
		System.out.println();
		Schoko.showObjectVar();
		Schoko.showGraphic();
	}

}

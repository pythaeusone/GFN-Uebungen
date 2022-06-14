package de.musti;

public class Main {

	public static void main(String[] args) {
		
		Health maik = new Health("Maik", 120, 1.80);
		maik.printBMI();
		
		Health tina = new Health("Tina", 50, 1.60);
		tina.printBMI();

	}

}

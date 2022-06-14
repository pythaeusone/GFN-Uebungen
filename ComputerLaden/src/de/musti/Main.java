package de.musti;

public class Main {

	public static void main(String[] args) {
		
		Laptop Aspire = new Laptop("Acer", 8, "i3", 399, false);		
		printer(Aspire);
		Aspire.starten();
		System.out.println();

		MacBook Air = new MacBook(16, "M1", 3999, true);
		printer(Air);
		Air.starten();
		System.out.println();
		
		

	}
	
	static void printer(Object o) {
		System.out.println("----------------------");
		System.out.println(String.format("%-7s %-5s","Marke: ", ((Laptop) o).getMarke()));
		System.out.println(String.format("%-7s %-5s","CPU: ", ((Laptop) o).getCpu() + " Chip"));
		System.out.println(String.format("%-7s %-5s","RAM: ", ((Laptop) o).getRam() + " GB"));
		System.out.println(String.format("%-7s %-5s","Touch: ", ((Laptop) o).touchbar ? "Ja" : "Nein"));
		System.out.println(String.format("%-7s %-5s","PREIS: ", ((Laptop) o).getPreis() + "$"));
		System.out.println();
	}

}

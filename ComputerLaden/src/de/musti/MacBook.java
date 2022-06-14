package de.musti;

public class MacBook extends Laptop{

	public MacBook(int ram, String cpu, double preis, boolean touchbar) {
		super("Apple", ram, cpu, preis, touchbar);
	}
	
	public void starten() {
		System.out.println("Apple bootet nun alleine ...");
	}
	
}

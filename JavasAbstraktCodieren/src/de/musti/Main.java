package de.musti;

public class Main {

	public static void main(String[] args) {
		// :-)
		SDV eins = new Vigenere();
		eins.setPrivateKey("PRUEFUNG");
		eins.setKlarText("DERADLERISTGELANDET");
		
		System.out.println(eins.codieren());

	}

}

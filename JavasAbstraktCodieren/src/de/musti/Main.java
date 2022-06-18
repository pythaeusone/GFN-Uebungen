package de.musti;

public class Main {

	public static void main(String[] args) {
		// :-)
		SDV eins = new Vigenere();
		eins.setPrivateKey("PRUEFUNG");
		eins.setKlarText("DERADLERISTGELANDET");
		eins.setGeheimText("SVLEIFRXXJNKJFNTSVN");
		
		System.out.println(eins.codieren());
		System.out.println();
		System.out.println(eins.decodiere());

	}

}

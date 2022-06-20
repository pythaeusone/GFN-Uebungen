package de.musti;

public class Main {

	public static void main(String[] args) {
		// :-)
		SDV eins = new Vigenere();
		eins.setPrivateKey("PRUEFUNGJDHKJSHDKJHSKJFDJKJFKLDJLFDH");
		eins.setKlarText("DERADLERISTGELANDETAUFDEMBERG");
		eins.setGeheimText("SVLEIFRXRVAQNDHQNNASEOIHVLNWQ");
		
		System.out.println(eins.codieren());
		System.out.println();
		System.out.println(eins.decodiere());

	}

}

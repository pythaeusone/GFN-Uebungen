package de.musti;
//:-)
public class Vigenere extends SDV {
	
	public String codieren() {
		String vigenere = "";
		for (int i = 0; i < klarText.length() ; i++){
			int kT = klarText.charAt(i) - 'A';
			int pK = pKey.charAt(i % pKey.length());
			int kTpK = (kT + pK) - 'A';
			int crypt = kTpK % 26 + 'A';
			vigenere = vigenere + (char)(crypt);
		}
		return vigenere;
	}

}

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
	
	public String decodiere() {
		String decode = "";
		for (int i = 0; i < geheimText.length() ; i++){
			int gT = geheimText.charAt(i) - 'A';
			if(gT != (gT%26))
				gT += 26;
			int pK = pKey.charAt(i % pKey.length());
			int c = (gT+'A') - pK;
			int gTpK = (0 > c ? c+=26 : c) + 'A';
			decode = decode + (char)(gTpK);
		}
		return decode;
	}

}

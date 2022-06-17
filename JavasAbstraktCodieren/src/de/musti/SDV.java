package de.musti;
// :-)
public abstract class SDV {
	protected String klarText;
	protected String pKey;
	
	public SDV() {

	}
	
	public void setPrivateKey(String key) {
		pKey = key;
	}
	
	public String getKlarText() {
		return klarText;
	}
	
	public void setKlarText(String text) {
		klarText = text;
	}
	
	public abstract String codieren();
}

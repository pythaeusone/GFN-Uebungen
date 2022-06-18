package de.musti;
// :-)
public abstract class SDV {
	protected String klarText;
	protected String geheimText;
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
	
	public String getGeheimText() {
		return geheimText;
	}
	
	public void setGeheimText(String text) {
		geheimText = text;
	}
	
	public abstract String codieren();
	public abstract String decodiere();
}

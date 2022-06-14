package de.ziehe_die_schraube;

import java.text.DecimalFormat;

public class Schrauben {
	private int durchmesser;
	private int laenge;
	private int anzahl;
	
	final float schraube_cat1 = 0.30f;
	boolean preisgruppe_cat1;
	final float schraube_cat2 = 0.40f;
	boolean preisgruppe_cat2;
	final float schraube_cat3 = 0.60f;
	boolean preisgruppe_cat3;
	final float schraube_cat4 = 0.80f;
	boolean preisgruppe_cat4;
	final float schraube_cat5 = 0.90f;
	boolean preisgruppe_cat5;
	
	
	public Schrauben(int anzahl, int durchmesser, int laenge) {
		if(anzahl <= 0)
			anzahl = 1;
		if(durchmesser <= 0)
			durchmesser = 1;
		if(laenge <= 0)
			laenge = 1;
		
		this.anzahl = anzahl;
		this.durchmesser = durchmesser;
		this.laenge = laenge;
	}
	
	
	private float getPreis() {
		if(this.durchmesser < 3 & this.laenge <= 20) {
			preisgruppe_cat1 = true;
			return this.anzahl*schraube_cat1;
		}else if(this.durchmesser >= 3 && this.durchmesser < 5 & this.laenge >= 20 && this.laenge <= 30) {
			preisgruppe_cat2 = true;
			return this.anzahl*schraube_cat2;
		}else if(this.durchmesser >= 5 && this.durchmesser <= 6 & this.laenge >= 20 && this.laenge <= 30) {
			preisgruppe_cat3 = true;
			return this.anzahl*schraube_cat3;
		}else if(this.durchmesser > 6 && this.durchmesser < 15 & this.laenge >= 30 && this.laenge <= 50) {
			preisgruppe_cat4 = true;
			return this.anzahl*schraube_cat4;
		}else if(this.durchmesser >= 15 && this.durchmesser <= 20 & this.laenge >= 30 && this.laenge <= 50) {
			preisgruppe_cat5 = true;
			return this.anzahl*schraube_cat5;
		}
		return 0.0f;
	}
	
	
	private String getPreisGruppe() {
		if(preisgruppe_cat1)
			return "Preisgruppe 1.";
		else if(preisgruppe_cat2)
			return "Preisgruppe 2.";
		else if(preisgruppe_cat3)
			return "Preisgruppe 3.";
		else if(preisgruppe_cat4)
			return "Preisgruppe 4.";
		else if(preisgruppe_cat5)
			return "Preisgruppe 5.";
		else
			return "";
	}
	
	
	public String toString() {
		if(getPreis() <= 0.0f)
			return "Schrauben Einheit unbekannt!";
		DecimalFormat formater = new DecimalFormat();
		formater.setMaximumFractionDigits(2);
		return "Nur " + getPreis() + " Euro kosten die Schrauben der " + getPreisGruppe();
	}
	
	
}

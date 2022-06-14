package de.baeumchen;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Baum {
	
	int pflanzjahr;
	double ausdehnung;
	double hoehe;
	String form;
	boolean krank;
	
	int alter() {
		
		Calendar kalender = new GregorianCalendar();
		int aktuellesjahr = kalender.get(Calendar.YEAR);
		
		return aktuellesjahr - pflanzjahr;
		
	}
	
	void setKrank (boolean k) {
		
		krank = k;
		
	}
	
	public boolean getKrank() {
		
		return krank;
		
	}
	
	void setHoehe(double h) {
		
		hoehe = h;
		
	}
	
	double getHoehe() {
		
		return hoehe;
		
	}
	
	void setAusdehnung(double ad) {
		
		ausdehnung = ad;
		
	}
	
	double getAusdehnung() {
		
		return ausdehnung;
		
	}
	
	void showObjektVar() {
		
		System.out.println("----- Baum -----");
		System.out.println("Planzjahr:  " + pflanzjahr);
		System.out.println("Alter:      " + alter());
		System.out.println("Ausdehnung: " + ausdehnung);
		System.out.println("Hoehe:      " + hoehe);
		System.out.println("Form:       " + form);
		
		if (krank)
			System.out.println("-> Krank");
		else
			System.out.println("-> Gesund");
		
	}
}

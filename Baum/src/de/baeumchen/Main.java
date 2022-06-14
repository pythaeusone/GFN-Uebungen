package de.baeumchen;

public class Main {

	public static void main(String[] args) {
		
		Baum b1 = new Baum();
		Baum b2 = new Baum();
		
		b1.pflanzjahr = 2022; b1.ausdehnung = 11.2d; b1.hoehe = 2.0d; b1.form = "rundlich"; b1.krank = false;
		
		b2.pflanzjahr = 2021; b2.ausdehnung = 18.0d; b2.hoehe = 5.5d; b2.form = "saeulenformig"; b2.krank = false;
		
		b1.showObjektVar();
		b2.showObjektVar();
		
		b1.setHoehe(4.5d);
		b2.setKrank(true);
		
		b1.showObjektVar();
		b2.showObjektVar();	

	}

}

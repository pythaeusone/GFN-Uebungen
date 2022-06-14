package de.musti;


public class Main {

	public static void main(String[] args) {

		StepCounter tim = new StepCounter("2022-06-05", 1051);		
		tim.dieAusgabe("Tim");
		
		StepCounter hans = new StepCounter("2021-12-01", 2000);		
		hans.dieAusgabe("Hans");
		
	}	

}

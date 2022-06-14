package de.musti;

public class Health {
	
	private double kg;
	private double size;
	private String name;
	
	
	public Health(String name, double kg, double size) {
		this.name = name;
		this.kg = kg;
		this.size = size;
	}
	
	private double setBMI(double kg, double size) {
		return kg / Math.pow(size, 2);
	}
	
	private double getBMI() {
		String strBmi[] = String.format("%.02f", setBMI(this.kg, this.size)).split(",");
		double newBmi = Double.parseDouble(strBmi[0]+"."+strBmi[1]);
		return newBmi;
	}
	
	private String getName() {
		return this.name;
	}
	
	private double getGewicht() {
		return this.kg;
	}
	
	private double getGroeße() {
		return this.size;
	}
	
	private String getBmiStatus(double bmi) {
		if(bmi < 18.5)
			return "hat untergewicht";
		else if(bmi >= 18.5 & bmi < 25)
			return "hat normalgewicht";
		else if(bmi >= 25 & bmi < 30)
			return "ist uebergewichtig";
		else if(bmi >= 30)
			return "ist fettleibig";
		else
			return "lebt nicht mehr!";
	}
	
	public void printBMI() {
		System.out.println("---------------------------");
		System.out.println(String.format("%-9s %-5s","Patient: ", getName()));
		System.out.println(String.format("%-9s %-5s","Groesse: ", getGroeße() + "m"));
		System.out.println(String.format("%-9s %-5s","Gewicht: ", getGewicht() + "kg"));
		System.out.println(String.format("%-9s %-5s","BMI: ", getBMI()));
		System.out.println(String.format("%-9s %-5s","Status: ", getBmiStatus(getBMI())));
		System.out.println();
	}

}

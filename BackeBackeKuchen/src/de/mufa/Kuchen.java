package de.mufa;

public class Kuchen extends Cutter {
	String name;
	int mehl;
	int butter;
	int eier;
	int zucker;
	boolean teig;
	int stueckeGesamt;
	int stueckeVorhanden;
	
	public Kuchen(String name,int mehl, int butter, int eier, int zucker) {
		this.name = name;
		this.mehl = mehl;
		this.butter = butter;
		this.eier = eier;
		this.zucker = zucker;
		this.teig = true;
	}
	public void backen() {
		teig = false;
		stueckeGesamt = 12;
		stueckeVorhanden = 12;
	}
	
	public void showObjectVar() {
		
		System.out.printf("%-15s %-10s\n" ,"Kuchenart: ",  name);
		System.out.printf("%-15s %-10s\n" ,"Mehl: ",  mehl+"g");
		System.out.printf("%-15s %-10s\n" ,"Butter: ",  butter+"g");
		System.out.printf("%-15s %-10s\n" ,"Zucker: ",  zucker+"g");
		System.out.printf("%-15s %-10s\n" ,"Eier: ",  eier);
		System.out.printf("%-15s %-10s\n" ,"Teig: ",  teig);
		System.out.printf("%-15s %-10s\n" ,"St�cke gesamt: ",  stueckeGesamt);
		System.out.printf("%-15s %-10s\n" ,"St�cke �brig: ",  stueckeVorhanden);
		
	}
	
	public void showGraphic() {
		createWindow(name, stueckeGesamt-stueckeVorhanden);
	}
	
	public void essen(int menge) {
		if (stueckeVorhanden - menge >= 0)
			stueckeVorhanden = stueckeVorhanden - menge;
		else
			System.out.println("Nicht gen�gend St�cke zum essen da!");
		
	}
}


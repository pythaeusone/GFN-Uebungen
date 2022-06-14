import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		eingabe();
	}
	
	public static void eingabe() throws InterruptedException {
		boolean richtig = true;
		int t = 0;
		int m = 0;
		int j = 0;
		
		
		while(richtig) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Zeitraum von 20-3-2000 bis 27-12-2399 sind im System!");
			System.out.println();
			System.out.print("Bitte gib ein Datum(7-6-2022) ein: ");
			String datum = sc.nextLine();
			
			String[] d = datum.split("-");
			try {
				
				t = Integer.parseInt(d[0]);
				m = Integer.parseInt(d[1]);
				j = Integer.parseInt(d[2]);

				if(t >= 1 & t <=31 & m >= 1 & m <= 12 & j >= 2000 & j <= 2399) {
					richtig = false;
				}else {
					cls();
					System.out.println("Bitte Format befolgen Tag-Monat-Jahr z.B. 30-6-2022");
					System.out.println("Zeitraum von 20-3-2000 bis 27-12-2399 sind im System!");
					System.out.println("Vollmond Berechnung beginnt am 20-03-2000");
					Thread.sleep(5000);
				}
				
			}catch(NumberFormatException e) {
				System.out.println("Nur Zahlen und bitte so: 20-3-2000");
				Thread.sleep(3000);
				cls();
			}
		}
		ausgabe(rechneJD(j,m,t));
	}
	
	
	public static void ausgabe(double jd) throws InterruptedException {
		final double sm = 29.530587981; // Synodischer Monat
		
		double lastVM = rechneJD(2000, 3, 20);
		int tage_um = (int)(jd - lastVM);
		
		
		System.out.println("Tage seit dem Vollmond(22.12.1999): " + tage_um);
		System.out.println("Anzahl der Neumonde seit dem (22.12.1999): " + (int)(tage_um/sm));
		System.out.println();
		checkPhase((tage_um/sm) - (int)(tage_um/sm));
		Thread.sleep(5000);
		cls();
		eingabe();		
	}
	
	public static void checkPhase(double phase) {
		
		System.out.println(phase);

		if(phase < 0.025 | phase >= 0.97)
			printVM();
		if(phase < 0.97 & phase >= 0.77)
			printZM();
		if(phase < 0.77 & phase >= 0.749)
			printZHM();
		if(phase < 0.749 & phase >= 0.51)
			printZS();
		if(phase < 0.51 & phase >= 0.47)
			printNM();
		if(phase < 0.47 & phase >= 0.255)
			printAS();
		if(phase < 0.255 & phase >= 0.22)
			printAHM();
		if(phase < 0.22 & phase >= 0.025)
			printAM();
		
	}
	
	
	public static double rechneJD(int jahr, int monat, int tag) {		
		int j;
		int m;
		int b;		
		double jd;
		
		if(monat >= 2) {
			j = jahr;
			m = monat;
		}else {
			j = jahr-1;
			m = monat+12;
		}
		
		b = 2 - ((j / 100) + (j / 400));
		
		jd = (365.25*(j + 4716)) + (30.6001 * (m + 1)) + tag + b - 1524.5;
		
		return jd;
	}

    public static void cls(){
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {}
    }
    
    public static void printVM() {
        System.out.println("VOLLMOND"); // 0.95 - 1.0 & alles unter 0.05
        System.out.println("        _..._");
        System.out.println("      .:::::::.");
        System.out.println("     :::::::::::");
        System.out.println("     :::::::::::");
        System.out.println("     `:::::::::'");
        System.out.println("       `':::''");
        System.out.println();
    }

    public static void printZM() {
        System.out.println("Zunehmender Mond"); // 0.8 - 0.95
        System.out.println("        _..._");
        System.out.println("      .' .::::.");
        System.out.println("     :  ::::::::");
        System.out.println("     :  ::::::::");
        System.out.println("     `. '::::::'");
        System.out.println("       `-.::''");
        System.out.println();
    }

    public static void printZHM() {
        System.out.println("Zunehmender Halbmond"); // 0.7 - 0.8
        System.out.println("        _..._");
        System.out.println("      .'  ::::.");
        System.out.println("     :    ::::::");
        System.out.println("     :    ::::::");
        System.out.println("     `.   :::::'");
        System.out.println("       `-.::''");
        System.out.println();
    }

    public static void printZS() {
        System.out.println("Zunehmende Sichel"); // 0.55 - 0.7
        System.out.println("        _..._");
        System.out.println("      .'   `::.");
        System.out.println("     :       ::: ");
        System.out.println("     :       :::");
        System.out.println("     `.     .::'");
        System.out.println("       `-..:''");
        System.out.println();
    }

    public static void printNM() {
        System.out.println("Neumond"); // 0.45 - 0.55
        System.out.println("        _..._");
        System.out.println("      .'     `.");
        System.out.println("     :         :");
        System.out.println("     :         :");
        System.out.println("     `.       .'");
        System.out.println("       `-...-'");
        System.out.println();
    }

    public static void printAS() {
        System.out.println("Abnehmende Sichel"); // 0.30 - 0.45
        System.out.println("        _..._");
        System.out.println("      .::'   `.");
        System.out.println("     :::       :");
        System.out.println("     :::       :");
        System.out.println("     `::.     .'");
        System.out.println("       `':..-'");
        System.out.println();
    }

    public static void printAHM() {
        System.out.println("Abnehmender Halbmond"); // 0.20 - 0.30
        System.out.println("        _..._");
        System.out.println("      .::::  `.");
        System.out.println("     ::::::    :");
        System.out.println("     ::::::    :");
        System.out.println("     `:::::   .'");
        System.out.println("       `'::.-'");
        System.out.println();
    }

    public static void printAM() {
        System.out.println("Abnehmender Mond"); // 0.05 - 0.20
        System.out.println("        _..._");
        System.out.println("      .::::. `.");
        System.out.println("     :::::::.  :");
        System.out.println("     ::::::::  :");
        System.out.println("     `::::::' .'");
        System.out.println("       `'::'-'");
        System.out.println();
    }
	
}

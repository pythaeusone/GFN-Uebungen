import java.util.Scanner;

public class Rechner {

	public static void main(String[] args) {
		callEingabe();
	}
	
	public static void callEingabe() {		
		System.out.println("Einfacher Rechner, 1 + 1 und dann Enter. x = Exit");		
		Scanner scanner = new Scanner(System.in);		
		while(true) {			
			System.out.print("Was magst du rechnen: ");
			String eingabe = scanner.nextLine();
			String[] eingabeArray = eingabe.split(" ", 3);
			
			if(eingabeArray[0].equals("x")) {
				break;
			}else {
				switch(eingabeArray[1].toString()) {
				case "+" -> add(Double.parseDouble(eingabeArray[0]), Double.parseDouble(eingabeArray[2]));
				case "-" -> sub(Double.parseDouble(eingabeArray[0]), Double.parseDouble(eingabeArray[2]));
				case "*" -> mul(Double.parseDouble(eingabeArray[0]), Double.parseDouble(eingabeArray[2]));
				case "/" -> div(Double.parseDouble(eingabeArray[0]), Double.parseDouble(eingabeArray[2]));
				}
			}			
		}
		scanner.close();
	}
	
	public static void add(double a, double b) {
		if(a == 0 && b == 0) {
			System.out.println("...du bist ne Null!");
		}else {
			System.out.println("Ergebnis: " + (a + b));
		}
	}
	
	public static void sub(double a, double b) {
		if(a == 0 && b == 0) {
			System.out.println("...du bist ne Null!");
		}else {
			System.out.println("Ergebnis: " + (a - b));
		}
	}
	
	public static void mul(double a, double b) {
		if(a == 0 || b == 0) {
			System.out.println("...du bist ne Null!");
		}else {
			System.out.println("Ergebnis: " + (a * b));
		}
	}
	
	public static void div(double a, double b) {
		if(a == 0 || b == 0) {
			System.out.println("...du bist ne Null!");
		}else {
			System.out.println("Ergebnis: " + (a / b));
		}
	}
	

}

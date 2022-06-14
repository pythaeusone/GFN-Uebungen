package Lampen;

public class Main {

	public static void main(String[] args) {
		Bulb b = new Bulb(60);		
		System.out.println(b.toString(10));
		
		LedBulb l = new LedBulb(9);
		System.out.println(l.toString(10));
	}

}

package Lampen;

public class Bulb extends Lampe {
	public Bulb(int watt) {
		super(watt);
	}
	
	public String toString(int hoursPerDay){
		return "A bulb consumes " + this.annualPowerConsumption(hoursPerDay) + "KWh per year";
	}
}

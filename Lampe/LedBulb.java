package Lampen;

public class LedBulb extends Lampe {
	public LedBulb(int watt) {
		super(watt);
	}
	
	public String toString(int hoursPerDay){
		return "A LED bulb consumes " + this.annualPowerConsumption(hoursPerDay) + "KWh per year";
	}
}

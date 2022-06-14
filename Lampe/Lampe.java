package Lampen;

public class Lampe {
	private int watt;
	
	public Lampe(int watt) {
		this.watt = watt;
	}
	
	public int annualPowerConsumption(int hoursPerDay) {
		return (watt * hoursPerDay * 365) / 1000;
	}
	
	public int getWatt() {
		return watt;
	}
}

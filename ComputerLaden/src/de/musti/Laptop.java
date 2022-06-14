package de.musti;

public class Laptop {
	
	private String marke;
	private int ram;
	private String cpu;
	private double preis;
	boolean touchbar;
	
	public Laptop(String marke, int ram, String cpu, double preis, boolean touchbar) {
		this.marke = marke;
		this.ram = ram;
		this.cpu = cpu;
		this.preis = preis;
		this.touchbar = touchbar;
	}
	
	public void starten() {
		System.out.println(this.marke + " bootet...");
	}

	public String getMarke() {
		return marke;
	}

	public void setMarke(String marke) {
		this.marke = marke;
	}

	public int getRam() {
		return ram;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public double getPreis() {
		return preis;
	}

	public void setPreis(double preis) {
		this.preis = preis;
	}

}

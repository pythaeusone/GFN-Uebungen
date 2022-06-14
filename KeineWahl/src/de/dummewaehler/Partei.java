package de.dummewaehler;

public class Partei {
	
	private int stimmeAlt;
	private int stimmeNeu;
	private String partei;
	
	public Partei(String partei, int stimmeAlt, int stimmeNeu) {
		this.partei = partei;
		this.stimmeAlt = stimmeAlt;
		this.stimmeNeu = stimmeNeu;
	}
	
	private double besimmeEntwicklung() {
		return (((this.stimmeNeu-this.stimmeAlt)*100)/(this.stimmeAlt));
	}
	
	private boolean istZuwachs() {
		if(this.stimmeNeu > this.stimmeAlt) {
			return true;
		}
		return false;
	}
	
	private String getPartei() {
		return this.partei;
	}
	
	private int getStimmenAlt() {
		return this.stimmeAlt;
	}
	
	private int getStimmenNeu() {
		return this.stimmeNeu;
	}
	
	public void printStatistik() {
		System.out.println("---------------------------------------------------");
		System.out.println(String.format("%-25s %-5s","Partei: ", getPartei()));
		System.out.println(String.format("%-25s %-5s","Stimmen vorheriger Wahl: ", getStimmenAlt() + " Stimmen."));
		System.out.println(String.format("%-25s %-5s","Stimmen aktueller Wahl: ", getStimmenNeu() + " Stimmen."));
		System.out.println(String.format("%-25s %-5s","Entwicklung: ", istZuwachs() ? "hat Stimmen Zuwachs." : "hat Stimmen Verluste."));
		System.out.println(String.format("%-25s %-5s","Prozent: ", istZuwachs() ? besimmeEntwicklung()+"% Gewinn." : besimmeEntwicklung()+"% Verlust."));
		System.out.println();
	}

}

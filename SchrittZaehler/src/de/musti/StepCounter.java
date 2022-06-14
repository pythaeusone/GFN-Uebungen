package de.musti;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class StepCounter {
	
	private int stepsDone;	
	private float stepsPerDay;	
	private String userStartDate;
	private float daysGones;
	
	public StepCounter(String startDate, int steps) {
		this.daysGones = getDaysGone(getDateToday(), startDate);
		this.stepsDone = incrementSteps(steps);
		this.userStartDate = startDate;
	}
	
	private String getDateToday() {
		
		String date;
		String monat;
		String tag;
		
		Calendar cal = new GregorianCalendar();
		int y = cal.get(Calendar.YEAR);
		int m = cal.get(Calendar.MONTH)+1;
		int d = cal.get(Calendar.DAY_OF_MONTH);
		if(m < 10)
			monat = "0" + Integer.toString(m);
		else
			monat = Integer.toString(m);
		if(d < 10)
			tag = "0" + Integer.toString(d);
		else
			tag = Integer.toString(d);
		date = Integer.toString(y) + "-" + monat + "-" + tag;
		
		return date;
	}
	
	private float getDaysGone(String today, String startDay) {
		
		LocalDate start = LocalDate.parse(startDay);
		LocalDate end = LocalDate.parse(today);

		long days = ChronoUnit.DAYS.between(start, end);
		
		return days;
		
	}
	
	private int incrementSteps(int steps) {
		int count = 0;
		while(count < steps) {
			count++;
		}
		
		return count;
	}
	
	private String getUserDate() {
		return this.userStartDate;
	}
	
	private int getStepsDone() {
		return this.stepsDone;
	}
	
	private String getAvgSteps() {
		this.stepsPerDay = this.stepsDone / this.daysGones;
		return String.format("%.02f", this.stepsPerDay);
	}
	
	public void dieAusgabe(String name) {
		System.out.println("--------------------------");
		System.out.println(String.format("%-11s %-5s","Today:", getDateToday()));
		System.out.println(String.format("%-11s %-5s","User:", name));
		System.out.println(String.format("%-11s %-5s","Start Date:", getUserDate()));
		System.out.println(String.format("%-11s %-5s","Steps done:", getStepsDone()));
		System.out.println(String.format("%-11s %-5s","Avg steps:", getAvgSteps()+" daily."));
		System.out.println();		
	}

}

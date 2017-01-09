package test;

public class TimeConversion {
	public static void main(String[] args) {
		
		final int 
			sec = 31,
			min = 16,
			hrs = 4;
		
		int tInSec = (hrs * 60 * 60) + (min * 60) + sec;
		
		System.out.println("Time in Seconds: " + tInSec);
		
		int tHrs = tInSec / (60*60);
		int tMin = (tInSec - tHrs * (60*60)) / 60;
		int tSec = tInSec % 60;
		
		
		System.out.println("Hours: "   +	tHrs);
		System.out.println("Minutes: " + 	tMin);
		System.out.println("Seconds: " + 	tSec);
	}
}

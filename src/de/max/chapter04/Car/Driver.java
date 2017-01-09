package de.max.chapter04.Car;

public class Driver {
	public static void main(String[] args)
	{
		double start = 100;
		double ramp = 1;
		double rampAngle = 89;
		CarJump jump = new CarJump(start, ramp, rampAngle);
		
		System.out.format(	"If a car stats at %5.2f meters and "
							+ "jumps off a %5.2f meter high ramp with an angle "
							+ "of %5.3f degress: \n\n", start, ramp, rampAngle);
		System.out.format(	"the velocity at the slope will be: \n%5.3f m/s / %5.3f km/h\n", 
							jump.getSlopeSpeed(), jump.getSlopeSpeed() * 3.6);
		System.out.format(	"the car's maximum height will be: \n%5.3f m \n", 
							jump.getMaxHeight());
		System.out.format(	"it will travel %5.3f m on it's ballistic arc", 
							jump.getDistance());
	}
}

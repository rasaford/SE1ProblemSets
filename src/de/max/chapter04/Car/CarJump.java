package de.max.chapter04.Car;

public class CarJump {

	private final double gravity = 9.81;

	private double initalHeight; // meters
	private double slopeHeight; // meters
	private double slopeAngle; // internally in radians
	// private double mass = 1000;
	// private double kineticEnergy;
	// private double distance;
	// private double maxHeight;
	//
	// private double height;
	// private double acceleration;
	// private double velocity;

	public CarJump(double accelHeight, double slopeHeight, double slopeAngle)
	{
		initalHeight = accelHeight;
		this.slopeHeight = slopeHeight;
		this.slopeAngle = degToRad(slopeAngle);
	}

	public double getSlopeSpeed()
	{
		double heightDiff = initalHeight - slopeHeight;
		double velocity = Math.sqrt(2 * gravity * heightDiff);
		return velocity;
	}

	// calculates the max height of the car given the fact that
	// it is ballistic
	public double getMaxHeight()
	{
		double slopeSpeed = getSlopeSpeed();
		double launchAngle = Math.sin(slopeAngle);
		double maxHeight = slopeSpeed * slopeSpeed * launchAngle * launchAngle;
		return maxHeight / (2 * gravity);
	}

	// calculated the distance the car will travel
	public double getDistance()
	{
		double slopeSpeed = getSlopeSpeed();
		double vel = (slopeSpeed * slopeSpeed) / gravity;
		return vel * Math.sin(2 * slopeAngle);
	}

	/**
	 * @param accelHeight
	 *            The height measured in meters at which the car will start at
	 *            the very beginning of its journey.
	 */
	public void setAccelHeight(double accelHeight)
	{
		initalHeight = accelHeight;
	}

	/**
	 * @param slopeHeight
	 *            The slope's tip height above ground level measured in meters.
	 */
	public void setSlopeHeight(double slopeHeight)
	{
		this.slopeHeight = slopeHeight;
	}

	private double degToRad(double deg)
	{
		return deg * java.lang.Math.PI / 180;
	}
}

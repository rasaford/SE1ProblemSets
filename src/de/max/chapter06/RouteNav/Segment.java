package de.max.chapter06.RouteNav;

public class Segment {

	private boolean NO_SPEED_LIMIT;
	// current distance in km
	private double distance;
	// speed limit in km/h
	private int speedLimit;

	public Segment(double distance, int speedLimit)
	{
		this.distance = distance;
		this.speedLimit = speedLimit;
	}

	public Segment(double distance)
	{
		this.distance = distance;
		NO_SPEED_LIMIT = true;
	}

	public void setDistance(double distance)
	{
		this.distance = distance;
	}

	public double getDistance()
	{
		return distance;
	}

	public void setSpeedLimit(int speedLimit)
	{
		this.speedLimit = speedLimit;
	}

	public int getSpeedLimit()
	{
		return speedLimit;
	}

}

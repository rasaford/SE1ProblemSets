package de.max.chapter06.RouteNav;

public class RouteNavigation {
	public static void main(String[] args)
	{
		Segment[] route = new Segment[] { 
				new Segment(2.4, 50), 
				new Segment(5, 100), 
				new Segment(3.1, 50),
				new Segment(0.8, 30) };

		System.out.println("Minimal duration: " + duration(route, 500));

	}

	public static long duration(Segment[] route, int personalSpeedLimit)
	{
		double duration = 0;

		for (Segment s : route)
		{
			int speedLimit = Math.min(s.getSpeedLimit(), personalSpeedLimit);
			duration += s.getDistance() / speedLimit;
		}
		return Math.round(duration * 60);
	}
}

package de.max.chapter07.shapes;

public class Draw {

	public static void main(String[] args)
	{
		Rectangle r = new Rectangle(0, 0, 2, 5);
		Circle c = new Circle(1, 2, 4);

		System.out.format("Rectangle: Area %f Perimeter %f \n", r.getArea(), r.getPerimeter());
		System.out.format("Circle: Area %f Perimeter %f \n", c.getArea(), c.getPerimeter());

		r = r.scale(0.5);
		c = c.scale(2);

		System.out.println();
		System.out.println("After scaling:");
		System.out.format("Rectangle: Area %f Perimeter %f \n", r.getArea(), r.getPerimeter());
		System.out.format("Circle: Area %f Perimeter %f \n", c.getArea(), c.getPerimeter());

		System.out.println(r.toString());
		System.out.println(c.toString());
	}
}

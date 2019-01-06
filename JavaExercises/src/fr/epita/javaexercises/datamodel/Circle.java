package fr.epita.javaexercises.datamodel;

public class Circle implements Shape{
	//private Point A;
	private double r;
	
	
	public Circle(double radius) {
		this.r = radius;
	}
	/*public Circle(Point a, double r) {
		super();
		A = a;
		this.r = r;
	}*/
	/*public Point getA() {
		return A;
	}
	public void setA(Point a) {
		A = a;
	}*/
	public double getR() {
		return r;
	}
	public void setR(double r) {
		this.r = r;
	}
	public double getPerimeter() {
		return 2*Math.PI * this.r;
	}
	public double getArea() {
		return Math.PI * Math.pow(this.r, 2);
	}
}

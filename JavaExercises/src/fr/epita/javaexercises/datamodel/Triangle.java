package fr.epita.javaexercises.datamodel;

public class Triangle implements Shape{
	private double base;
	private double side1;
	private double side2;
	private double h;
	

	public Triangle() {
		super();
	}
	public Triangle(double base, double side1, double side2, double h) {
		super();
		this.base = base;
		this.side1 = side1;
		this.side2 = side2;
		this.h = h;
	}
	public double getBase() {
		return base;
	}
	public void setBase(double base) {
		this.base = base;
	}
	public double getSide1() {
		return side1;
	}
	public void setSide1(double side1) {
		this.side1 = side1;
	}
	public double getSide2() {
		return side2;
	}
	public void setSide2(double side2) {
		this.side2 = side2;
	}
	public double getH() {
		return h;
	}
	public void setH(double h) {
		this.h = h;
	}
	public double getPerimeter() {
		return this.base + this.side1 + this.side2;
	}
	public double getArea() {
		return this.base * this.h / 2;
	}
	
}

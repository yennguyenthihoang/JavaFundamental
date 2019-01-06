package fr.epita.javaexercises.datamodel;

public class Square implements Shape{
	private double n;

	public Square(double n) {
		this.n = n;
	}

	public double getN() {
		return n;
	}

	public void setN(double n) {
		this.n = n;
	}
	
	public double getPerimeter() {
		return 4*this.n;
	}
	public double getArea() {
		return Math.pow(this.n, 2);
	}
}

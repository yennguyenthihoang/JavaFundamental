package fr.epita.javaexercises.launcher;

import java.util.Arrays;
import java.util.List;

import fr.epita.javaexercises.datamodel.Circle;
import fr.epita.javaexercises.datamodel.Factorial;
import fr.epita.javaexercises.datamodel.Shape;
import fr.epita.javaexercises.datamodel.Square;
import fr.epita.javaexercises.datamodel.Triangle;

public class Launcher {
	public static void main(String[] args) {

		// Exercise 1: Lecture 4 Peremeter and Area of Circle, square and triangle
		
		 //Shape circle = new Circle(3); Shape square = new Square(4); Shape triangle = new Triangle(13,7,4,5);
		 
		 /*rawCircle(circle); 
		 rawSquare(square); 
		 rawTriangle(triangle);*/
		 
		 /*List<Shape> shapes = Arrays.asList(circle, square, triangle); double
		 globalArea = 0.0; double globalPerimeter = 0.0; for(Shape shape: shapes) {
		 displayShape(shape); }*/
		 

		// Exercise 2: Lecture 5 - factorial implementation
		Factorial fac = new Factorial(6);
		System.out.println("Factorial (while): " + fac.runFactorialWhile());
		System.out.println("Factorial (do ... while): " + fac.runFactorialDoWhile());
		System.out.println("Factorial (for): " + fac.runFactorialFor());

	}

	
	/*private static void rawCircle(Circle circle) { 
		System.out.println("Area: " + circle.getArea()); System.out.println("Perimeter: " + circle.getPerimeter());
	} 
	private static void rawSquare(Square square) { 
		System.out.println("Area: " + square.getArea()); System.out.println("Perimeter: " +	 square.getPerimeter()); 
	}
	 
	private static void rawTriangle(Triangle triangle) {
	 System.out.println("Area: " + triangle.getArea());
	 System.out.println("Perimeter: " + triangle.getPerimeter()); }
	 
	private static void displayShape(Shape shape) {
		System.out.println("This is : " + shape.getClass().getSimpleName());
		System.out.println("Area: " + shape.getArea());
		System.out.println("Perimeter: " + shape.getPerimeter());
	}*/

}

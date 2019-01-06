package fr.epita.javaexercises.datamodel;

public class Factorial {
	private int element;

	public int getElement() {
		return element;
	}

	public void setElement(int element) {
		this.element = element;
	}

	public Factorial() {
		
	}
			
	public Factorial(int element) {
		super();
		this.element = element;
	}
	
	public int runFactorialWhile() {
		int result = 1, i = 1;
		if(this.element > 1) {
			while(i <= this.element) {
				result = result * i;
				i++;
			}
		}else {
			result = 1;
		}
		return result;
	}
	public int runFactorialDoWhile() {
		int result = 1, i = 1;
		do {
			result = result * i;
			i++;
		}while(i <= this.element && this.element > 1);
		return result;
	}
	public int runFactorialFor() {
		int result = 1;
		for(int i = 1; i <= this.element; i++) {
			result = result * i;
		}
		return result;
	}
	
}

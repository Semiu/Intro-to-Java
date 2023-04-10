/**
 * Rectangle2 class - a subclass of Square2
 * @author Semiu
 *
 */

public class Rectangle2 extends Square2 {
	
	//An instance of the superclass is created
	//This suggests a "is-a" relationship: every instance of a Rectangle(2) is a Square(2)
	Square2 obj = new Square2();
	
	//Declaration of the variables
	private double breadth;

	//set method for the length variable
	public void setLength (double len) {
		this.lengthRec = len;
	}
	
	//set method for the breadth variable
	public void setBreadth (double bre) {
		if (bre <= 0) {
			throw new IllegalArgumentException();
		}
		this.breadth = bre;
	}
	
	//get method for the length variable -inherited from the Rectangle1 super class
	double lengthRec = obj.getLength();
	
	//get method for the breadth variable
	public double getBreadth () {
		return this.breadth;
	}
	
	//computeArea method overriding the computeArea method of the super class
	public double computeArea (double length, double breadth) {
		return this.lengthRec * this.breadth;
		 
	}
	
	//computePerimeter method overriding the computeArea method of the super class
	public double computePerimeter (double length, double breadth) {
		return 2*(this.lengthRec + this.breadth);
	}
	
}
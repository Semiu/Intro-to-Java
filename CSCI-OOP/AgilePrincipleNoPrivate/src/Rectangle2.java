//Rectangle2 class -a subclass of Square2 class
public class Rectangle2 extends Square2 {
	//Declaration of the breadth variable
	double breadth;
	//set method for the breadth variable
	//Post-condition: variable length must hold a value
	public void setBreadth (double bre) {
		this.breadth = bre;
	}
	//get method for the breadth variable
	//Pre-condition: variable breadth must hold a value
	public double getBreadth () {
		return this.breadth;
	}
	//computeArea method
	//Post-condition: variable A must hold value
	public double computeArea (double length, double breadth) {
		 A = this.length * this.breadth;
		 return A;
	}
	//computePerimeter method
	//Post-condition: variable P must hold value
	public double computePerimeter (double length, double breadth) {
		P =  2*(this.length + this.breadth);
		return P;
	}
	
}
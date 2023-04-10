//Rectangle1 class
public class Rectangle1 {
	//Declaration of the variables
	double length;
	double breadth;
	double A;
	double P;
	//set method for the length variable
	//Post-condition: variable length must hold a value
	public void setLength (double len) {
		this.length = len;
	}
	//set method for the breadth variable
	//Post-condition: variable length must hold a value
	public void setBreadth (double bre) {
		this.breadth = bre;
	}
	//get method for the length variable
	//Pre-condition: variable length must hold a value
	public double getLength () {
		return this.length; 
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
		P = 2*(this.length + this.breadth);  
		return P;
	}

}

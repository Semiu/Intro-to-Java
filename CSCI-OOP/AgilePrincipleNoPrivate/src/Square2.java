//Square2 class
public class Square2 {
	//Declaration of the variables
	double length;
	double A;
	double P;
	//get method for the length variable
	//Pre-condition: variable breadth must hold a value
	public double getLength () {
		return this.length;
	}
	//set method for the length variable
	//Post-condition: variable length must hold a value
	public void setLength (double len) {
		this.length = len;
	}
	//computeArea method
	//Post-condition: variable A must hold value
	public double computeArea (double len) {
		A = Math.pow(this.length, 2);
		return A;
	}
	//computePerimeter method
	//Post-condition: variable P must hold value
	public double computePerimeter (double len) {
		P =  4*(this.length);
		return P;
	}

}

/**
 * Square2 class
 * @author Semiu
 *
 */
public class Square2 {
	
	//Declaration of the variables
	private double length;
	
	//set method for the length variable
	//Pre-condition: Value must be greater than 0
	//Post-conditon: Variable must hold a value
	public void setLength (double len) {
		if (len <= 0) {
			throw new IllegalArgumentException();
		}
		this.length = len;
	}
	
	//get method for the length variable
	public double getLength () {
		return this.length;
	}
	
	//computeArea method
	public double computeArea (double len) {
		return Math.pow(this.length, 2);
	}
	
	//computePerimeter method
	public double computePerimeter (double len) {
		return  4*(this.length); 
	}
	
}
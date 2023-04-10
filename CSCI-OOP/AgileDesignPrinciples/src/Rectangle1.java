/**
 * Rectangle1 class
 * @author Semiu
 *
 */
public class Rectangle1 {
    
	//Declaration of the variables
	private double length;
	private double breadth;
	
	//set method for the length variable
	//Pre-condition: Value must be greater than 0
	//Post-conditon: Variable must hold a value
	public void setLength (double len) {
		if (len <= 0) {
			throw new IllegalArgumentException();
		}
		this.length = len; 
	}
	
	//set method for the breadth variable
	//Pre-condition: Value must be greater than 0
	//Post-conditon: Variable must hold a value
	public void setBreadth (double bre) {
		if (bre <= 0) {
			throw new IllegalArgumentException();
		}
		this.breadth = bre;
	}
	
	//get method for the length variable
	public double getLength () {
		return this.length; 
	}
	
	//get method for the breadth variable
	public double getBreadth () {
		return this.breadth;
	}
	
	//computeArea method
	public double computeArea (double length, double breadth) {
		 return this.length * this.breadth;
	}
	
	//computePerimeter method
	public double computePerimeter (double length, double breadth) {
		return 2*(this.length + this.breadth);  
		
	}

}

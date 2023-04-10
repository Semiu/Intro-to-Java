/**
 * Square1 class -a subclass of Rectangle1 class
 * @author Semiu
 *
 */
public class Square1 extends Rectangle1 {
	
	
	//An instance of the superclass is created
	//This suggests a "is-a" relationship: every instance of a Square(1) is a Rectangle(1)
	
	//Rectangle1 obj = new Rectangle1();
	//double lengthSq = obj.getLength();
	//lengthSq = this.length;
	//lengthSq = this.breadth;
	
	
	//set method (This inheritance approach does not work: obj.setLength(lengthSq))
	//set method 
	/**
	 
	
	public void setLength (double len) {
		this.lengthSq = len;
	}
	 
	
	//get method -inherited from the Rectangle1 super class
	
	*/
	//computeArea method overriding the computeArea method of the super class
	public double computeArea (double lengthSq) {
		return Math.pow(lengthSq, 2); 
		
	}
	
	//computePerimeter method overriding the computeArea method of the super class
	public double computePerimeter (double lengthSq) {
		return 4*(lengthSq);  
	}
	
	
}
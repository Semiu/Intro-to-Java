//Square1 class -a subclass of Rectangle1 class
public class Square1 extends Rectangle1 {
	//computeArea method
	//Post-condition: variable A must hold value
	public double computeArea (double lengthSq) {
		A = Math.pow(lengthSq, 2);
		return A;
	}
	//computePerimeter method
	//Post-condition: variable P must hold value
	public double computePerimeter (double lengthSq) {
		P =  4*(lengthSq);  
		return P;
	}

}

public class PreferedCustomer extends Customer{
	
	private static double DISCOUNT_RATE = 0.05;
	
	private double SPECIAL_DISCOUNT_PREFERED = 1.5;

	//getDiscountRate method - overriding the Super class method
	public double getDiscountRate() {
		
		return DISCOUNT_RATE = DISCOUNT_RATE/SPECIAL_DISCOUNT_PREFERED;
	}
	
		
}

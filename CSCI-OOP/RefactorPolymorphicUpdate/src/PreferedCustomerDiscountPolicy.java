
public class PreferedCustomerDiscountPolicy extends CustomerDiscountPolicy{
	
	private static double DISCOUNT_RATE = 0.05;
	
	//Dummy special discount assigned for the preferred customer
	private double SPECIAL_DISCOUNT_PREFERED = 1.5;

	//getDiscountRate method - overriding the Super class method
	public double getDiscountRate() {
		
		return DISCOUNT_RATE = DISCOUNT_RATE/SPECIAL_DISCOUNT_PREFERED;
	}
	

}
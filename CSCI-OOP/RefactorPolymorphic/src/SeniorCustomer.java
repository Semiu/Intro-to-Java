
public class SeniorCustomer extends Customer{
	
	private static double DISCOUNT_RATE = 0.05;
	
	enum PurchaseDay {Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday};
	
	private double SPECIAL_DISCOUNT_SENIOR = 3.0;
	
	public static PurchaseDay day;
	
	private static PurchaseDay Tuesday;
	
	
	//getDiscountRate method - overriding the Super class method
	public double getDiscountRate() {
		
		if (day == Tuesday) {
			
			return DISCOUNT_RATE = DISCOUNT_RATE/SPECIAL_DISCOUNT_SENIOR;
		}
		
		return DISCOUNT_RATE;
		
	}
	
	
	

}

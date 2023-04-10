public class Customer{
	
	private static double DISCOUNT_RATE = 0.05;
	
	//getDiscountRate method
	public double getDiscountRate() {
			
			return DISCOUNT_RATE;
			
		}
		
	//Constructor method to create an instance of the Sale class
	Item item = new Item ();
	
	//getDiscount method
	public double getDiscount() {
		
		return item.getSubTotal() * getDiscountRate(); 
		
	}
	
	//getDiscountedSubTotal method
	public double getDiscountedSubTotal() {
		
		return item.getSubTotal() - getDiscount();
		
	}

}

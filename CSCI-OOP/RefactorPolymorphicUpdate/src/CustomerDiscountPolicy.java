
public class CustomerDiscountPolicy extends DiscountPolicy {
	
	
	//Constructor method to create an instance of the Item class
	//This is to access the getSubTotal method of the item class
	
		Item item = new Item();
		
		//getDiscount method
		public double getDiscount() {
			
			return item.getSubTotal() * getDiscountRate(); 
		
		}
		
		//getDiscountedSubTotal method
		public double getDiscountedSubTotal() {
			
			return item.getSubTotal() - getDiscount(); 
		
		}
		
}

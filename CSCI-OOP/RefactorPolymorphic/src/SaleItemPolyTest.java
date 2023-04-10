
public class SaleItemPolyTest {
	
	public static void main(String[] args) {
		
		/**
		 * Sale class
		 */
		//Constructor method to create an instance of the Item class
		Item item = new Item();
				
		String in = null;
				
		item.addItem(in);
				
		//Calling the getSubTotal method of the Sale class
		System.out.println("The subtoal is " + item.getSubTotal());
		
		
		/**
		 * Customer
		 */
		
		//A constructor method for an instance of the PreferedCustoner
		 PreferedCustomer preCust = new  PreferedCustomer();
		 
		//Calling the getDiscountedSubTotal method 
		System.out.println("The discounted subtotal for prefered customer is " + preCust.getDiscountedSubTotal());
		
		//Calling the getDiscount method of the Sale class
		System.out.println("The discount for prefered customer is " + preCust.getDiscount());
		
		//Calling the getDiscountRate method 
		System.out.println("The discount rate for prefered customer is " + preCust.getDiscountRate());
		
		//A constructor method for an instance of the SeniorCustomer
		SeniorCustomer snrCust = new  SeniorCustomer();
		 
		//Calling the getDiscountedSubTotal method 
		System.out.println("The discounted subtotal for senior customer is " + snrCust.getDiscountedSubTotal());
			
		//Calling the getDiscount method of the Sale class
		System.out.println("The discount for senior customer is " + snrCust.getDiscount());
			
		//Calling the getDiscountRate method 
		System.out.println("The discount rate for senior customer is " + snrCust.getDiscountRate());
		
		
		/**
		 * Item class
		 */
		
		//Calling the getItemTotal method of the Item class
		System.out.println("The total item is " + item.getItemTotal());
		
		//Calling the getItemCost method of the Item class
		System.out.println("The cost of the item is " + item.getItemCost());
		
	}
	

}

//import java.util.ArrayList;
import java.util.List;
//import java.util.Vector;

public class SaleItemPolyUpdate {
	
	public static void main(String[] args) {
		
		/**
		 * Item class
		 */
		
		//Constructor method to create an instance of the Item class
		Item item = new Item();
		
		String in = null;
		
		item.addItem(in);
		
		//Calling the getItemTotal method of the Item class
		System.out.println("The total item is " + item.getItemTotal());
		
		//Initialize the itemList parameter
		//List<String> itemList = new ArrayList<>();
		
		List<String> itemList = null;
		
		//Calling the getItemCost method of the Item class
		System.out.println("The cost of the item is " + item.getItemCost(itemList));
		
		//Calling the getDiscountRate method of the Item class
		System.out.println("The discount rate of the item is " + item.getDiscountRate());
		
		//Calling the getSubTotal method of the Item class
		System.out.println("The subtoal of the item is " + item.getSubTotal());
		
		//Calling the getDiscount method of the Item class
		System.out.println("The discount of the item is " + item.getDiscount());
		
		//Calling the getDiscountedSubTotal method of the Item class
		System.out.println("The discounted sub total of the item is " + item.getDiscountedSubTotal());
	
		/**
		 * Customer 
		 */
		
		//A constructor method for an instance of the PreferedCustoner
		PreferedCustomerDiscountPolicy preCust = new  PreferedCustomerDiscountPolicy();
		 
		//Calling the getDiscountedSubTotal method 
		System.out.println("The discounted subtotal for prefered customer is " + preCust.getDiscountedSubTotal());
		
		//Calling the getDiscount method of the Sale class
		System.out.println("The discount for prefered customer is " + preCust.getDiscount());
		
		//Calling the getDiscountRate method 
		System.out.println("The discount rate for prefered customer is " + preCust.getDiscountRate());
		
		//A constructor method for an instance of the SeniorCustomer
		SeniorCustomerPolicyDiscountPolicy snrCust = new  SeniorCustomerPolicyDiscountPolicy();
		 
		//Calling the getDiscountedSubTotal method 
		System.out.println("The discounted subtotal for senior customer is " + snrCust.getDiscountedSubTotal());
			
		//Calling the getDiscount method of the Sale class
		System.out.println("The discount for senior customer is " + snrCust.getDiscount());
			
		//Calling the getDiscountRate method 
		System.out.println("The discount rate for senior customer is " + snrCust.getDiscountRate());
		
	}

}

//import java.util.Scanner;
//The Test class - SaleItemTest - for the Item and Sale classes
public class SaleItemTest {
	
	public static void main(String[] args) {
		
		/**
		 * Sale class
		 */
		//Constructor method to create an instance of the Sale class
		Sale sale = new Sale();
		
		String item = null;
		
		sale.addItem(item);
		
		//Calling the getDiscountRate method of the Sale class
		System.out.println("The discount rate is " + sale.getDiscountRate());
		
		//Calling the getDiscount method of the Sale class
		System.out.println("The discount is " + sale.getDiscount());
		
		//Calling the getSubTotal method of the Sale class
		System.out.println("The subtotal is " + sale.getSubTotal());
		
		//Calling the getDiscountedSubTotal method of the Sale class
		System.out.println("The discounted subtotal is " + sale.getDiscountedSubTotal());
		
		/**
		 * Item class
		 */
		//Constructor method to create an instance of the Item class
		Item itemtwo = new Item();
		
		//Calling the getItemTotal method of the Item class
		//System.out.println("The total item is " + itemtwo.getItemTotal());
		
		//Calling the getItemCost method of the Item class
		System.out.println("The cost of the item is " + itemtwo.getItemCost());
		
		//The total cost after discount is applied
		System.out.println("The  total cost of the items after discount is " + itemtwo.getItemCost() * sale.getDiscount());
	}
}

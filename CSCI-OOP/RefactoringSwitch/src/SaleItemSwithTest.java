//The Test class - SaleItemTest - for the Item and Sale classes
public class SaleItemSwithTest {
	
	public static void main(String[] args) {
		
		/**
		 * Sale class
		 */
		//Constructor method to create an instance of the Sale class
		Sale sale = new Sale();
			
		String i = null;
		
		sale.addItem(i);

		//Calling the getDiscountRate method of the Sale class
		
		String customerType = null;
		
		System.out.println("The discount rate is " + sale.getDiscountRate(customerType));
		
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
		Item item = new Item();
		
		//Calling the getItemTotal method of the Item class
		System.out.println("The total item is " + item.getItemTotal());
		
		//Calling the getItemCost method of the Item class
		System.out.println("The cost of the item is " + item.getItemCost());
		
	}

}

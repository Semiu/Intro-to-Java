import java.util.ArrayList;
//import java.util.Enumeration;
import java.util.List;
//import java.util.Vector;

import java.util.Scanner;

//Sale class
public class Sale {
	
	private static double DISCOUNT_RATE = 0.05;
	
	enum CustomerType {seniorCustomer, preferedCustomer};
	
	enum Day {Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday};

	//private Vector itemList = new Vector();
	
	private double SPECIAL_DISCOUNT_SENIOR = 3.0;
	
	private double SPECIAL_DISCOUNT_PREFERED = 1.5;
	
	public static CustomerType customerType;
	
	public static Day day;
	
	List<String> itemList = new ArrayList<>();
	
	//addItem method
		public void addItem (String item) {
			
			//Constructor method to create an object of the Scanner class -userIn
			Scanner userIn = new Scanner (System.in);
			
			System.out.println("How many items do you want to add?");
			
			//The number of times the items will be added to itemList vector
			int numLines = userIn.nextInt();
			
			//Instantiating the input string
			String s;
			
			for (int i= 0; i <= numLines; i++) {
				
				s = userIn.nextLine();
				
				System.out.println("Add items");
				
				//Calling the addItem method
				//itemList.addElement(ite);
				
				//Add new items to the itemList
				itemList.add(s);
				//itemList.
			}
			
			//closing the Scanner method
			userIn.close();
		}
		
	
	//getDiscountRate method using switch case statements
	public double getDiscountRate(CustomerType customerType, Day day) {
		switch(customerType) {
		case preferedCustomer:
			DISCOUNT_RATE = DISCOUNT_RATE/SPECIAL_DISCOUNT_PREFERED;
			return DISCOUNT_RATE;
			
		case seniorCustomer:
			switch(day) {
			case Tuesday:
				DISCOUNT_RATE = DISCOUNT_RATE/SPECIAL_DISCOUNT_SENIOR;
				return DISCOUNT_RATE;
				
			default: DISCOUNT_RATE = 0.05;
			}
		}
		return DISCOUNT_RATE;
	}
		    
	//getDiscount method
	public double getDiscount() {
		return getSubTotal() * getDiscountRate(customerType, day); 
	}
	
	//getSubTotal method
		public double getSubTotal() {
			
			double subTotal = 0.0;
			//Enumeration items = itemList.elements();
			
			//Initialize to start from 1 since we are checking for the number of items not index
			for (int i = 1; i < itemList.size(); i++) {
				
				subTotal++;
			}
			
			/**
			while (items.hasMoreElements()) {
				Item theNextItem = (Item)nextElement();
				subTotal += theNextItem.getItemTotal();
			}
			*/
			
			return subTotal;
		}
		
		/**
		 * 
		 
	//nextElement method
	private Item nextElement() {
		
		if (items.hasMoreElements() == false) {
			
			return null;
			
		}
		
		return (Item) items.nextElement();
			
	}
	* @return
		 */
	
	//getDiscountedSubTotal method
	public double getDiscountedSubTotal() {
		return getSubTotal() - getDiscount();
	}

}

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

//The Item class
public class Item {
	
	//The instance variables
		private String title;
		
		//private Item item;
		
		private double UNIT_PRICE;
		
		private int quantity;
		
		enum CustomerType {seniorCustomer, preferedCustomer};

		public static CustomerType customerType;

		private String item;
		
		//private Vector itemList = new Vector();
	
	//setItem method
		public void setItem (String i) {
			this.item= i; 
			
		}
				
		//getItem method
		public String getItem () {
			return this.item; 
		}
		

	//private Vector itemList = new Vector();
	
	List<String> itemList = new ArrayList<>();
	
	//addItem method
	public List<String> addItem (String item) {
		
		//Constructor method to create an object of the Scanner class -userIn
		
		Scanner userIn = new Scanner (System.in);
		
		System.out.println("How many items do you want to add?");
		
		//The number of times the items will be added to itemList vector
		int numLines = userIn.nextInt();
				
		//Instantiating the input string
		String s;
		
		for (int i= 0; i <= numLines; i++) {
			s = userIn.nextLine();
					
					System.out.println("Add item");
					
					//Calling the addItem method
					//itemList.addElement(ite);
					
					//Add new items to the itemList
					itemList.add(s);
					//itemList.
				}
				//closing the Scanner method
				userIn.close();
				
				return itemList;
				
			}
	
	//getItemTotal method
	public double getItemTotal() {
		
		//double finalTotal = 0.0;
		double finalTotal;
		//Return the number of elements in the itemList, i.e. the finalTotal
		 finalTotal = getSubTotal();
		
		/**
		 * 
		Enumeration items = itemList.elements();
		
		while (items.hasMoreElements()) {
			
			finalTotal++;
		}
		 */
		
		return finalTotal;
	}
	
	//getItemCost method
	public double getItemCost() {
		
		UNIT_PRICE = 35;
		
		quantity = 4;
		
		return UNIT_PRICE * quantity;
	}
	
	//getSubTotal method
		//Enumeration items = itemList.elements();
		
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
	
}

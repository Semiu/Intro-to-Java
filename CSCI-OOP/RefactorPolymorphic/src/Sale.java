import java.util.Enumeration;

import java.util.Vector;

import java.util.Scanner;

//Sale class
public class Sale {
	
	enum CustomerType {seniorCustomer, preferedCustomer};
	
	public static CustomerType customerType;

	private Vector itemList = new Vector();
	
	//addItem method
	public void addItem (Item item) {
		
		//Constructor method to create an object of the Scanner class -userIn
		Scanner userIn = new Scanner (System.in);
		
		System.out.println("How many items do you want to add?");
		
		//The number of times the items will be added to itemList vector
		int numLines = userIn.nextInt();
		
		//Instantiating the input string
		String s;
		
		for (int i= 0; i <= numLines; i++) {
			
			System.out.println("Add item");
			
			s = userIn.nextLine();
			
			char[] ite = s.toCharArray();
			
			//Calling the addItem method
			itemList.addElement(ite);
			
		}
		
	}
	
	//getSubTotal method
	Enumeration items = itemList.elements();
	
	public double getSubTotal() {
		double subTotal = 0.0;
		
		
		while (items.hasMoreElements()) {
			Item theNextItem = (Item)nextElement();
			subTotal += theNextItem.getItemTotal();
		}
		
		return subTotal;
	}
	
	//nextElement method
		private Item nextElement() {
			
			if (items.hasMoreElements() == false) {
				
				return null;
				
			}
			
			return (Item) items.nextElement();
				
		}
	
	

}

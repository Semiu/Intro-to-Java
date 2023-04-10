//import java.util.Enumeration;

//import java.util.Vector;

import java.util.Scanner;

import java.util.ArrayList;
//import java.util.Enumeration;
import java.util.List;

public class Item extends DiscountPolicy {
	
	//The instance variables
	private String title;
	
	private String item;
	
	private double UNIT_PRICE;
	
	private int quantity;
	
	//private Vector itemList = new Vector();
	
	//setItem method
	public void setItem (String i) {
		this.item= i; 
		
	}
			
	//getItem method
	public String getItem () {
		return this.item; 
	}
	
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
				
				System.out.println("Add items");
				
				//Calling the addItem method
				//itemList.addElement(ite);
				
				//Add new items to the itemList
				itemList.add(s);
				//itemList.
			}
			userIn.close();
			
			 return itemList;
			//closing the Scanner method
			
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
	
	//getSubTotal method
	
	//Instantiating the items from the itemList vector 
	//(used by getSubTotal and nextElement methods)
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
	
	//nextElement method
				/**
				 * 
				
	private Item nextElement() {
		
		if (items.hasMoreElements() == false) {
			
			return null;
			
		}
		
		return (Item) items.nextElement();
		
	}
	 * @return
				 */
				
	//getItemCost method
		public double getItemCost (List<String> itemList) {
			
			//Loop to calculate for each item added in the itemList
			for (int i = 0; i <= itemList.size();) {
				
				//Dummy values assigned to UNIT_PRICE and quantity
				UNIT_PRICE = 35;
				
				quantity = 4;
				
				return UNIT_PRICE * quantity;
			}
			
			return  UNIT_PRICE * quantity;
		}
	
		//getDiscount method
		public double getDiscount() {
			
			return getSubTotal() * getDiscountRate(); 
			
		}
				
		//getDiscountedSubTotal method
		public double getDiscountedSubTotal() {
			
			return getSubTotal() - getDiscount();
			
		}
		
			
}
